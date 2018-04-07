package com.mcmoddev.lib.crafting.extractor.implementation;

import java.util.stream.Stream;
import javax.annotation.Nullable;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventory;
import com.mcmoddev.lib.crafting.recipe.RecipeRunningContext;
import com.mcmoddev.lib.util.ItemStackUtils;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemHandlerHelper;
import ICraftingIngredient;
import ICraftingInput;
import ICraftingItemInput;
import IItemInventory;
import IngredientUtils;

public class ItemExtractor extends BaseCraftingExtractor {
    public static final ItemExtractor INSTANCE = new ItemExtractor("default_item_extractor");

    protected ItemExtractor(String key) {
        super(key);
    }

    @Override
    public ICraftingInventory getTempInventory() {
        return null;
    }

    @Override
    public boolean process(RecipeRunningContext context) {
        return false;
    }

    @Nullable
    @Override
    public ICraftingIngredient extract(ICraftingInput input, ICraftingInventory inventory, boolean simulate) {
        ICraftingItemInput itemInput = (input instanceof ICraftingItemInput) ? (ICraftingItemInput)input : null;
        IItemInventory itemInventory = (inventory instanceof IItemInventory) ? (IItemInventory)inventory : null;
        if ((itemInput != null) && (itemInventory != null)) {
            Stream<ItemStack> inputStacks = itemInput.getPossibleInputs().stream();
            int extracted = 0;
            ItemStack result = ItemStack.EMPTY;
            for (int i = 0; i < itemInventory.getSlots(); i++) {
                ItemStack stack = itemInventory.getSlotContent(i);
                if (inputStacks.anyMatch(s -> ItemStackUtils.areEqualIgnoreSizeAndDurability(s, stack))) {
                    int toExtract = Math.min(stack.getCount(), (input.getAmount() - extracted));
                    if ((toExtract > 0) && ((result.isEmpty() || ItemHandlerHelper.canItemStacksStack(result, stack)))) {
                        if (result.isEmpty()) {
                            result = ItemStackUtils.copyWithSize(stack, toExtract);
                        }
                        else {
                            result.grow(toExtract);
                        }
                        extracted += toExtract;
                        if (!simulate) {
                            stack.shrink(toExtract);
                        }

                        if (result.getCount() == input.getAmount()) {
                            return IngredientUtils.wrapItemStack(result);
                        }
                    }
                }
            }
        }
        return null;
    }
}
