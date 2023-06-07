package espresso.syntax;

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

    // <syntax node,  associated scope symbol(not containing scope))>
    Map<ParserRuleContext, Scope> nodeOfScope;

    // <syntax node, declaration symbol>
    Map<ParserRuleContext, Symbol> node2Symbol;

    public SemanticModel(ParseTree syntaxTree){
        this.typeSet = new HashSet<>();
        this.diagnostics = new ArrayList<>();
        this.node2Type = new HashMap<>();
        this.node2Symbol = new HashMap<>();
        this.nodeOfScope = new HashMap<>();
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

    public void addDiagnose(String msg){
        diagnostics.add(msg);
    }

    public void addNodeToScope(ParserRuleContext node, Scope scope){
        nodeOfScope.put(node, scope);
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
}
