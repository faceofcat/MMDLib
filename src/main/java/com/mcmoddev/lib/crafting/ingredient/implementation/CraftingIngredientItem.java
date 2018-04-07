package com.mcmoddev.lib.crafting.ingredient.implementation;

import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredient;
import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredientItem;
import com.mcmoddev.lib.util.ItemStackUtils;
import net.minecraft.item.ItemStack;

public class CraftingIngredientItem extends BaseCraftingIngredient implements ICraftingIngredientItem {
    private final ItemStack stack;

    public CraftingIngredientItem(final ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public ItemStack getStack() {
        return this.stack;
    }

    @Override
    public ICraftingIngredient copyWithAmount(int amount) {
        return new CraftingIngredientItem(ItemStackUtils.copyWithSize(this.getStack(), amount));
    }
}
