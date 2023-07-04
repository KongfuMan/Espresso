package espresso.roslyn.binders;

public class Binder {
    public Binder Next;

    public Binder(Binder binder){
        this.Next = binder;
    }
}
