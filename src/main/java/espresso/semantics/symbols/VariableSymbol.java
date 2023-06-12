package espresso.semantics.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

// represents variable declaration, which includes class field, method parameters and local variables in a block
public class VariableSymbol extends Symbol{
    private Type type;

    public VariableSymbol(String idName, ParserRuleContext node, Scope containingScope) {
        super(idName, node, containingScope);
    }

    public void setType(Type type){
        this.type = type;
    }

    public Type getType(){
        return this.type;
    }
}
