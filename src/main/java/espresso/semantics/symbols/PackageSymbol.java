package espresso.semantics.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

//TODO: package is not supported yet
public class PackageSymbol extends Scope implements Type{

    protected PackageSymbol(String idName, ParserRuleContext node, Scope containingScope) {
        super(idName, node, containingScope);
    }

    @Override
    public boolean isType(Type type) {
        return false;
    }
}
