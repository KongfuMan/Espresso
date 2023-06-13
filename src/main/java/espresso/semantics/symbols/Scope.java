package espresso.semantics.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Scope extends Symbol{

    // direct child symbol in this scope, NOT including descendants of nested scope.
    public Map<String, Symbol> childScopes;
    protected Scope(String idName, ParserRuleContext node, Scope containingScope){
        super(idName, node, containingScope);
        childScopes = new HashMap<>();
    }

    public void addSymbol(String name, Symbol symbol){
        childScopes.put(name, symbol);
    }

    public boolean lookup(Symbol symbol){
        return childScopes.containsKey(symbol.getName());
    }

    public MethodSymbol getMethodDeclaration(String name, List<Type> paramTypes){
        if (!childScopes.containsKey(name)){
            return null;
        }
        Symbol symbol = childScopes.get(name);
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
