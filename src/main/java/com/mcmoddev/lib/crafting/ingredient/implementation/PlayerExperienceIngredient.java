package com.mcmoddev.lib.crafting.ingredient.implementation;

import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredient;

// TODO: also make a PlayerExperienceLevelIngredient
public class PlayerExperienceIngredient extends BaseCraftingIngredient {
    private final int amount;

    public PlayerExperienceIngredient(final int amount) {
        this.amount = amount;
    }

    @Override
    public int getAmount() {
        return this.amount;
    }

    @Override
    public ICraftingIngredient copyWithAmount(int amount) {
        return new PlayerExperienceIngredient(amount);
    }
}
