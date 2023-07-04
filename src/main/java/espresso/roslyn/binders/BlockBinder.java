package espresso.roslyn.binders;

import espresso.syntax.EspressoParser.*;

public class BlockBinder extends Binder{
    private final BlockContext block;
    public BlockBinder(BlockContext block, Binder binder) {
        super(binder);
        this.block = block;
    }
}
