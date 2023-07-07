package espresso.roslyn.symbols;

import com.beust.ah.A;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassSymbol extends TypeSymbol{
    List<TypeSymbol> implementedInterfaces;
    ClassSymbol baseType;
    Map<String, List<Symbol>> members;
    List<Symbol> allMembers;

    @Override
    public List<Symbol> getMembers() {
        if (allMembers != null){
            return allMembers;
        }
        allMembers = new ArrayList<>();
        makeAllMembers();
        return allMembers;
    }

    private List<Symbol> makeAllMembers(){
        for (ParseTree child : declaringSyntaxNode.children) {

        }

        return null;
    }

    @Override
    public Symbol getMembers(String name) {
        return null;
    }
}
