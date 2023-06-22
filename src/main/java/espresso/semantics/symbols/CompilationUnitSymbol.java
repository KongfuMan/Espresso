package espresso.semantics.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

public class CompilationUnitSymbol extends Scope{
    /**
     * Top level scope representing a namespace.
     * @param idName the identifier name of namespace, e.g. "system.utils"
     * @param node the syntax node that represent namespace.
     * */
    public CompilationUnitSymbol(String idName, ParserRuleContext node){
        super(idName, node, null);
    }
}
