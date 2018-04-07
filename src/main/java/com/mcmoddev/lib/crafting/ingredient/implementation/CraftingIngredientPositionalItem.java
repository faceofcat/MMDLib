package com.mcmoddev.lib.crafting.ingredient.implementation;

import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredient;
import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredientPositional;
import com.mcmoddev.lib.util.ItemStackUtils;
import net.minecraft.item.ItemStack;

public class CraftingIngredientPositionalItem extends CraftingIngredientItem implements ICraftingIngredientPositional {
    private final int slot;

    public CraftingIngredientPositionalItem(final ItemStack stack, final int slot) {
        super(stack);

        this.slot = slot;
    }

    @Override
    public int getSlot() {
        return this.slot;
    }

    @Override
    public ICraftingIngredient copyWithAmount(int amount) {
        return new CraftingIngredientPositionalItem(ItemStackUtils.copyWithSize(this.getStack(), amount), this.slot);
    }
}
