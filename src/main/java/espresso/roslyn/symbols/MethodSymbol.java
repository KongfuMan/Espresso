package espresso.roslyn.symbols;

import java.util.List;

public class MethodSymbol extends Symbol{
    private TypeSymbol returnType;
    private List<TypeSymbol> paramTypes;
}
