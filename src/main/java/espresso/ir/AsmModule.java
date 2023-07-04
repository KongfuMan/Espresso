package espresso.ir;


import espresso.semantics.symbols.MethodSymbol;

import java.util.Map;

/**
 * represent an assembly
 * */
public class AsmModule {
    Map<MethodSymbol, BasicBlock[]> funBlocks;
    Map<MethodSymbol, Integer> funMaxVarCount;
    String[] stringConsts;
}
