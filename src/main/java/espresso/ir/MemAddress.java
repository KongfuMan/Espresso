package espresso.ir;

/**
 * Memory address oprand.
 * */
public class MemAddress extends Oprand{
    Register register;
    long offset;

    public MemAddress(Register register, long offset) {
        super(OprandKind.memory, "undefined");
        this.register = register;
        this.offset = offset;
    }
}
