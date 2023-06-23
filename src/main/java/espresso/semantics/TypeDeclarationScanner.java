package espresso.semantics;

import espresso.semantics.symbols.*;
import espresso.syntax.*;
import espresso.syntax.EspressoParser.*;
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

    /**
     * Since a type can be declared in a block, e.g. nested class declaration inside a method block.
     *
     * */
    @Override
    public void enterBlock(EspressoParser.BlockContext node) {
        if (node.getParent() instanceof MethodBodyContext){
            // skip the method body block, since we've already had a method scope
            return;
        }

        BlockSymbol blockSymbol = new BlockSymbol(node, currentScope());
        currentScope().addSymbol(blockSymbol);
        pushScope(node, blockSymbol);
    }

    @Override
    public void exitBlock(BlockContext node) {
        if (node.getParent() instanceof MethodBodyContext){
            return;
        }

        popScope();
    }

    // create scope for only FOR  statement.
    @Override
    public void enterStatement(StatementContext node) {
        if (node.FOR() != null){
            BlockSymbol blockSymbol = new BlockSymbol(node, currentScope());
            currentScope().addSymbol(blockSymbol);
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
     * Scan the single namespace declaration in this compilation unit.
     * */
    @Override
    public void enterCompilationUnit(CompilationUnitContext node) {
        Scope ns = new CompilationUnitSymbol("", node);
        pushScope(node, ns);
    }

    @Override
    public void exitCompilationUnit(CompilationUnitContext node) {
        popScope();
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
        currentScope().addSymbol(classSymbol);
        pushScope(node, classSymbol);
    }

    @Override
    public void enterMethodDeclaration(MethodDeclarationContext node) {
        String idName = node.IDENTIFIER().getText();
        MethodSymbol methodSymbol = new MethodSymbol(idName, node, currentScope());
        currentScope().addSymbol(methodSymbol);
        pushScope(node, methodSymbol);
    }

    @Override
    public void exitMethodDeclaration(MethodDeclarationContext ctx) {
        popScope();
    }
}
