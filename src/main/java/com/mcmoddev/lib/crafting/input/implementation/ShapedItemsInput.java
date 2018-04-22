package com.mcmoddev.lib.crafting.input.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredient;
import com.mcmoddev.lib.crafting.input.ICraftingItemInput;
import com.mcmoddev.lib.crafting.input.IMatchedCraftingInput;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventory;

public class ShapedItemsInput extends BaseCraftingInput {
    private final int gridSize;
    private final boolean acceptReversed;
    private final Map<Integer, ICraftingItemInput> shaped;

    protected ShapedItemsInput(final String key, final int gridSize, final boolean acceptReversed, final Map<Integer, ICraftingItemInput> shaped) {
        super(key, 1);

        this.gridSize = gridSize;
        this.acceptReversed = acceptReversed;
        this.shaped = shaped;
    }

    @Override
    public List<IMatchedCraftingInput> matchInventory(ICraftingInventory inventory) {
        // TODO: consider adding an interface for non-square crafting grids
        int inventorySize = (int)Math.round(Math.sqrt(inventory.getSlots()));
        if (inventorySize >= this.gridSize) {
            int padding = inventorySize - this.gridSize;
            for(int x = 0; x < padding; x++) {
                for (int y = 0; y < padding; y++) {
                    List<IMatchedCraftingInput> matched = this.matchInventory(inventory, x, y);
                    if (matched != null) {
                        return matched;
                    }
                }
            }
        }
        return null;
    }

    @Nullable
    private List<IMatchedCraftingInput> matchInventory(ICraftingInventory inventory, int offsetX, int offsetY) {
        int inventoryGridSize = (int)Math.round(Math.sqrt(inventory.getSlots()));
        List<IMatchedCraftingInput> matched = new ArrayList<>();
        for(int slot = 0; slot < inventory.getSlots(); slot++) {
            int slotX = slot % this.gridSize;
            int slotY = slot / this.gridSize;
            int inventorySlot = (slotY + offsetY) * inventoryGridSize + offsetX + slotX;
            ICraftingIngredient ingredient = inventory.getIngredient(inventorySlot);
            ICraftingItemInput matchAgainst = this.shaped.getOrDefault(slot, null);
            if (!ingredient.isEmpty() && (matchAgainst == null)) {
                // found an extra ingredient in the input inventory
                // we don't like that
                return null;
            }
            if (matchAgainst != null) {
                IMatchedCraftingInput matchedInput = matchAgainst.matchIngredient(inventory, slot);
                if (matchedInput == null) {
                    // found an ingredient that doesn't match the input definition
                    // we don't like that either
                    return null;
                }
                matched.add(matchedInput);
            }
        }
        return matched;
    }

    @Override
    public IMatchedCraftingInput matchIngredient(ICraftingInventory inventory, int slot) {
        throw new RuntimeException("This input type doesn't support individual slot matching.");
    }
}
