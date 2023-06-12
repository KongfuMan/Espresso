package espresso.semantics.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.concurrent.atomic.AtomicInteger;

public class BlockSymbol extends Scope {
    private static final AtomicInteger indexer = new AtomicInteger();
    public BlockSymbol(ParserRuleContext node, Scope containingScope){
        super("block_" + indexer.addAndGet(1), node, containingScope);
    }
}
