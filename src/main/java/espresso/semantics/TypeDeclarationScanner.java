package espresso.semantics;

import espresso.semantics.symbols.*;
import espresso.syntax.EspressoBaseListener;
import espresso.syntax.EspressoParser.CompilationUnitContext;
import espresso.syntax.EspressoParser.ClassDeclarationContext;
import espresso.syntax.EspressoParser.MethodDeclarationContext;
import espresso.syntax.EspressoParser.BlockContext;
import espresso.syntax.EspressoParser.MethodBodyContext;
import espresso.syntax.EspressoParser.StatementContext;
import espresso.syntax.SemanticModel;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.Deque;
import java.util.LinkedList;

// pass1. Scan custom type declaration and check duplicate declaration in hierarchical scopes.
public class TypeDeclarationScanner extends EspressoBaseListener {
    SemanticModel semanticModel;
    Deque<Scope> stackScope;
    public TypeDeclarationScanner(SemanticModel semanticModel){
        this.semanticModel = semanticModel;
        this.stackScope = new LinkedList<>();
    }

    private void pushScope(ParserRuleContext node, Scope scope){
        semanticModel.addNodeToScope(node, scope);
        stackScope.push(scope);
    }

    private void popScope(){
        stackScope.pop();
    }

    private Scope currentScope(){
        if (!stackScope.isEmpty()){
            return stackScope.peek();
        }
        return  null;
    }

    @Override
    public void enterCompilationUnit(CompilationUnitContext node) {
        Scope compilationUnit = new CompilationUnitSymbol("", node);
        pushScope(node, compilationUnit);
    }

    @Override
    public void exitCompilationUnit(CompilationUnitContext ctx) {
        popScope();
    }

    /**
     * Since a type can be declared in a block, e.g. nested class declaration inside a
     *
     * */
    @Override
    public void enterBlock(BlockContext node) {
        if (node.getParent() instanceof MethodBodyContext){
            return;
        }

        BlockSymbol blockSymbol = new BlockSymbol(node, currentScope());
        currentScope().addSymbol("", blockSymbol);
        pushScope(node, blockSymbol);
    }

    @Override
    public void exitBlock(BlockContext node) {
        if (node.getParent() instanceof MethodBodyContext){
            return;
        }

        popScope();
    }

    @Override
    public void enterStatement(StatementContext node) {
        if (node.FOR() != null){
            BlockSymbol blockSymbol = new BlockSymbol(node, currentScope());
            currentScope().addSymbol("", blockSymbol);
            pushScope(node, blockSymbol);
        }
    }

    @Override
    public void exitStatement(StatementContext node) {
        if (node.FOR() != null){
            popScope();
        }
    }

    /**
     * Scan class declaration into typeSet.
     * Class member will be filled out later after
     * all the members are scanned.
     * */
    @Override
    public void enterClassDeclaration(ClassDeclarationContext node){
        String className = node.IDENTIFIER().getText();
        ClassSymbol classSymbol = new ClassSymbol(className, node, currentScope());
        semanticModel.addType(classSymbol);
        if (semanticModel.lookup(currentScope(), classSymbol)){
            semanticModel.addDiagnose("duplicate class declaration.");
        }
        currentScope().addSymbol(className, classSymbol);
        pushScope(node, classSymbol);
    }

    @Override
    public void enterMethodDeclaration(MethodDeclarationContext node) {
        String idName = node.IDENTIFIER().getText();
        MethodSymbol methodSymbol = new MethodSymbol(idName, node, currentScope());
        currentScope().addSymbol(idName, methodSymbol);
        pushScope(node, methodSymbol);
    }

    @Override
    public void exitMethodDeclaration(MethodDeclarationContext ctx) {
        popScope();
    }
}
