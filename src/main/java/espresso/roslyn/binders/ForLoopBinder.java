package espresso.roslyn.binders;

import espresso.syntax.EspressoParser.*;

public class ForLoopBinder extends Binder{
    private final StatementContext forStatement;
    public ForLoopBinder(StatementContext forStatement, Binder binder) {
        super(binder);
        this.forStatement = forStatement;
    }
}
