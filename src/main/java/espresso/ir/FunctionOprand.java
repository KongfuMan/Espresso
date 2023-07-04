package espresso.ir;

import espresso.semantics.symbols.Type;

public class FunctionOprand extends Oprand{
    Oprand[] args;
    Type retType;

    public FunctionOprand(String funName, Oprand[] args, Type retType) {
        super(OprandKind.function, funName);
        this.args = args;
        this.retType = retType;
    }
}
