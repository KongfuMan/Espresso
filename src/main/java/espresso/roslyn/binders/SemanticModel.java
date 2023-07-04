package espresso.roslyn.binders;

import espresso.semantics.symbols.CompilationUnitSymbol;
import org.antlr.v4.runtime.RuleContext;

public class SemanticModel {
    public CompilationUnitSymbol compilationUnitSymbol;
    Binder getBinder(RuleContext node){
        return getBinderFactory(node.getParent()).getBinder(node);
    }

    BinderFactory getBinderFactory(RuleContext tree){
        return new BinderFactory(this);
    }
}
