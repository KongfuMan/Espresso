package espresso.roslyn.symbols;


import java.util.List;

/**
 * Represent a type: class, or primitive type.
 * */
public abstract class TypeSymbol extends Symbol{
    public abstract List<Symbol> getMembers();
    public abstract Symbol getMembers(String name);
}
