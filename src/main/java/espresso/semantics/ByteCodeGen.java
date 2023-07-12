package espresso.semantics;

import espresso.syntax.EspressoBaseVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

/**
 * Convert the semantic model to JAVA byte code
 * */
public class ByteCodeGen extends EspressoBaseVisitor implements Opcodes {
    private SymbolTable symbolTable;

    private ClassWriter classWriter;

    public ByteCodeGen(SymbolTable symbolTable){
        this.symbolTable = symbolTable;
    }

    public byte[] generate(){
        return null;
    }
}
