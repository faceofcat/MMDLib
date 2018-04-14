package com.mcmoddev.lib.crafting.input;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import com.mcmoddev.lib.crafting.base.ICraftingObject;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventory;

/**
 * Represents an input into a recipe.
 */
public interface ICraftingInput extends ICraftingObject {
    String[] getInventoryKeys();

    int getAmount();

    @Nullable
    default List<IMatchedCraftingInput> matchInventory(ICraftingInventory inventory) {
        for(int slot = 0; slot < inventory.getSlots(); slot++) {
            IMatchedCraftingInput matched = this.matchIngredient(inventory, slot);
            if (matched != null) {
                return Collections.singletonList(matched);
            }
        }
        return null;
    }

    @Nullable
    IMatchedCraftingInput matchIngredient(ICraftingInventory inventory, int slot);
}
