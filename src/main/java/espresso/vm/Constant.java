package espresso.vm;

enum ConstantType{
    MethodRef,
    Class,
    NameAndType,
    UTF8,
}

public class Constant {
    int index; // in the pool
    ConstantType type;
    String value;
}
