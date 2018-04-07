package com.mcmoddev.lib.crafting.recipe.implementation.processor;

import java.util.List;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventory;
import com.mcmoddev.lib.crafting.recipe.RecipeRunningContext;
import com.mcmoddev.lib.crafting.temp.ICraftingInput;

public class TakeAllAtStartProcessor extends BaseInputProcessor {
    private boolean processed = false;

    protected TakeAllAtStartProcessor(final String key,
                                      final List<String> dependencies,
                                      final ICraftingInventory source,
                                      final ICraftingInput input) {
        super(key, dependencies, source, input);
    }

    @Override
    public boolean process(RecipeRunningContext context) {
        if (this.processed) {
            return true;
        }

        return false;
    }
}
