package espresso.semantics;

import espresso.semantics.symbols.*;
import espresso.syntax.EspressoBaseListener;
import espresso.syntax.EspressoParser.*;

// pass2. variable declaration
public class TypeResolver extends EspressoBaseListener {
    private SymbolTable symbolTable;

    private final boolean enterLocalVariable;

    public TypeResolver(SymbolTable symbolTable){
        this(symbolTable, false);
    }

    public TypeResolver(SymbolTable symbolTable, boolean enterLocalVariable){
        this.symbolTable = symbolTable;
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
        Scope scope = symbolTable.getContainingScope(node);
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
                symbolTable.addDiagnose("duplicate variable declaration");
            }

            scope.addSymbol(variableSymbol);
            symbolTable.addNodeToSymbol(node, variableSymbol);
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
        Type type = symbolTable.getType(node.typeType());
        for (VariableDeclaratorContext variableNode : node.variableDeclarator()){
            VariableSymbol varSymbol = (VariableSymbol) symbolTable.getSymbol(variableNode.variableDeclaratorId());
            varSymbol.setType(type);
        }
    }

    /**
     * Resolve type of each parameter of method.
     * */
    @Override
    public void exitParameter(ParameterContext node) {
        Type paramType = symbolTable.getType(node.typeType());
        VariableSymbol variableSymbol = (VariableSymbol) symbolTable.getSymbol(node.variableDeclaratorId());
        variableSymbol.setType(paramType);

        Scope scope = symbolTable.getContainingScope(node);
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
        MethodSymbol methodSymbol = (MethodSymbol) symbolTable.getAssociatedScope(node);
        Type returnType = symbolTable.getType(node.typeTypeOrVoid());
        methodSymbol.setReturnType(returnType);

        // Check duplicate method, since the method has been completely resolved at this point.
        String idName = node.IDENTIFIER().getText();
        Scope scope = symbolTable.getContainingScope(node);
        MethodSymbol findResult = scope.lookupMethodSymbol(idName, methodSymbol.getParameterTypes());
        if (findResult != null && findResult != methodSymbol){
            symbolTable.addDiagnose("duplicate method declaration");
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
        ClassSymbol currClass = (ClassSymbol)(symbolTable.getAssociatedScope(node));
        Type baseType = symbolTable.lookupType(node.typeType().getText());
        if (baseType == null){
            symbolTable.addDiagnose("Unknown base type");
        }
        currClass.setBaseType(baseType);
    }

    /**
     * build connection from typeTypeOrVoid to Type declaration.
     * */
    @Override
    public void exitTypeTypeOrVoid(TypeTypeOrVoidContext node) {
        if (node.VOID() != null){
            symbolTable.addNodeToType(node, VoidType.instance());
        } else if (node.typeType() != null){
            // bubble up the bound node
            symbolTable.addNodeToType(node, symbolTable.getType(node.typeType()));
        }
    }

    @Override
    public void exitTypeType(TypeTypeContext node) {
        Type type = null;
        if (node.classOrInterfaceType() !=  null){
            type = symbolTable.getType(node.classOrInterfaceType());
        }else if (node.primitiveType() != null){
            type = symbolTable.getType(node.primitiveType());
        }

        // bubble up the bound node
        symbolTable.addNodeToType(node, type);
    }

    /**
     * Bind class or interface type of variable declaration with type declaration.
     * */
    @Override
    public void enterClassOrInterfaceType(ClassOrInterfaceTypeContext node) {
        if (node.qualifiedName().IDENTIFIER() != null){
            Scope containingScope = symbolTable.getContainingScope(node);
            ClassSymbol classType = symbolTable.lookupClassSymbol(containingScope, node.getText());
            if (classType == null){
                symbolTable.addDiagnose("unknown type");
            }
            symbolTable.addNodeToType(node, classType);
        }
    }

    /**
     * For primitive type of variable declaration, add <node, type>
     * */
    @Override
    public void exitPrimitiveType(PrimitiveTypeContext node) {
        Type type = null;
        Scope containingScope = symbolTable.getContainingScope(node);
        if (node.BOOLEAN() != null) {
            type = PrimitiveSymbol.Boolean(node, containingScope);
        } else if (node.INT() != null) {
            type = PrimitiveSymbol.Integer(node, containingScope);
        } else if (node.LONG() != null) {
            type = PrimitiveSymbol.Long(node, containingScope);
        } else if (node.FLOAT() != null) {
            type = PrimitiveSymbol.Float(node, containingScope);
        } else if (node.DOUBLE() != null) {
            type = PrimitiveSymbol.Double(node, containingScope);
        } else if (node.BYTE() != null) {
            type = PrimitiveSymbol.Byte(node, containingScope);
        } else if (node.SHORT() != null) {
            type = PrimitiveSymbol.Short(node, containingScope);
        } else if (node.CHAR() != null) {
            type = PrimitiveSymbol.Char(node, containingScope);
        }else if (node.STRING() != null) {
            type = PrimitiveSymbol.String(node, containingScope);
        }

        symbolTable.addNodeToType(node, type);
    }
}
