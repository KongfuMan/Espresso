package espresso.semantics.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MethodSymbol extends Scope{
    private Type returnType;

    private List<VariableSymbol> parameterList;
    private List<Type> parameterTypes;

    public MethodSymbol(String idName, ParserRuleContext node, Scope containingScope) {
        super(idName, node, containingScope);
        this.parameterList = new LinkedList<>();
        this.parameterTypes = new LinkedList<>();
    }

    public void setReturnType(Type returnType){
        this.returnType = returnType;
    }

    public Type getReturnType(){
        return this.returnType;
    }

    public void addParameter(VariableSymbol variable){
        this.parameterList.add(variable);
        this.parameterTypes.add(variable.getType());
    }

    public List<Type> getParameterTypes(){
        return this.parameterTypes;
    }

    /**
     * 检查改函数是否匹配所需的参数。
     * @param paramTypes
     * @return
     */
    public boolean matchParameterTypes(List<Type> paramTypes){
        // 比较每个参数
        if (parameterList.size() != paramTypes.size()) {
            return false;
        }

        boolean match = true;
        for (int i = 0; i < paramTypes.size(); i++) {
            VariableSymbol var = parameterList.get(i);
            Type type = paramTypes.get(i);
            if (!var.getType().isType(type)) {
                match = false;
                break;
            }
        }

        return match;
    }
}
