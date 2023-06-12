package espresso.syntax;

import espresso.semantics.symbols.ClassSymbol;
import espresso.semantics.symbols.Scope;
import espresso.semantics.symbols.Symbol;
import espresso.semantics.symbols.Type;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

public class SemanticModel {
    private ParseTree syntaxTree;
    Set<Type> typeSet;
    List<String> diagnostics;

    // <declaration syntax node : Type>
    Map<ParserRuleContext, Type> node2Type;

    // <syntax node, represented scope of node (NOT containing scope))>
    Map<ParserRuleContext, Scope> node2Scope;

    // <referencing syntax node, declaration symbol>
    Map<ParserRuleContext, Symbol> node2Symbol;

    public SemanticModel(ParseTree syntaxTree){
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

    public Type getNodeType(ParserRuleContext node){
        return node2Type.get(node);
    }

    public void addDiagnose(String msg){
        diagnostics.add(msg);
    }

    public void addNodeToScope(ParserRuleContext node, Scope scope){
        node2Scope.put(node, scope);
    }

    public boolean lookup(Scope scope, Symbol symbol){
        while(scope != null){
            if (scope.lookup(symbol)){
                return true;
            }
            scope = scope.getContainingScope();
        }
        return false;
    }

    public ClassSymbol lookupClassUpwards(Scope scope, String idName){
        while(scope != null){
            if (scope instanceof ClassSymbol &&  scope.getName().equals(idName)){
                return (ClassSymbol) scope;
            }
            scope = scope.getContainingScope();
        }
        return null;
    }

    /**
     * Search for containing scope of this node up to root scope.
     * */
    public Scope getContainingScope(ParserRuleContext node) {
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

    public Scope getAssociatedScope(ParserRuleContext node){
        return node2Scope.get(node);
    }

    public Type getType(String typeName){
        for (Type type : typeSet){
            if (type.getName().equals(typeName)){
                return type;
            }
        }
        return null;
    }
}
