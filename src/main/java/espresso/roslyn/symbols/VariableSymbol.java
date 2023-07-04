package espresso.roslyn.symbols;

/**
 * Represent a variable declaration in method body,
 * or field of class, or method parameters.
 * */
public class VariableSymbol extends Symbol{

    /** Type for variable declaration*/
    private TypeSymbol type;
}
