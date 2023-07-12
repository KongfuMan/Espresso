package espresso.semantics.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.LinkedList;
import java.util.List;

public abstract class Scope extends Symbol{

    // child symbols direct contained in this scope, NOT include those contained in the nested scope.
    public List<Symbol> childSymbols;

    protected Scope(String idName, ParserRuleContext node, Scope containingScope){
        super(idName, node, containingScope);
        childSymbols = new LinkedList<>();
    }

    public void addSymbol(Symbol symbol){
        childSymbols.add(symbol);
    }

    /** look up the method symbol in current scope by method name and parameter type*/
    public MethodSymbol lookupMethodSymbol(String name, List<Type> paramTypes){
        MethodSymbol result = null;
        for (Symbol symbol : childSymbols){
            if (!symbol.getName().equals(name) || !(symbol instanceof MethodSymbol)){
                continue;
            }
            MethodSymbol methodSymbol = (MethodSymbol) symbol;
            if (methodSymbol.matchParameterTypes(paramTypes)){
                // if method name and type of each parameter match, then return the matched method symbol.
                result = methodSymbol;
                break;
            }
        }

        return result;
    }

    /** look up variable symbol by variable identifier name in current scope. */
    public VariableSymbol lookupVariableSymbol(String idName){
        for (Symbol symbol : childSymbols){
            if (symbol instanceof VariableSymbol && symbol.getName().equals(idName)){
                return (VariableSymbol) symbol;
            }
        }
        return null;
    }

    /** look up class symbol by class name in current scope. */
    public ClassSymbol lookupClassSymbol(String idName){
        for (Symbol symbol : childSymbols){
            if (symbol instanceof ClassSymbol && symbol.getName().equals(idName)){
                return (ClassSymbol) symbol;
            }
        }
        return null;
    }

    public Scope getContainingScope(){
        return containingScope;
    }
}
