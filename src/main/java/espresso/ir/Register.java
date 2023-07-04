package espresso.ir;

/**
 * register oprand, can be an immediate number or memory address or other register
 * */
public class Register extends Oprand{
    boolean is32;
    public Register(String regName, boolean is32) {
        super(OprandKind.register, regName);
        this.is32 = is32;
    }
}
