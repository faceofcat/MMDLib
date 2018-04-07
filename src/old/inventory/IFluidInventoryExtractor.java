package com.mcmoddev.lib.crafting.old.inventory;

import javax.annotation.Nullable;
import com.mcmoddev.lib.crafting.old.ingredient.ICraftingIngredient;

public interface IFluidInventoryExtractor {
    @Nullable
    ICraftingIngredient extractFluidFrom(IFluidInventory inventory, int slot, boolean simulate);
}
