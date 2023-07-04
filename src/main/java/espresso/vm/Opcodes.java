package espresso.vm;

/**
 * The operation code of espresso virtual machine.
 *
 * */
public interface Opcodes{
    int iconst_0= 0x03;
    int iconst_1= 0x04;
    int iconst_2= 0x05;
    int iconst_3= 0x06;
    int iconst_4= 0x07;
    int iconst_5= 0x08;
    int bipush  = 0x10;  //8位整数入栈
    int sipush  = 0x11;  //16位整数入栈
    int iload   = 0x15;  //本地变量入栈
    int iload_0 = 0x1a;
    int iload_1 = 0x1b;
    int iload_2 = 0x1c;
    int iload_3 = 0x1d;
    int istore  = 0x36;
    int istore_0= 0x3b;
    int istore_1= 0x3c;
    int istore_2= 0x3d;
    int istore_3= 0x3e;
    int iaddint = 0x60;
    int isubint = 0x64;
    int imulint = 0x68;
    int idivint = 0x6c;
    int ireturn = 0xac;
    int voidreturn  = 0xb1;
    int invokestatic= 0xb8; //调用函数
}
