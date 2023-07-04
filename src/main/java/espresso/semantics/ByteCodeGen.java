package espresso.semantics;

import espresso.syntax.EspressoBaseVisitor;
import espresso.syntax.SemanticModel;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

/**
 * Convert the semantic model to JAVA byte code
 * */
public class ByteCodeGen extends EspressoBaseVisitor implements Opcodes {
    private SemanticModel semanticModel;

    private ClassWriter classWriter;

    public ByteCodeGen(SemanticModel semanticModel){
        this.semanticModel = semanticModel;
    }

    public byte[] generate(){
        return null;
    }
}
