package com.mcmoddev.lib.crafting.recipe;

import java.util.List;
import com.mcmoddev.lib.crafting.base.ICraftingObject;

public interface ICraftingProcessor extends ICraftingObject {
    List<String> getDependencies();

    boolean process(RecipeRunningContext context);
}
