package projectzulu.common.potion.subitem;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import projectzulu.common.api.ItemList;
import projectzulu.common.api.SubItemPotionList;
import projectzulu.common.core.ItemGenerics.Properties;
import projectzulu.common.potion.PotionParser;

import com.google.common.base.Optional;

public class SubItemPotionDigspeed extends SubItemPotionHalfPower {

    public SubItemPotionDigspeed(int itemID, int subID) {
        super(itemID, subID, "Haste");
        setSubItemBounds(4, 4, 4, 0);
        setEffectScale(20 * 20, 20 * 5, 12, 10, 1);
    }

    @Override
    Optional<? extends Potion> getPotion() {
        return Optional.of(Potion.digSpeed);
    }

    @Override
    protected TYPE getIngredientType(ItemStack ingredient, ItemStack brewingStack) {
        if (ItemList.genericCraftingItems.isPresent()
                && ingredient.itemID == ItemList.genericCraftingItems.get().itemID
                && ingredient.getItemDamage() == Properties.SmallUnhealthyHeart.meta) {
            return TYPE.CHEMICAL;
        } else {
            return super.getIngredientType(ingredient, brewingStack);
        }
    }

    @Override
    protected ItemStack getChemicalPotionResult(ItemStack ingredient, ItemStack brewingStack) {
        if (SubItemPotionList.DIG_SLOW.isPresent()) {
            SubItemPotion subItemPotion = SubItemPotionList.DIG_SLOW.get();
            return new ItemStack(subItemPotion.itemID, 1, PotionParser.setID(subItemPotion.subID,
                    brewingStack.getItemDamage()));
        }
        return null;
    }
}