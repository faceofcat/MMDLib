package com.mcmoddev.lib.crafting.old.ingredient.implementation;

import javax.annotation.Nullable;
import com.mcmoddev.lib.crafting.old.ingredient.ICraftingIngredient;
import com.mcmoddev.lib.crafting.old.ingredient.IItemIngredient;
import com.mcmoddev.lib.crafting.old.ingredient.IngredientUtils;
import com.mcmoddev.lib.util.ItemStackUtils;
import net.minecraft.item.ItemStack;

public class ItemIngredient extends BaseCraftingIngredient implements IItemIngredient {
    private final ItemStack wrapped;

    public ItemIngredient(ItemStack wrapped) {
        super();

        this.wrapped = wrapped;
    }

    @Override
    public ItemStack getItemStack() {
        return this.wrapped;
    }

    @Override
    @Nullable
    public ICraftingIngredient mergeInto(ICraftingIngredient other, boolean simulate) {
        if (!(other instanceof ItemIngredient)) {
            return null; // can only merge into another item ingredient
        }

        ItemStack otherStack = ((ItemIngredient) other).getItemStack();
        if (!ItemStackUtils.areEqualIgnoreSize(this.wrapped, otherStack)) {
            return null; // incompatible stacks
        }

        int accepting = Math.min(otherStack.getMaxStackSize() - otherStack.getCount(), this.wrapped.getCount());
        if (accepting <= 0) {
            return null; // not enough space in target stack
        }

        if (!simulate) {
            this.wrapped.shrink(accepting);
        }
        return other.copyWithAmount(accepting + otherStack.getCount());
    }

    @Override
    public ICraftingIngredient copyWithAmount(int amount) {
        return IngredientUtils.wrapItemStack(
            ItemStackUtils.copyWithSize(this.wrapped, amount)
        );
    }

    @Override
    public ICraftingIngredient split(int amount, boolean simulate) {
        ItemStack other = (simulate ? this.wrapped.copy() : this.wrapped).splitStack(amount);
        return IngredientUtils.wrapItemStack(other);
    }
}
