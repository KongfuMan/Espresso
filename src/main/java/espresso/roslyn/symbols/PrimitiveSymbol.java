package espresso.roslyn.symbols;

import java.util.List;

/** Language pre-defined types: int, float, ... */
public class PrimitiveSymbol extends TypeSymbol{

    @Override
    public List<Symbol> getMembers() {
        return null;
    }

    @Override
    public Symbol getMembers(String name) {
        return null;
    }
}
