package espresso.semantics;

import espresso.syntax.EspressoLexer;
import espresso.syntax.EspressoParser;
import espresso.syntax.SemanticModel;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReferenceResolverTest {
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

        ReferenceResolver pass3 = new ReferenceResolver(semanticModel);
        walker.walk(pass3, semanticModel.getSyntaxTree());
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