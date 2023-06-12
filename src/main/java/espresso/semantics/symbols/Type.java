package espresso.semantics.symbols;

/**
 * Class, Primitive type
 * */
public interface Type {

    /**
     * Get full qualified name
     * */
    String getName();

    /**
     * Check if given type is a super type of this
     * */
    boolean isType(Type type);
}
