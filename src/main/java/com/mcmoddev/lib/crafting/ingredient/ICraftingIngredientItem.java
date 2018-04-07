package com.mcmoddev.lib.crafting.ingredient;

import net.minecraft.item.ItemStack;

public interface ICraftingIngredientItem extends ICraftingIngredient {
    ItemStack getStack();

    @Override
    default int getAmount() { return this.getStack().getCount(); }
}
