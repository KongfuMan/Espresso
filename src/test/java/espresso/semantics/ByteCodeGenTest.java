package espresso.semantics;

import org.junit.jupiter.api.Test;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.objectweb.asm.Opcodes.*;

class ByteCodeGenTest {

    @Test
    public void test() throws IOException {
        String code = """
                public class MyClass {
                    public int foo(int a){
                        return a + 3;
                    }
                }
                """;

        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        classWriter.visit(V1_8, ACC_PUBLIC, "MyClass", null, null, null);
        genFooMethod(classWriter);
        classWriter.visitEnd();

        byte[] data = classWriter.toByteArray();
        File file = new File("MyClass2.class");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(data);
        fos.close();
    }

    //创建foo方法
    private static void genFooMethod(ClassWriter classWriter){
        MethodVisitor methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "foo",
                "(I)I",  //括号中的是参数类型，括号后面的是返回值类型
                null, null);

        //添加参数a
        methodVisitor.visitParameter("a", ACC_PUBLIC);
        methodVisitor.visitVarInsn(ILOAD, 1);
        methodVisitor.visitInsn(ICONST_3);
        methodVisitor.visitInsn(IADD);
        methodVisitor.visitInsn(IRETURN);

        methodVisitor.visitMaxs(2, 2);
        methodVisitor.visitEnd();
    }

}