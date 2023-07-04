package espresso.roslyn.binders;

import espresso.semantics.symbols.ClassSymbol;

public class ClassBinder extends Binder{
    private final ClassSymbol classSymbol;
    public ClassBinder(ClassSymbol classSymbol, Binder binder) {
        super(binder);
        this.classSymbol = classSymbol;
    }
}
