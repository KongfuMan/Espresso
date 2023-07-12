package espresso.semantics;

import espresso.semantics.symbols.SymbolTable;
import espresso.syntax.EspressoLexer;
import espresso.syntax.EspressoParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ReferenceResolverTest {
    private EspressoLexer lexer;
    private EspressoParser parser;
    private SymbolTable symbolTable;

    private void setup(String code){
        lexer = new EspressoLexer(CharStreams.fromString(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //syntax analysis
        parser = new EspressoParser(tokens);
        symbolTable = new SymbolTable(parser.compilationUnit());

        ParseTreeWalker walker = new ParseTreeWalker();

        // semantic analysis- pass1.type declaration
        TypeDeclarationScanner pass1 = new TypeDeclarationScanner(symbolTable);
        walker.walk(pass1, symbolTable.getSyntaxTree());

        TypeResolver pass2 = new TypeResolver(symbolTable);
        walker.walk(pass2, symbolTable.getSyntaxTree());

        ReferenceResolver pass3 = new ReferenceResolver(symbolTable);
        walker.walk(pass3, symbolTable.getSyntaxTree());
    }

    @Test
    public void testPrimitiveClassFieldsDeclarator() throws IOException {
        String code = """
                class Foo
                {
                    int myField;
                }
                class MyClass
                {
                    void func()
                    {
                        Foo myObj;
                        myObj.myField;
                    }
                }
                """;
        setup(code);
    }

}