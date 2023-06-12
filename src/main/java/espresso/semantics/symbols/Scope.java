package espresso.semantics.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.List;
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
        return symbols.containsKey(symbol.getName());
    }

    public MethodSymbol getMethodDeclaration(String name, List<Type> paramTypes){
        if (!symbols.containsKey(name)){
            return null;
        }
        Symbol symbol = symbols.get(name);
        if (!(symbol instanceof MethodSymbol)){
            return null;
        }
        MethodSymbol result = null;
        MethodSymbol methodSymbol = (MethodSymbol) symbol;
        if (methodSymbol.matchParameterTypes(paramTypes)){
            result = methodSymbol;
        }
        return result;
    }

    public Scope getContainingScope(){
        return containingScope;
    }
}
