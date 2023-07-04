package espresso.ir;

import espresso.syntax.EspressoBaseVisitor;
import espresso.syntax.EspressoParser;
import espresso.syntax.SemanticModel;

public class AsmGen extends EspressoBaseVisitor<Oprand> {
    private SemanticModel semanticModel;

    private AsmModule asmModule;

    public AsmGen(SemanticModel semanticModel){
        this.semanticModel = semanticModel;
    }

    @Override
    public Oprand visitCompilationUnit(EspressoParser.CompilationUnitContext ctx) {
        asmModule = new AsmModule();
        return super.visitCompilationUnit(ctx);
    }

    @Override
    public Oprand visitIntegerLiteral(EspressoParser.IntegerLiteralContext ctx) {
        return new Oprand(OprandKind.immediate, ctx.getText());
    }



    //TODO: visit other type of syntax nodes
}
