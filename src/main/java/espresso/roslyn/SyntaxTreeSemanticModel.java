package espresso.roslyn;

import espresso.roslyn.symbols.Symbol;
import espresso.roslyn.symbols.TypeSymbol;
import espresso.syntax.EspressoParser.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.SyntaxTree;

import java.util.Map;

public class SyntaxTreeSemanticModel {
    private final SyntaxTree tree;
    private Map<ParserRuleContext, MemberSemanticModel> memberModels;

    public SyntaxTreeSemanticModel(SyntaxTree tree){
        this.tree = tree;
    }

    /** Request symbol from bottom and create symbol when popping stack*/
    public Symbol getDeclaredSymbol(ClassDeclarationContext classDecl){
        return null;
    }

    public Symbol getDeclaredSymbol(VariableDeclaratorContext varDecl){
        String idName = varDecl.variableDeclaratorId().IDENTIFIER().getText();
        if (varDecl.getParent().getParent() instanceof FieldDeclarationContext){
            FieldDeclarationContext field = (FieldDeclarationContext)varDecl.getParent().getParent();
            TypeSymbol container = getDeclaredTypeContainer(field);
            return getDeclaredMember(container, field.getStart().getStartIndex(), idName);
        }
        return null;
    }

    public TypeSymbol getDeclaredTypeContainer(ParserRuleContext node){
        return null;
    }

    public Symbol getDeclaredMember(TypeSymbol container, int location, String name){
        return container.getMembers(name);
    }
}
