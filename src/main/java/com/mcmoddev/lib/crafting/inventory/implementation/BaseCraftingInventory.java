package com.mcmoddev.lib.crafting.inventory.implementation;

import com.mcmoddev.lib.crafting.base.implementation.BaseCraftingObject;
import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredient;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventory;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventoryExtractor;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventoryInserter;

public abstract class BaseCraftingInventory extends BaseCraftingObject implements ICraftingInventory {
    protected BaseCraftingInventory(String key) {
        super(key);
    }

    @Override
    public ICraftingIngredient take(ICraftingIngredient ingredient, boolean simulate) {
        if (ingredient instanceof ICraftingInventoryExtractor) {
            return ((ICraftingInventoryExtractor) ingredient).take(ingredient, simulate);
        }
        return ICraftingIngredient.EMPTY;
    }

    @Override
    public ICraftingIngredient insert(ICraftingIngredient ingredient, boolean simulate) {
        if (ingredient instanceof ICraftingInventoryInserter) {
            return ((ICraftingInventoryInserter) ingredient).insert(ingredient, simulate);
        }
        return ingredient;
    }
}
