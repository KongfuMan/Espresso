package espresso.syntax;

import espresso.semantics.TypeDeclarationScanner;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class EspressoCompiler {
    SemanticModel semantModel;
    EspressoLexer lexer = null;
    EspressoParser parser = null;

    public SemanticModel compile(String script) {
        //Lexical analysis
        lexer = new EspressoLexer(CharStreams.fromString(script));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //syntax analysis
        parser = new EspressoParser(tokens);
        semantModel = new SemanticModel(parser.compilationUnit());

        ParseTreeWalker walker = new ParseTreeWalker();

        // semantic analysis- pass1.type declaration
        TypeDeclarationScanner pass1 = new TypeDeclarationScanner(semantModel);
        walker.walk(pass1, semantModel.getSyntaxTree());

        //semantic analysis- pass2：variable declaration

        //semantic analysis- pass3: binding referencing identifier to symbol.

        //semantic analysis- pass4：type checking

        //semantic analysis- pass5: ??

        //semantic analysis- pass6：closure analysis
        dumpAST();
        return semantModel;
    }

    public void dumpAST(){
        if (semantModel!=null) {
            System.out.println(semantModel.getSyntaxTree().toStringTree(parser));
        }
    }
}
