package espresso.semantics.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

public class PrimitiveSymbol extends Symbol implements Type{
    protected PrimitiveSymbol(String idName, ParserRuleContext node, Scope containingScope) {
        super(idName, node, containingScope);
    }
}
