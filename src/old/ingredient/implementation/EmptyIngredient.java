package com.mcmoddev.lib.crafting.old.ingredient.implementation;

import javax.annotation.Nullable;
import com.mcmoddev.lib.crafting.old.ingredient.ICraftingIngredient;

public class EmptyIngredient implements ICraftingIngredient {
    public static final EmptyIngredient INSTANCE = new EmptyIngredient();

    private EmptyIngredient() { }

    @Override
    public int getAmount() { return 0; }

    @Nullable
    @Override
    public ICraftingIngredient mergeInto(ICraftingIngredient other, boolean simulate) {
        return other;
    }

    @Override
    public ICraftingIngredient copyWithAmount(int amount) {
        if (amount > 0) {
            throw new RuntimeException("Cannot set a size on an empty ingredient!");
        }
        return new EmptyIngredient();
    }

    @Override
    public ICraftingIngredient split(int amount, boolean simulate) {
        if (amount > 0) {
            throw new RuntimeException("Cannot set a size on an empty ingredient!");
        }
        return new EmptyIngredient();
    }
}
