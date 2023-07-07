package espresso.roslyn.declaration;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;

public class TypeDeclaration extends Declaration{
    protected final ParserRuleContext node;
    protected final DeclarationKind kind;
    protected List<TypeDeclaration> children;

    public TypeDeclaration(String name,
                           ParserRuleContext node,
                           DeclarationKind kind,
                           List<TypeDeclaration> children
                           ) {
        super(name);
        this.node = node;
        this.kind = kind;
        this.children = children;
    }


}
