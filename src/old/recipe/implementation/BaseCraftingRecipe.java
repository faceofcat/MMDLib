package com.mcmoddev.lib.crafting.old.recipe.implementation;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import com.mcmoddev.lib.crafting.old.ingredient.ICraftingIngredient;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventoryProvider;
import com.mcmoddev.lib.crafting.old.recipe.ICraftingRecipe;
import com.mcmoddev.lib.crafting.old.recipe.ICraftingRecipeRunner;

public class BaseCraftingRecipe implements ICraftingRecipe {
    private final List<ICraftingIngredient> ingredients;

    protected BaseCraftingRecipe(ICraftingIngredient... ingredients) {
        this.ingredients = Arrays.asList(ingredients);
    }

    @Override
    public List<ICraftingIngredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public boolean canStart(ICraftingInventoryProvider inventories) {
        return false;
    }

    @Nullable
    @Override
    public ICraftingRecipeRunner start(ICraftingInventoryProvider inventories, boolean simulate) {
        return null;
    }
}
