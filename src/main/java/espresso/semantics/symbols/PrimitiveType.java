package espresso.semantics.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

public class PrimitiveType implements Type{
    private final String name;

    public PrimitiveType(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isType(Type type){
        return this == type;
    }
}
