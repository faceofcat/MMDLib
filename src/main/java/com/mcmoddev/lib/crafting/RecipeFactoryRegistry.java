package com.mcmoddev.lib.crafting;

import com.mcmoddev.lib.crafting.recipe.ICraftingRecipeFactory;

public class RecipeFactoryRegistry extends BaseCraftingRegistry<ICraftingRecipeFactory> {
    private RecipeFactoryRegistry() {
        super(ICraftingRecipeFactory.class, "crafting_recipe_factory");
    }

    public final static RecipeFactoryRegistry INSTANCE = new RecipeFactoryRegistry();
}
