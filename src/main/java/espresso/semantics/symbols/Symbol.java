package espresso.semantics.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

import java.awt.*;

public abstract class Symbol {
    protected String idName;
    protected Scope containingScope;
    protected Symbol containingClass;
    protected Symbol containingMethod;
    protected ParserRuleContext node;

    protected Symbol(String idName, ParserRuleContext node,Scope containingScope){
        this.idName = idName;
        this.node = node;
        this.containingScope = containingScope;
    }

    public String getFullName(){
        return idName;
    }

    public void setContainingScope(Scope scope){
        this.containingScope = scope;
    }
}
