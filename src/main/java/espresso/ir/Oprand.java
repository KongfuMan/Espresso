package espresso.ir;

/** single value operand*/
public class Oprand {
    OprandKind kind;
    Object value;

    public Oprand(OprandKind kind, Object value){
        this.kind = kind;
        this.value = value;
    }
}
