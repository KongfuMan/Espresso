package espresso.semantics.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.Map;

public abstract class Scope extends Symbol{
    Map<String, Symbol> symbols;
    protected Scope(String idName, ParserRuleContext node, Scope containingScope){
        super(idName, node, containingScope);
        symbols = new HashMap<>();
    }

    public void addSymbol(String name, Symbol symbol){
        symbols.put(name, symbol);
    }

    public boolean lookup(Symbol symbol){
        return symbols.containsKey(symbol.getFullName());
    }

    public Scope getContainingScope(){
        return containingScope;
    }
}
