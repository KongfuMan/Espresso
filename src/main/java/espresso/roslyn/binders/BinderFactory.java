package espresso.roslyn.binders;

import espresso.semantics.symbols.ClassSymbol;
import espresso.syntax.EspressoBaseVisitor;
import espresso.syntax.EspressoParser.*;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

public class BinderFactory {
    SemanticModel semanticModel;

    public BinderFactory(SemanticModel semanticModel){
        this.semanticModel = semanticModel;
    }

    Binder getBinder(RuleContext node){
        BinderFactoryVisitor visitor = new BinderFactoryVisitor();
        return visitor.visit(node);
    }

    public class BinderFactoryVisitor extends EspressoBaseVisitor<Binder> {
//        private final BinderFactory factory;

        BinderFactoryVisitor(){
//            this.factory = factory;
        }

        @Override
        public Binder visit(ParseTree tree) {
            return tree.accept(this);
        }

        @Override
        public Binder visitCompilationUnit(CompilationUnitContext ctx) {
            Binder result = new DummyEndBinder();
            result = new CompilationUnitBinder(BinderFactory.this.semanticModel.compilationUnitSymbol, result);
            return result;
        }

        @Override
        public Binder visitClassDeclaration(ClassDeclarationContext ctx) {
            Binder result = visit(ctx.getParent());
            ClassSymbol classSymbol = BinderFactory.this.semanticModel.compilationUnitSymbol.lookupClassSymbol(ctx.IDENTIFIER().getText());
            result = new ClassBinder(classSymbol, result);
            return result;
        }

        @Override
        public Binder visitMethodDeclaration(MethodDeclarationContext ctx) {
            Binder result = visit(ctx.getParent());
            return result;
        }
    }
}
