package com.mcmoddev.lib.crafting.old.inventory;

import com.mcmoddev.lib.crafting.old.ingredient.ICraftingIngredient;
import com.mcmoddev.lib.crafting.old.input.ICraftingInput;

public interface ICraftingInventory {
    String getKey();

    int getSlots();
    ICraftingIngredient getIngredient(int slot);

    ICraftingIngredient extract(ICraftingInput ingredient, boolean simulate);
    ICraftingIngredient insert(int slot, ICraftingIngredient ingredient, boolean simulate);
}
