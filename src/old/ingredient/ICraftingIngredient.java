package com.mcmoddev.lib.crafting.old.ingredient;

import javax.annotation.Nullable;

public interface ICraftingIngredient {
    int getAmount();

    default boolean isEmpty() { return (this.getAmount() == 0); }

    default boolean canMergeInto(ICraftingIngredient other) {
        return this.mergeInto(other, true) != null;
    }

    @Nullable
    ICraftingIngredient mergeInto(ICraftingIngredient other, boolean simulate);

    ICraftingIngredient copyWithAmount(int amount);

    ICraftingIngredient split(int amount, boolean simulate);
}
