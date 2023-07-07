package espresso.roslyn;

import espresso.roslyn.boundtree.BoundNode;
import espresso.roslyn.symbols.Symbol;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;
import java.util.Map;

public class MemberSemanticModel {
    final Symbol symbol;
    final ParserRuleContext root;
    Map<ParserRuleContext, List<BoundNode>> boundNodeMap;

    public MemberSemanticModel(Symbol symbol, ParserRuleContext root){
        this.symbol = symbol;
        this.root = root;
    }
}
