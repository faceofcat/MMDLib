package com.mcmoddev.lib.crafting.inventory;

import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredient;

public interface ICraftingInventoryExtractor {
    ICraftingIngredient take(ICraftingIngredient ingredient, boolean simulate);
}
