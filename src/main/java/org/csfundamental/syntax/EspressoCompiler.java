package org.csfundamental.syntax;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class EspressoCompiler {
    SemanticModel semantModel;
    EspressoLexer lexer = null;
    EspressoParser parser = null;

    public SemanticModel compile(String script, boolean verbose, boolean ast_dump) {
        semantModel = new SemanticModel();

        //Lexical analysis
        lexer = new EspressoLexer(CharStreams.fromString(script));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //syntax analysis
        parser = new EspressoParser(tokens);
        semantModel.syntaxTree = parser.compilationUnit();

        ParseTreeWalker walker = new ParseTreeWalker();

        // semantic analysis- pass1.type declaration

        //semantic analysis- pass2：variable declaration

        //semantic analysis- pass3: binding referencing identifier to symbol.

        //semantic analysis- pass4：type checking

        //semantic analysis- pass5: ??

        //semantic analysis- pass6：closure analysis

        return semantModel;
    }
}
