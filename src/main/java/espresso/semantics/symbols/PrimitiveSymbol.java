package espresso.semantics.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

public class PrimitiveSymbol extends Symbol implements Type{
    protected PrimitiveSymbol(String idName, ParserRuleContext node, Scope containingScope) {
        super(idName, node, containingScope);
    }

    public static PrimitiveSymbol Integer(ParserRuleContext node, Scope containingScope) {
        return new PrimitiveSymbol("Integer", node, containingScope);
    }
    public static PrimitiveSymbol Long(ParserRuleContext node, Scope containingScope) {
        return new PrimitiveSymbol("Long", node, containingScope);
    }

    public static PrimitiveSymbol Float(ParserRuleContext node, Scope containingScope) {
        return new PrimitiveSymbol("Float", node, containingScope);
    }

    public static PrimitiveSymbol Double(ParserRuleContext node, Scope containingScope) {
        return new PrimitiveSymbol("Double", node, containingScope);
    }

    public static PrimitiveSymbol Boolean(ParserRuleContext node, Scope containingScope) {
        return new PrimitiveSymbol("Boolean", node, containingScope);
    }

    public static PrimitiveSymbol Byte(ParserRuleContext node, Scope containingScope) {
        return new PrimitiveSymbol("Byte", node, containingScope);
    }
    public static PrimitiveSymbol Char(ParserRuleContext node, Scope containingScope) {
        return new PrimitiveSymbol("Char", node, containingScope);
    }
    public static PrimitiveSymbol Short(ParserRuleContext node, Scope containingScope) {
        return new PrimitiveSymbol("Short", node, containingScope);
    }

    public static PrimitiveSymbol String(ParserRuleContext node, Scope containingScope) {
        return new PrimitiveSymbol("Short", node, containingScope); //增加String为基础类型
    }

    public static PrimitiveSymbol Null(ParserRuleContext node, Scope containingScope) {
        return new PrimitiveSymbol("null", node, containingScope);
    }

    @Override
    public boolean isType(Type type){
        return this == type;
    }
}
