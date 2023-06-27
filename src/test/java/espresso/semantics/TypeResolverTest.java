package espresso.semantics;

import espresso.semantics.symbols.*;
import espresso.syntax.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TypeResolverTest {
    private EspressoLexer lexer;
    private EspressoParser parser;
    private SemanticModel semanticModel;

    private void setup(String code){
        lexer = new EspressoLexer(CharStreams.fromString(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //syntax analysis
        parser = new EspressoParser(tokens);
        semanticModel = new SemanticModel(parser.compilationUnit());

        ParseTreeWalker walker = new ParseTreeWalker();

        // semantic analysis- pass1.type declaration
        TypeDeclarationScanner pass1 = new TypeDeclarationScanner(semanticModel);
        walker.walk(pass1, semanticModel.getSyntaxTree());

        TypeResolver pass2 = new TypeResolver(semanticModel);
        walker.walk(pass2, semanticModel.getSyntaxTree());
    }

    @Test
    public void testPrimitiveClassFieldsDeclarator() throws IOException {
        String code = """
                class MyClass
                {
                    int a;
                    void func()
                    {
                        a=1;
                    }
                }
                """;
        setup(code);
        class MyVisitor extends EspressoBaseVisitor{
            @Override
            public Object visitVariableDeclaratorId(EspressoParser.VariableDeclaratorIdContext node) {
                if (node.IDENTIFIER().getText().equals("a")){
                    Symbol varSymbol = semanticModel.getSymbol(node); // int
                    assertTrue(varSymbol instanceof VariableSymbol);
                    assertTrue(((VariableSymbol) varSymbol).getType() instanceof PrimitiveSymbol);
                }
                return super.visitVariableDeclaratorId(node);
            }

            @Override
            public Object visitPrimitiveType(EspressoParser.PrimitiveTypeContext node) {
                Type nodeType = semanticModel.getType(node);
                assertTrue(nodeType instanceof PrimitiveSymbol);
                assertEquals(nodeType.getName(), "Integer");
                Scope containingScope = semanticModel.getContainingScope(node);
                assertTrue(containingScope instanceof ClassSymbol);

                Type parentNodeType = semanticModel.getType(node.getParent());
                assertEquals(parentNodeType, nodeType);
                containingScope = semanticModel.getContainingScope(node.getParent());
                assertTrue(containingScope instanceof ClassSymbol);

                return super.visitPrimitiveType(node);
            }
        }
        MyVisitor visitor = new MyVisitor();
        visitor.visit(semanticModel.getSyntaxTree());
    }

    @Test
    public void testPrimitiveMethodParametersDeclarator(){
        String code = """
                class MyClass
                {
                    void func(int myParam)
                    {
                    }
                }
                """;
        setup(code);
        class MyVisitor extends EspressoBaseVisitor{
            @Override
            public Object visitMethodDeclaration(EspressoParser.MethodDeclarationContext node) {
                MethodSymbol methodSymbol = (MethodSymbol)semanticModel.getAssociatedScope(node);
                Type returnType = semanticModel.getType(node.typeTypeOrVoid());
                assertEquals(methodSymbol.getReturnType(), returnType);

                Scope containingScope = semanticModel.getContainingScope(node);
                assertTrue(containingScope instanceof ClassSymbol);

                return super.visitMethodDeclaration(node);
            }

            @Override
            public Object visitParameter(EspressoParser.ParameterContext node) {
                Type paramType = semanticModel.getType(node.typeType());
                VariableSymbol variableSymbol = (VariableSymbol)semanticModel.getSymbol(node.variableDeclaratorId());
                assertTrue(variableSymbol.getType() instanceof PrimitiveSymbol);
                return super.visitParameter(node);
            }

            @Override
            public Object visitVariableDeclaratorId(EspressoParser.VariableDeclaratorIdContext node) {
                if (node.IDENTIFIER().getText().equals("myParam")){
                    Symbol varSymbol = semanticModel.getSymbol(node); // int
                    assertTrue(varSymbol instanceof VariableSymbol);
                    assertTrue(((VariableSymbol) varSymbol).getType() instanceof PrimitiveSymbol);
                }
                return super.visitVariableDeclaratorId(node);
            }

            @Override
            public Object visitPrimitiveType(EspressoParser.PrimitiveTypeContext node) {
                Type nodeType = semanticModel.getType(node);
                assertTrue(nodeType instanceof PrimitiveSymbol);
                assertEquals(nodeType.getName(), "Integer");
                Scope containingScope = semanticModel.getContainingScope(node);
                assertTrue(containingScope instanceof MethodSymbol);

                Type parentNodeType = semanticModel.getType(node.getParent());
                assertEquals(parentNodeType, nodeType);
                containingScope = semanticModel.getContainingScope(node.getParent());
                assertTrue(containingScope instanceof MethodSymbol);

                return super.visitPrimitiveType(node);
            }
        }
        MyVisitor myVisitor = new MyVisitor();
        myVisitor.visit(semanticModel.getSyntaxTree());
    }

    @Test
    public void testPrimitiveLocalVariableDeclarator() {
        String code = """
                class MyClass
                {
                    void func()
                    {
                        int myLocal = 1;
                    }
                }
                """;
        setup(code);
        class MyVisitor extends EspressoBaseVisitor {
            @Override
            public Object visitVariableDeclaratorId(EspressoParser.VariableDeclaratorIdContext node) {
                if (node.IDENTIFIER().getText().equals("myLocal")){
                    Symbol varSymbol = semanticModel.getSymbol(node); // int
                    // local variables will be scanned in next pass.
                    assertNull(varSymbol);
                }
                return super.visitVariableDeclaratorId(node);
            }
        }
        MyVisitor myVisitor = new MyVisitor();
        myVisitor.visit(semanticModel.getSyntaxTree());
    }

    @Test
    public void testCustomClassFieldDeclarator(){
        String code = """
                class ClsType{}
                class MyClass
                {
                    ClsType myField;
                }
                """;
        setup(code);
        class MyVisitor extends EspressoBaseVisitor {
            @Override
            public Object visitClassDeclaration(EspressoParser.ClassDeclarationContext node) {
                String idName = node.IDENTIFIER().getText();
                Type type = semanticModel.lookupType(idName);
                assertTrue(type instanceof ClassSymbol);
                return super.visitClassDeclaration(node);
            }

            @Override
            public Object visitVariableDeclaratorId(EspressoParser.VariableDeclaratorIdContext node) {
                Symbol symbol = semanticModel.getSymbol(node);
                assertTrue(symbol instanceof VariableSymbol);
                assertTrue(((VariableSymbol) symbol).getType() instanceof ClassSymbol);
                return super.visitVariableDeclaratorId(node);
            }

            @Override
            public Object visitClassOrInterfaceType(EspressoParser.ClassOrInterfaceTypeContext node) {
                Type nodeType = semanticModel.getType(node);
                assertTrue(nodeType instanceof ClassSymbol);

                Type parentNodeType = semanticModel.getType(node.getParent());
                assertEquals(nodeType, parentNodeType);

                return super.visitClassOrInterfaceType(node);
            }
        }
        MyVisitor myVisitor = new MyVisitor();
        myVisitor.visit(semanticModel.getSyntaxTree());
    }

    @Test
    public void testDuplicateMethodDeclaration(){
        String code = """
                class MyClass
                {
                    void fun(int a, long b, float c, double d, boolean e, byte f, char g, short h, string i){}
                    void fun(int a, long b, float c, double d, boolean e, byte f, char g, short h, string i){}
                }
                """;
        setup(code);
        assertEquals(1, semanticModel.diagnostics.size());
        code = """
                class MyType {}
                class MyClass
                {
                    void fun(MyType a){}
                    void fun(MyType a){}
                }
                """;
        setup(code);
        assertEquals(1, semanticModel.diagnostics.size());
    }

    @Test
    public void testBaseClass(){
        String code = """
                class baseClass{}
                class derivedClass extends baseClass
                {
                }
                """;
        setup(code);

        class MyVisitor extends EspressoBaseVisitor {
            @Override
            public Object visitClassDeclaration(EspressoParser.ClassDeclarationContext node) {
                if (node.IDENTIFIER().getText().equals("derivedClass")){
                    Type definedType = semanticModel.lookupType("baseClass");
                    Scope derivedClass = semanticModel.getAssociatedScope(node);
                    assertTrue(derivedClass instanceof ClassSymbol);
                    Type baseType = ((ClassSymbol) derivedClass).getBaseType();
                    assertEquals(baseType, definedType);
                }
                return super.visitClassDeclaration(node);
            }
        }
        MyVisitor myVisitor = new MyVisitor();
        myVisitor.visit(semanticModel.getSyntaxTree());
    }
}