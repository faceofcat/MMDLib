package com.mcmoddev.lib.crafting.recipe;

import java.util.List;
import com.mcmoddev.lib.crafting.base.ICraftingObject;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface ICraftingRecipeFactory extends ICraftingObject, IForgeRegistryEntry<ICraftingRecipeFactory> {
    List<CraftingInputInfo> getInputs();
    List<CraftingOutputInfo> getOutputs();
}
