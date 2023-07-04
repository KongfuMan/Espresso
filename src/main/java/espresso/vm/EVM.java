package espresso.vm;

import java.util.Stack;

/**
 * The execution engine of Espresso VM.
 *
 * */
public class EVM {
    BCModule[] modules;
    Stack<StackFrame> callStack;
    long programCounter;

    void execute(BCModule module){
        Method main = module.getMain();
        if (main == null){
            throw new IllegalArgumentException("");
        }

        callStack = new Stack<>();
        callStack.push(new StackFrame()); //create stack frame for main function
        programCounter = 0;
        while(true){
            String code = main.instructions.get(programCounter);
            switch (code){
                case "iload_0":
                    String var0 = main.localVariableTable[0]; //first local var
                    callStack.peek().operandStack.push(Integer.valueOf(var0));
                    break;

                case "iadd":
                    int operand1 = callStack.peek().operandStack.pop();
                    int operand2 = callStack.peek().operandStack.pop();
                    int res = operand1 + operand2;
                    callStack.peek().operandStack.push(res);
            }
            programCounter++;
        }
    }
}
