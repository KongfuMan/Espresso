package espresso.semantics;

import espresso.semantics.symbols.*;
import espresso.syntax.EspressoBaseListener;
import espresso.syntax.EspressoParser.*;
import espresso.syntax.EspressoParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

// pass3.
public class ReferenceResolver extends EspressoBaseListener {
    private final SymbolTable symbolTable;

    public ReferenceResolver(SymbolTable symbolTable){
        this.symbolTable = symbolTable;
    }

    @Override
    public void enterVariableDeclarators(VariableDeclaratorsContext node) {
        Scope scope = symbolTable.getContainingScope(node);
        if (scope instanceof BlockSymbol || scope instanceof MethodSymbol){
            TypeResolver pass2 = new TypeResolver(symbolTable, true);
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(pass2, symbolTable.getSyntaxTree());
        }
    }

    /**
     *  int myVar = 0;
     *  expression: myVar = myExpression2
     *       primary:
     *           IDENTIFIER:
     *                 myVar
     *       bop: '='
     *       expression: myExpression2
     *  myVar = myExpression2;
     * */
    @Override
    public void exitPrimary(PrimaryContext node) {
        if (node.IDENTIFIER() == null){
            return;
        }
        // search for Symbol by idName of primary node in the containing scope or its ancestor scopes
        Type type = null;
        Scope scope = symbolTable.getContainingScope(node);
        String idName = node.IDENTIFIER().getText();
        VariableSymbol variableSymbol = symbolTable.lookupVariableSymbol(scope, idName);
        if (variableSymbol != null){
            symbolTable.addNodeToSymbol(node, variableSymbol);
            type = variableSymbol.getType();
        }else{
            symbolTable.addDiagnose("unknown variable or function: " + idName);
        }

        // set declared type for primary node, e.g. <myVar, int>
        symbolTable.addNodeToType(node, type);
    }

    @Override
    public void exitMethodCall(MethodCallContext node) {
        super.exitMethodCall(node);
    }

    @Override
    public void exitExpression(ExpressionContext node) {
        Token bop = node.bop;

        // expression: myObj.method(...)
        //      primary: myObj
        //      bop: .
        //      methodCall: method(...)
        //            identifier: method
        if (bop != null && bop.getType() == EspressoParser.DOT){
            ExpressionContext primary = node.expression(0);
            symbolTable.getType(primary);
            // ...
        }

        // flatten the <node:type> of "expression (primary ("a"))"
        if (node.primary() != null){
            // variable declaration symbol of primary
            Symbol symbol = symbolTable.getSymbol(node.primary());
            symbolTable.addNodeToSymbol(node, symbol);
        }

        Type type = null;
        if (node.primary() != null){
            type = symbolTable.getType(node.primary());
        }
        // assignment expression:
        //      int a = 0;
        //      a = expression;
        if (bop != null && bop.getType() == EspressoParser.ASSIGN){
            ExpressionContext expression = node.expression(0);
            if (expression.primary() != null){
                type = symbolTable.getType(expression.primary());
            }

            int i = 0;
        }
        symbolTable.addNodeToType(node, type);
    }
}
