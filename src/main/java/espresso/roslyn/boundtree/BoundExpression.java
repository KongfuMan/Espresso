package espresso.roslyn.boundtree;

import espresso.roslyn.symbols.TypeSymbol;
import org.antlr.v4.runtime.ParserRuleContext;

public class BoundExpression extends BoundNode{
    final TypeSymbol type;

    public BoundExpression(ParserRuleContext node, TypeSymbol type) {
        super(node);
        this.type = type;
    }
}
