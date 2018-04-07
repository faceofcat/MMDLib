package com.mcmoddev.lib.crafting.inventory;

import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredient;

public interface ICraftingInventoryInserter {
    ICraftingIngredient insert(ICraftingIngredient ingredient, boolean simulate);
}
