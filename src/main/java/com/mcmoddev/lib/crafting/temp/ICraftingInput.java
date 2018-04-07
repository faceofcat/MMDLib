package com.mcmoddev.lib.crafting.temp;

import javax.annotation.Nullable;
import com.mcmoddev.lib.crafting.base.ICraftingObject;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventoryProvider;
import com.mcmoddev.lib.crafting.recipe.MatchedRecipeInput;

public interface ICraftingInput extends ICraftingObject {
    @Nullable
    MatchedRecipeInput matchInput(ICraftingInventoryProvider inventories);
}
