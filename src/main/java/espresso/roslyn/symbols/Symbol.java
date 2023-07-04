package espresso.roslyn.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

public class Symbol {
    protected String name;

    /** immediate symbol containing this symbol*/
    protected Symbol containingSymbol;

    protected ParserRuleContext declaringSyntaxNode;
}
