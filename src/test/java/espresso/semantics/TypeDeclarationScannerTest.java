package espresso.semantics;

import espresso.syntax.*;
import espresso.semantics.symbols.*;
import espresso.syntax.SemanticModel;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TypeDeclarationScannerTest {
    private EspressoLexer lexer;
    private EspressoParser parser;
    private SemanticModel semanticModel;

//    private void setup(String fileName) throws IOException {
//        File file = Paths.get("src","test","resources", fileName).toFile();
//        StringBuilder buffer = new StringBuilder();
//        try (FileReader reader = new FileReader(file);
//             BufferedReader br = new BufferedReader(reader)) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                buffer.append(line).append('\n');
//            }
//        }
//
//        setupWithCode(buffer.toString());
//    }

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
        Type type = semanticModel.getType("MyClass");
        assertTrue(type instanceof ClassSymbol);
        ClassSymbol classSymbol = (ClassSymbol) type;
        assertTrue(classSymbol.getContainingScope() instanceof CompilationUnitSymbol);
        Map<String, Symbol> childScopes = classSymbol.childScopes;
        assertEquals(childScopes.size(),1);
        Symbol funSymbol = childScopes.get("func");
        assertTrue(funSymbol instanceof MethodSymbol);
        assertEquals(((MethodSymbol) funSymbol).childScopes.size(), 0);
        assertEquals(((MethodSymbol) funSymbol).getContainingScope(), classSymbol);
    }

    @Test
    public void tesStatementOK() throws IOException {
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
        Type type = semanticModel.getType("MyClass");
        assertTrue(type instanceof ClassSymbol);
        ClassSymbol classSymbol = (ClassSymbol) type; // class scope
        Map<String, Symbol> childScopes = classSymbol.childScopes;

        Symbol funSymbol = childScopes.get("func"); // method scope
        assertEquals(((MethodSymbol) funSymbol).childScopes.size(), 2);

        Symbol forStatement = ((MethodSymbol) funSymbol).childScopes.get("block_1"); // for statement scope
        assertTrue(forStatement instanceof BlockSymbol);
        assertEquals(((BlockSymbol)forStatement).childScopes.size(), 1);
        assertEquals(((BlockSymbol) forStatement).getContainingScope(), funSymbol);

        Symbol forBlock = ((BlockSymbol) forStatement).childScopes.get("block_2"); // block scope of for statement
        assertTrue(forBlock instanceof BlockSymbol);
        assertEquals(((BlockSymbol) forBlock).childScopes.size(), 0);
        assertEquals(((BlockSymbol) forBlock).getContainingScope(), forStatement);

        Symbol ifBlock = ((MethodSymbol) funSymbol).childScopes.get("block_3"); // for statement scope
        assertTrue(ifBlock instanceof BlockSymbol);
        assertEquals(((BlockSymbol) ifBlock).childScopes.size(), 0);
        assertEquals(((BlockSymbol) ifBlock).getContainingScope(), funSymbol);
    }
}

