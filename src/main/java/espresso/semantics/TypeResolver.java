package espresso.semantics;

import espresso.semantics.symbols.*;
import espresso.syntax.EspressoBaseListener;
import espresso.syntax.EspressoParser.*;
import espresso.syntax.SemanticModel;

// pass2. variable declaration
public class TypeResolver extends EspressoBaseListener {
    private SemanticModel semanticModel;

    private final boolean enterLocalVariable;

    public TypeResolver(SemanticModel semanticModel){
        this(semanticModel, false);
    }

    public TypeResolver(SemanticModel semanticModel, boolean enterLocalVariable){
        this.semanticModel = semanticModel;
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
        Scope scope = semanticModel.getContainingScope(node);
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
                semanticModel.addDiagnose("duplicate variable declaration");
            }

            scope.addSymbol(variableSymbol);
            semanticModel.addNodeToSymbol(node, variableSymbol);
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
        Type type = semanticModel.getType(node.typeType());
        for (VariableDeclaratorContext variableNode : node.variableDeclarator()){
            VariableSymbol varSymbol = (VariableSymbol)semanticModel.getSymbol(variableNode.variableDeclaratorId());
            varSymbol.setType(type);
        }
    }

    /**
     * Resolve type of each parameter of method.
     * */
    @Override
    public void exitParameter(ParameterContext node) {
        Type paramType = semanticModel.getType(node.typeType());
        VariableSymbol variableSymbol = (VariableSymbol)semanticModel.getSymbol(node.variableDeclaratorId());
        variableSymbol.setType(paramType);

        Scope scope = semanticModel.getContainingScope(node);
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
        MethodSymbol methodSymbol = (MethodSymbol)semanticModel.getAssociatedScope(node);
        Type returnType = semanticModel.getType(node.typeTypeOrVoid());
        methodSymbol.setReturnType(returnType);

        // Check duplicate method, since the method has been completely resolved at this point.
        String idName = node.IDENTIFIER().getText();
        Scope scope = semanticModel.getContainingScope(node);
        MethodSymbol findResult = scope.getMethodDeclaration(idName, methodSymbol.getParameterTypes());
        if (findResult != null && findResult != methodSymbol){
            semanticModel.addDiagnose("duplicate method declaration");
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
        ClassSymbol currClass = (ClassSymbol)(semanticModel.getAssociatedScope(node));
        Type baseType = semanticModel.lookupType(node.typeType().getText());
        if (baseType == null){
            semanticModel.addDiagnose("Unknown base type");
        }
        currClass.setBaseType(baseType);
    }

    /**
     * build connection from typeTypeOrVoid to Type declaration.
     * */
    @Override
    public void exitTypeTypeOrVoid(TypeTypeOrVoidContext node) {
        if (node.VOID() != null){
            semanticModel.addNodeToType(node, VoidType.instance());
        } else if (node.typeType() != null){
            // bubble up the bound node
            semanticModel.addNodeToType(node, semanticModel.getType(node.typeType()));
        }
    }

    @Override
    public void exitTypeType(TypeTypeContext node) {
        Type type = null;
        if (node.classOrInterfaceType() !=  null){
            type = semanticModel.getType(node.classOrInterfaceType());
        }else if (node.primitiveType() != null){
            type = semanticModel.getType(node.primitiveType());
        }

        // bubble up the bound node
        semanticModel.addNodeToType(node, type);
    }

    /**
     * Bind class or interface type of variable declaration with type declaration.
     * */
    @Override
    public void enterClassOrInterfaceType(ClassOrInterfaceTypeContext node) {
        if (node.qualifiedName().IDENTIFIER() != null){
            Scope containingScope = semanticModel.getContainingScope(node);
            ClassSymbol classType = semanticModel.lookupClassSymbol(containingScope, node.getText());
            if (classType == null){
                semanticModel.addDiagnose("unknown type");
            }
            semanticModel.addNodeToType(node, classType);
        }
    }

    /**
     * For primitive type of variable declaration, add <node, type>
     * */
    @Override
    public void exitPrimitiveType(PrimitiveTypeContext node) {
        Type type = null;
        Scope containingScope = semanticModel.getContainingScope(node);
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

        semanticModel.addNodeToType(node, type);
    }
}
