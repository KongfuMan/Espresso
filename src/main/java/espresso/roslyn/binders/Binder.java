package espresso.roslyn.binders;

/**
 * Binder to bind the syntax to declaration
 * */
public class Binder {
    public Binder Next;

    public Binder(Binder binder){
        this.Next = binder;
    }
}
