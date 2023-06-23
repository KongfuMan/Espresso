package espresso.syntax;

import espresso.semantics.TypeDeclarationScanner;
import espresso.semantics.TypeResolver;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class EspressoCompiler {
    SemanticModel semanticModel;
    EspressoLexer lexer = null;
    EspressoParser parser = null;

    public SemanticModel compile(String script) {
        //Lexical analysis
        lexer = new EspressoLexer(CharStreams.fromString(script));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //syntax analysis
        parser = new EspressoParser(tokens);
        semanticModel = new SemanticModel(parser.compilationUnit());

        ParseTreeWalker walker = new ParseTreeWalker();

        // semantic analysis- pass1.type declaration
        TypeDeclarationScanner pass1 = new TypeDeclarationScanner(semanticModel);
        walker.walk(pass1, semanticModel.getSyntaxTree());

        // semantic analysis- pass2：variable declaration
        TypeResolver pass2 = new TypeResolver(semanticModel);
        walker.walk(pass2, semanticModel.getSyntaxTree());

        //semantic analysis- pass3: binding referencing identifier to symbol.

        //semantic analysis- pass4：type checking

        //semantic analysis- pass5: ??

        //semantic analysis- pass6：closure analysis
        dumpAST();
        return semanticModel;
    }

    public void dumpAST(){
        if (semanticModel !=null) {
            System.out.println(semanticModel.getSyntaxTree().toStringTree(parser));
        }
    }
}
