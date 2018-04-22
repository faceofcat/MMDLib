package com.mcmoddev.lib.crafting.input.implementation;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredient;
import com.mcmoddev.lib.crafting.input.ICraftingItemInput;
import com.mcmoddev.lib.crafting.input.IMatchedCraftingInput;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventory;

public class ShapelessItemsInput extends BaseCraftingInput {
    private final List<ICraftingItemInput> inputs;

    protected ShapelessItemsInput(final String key, final List<ICraftingItemInput> inputs) {
        super(key, 1);

        this.inputs = inputs;
    }

    @Nullable
    @Override
    public List<IMatchedCraftingInput> matchInventory(ICraftingInventory inventory) {
        List<Integer> inventoryThings = new ArrayList<>();
        for(int slot = 0; slot < inventory.getSlots(); slot ++) {
            ICraftingIngredient ingredient = inventory.getIngredient(slot);
            if (!ingredient.isEmpty()) {
                if (inventoryThings.size() >= this.inputs.size()) {
                    // too many items in input inventory
                    return null;
                }
                inventoryThings.add(slot);
            }
        }

        if (this.inputs.size() != inventoryThings.size()) {
            // different ingredient counts
            return null;
        }

        List<IMatchedCraftingInput> result = new ArrayList<>();
        for(int slot = 0; slot < this.inputs.size(); slot++) {
            ICraftingItemInput input = this.inputs.get(slot);
            boolean found = false;
            for(int inventorySlot = 0; inventorySlot < inventoryThings.size(); inventorySlot++) {
                IMatchedCraftingInput matched = input.matchIngredient(inventory, inventoryThings.get(inventorySlot));
                if (matched != null) {
                    result.add(matched);
                    inventoryThings.remove(inventorySlot);
                    found = true;
                    break;
                }
            }

            if (!found) {
                // current ingredient not found, bad recipe
                return null;
            }
        }

        return result;
    }

    @Nullable
    @Override
    public IMatchedCraftingInput matchIngredient(ICraftingInventory inventory, int slot) {
        throw new RuntimeException("This input type doesn't support individual slot matching.");
    }
}
