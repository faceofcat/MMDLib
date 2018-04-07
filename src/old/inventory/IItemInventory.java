package com.mcmoddev.lib.crafting.old.inventory;

import com.mcmoddev.lib.crafting.old.ingredient.ICraftingIngredient;
import com.mcmoddev.lib.crafting.old.ingredient.IngredientUtils;
import net.minecraft.item.ItemStack;

public interface IItemInventory extends ICraftingInventory {
    ItemStack getSlotContent(int slot);

    boolean setSlotContent(int slot, ItemStack stack);

    @Override
    default ICraftingIngredient getIngredient(int slot) {
        return IngredientUtils.wrapItemStack(this.getSlotContent(slot));
    }
}
