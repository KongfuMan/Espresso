package espresso.semantics.symbols;

import espresso.semantics.symbols.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

public class SymbolTable {
    final ParseTree syntaxTree;
    Set<Type> typeSet;
    public List<String> diagnostics;

    // <declaration syntax node : Type>
    Map<ParserRuleContext, Type> node2Type;

    // <syntax node, represented scope of node (NOT containing scope))>
    Map<ParserRuleContext, Scope> node2Scope;

    // <referencing syntax node, declaration symbol>
    Map<ParserRuleContext, Symbol> node2Symbol;

    public SymbolTable(ParseTree syntaxTree){
        this.typeSet = new HashSet<>();
        this.diagnostics = new ArrayList<>();
        this.node2Type = new HashMap<>();
        this.node2Symbol = new HashMap<>();
        this.node2Scope = new HashMap<>();
        this.syntaxTree = syntaxTree;
    }

    public ParseTree getSyntaxTree(){
        return this.syntaxTree;
    }

    public void addType(Type type){
        typeSet.add(type);
    }

    public void addNodeToType(ParserRuleContext node, Type type){
        node2Type.put(node, type);
    }

    public void addNodeToScope(ParserRuleContext node, Scope scope){
        node2Scope.put(node, scope);
    }

    public Type getType(ParserRuleContext node){
        return node2Type.get(node);
    }

    public void addDiagnose(String msg){
        diagnostics.add(msg);
    }

    /**
     * Search for containing scope of this node up to root scope.
     * */
    public Scope getContainingScope(ParserRuleContext node) {
        node = node.getParent();
        while(node != null){
            if(node2Scope.containsKey(node)){
                return node2Scope.get(node);
            }
            node = node.getParent();
        }
        return null;
    }

    public void addNodeToSymbol(ParserRuleContext node, Symbol symbol){
        node2Symbol.put(node, symbol);
    }

    public Symbol getSymbol(ParserRuleContext node){
        return node2Symbol.get(node);
    }

    /**
     * Get the scope by the representing node(class, method, block)
     * */
    public Scope getAssociatedScope(ParserRuleContext node){
        return node2Scope.get(node);
    }

    /**
     * Get the type definition by the idName.
     * */
    public Type lookupType(String typeName){
        for (Type type : typeSet){
            if (type.getName().equals(typeName)){
                return type;
            }
        }
        return null;
    }

    /**
     * Search from current scope to root scope for the variable by idName
     * */
    public VariableSymbol lookupVariableSymbol(Scope scope, String idName){
        while(scope != null){
            VariableSymbol symbol = scope.lookupVariableSymbol(idName);
            if (symbol != null){
                return symbol;
            }
            scope = scope.getContainingScope();
        }
        return null;
    }

    /**
     * Search for lowest ascendant class symbol of the scope by idName.
     * */
    public ClassSymbol lookupClassSymbol(Scope scope, String idName){
        while(scope != null){
            if (scope instanceof ClassSymbol &&  scope.getName().equals(idName)){
                return (ClassSymbol) scope;
            }
            scope = scope.getContainingScope();
        }
        return null;
    }

    /**
     * Look up ascendant ClassSymbol to see if there is one with the given name
     * */
    public boolean existAscendantClassSymbolOfIdName(Scope scope, String idName){
        while(scope != null){
            if (scope instanceof ClassSymbol &&  scope.getName().equals(idName)){
                return true;
            }
            scope = scope.getContainingScope();
        }
        return false;
    }
}
