package espresso.semantics.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.LinkedList;
import java.util.List;

public abstract class Scope extends Symbol{

    // direct child symbols in this scope, NOT including descendants of nested scope.
    public List<Symbol> childSymbols;

    protected Scope(String idName, ParserRuleContext node, Scope containingScope){
        super(idName, node, containingScope);
        childSymbols = new LinkedList<>();
    }

    public void addSymbol(Symbol symbol){
        childSymbols.add(symbol);
    }

    /**
     * Check if symbol has already existed in the scope.
     * */
    public boolean contains(Symbol targetSymbol){
        for(Symbol symbol : childSymbols){
            if (symbol == targetSymbol){
                return true;
            }
        }
        return false;
    }

    public MethodSymbol getMethodDeclaration(String name, List<Type> paramTypes){
        MethodSymbol result = null;
        for (Symbol symbol : childSymbols){
            if (!symbol.getName().equals(name) || !(symbol instanceof MethodSymbol)){
                continue;
            }
            MethodSymbol methodSymbol = (MethodSymbol) symbol;
            if (methodSymbol.matchParameterTypes(paramTypes)){
                result = methodSymbol;
            }
        }

        return result;
    }

    public VariableSymbol getVariableSymbol(String idName){
        for (Symbol symbol : childSymbols){
            if (symbol instanceof VariableSymbol && symbol.getName().equals(idName)){
                return (VariableSymbol) symbol;
            }
        }
        return null;
    }

    public ClassSymbol getClassSymbol(String idName){
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
