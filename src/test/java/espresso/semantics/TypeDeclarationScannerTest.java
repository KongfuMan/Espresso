package espresso.semantics;

import espresso.syntax.*;
import espresso.semantics.symbols.*;
import espresso.syntax.SemanticModel;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
        ClassSymbol symbol = (ClassSymbol) type;


    }
}

