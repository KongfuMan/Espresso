package espresso.semantics;

import espresso.syntax.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

class TypeResolverTest {
    private EspressoLexer lexer;
    private EspressoParser parser;
    private SemanticModel semanticModel;

    public void setup(String fileName) throws IOException {
        File file = Paths.get("src","test","resources", fileName).toFile();
        StringBuilder buffer = new StringBuilder();
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                buffer.append(line).append('\n');
            }
        }

        lexer = new EspressoLexer(CharStreams.fromString(buffer.toString()));
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
    public void testOK() throws IOException {
        String fileName = "MyClass.esp";
        setup(fileName);
    }

}