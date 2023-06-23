package espresso.semantics;

import espresso.syntax.*;
import espresso.semantics.symbols.*;
import espresso.syntax.SemanticModel;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TypeDeclarationScannerTest {
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
    }

    @Test
    public void testOK() throws IOException {
        String code = """
                class MyClass
                {
                    int a=2;
                    int b;
                                
                    void func()
                    {
                        b = 3;
                    }
                }
                """;
        setup(code);
        String stringTree = semanticModel.getSyntaxTree().toStringTree(parser);
        String expected = "(compilationUnit (classDeclaration class MyClass (classBody { (classBodyDeclaration " +
                "(memberDeclaration (fieldDeclaration (variableDeclarators (typeType (primitiveType int))" +
                " (variableDeclarator (variableDeclaratorId a) = (variableInitializer (expression (primary " +
                "(literal (integerLiteral 2))))))) ;))) (classBodyDeclaration (memberDeclaration (fieldDeclaration " +
                "(variableDeclarators (typeType (primitiveType int)) (variableDeclarator (variableDeclaratorId b))) ;)))" +
                " (classBodyDeclaration (memberDeclaration (methodDeclaration (typeTypeOrVoid void) func (parameterList ( ))" +
                " (methodBody (block { (blockStatement (statement (expression (expression (primary b)) = " +
                "(expression (primary (literal (integerLiteral 3))))) ;)) }))))) })) <EOF>)";
        assertEquals(expected, stringTree);
    }

    @Test
    public void testClassDeclarationOK() throws IOException {
        String code = """
                class MyClass
                {
                    int a=2;
                    int b;
                                
                    int func()
                    {
                        return 1;
                    }
                }
                """;

        setup(code);
        Type type = semanticModel.lookupType("MyClass");
        assertTrue(type instanceof ClassSymbol);
        ClassSymbol classSymbol = (ClassSymbol) type;
        assertTrue(classSymbol.getContainingScope() instanceof CompilationUnitSymbol);

        List<Symbol> childSymbols = classSymbol.childSymbols;
        assertEquals(childSymbols.size(),1);
        Symbol methodSymbol = childSymbols.get(0);
        assertTrue(methodSymbol instanceof MethodSymbol);
        assertEquals(((MethodSymbol) methodSymbol).childSymbols.size(), 0);
        assertEquals(((MethodSymbol) methodSymbol).getContainingScope(), classSymbol);
    }

    @Test
    public void testMethodMethodOK(){
        String code = """
                class MyClass
                {
                    int func()
                    {
                        return 1;
                    }
                }
                """;
        setup(code);
        Type type = semanticModel.lookupType("MyClass");
        ClassSymbol classSymbol = (ClassSymbol) type; // class scope

        List<Symbol> childSymbols = classSymbol.childSymbols;
        assertEquals(childSymbols.size(), 1);
        Symbol funSymbol = childSymbols.get(0); // method scope
        assertEquals(((MethodSymbol) funSymbol).childSymbols.size(), 0);
    }

    @Test
    public void tesStatementOK() {
        String code = """
                class MyClass
                {
                    int a=2;
                    int b;
                                
                    int func()
                    {
                        for (int i = 0; i < 10; i++)
                        {
                            b += 1;
                        }
                        
                        if (a == 2)
                        {
                            b += 1;
                        }
                    }
                }
                """;

        setup(code);
        Type type = semanticModel.lookupType("MyClass");
        assertTrue(type instanceof ClassSymbol);
        ClassSymbol classSymbol = (ClassSymbol) type; // class scope

        List<Symbol> childSymbols = classSymbol.childSymbols;

        Symbol funSymbol = childSymbols.get(0); // method scope
        assertEquals(((MethodSymbol) funSymbol).childSymbols.size(), 2);

        Symbol forStatement = ((MethodSymbol) funSymbol).childSymbols.get(0); // for statement scope
        assertTrue(forStatement instanceof BlockSymbol);
        assertEquals(((BlockSymbol)forStatement).childSymbols.size(), 1);
        assertEquals(((BlockSymbol) forStatement).getContainingScope(), funSymbol);

        Symbol forBlock = ((BlockSymbol) forStatement).childSymbols.get(0); // block scope of for statement
        assertTrue(forBlock instanceof BlockSymbol);
        assertEquals(((BlockSymbol) forBlock).childSymbols.size(), 0);
        assertEquals(((BlockSymbol) forBlock).getContainingScope(), forStatement);

        Symbol ifBlock = ((MethodSymbol) funSymbol).childSymbols.get(1); // if statement scope
        assertTrue(ifBlock instanceof BlockSymbol);
        assertEquals(((BlockSymbol) ifBlock).childSymbols.size(), 0);
        assertEquals(((BlockSymbol) ifBlock).getContainingScope(), funSymbol);
    }
}

