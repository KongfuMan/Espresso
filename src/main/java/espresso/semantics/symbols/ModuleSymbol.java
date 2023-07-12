package espresso.semantics.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

//TODO: java module is mapping into a folder in OS file system.
public class ModuleSymbol extends Scope{
    protected ModuleSymbol(String idName, ParserRuleContext node, Scope containingScope) {
        super(idName, node, containingScope);
    }
}
