package com.mcmoddev.lib.crafting.temp;

import com.mcmoddev.lib.crafting.base.ICraftingObject;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventoryProvider;
import com.mcmoddev.lib.crafting.recipe.MatchedRecipeInput;

public interface ICraftingInputExtractor extends ICraftingObject {
    boolean canExtractEntirely(ICraftingInput input, ICraftingInventoryProvider inventories);
    MatchedRecipeInput matchInput(ICraftingInput input, ICraftingInventoryProvider inventories);
}
