package com.mcmoddev.lib.crafting.old.recipe;

import net.minecraft.util.ITickable;

public interface ICraftingRecipeRunner extends ITickable {
    boolean isFinished();

    default boolean isStuck() {
        return (this.getStuckReason() != RecipeRunnerStuckReason.NOT_STUCK);
    }

    default RecipeRunnerStuckReason getStuckReason() { return RecipeRunnerStuckReason.NOT_STUCK; }
}
