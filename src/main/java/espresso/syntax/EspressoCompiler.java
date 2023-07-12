package espresso.syntax;

import espresso.semantics.ReferenceResolver;
import espresso.semantics.symbols.SymbolTable;
import espresso.semantics.TypeDeclarationScanner;
import espresso.semantics.TypeResolver;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class EspressoCompiler {
    SymbolTable symbolTable;
    EspressoLexer lexer = null;
    EspressoParser parser = null;

    public SymbolTable compile(String script) {
        //Lexical analysis
        lexer = new EspressoLexer(CharStreams.fromString(script));
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //syntax analysis
        parser = new EspressoParser(tokens);
        symbolTable = new SymbolTable(parser.compilationUnit());

        ParseTreeWalker walker = new ParseTreeWalker();

        // semantic analysis- pass1.type declaration
        TypeDeclarationScanner pass1 = new TypeDeclarationScanner(symbolTable);
        walker.walk(pass1, symbolTable.getSyntaxTree());

        // semantic analysis- pass2：variable declaration
        TypeResolver pass2 = new TypeResolver(symbolTable);
        walker.walk(pass2, symbolTable.getSyntaxTree());

        //semantic analysis- pass3: binding referencing identifier to symbol.
        ReferenceResolver pass3 = new ReferenceResolver(symbolTable);
        walker.walk(pass3, symbolTable.getSyntaxTree());

        //semantic analysis- pass4：type checking

        //semantic analysis- pass5: ??

        //semantic analysis- pass6：closure analysis
        dumpAST();
        return symbolTable;
    }

    public void dumpAST(){
        if (symbolTable !=null) {
            System.out.println(symbolTable.getSyntaxTree().toStringTree(parser));
        }
    }
}
