package espresso.roslyn.symbols;

import java.util.List;

public class ClassSymbol extends TypeSymbol{
    List<TypeSymbol> implementedInterfaces;
    ClassSymbol baseType;
}
