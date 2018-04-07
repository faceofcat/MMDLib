package com.mcmoddev.lib.crafting.extractor;

import com.mcmoddev.lib.crafting.inventory.ICraftingInventory;
import com.mcmoddev.lib.crafting.recipe.ICraftingProcessor;

public interface ICraftingExtractor extends ICraftingProcessor {
    ICraftingInventory getTempInventory();
}
