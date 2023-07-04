package espresso.semantics;

import espresso.syntax.EspressoBaseVisitor;
import espresso.syntax.EspressoParser;
import espresso.syntax.SemanticModel;
import espresso.vm.Opcodes;

/**
 * Convert the resolved AST to byte code recognized by espresso VM.
 * */
public class EVMBytecodeGen extends EspressoBaseVisitor implements Opcodes {
    private SemanticModel semanticModel;

    public EVMBytecodeGen(SemanticModel semanticModel){
        this.semanticModel = semanticModel;
    }


    @Override
    public Object visitExpression(EspressoParser.ExpressionContext node) {
        return super.visitExpression(node);
    }
}
