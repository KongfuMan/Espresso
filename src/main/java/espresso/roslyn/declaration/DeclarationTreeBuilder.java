package espresso.roslyn.declaration;

import espresso.syntax.EspressoBaseVisitor;
import espresso.syntax.EspressoParser.*;

/** Parse tree visitor to create a declaration tree from the syntax tree*/
public class DeclarationTreeBuilder extends EspressoBaseVisitor<TypeDeclaration> {
    @Override
    public TypeDeclaration visitCompilationUnit(CompilationUnitContext ctx) {
        return super.visitCompilationUnit(ctx);
    }

    @Override
    public TypeDeclaration visitClassDeclaration(ClassDeclarationContext node) {
        return super.visitClassDeclaration(node);
    }
}
