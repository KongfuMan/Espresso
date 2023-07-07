package espresso.roslyn;

import espresso.roslyn.symbols.Symbol;
import org.antlr.v4.runtime.ParserRuleContext;

public class MethodBodySemanticModel extends MemberSemanticModel {

    public MethodBodySemanticModel(Symbol symbol, ParserRuleContext root) {
        super(symbol, root);
    }
}
