package espresso.semantics.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

public class CompilationUnitSymbol extends Scope{

    public CompilationUnitSymbol(String idName, ParserRuleContext node){
        super(idName, node, null);
    }
}
