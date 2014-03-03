package projectzulu.common.blocks.itemblockdeclarations;

import projectzulu.common.api.ItemList;
import projectzulu.common.blocks.ItemScale;
import projectzulu.common.core.itemblockdeclaration.ItemDeclaration;

import com.google.common.base.Optional;

public class ScaleItemDeclaration extends ItemDeclaration {

    public ScaleItemDeclaration() {
        super("ScaleItem");
    }

    @Override
    protected boolean createItem(int iD) {
        ItemList.scaleItem = Optional.of(new ItemScale(iD, false, name.toLowerCase()));
        return true;
    }

    @Override
    protected void registerItem() {
    }
}