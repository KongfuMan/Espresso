package espresso.semantics;

import espresso.syntax.EspressoBaseVisitor;
import espresso.syntax.EspressoParser;
import espresso.vm.Opcodes;

/**
 * Convert the resolved AST to byte code recognized by espresso VM.
 * */
public class EVMBytecodeGen extends EspressoBaseVisitor implements Opcodes {
    private SymbolTable symbolTable;

    public EVMBytecodeGen(SymbolTable symbolTable){
        this.symbolTable = symbolTable;
    }


    @Override
    public Object visitExpression(EspressoParser.ExpressionContext node) {
        return super.visitExpression(node);
    }
}
