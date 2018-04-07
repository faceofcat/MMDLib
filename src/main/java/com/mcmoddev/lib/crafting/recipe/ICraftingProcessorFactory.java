package com.mcmoddev.lib.crafting.recipe;

import com.mcmoddev.lib.crafting.base.ICraftingObject;
import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredient;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventory;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface ICraftingProcessorFactory extends ICraftingObject, IForgeRegistryEntry<ICraftingProcessorFactory> {
    ICraftingProcessor create(ICraftingInventory source, ICraftingIngredient ingredient, ICraftingInventory destination);
}
