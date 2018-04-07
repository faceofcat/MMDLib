package com.mcmoddev.lib.crafting.recipe;

import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredient;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventory;
import com.mcmoddev.lib.crafting.temp.ICraftingOutput;

public class MatchedRecipeOutput extends MatchedRecipeIngredient {
    private final ICraftingOutput output;
    private final ICraftingIngredient ingredient;

    MatchedRecipeOutput(final ICraftingOutput output, final ICraftingInventory inventory) {
        super(inventory);

        this.output = output;
        this.ingredient = this.output.createIngredient();
    }

    @Override
    public String getKey() {
        return this.output.getKey();
    }

    public ICraftingOutput getOutput() {
        return this.output;
    }

    public ICraftingIngredient getIngredient() {
        return this.ingredient;
    }
}
