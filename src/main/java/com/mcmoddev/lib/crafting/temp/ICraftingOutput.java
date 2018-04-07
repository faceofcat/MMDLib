package com.mcmoddev.lib.crafting.temp;

import javax.annotation.Nullable;
import com.mcmoddev.lib.crafting.base.ICraftingObject;
import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredient;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventoryProvider;
import com.mcmoddev.lib.crafting.recipe.MatchedRecipeOutput;

public interface ICraftingOutput extends ICraftingObject {
    ICraftingIngredient createIngredient();

    @Nullable
    MatchedRecipeOutput matchOutput(ICraftingInventoryProvider inventories);
}
