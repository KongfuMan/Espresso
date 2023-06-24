package espresso.semantics.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

public class PrimitiveSymbol extends Symbol implements Type{

    public static PrimitiveSymbol Integer;
    public static PrimitiveSymbol Long;
    public static PrimitiveSymbol Float;
    public static PrimitiveSymbol Double;
    public static PrimitiveSymbol Boolean;
    public static PrimitiveSymbol Byte;
    public static PrimitiveSymbol Char;
    public static PrimitiveSymbol Short;
    public static PrimitiveSymbol String; //增加String为基础类型
    public static PrimitiveSymbol Null;

    protected PrimitiveSymbol(String idName, ParserRuleContext node, Scope containingScope) {
        super(idName, node, containingScope);
    }

    public static PrimitiveSymbol Integer(ParserRuleContext node, Scope containingScope) {
        return Integer != null ? Integer : (Integer = new PrimitiveSymbol("Integer", node, containingScope));
    }

    public static PrimitiveSymbol Long(ParserRuleContext node, Scope containingScope) {
        return Long != null ? Long : (Long = new PrimitiveSymbol("Long", node, containingScope));
    }

    public static PrimitiveSymbol Float(ParserRuleContext node, Scope containingScope) {
        return Float != null ? Float : (Float = new PrimitiveSymbol("Float", node, containingScope));
    }

    public static PrimitiveSymbol Double(ParserRuleContext node, Scope containingScope) {
        return Double != null ? Double : (Double = new PrimitiveSymbol("Double", node, containingScope));
    }

    public static PrimitiveSymbol Boolean(ParserRuleContext node, Scope containingScope) {
        return Boolean != null ? Boolean : (Boolean = new PrimitiveSymbol("Boolean", node, containingScope));
    }

    public static PrimitiveSymbol Byte(ParserRuleContext node, Scope containingScope) {
        return Byte != null ? Byte : (Byte = new PrimitiveSymbol("Byte", node, containingScope));
    }

    public static PrimitiveSymbol Char(ParserRuleContext node, Scope containingScope) {
        return Char != null ? Char : (Char = new PrimitiveSymbol("Char", node, containingScope));
    }

    public static PrimitiveSymbol Short(ParserRuleContext node, Scope containingScope) {
        return Short != null ? Short : (Short = new PrimitiveSymbol("Short", node, containingScope));
    }

    public static PrimitiveSymbol String(ParserRuleContext node, Scope containingScope) {
        return String != null ? String : (String = new PrimitiveSymbol("String", node, containingScope)); //增加String为基础类型
    }

    public static PrimitiveSymbol Null(ParserRuleContext node, Scope containingScope) {
        return Null != null ? Null : (Null = new PrimitiveSymbol("null", node, containingScope));
    }

    @Override
    public boolean isType(Type type){
        return this == type;
    }
}
