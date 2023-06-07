package espresso.semantics.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

public class ClassSymbol extends Scope implements Type{

    public ClassSymbol(String idName, ParserRuleContext node, Scope containingScope){
        super(idName, node, containingScope);
    }
}
