package espresso.ir;

public enum OprandKind {

    /**logical registers*/
    regIndex,
    bb,
    function,
    stringConst,

    /**physical registers*/
    register,
    memory,
    immediate,

    flag
}
