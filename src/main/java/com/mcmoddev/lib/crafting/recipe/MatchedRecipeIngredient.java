package com.mcmoddev.lib.crafting.recipe;

import com.mcmoddev.lib.crafting.base.ICraftingObject;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventory;

public abstract class MatchedRecipeIngredient implements ICraftingObject {
    protected final ICraftingInventory inventory;

    protected MatchedRecipeIngredient(final ICraftingInventory inventory) {
        this.inventory = inventory;
    }

    public ICraftingInventory getInventory() {
        return this.inventory;
    }
}
