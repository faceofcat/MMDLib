package com.mcmoddev.lib.crafting.old.recipe;

import java.util.List;
import javax.annotation.Nullable;
import com.mcmoddev.lib.crafting.old.ingredient.ICraftingIngredient;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventoryProvider;

public interface ICraftingRecipe {
    List<ICraftingIngredient> getIngredients();

    default boolean canStart(ICraftingInventoryProvider inventories) {
        return (this.start(inventories, true) != null);
    }

    @Nullable
    ICraftingRecipeRunner start(ICraftingInventoryProvider inventories, boolean simulate);
}
