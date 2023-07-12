package espresso.semantics;

import espresso.semantics.symbols.*;
import espresso.syntax.EspressoBaseListener;
import espresso.syntax.EspressoParser.*;

// pass2. variable declaration
public class TypeResolver extends EspressoBaseListener {
    private SymbolTable symTab;

    private final boolean enterLocalVariable;

    public TypeResolver(SymbolTable symTab){
        this(symTab, false);
    }

    public TypeResolver(SymbolTable symTab, boolean enterLocalVariable){
        this.symTab = symTab;
        this.enterLocalVariable = enterLocalVariable;
    }

    /**
     * Create symbol for identifier of variableDeclarator of class field and method parameters.
     * */
    @Override
    public void enterVariableDeclaratorId(VariableDeclaratorIdContext node) {
        // TODO: resolving class field declaration , method parameters.
        //       local variables declaration in the block will be left for the next phase
        String idName = node.IDENTIFIER().getText();
        Scope scope = symTab.getContainingScope(node);
        if (node.getParent().getParent().getParent() instanceof FieldDeclarationContext ||
            node.getParent() instanceof ParameterContext || enterLocalVariable) {
            VariableSymbol variableSymbol = new VariableSymbol(idName, node, scope);

            // should not have multiple identifier of same name in same scope, regardless of type
            // e.g.
            // class myClass {
            //     int age;
            //     String age; # duplicate age
            //     void fun(int a, double a){} # duplicate a
            // }
            if (scope.lookupVariableSymbol(idName) != null){
                symTab.addDiagnose("duplicate variable declaration");
            }

            scope.addSymbol(variableSymbol);
            symTab.addNodeToSymbol(node, variableSymbol);
        }
    }

    /**
     * Resolve type for variable declaration in class fields
     * */
    @Override
    public void exitVariableDeclarators(VariableDeclaratorsContext node) {
        if (!(node.getParent() instanceof FieldDeclarationContext || enterLocalVariable)){
            return;
        }

        // typeType has been resolved by exitTypeType(...) listener
        Type type = symTab.getType(node.typeType());
        for (VariableDeclaratorContext variableNode : node.variableDeclarator()){
            VariableSymbol varSymbol = (VariableSymbol) symTab.getSymbol(variableNode.variableDeclaratorId());
            varSymbol.setType(type);
        }
    }

    /**
     * Resolve type of each parameter of method.
     * */
    @Override
    public void exitParameter(ParameterContext node) {
        Type paramType = symTab.getType(node.typeType());
        VariableSymbol variableSymbol = (VariableSymbol) symTab.getSymbol(node.variableDeclaratorId());
        variableSymbol.setType(paramType);

        Scope scope = symTab.getContainingScope(node);
        if (scope instanceof MethodSymbol){
            ((MethodSymbol)scope).addParameter(variableSymbol);
        }
    }

    /**
     * Resolve the return type of method.
     * methodDeclaration
     *     : typeTypeOrVoid IDENTIFIER parameterList ('[' ']')*
     *       (THROWS qualifiedNameList)?
     *       methodBody
     *     ;
     * */
    @Override
    public void exitMethodDeclaration(MethodDeclarationContext node) {
        MethodSymbol methodSymbol = (MethodSymbol) symTab.getAssociatedScope(node);
        Type returnType = symTab.getType(node.typeTypeOrVoid());
        methodSymbol.setReturnType(returnType);

        // Check duplicate method, since the method has been completely resolved at this point.
        String idName = node.IDENTIFIER().getText();
        Scope scope = symTab.getContainingScope(node);
        MethodSymbol findResult = scope.lookupMethodSymbol(idName, methodSymbol.getParameterTypes());
        if (findResult != null && findResult != methodSymbol){
            symTab.addDiagnose("duplicate method declaration");
        }
    }

    /**
     * Resolve the type of base class.
     * classDeclaration
     *     : CLASS IDENTIFIER (EXTENDS typeType)? classBody
     * */
    @Override
    public void enterClassDeclaration(ClassDeclarationContext node) {
        if (node.EXTENDS() == null){
            return;
        }

        // get class (scoped) symbol associated with the node
        ClassSymbol currClass = (ClassSymbol)(symTab.getAssociatedScope(node));
        Type baseType = symTab.lookupType(node.typeType().getText());
        if (baseType == null){
            symTab.addDiagnose("Unknown base type");
        }
        currClass.setBaseType(baseType);
    }

    /**
     * build connection from typeTypeOrVoid to Type declaration.
     * */
    @Override
    public void exitTypeTypeOrVoid(TypeTypeOrVoidContext node) {
        if (node.VOID() != null){
            symTab.addNodeToType(node, VoidType.instance());
        } else if (node.typeType() != null){
            // bubble up the bound node
            symTab.addNodeToType(node, symTab.getType(node.typeType()));
        }
    }

    @Override
    public void exitTypeType(TypeTypeContext node) {
        Type type = null;
        if (node.classOrInterfaceType() !=  null){
            type = symTab.getType(node.classOrInterfaceType());
        }else if (node.primitiveType() != null){
            type = symTab.getType(node.primitiveType());
        }

        // bubble up the bound node
        symTab.addNodeToType(node, type);
    }

    /**
     * Bind class or interface type of variable declaration with type declaration.
     * */
    @Override
    public void enterClassOrInterfaceType(ClassOrInterfaceTypeContext node) {
        if (node.qualifiedName().IDENTIFIER() != null){
            Scope containingScope = symTab.getContainingScope(node);
            ClassSymbol classType = symTab.lookupClassSymbol(containingScope, node.getText());
            if (classType == null){
                symTab.addDiagnose("unknown type");
            }
            symTab.addNodeToType(node, classType);
        }
    }

    /**
     * For primitive type of variable declaration, add <node, type>
     * */
    @Override
    public void exitPrimitiveType(PrimitiveTypeContext node) {
        Type type = null;
        Scope containingScope = symTab.getContainingScope(node);
        if (node.BOOLEAN() != null) {
            type = SymbolTable.Boolean;
        } else if (node.INT() != null) {
            type = SymbolTable.Integer;
        } else if (node.LONG() != null) {
            type = SymbolTable.Long;
        } else if (node.FLOAT() != null) {
            type = SymbolTable.Float;
        } else if (node.DOUBLE() != null) {
            type = SymbolTable.Double;
        } else if (node.BYTE() != null) {
            type = SymbolTable.Byte;
        } else if (node.SHORT() != null) {
            type = SymbolTable.Short;
        } else if (node.CHAR() != null) {
            type = SymbolTable.Char;
        }else if (node.STRING() != null) {
            type = SymbolTable.String;
        }

        symTab.addNodeToType(node, type);
    }
}
