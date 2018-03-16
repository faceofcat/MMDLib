package com.mcmoddev.lib.crafting.ingredient.implementation;

import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredient;

public class EmptyIngredient implements ICraftingIngredient {
    public static final EmptyIngredient INSTANCE = new EmptyIngredient();

    private EmptyIngredient() { }

    @Override
    public int getAmount() { return 0; }
}
