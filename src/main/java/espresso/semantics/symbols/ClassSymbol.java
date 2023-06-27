package espresso.semantics.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

public class ClassSymbol extends Scope implements Type{
    private ClassSymbol baseType;

    public ClassSymbol(String idName, ParserRuleContext node, Scope containingScope){
        super(idName, node, containingScope);
    }

    public void setBaseType(Type baseType){
        if (!(baseType instanceof ClassSymbol)){
            throw new IllegalArgumentException("Base type is not a class");
        }
        this.baseType = (ClassSymbol)baseType;
    }

    public Type getBaseType(){
        return this.baseType;
    }

    @Override
    public boolean isType(Type type) {
        if (!(type instanceof ClassSymbol)){
            return false;
        }

        if (type == this){
            return true;
        }

        ClassSymbol baseSymbol = (ClassSymbol) this.getBaseType();
        while(baseSymbol != null){
            if (baseSymbol == type){
                return true;
            }
            baseSymbol = (ClassSymbol) baseSymbol.getBaseType();
        }
        return false;
    }
}
