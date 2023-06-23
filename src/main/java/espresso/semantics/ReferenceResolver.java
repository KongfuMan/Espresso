package espresso.semantics;

import espresso.semantics.symbols.Scope;
import espresso.semantics.symbols.VariableSymbol;
import espresso.syntax.EspressoBaseListener;
import espresso.syntax.EspressoParser;
import espresso.syntax.SemanticModel;

// pass3.
public class ReferenceResolver extends EspressoBaseListener {
    private final SemanticModel semanticModel;

    public ReferenceResolver(SemanticModel semanticModel){
        this.semanticModel = semanticModel;
    }

    @Override
    public void exitPrimary(EspressoParser.PrimaryContext node) {
        // search for Symbol by idName of primary node in the containing scope or its ancestor scopes
        Scope scope = semanticModel.getContainingScope(node);
        String idName = node.IDENTIFIER().getText();
        VariableSymbol variableSymbol = semanticModel.lookupVariableSymbol(scope, idName);
        if (variableSymbol != null){
            semanticModel.addNodeToSymbol(node, variableSymbol);
        }else{
            semanticModel.addDiagnose("unknown variable or function: " + idName);
        }

        super.exitPrimary(node);
    }
}
