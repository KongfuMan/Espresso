package espresso.vm;

import java.util.Stack;

/**
 *  Frame of EVM call stack
 * */
public class StackFrame {

    // Stack for operands. Assume only support integer.
    Stack<Integer> operandStack;
    String[] localVars;
    long returnPC;
}
