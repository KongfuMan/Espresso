package espresso.roslyn.binders;

import espresso.semantics.symbols.CompilationUnitSymbol;

public class CompilationUnitBinder extends Binder{
    private CompilationUnitSymbol compilationUnitSymbol;
    public CompilationUnitBinder(CompilationUnitSymbol compilationUnitSymbol, Binder binder) {
        super(binder);
        this.compilationUnitSymbol = compilationUnitSymbol;
    }
}
