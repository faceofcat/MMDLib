package com.mcmoddev.lib.crafting.processor;

import javax.annotation.Nullable;
import com.mcmoddev.lib.crafting.base.ICraftingObject;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventory;
import com.mcmoddev.lib.crafting.recipe.RecipeRunningContext;

public interface ICraftingProcessor extends ICraftingObject {
    CraftingProcessorResult process(RecipeRunningContext context);

    // These should only be used for display purposes
    // extracted stuff will go in here, output stuff not yet inserted will be here
    @Nullable
    ICraftingInventory getTempInputInventory();

    @Nullable
    ICraftingInventory getTempOutputInventory();
}
