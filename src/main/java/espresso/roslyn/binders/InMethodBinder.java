package espresso.roslyn.binders;

import espresso.semantics.symbols.MethodSymbol;

public class InMethodBinder extends Binder{
    private final MethodSymbol methodSymbol;

    public InMethodBinder(MethodSymbol methodSymbol, Binder binder) {
        super(binder);
        this.methodSymbol = methodSymbol;
    }
}
