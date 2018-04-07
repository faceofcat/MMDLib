package com.mcmoddev.lib.crafting.old.inventory;

import javax.annotation.Nullable;
import com.mcmoddev.lib.crafting.old.ingredient.ICraftingIngredient;

public interface IFluidInventoryInserter {
    @Nullable
    ICraftingIngredient insertFluidInto(IFluidInventory inventory, int slot, boolean simulate);
}
