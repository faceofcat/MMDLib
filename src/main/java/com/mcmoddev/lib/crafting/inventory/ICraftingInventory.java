package com.mcmoddev.lib.crafting.inventory;

import com.mcmoddev.lib.crafting.base.ICraftingObject;
import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredient;

public interface ICraftingInventory extends ICraftingObject, ICraftingInventoryInserter, ICraftingInventoryExtractor {
    int getSlots();

    // should always return a copy
    ICraftingIngredient getIngredient(int slot);
}
