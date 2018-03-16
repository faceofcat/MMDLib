package com.mcmoddev.lib.crafting.inventory;

import javax.annotation.Nullable;
import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredient;
import com.mcmoddev.lib.crafting.ingredient.IngredientUtils;
import com.mcmoddev.lib.crafting.ingredient.implementation.EmptyIngredient;
import net.minecraftforge.fluids.FluidStack;

public interface IFluidInventory extends ICraftingInventory {
    @Nullable
    FluidStack getSlotContent(int slot);
    boolean setSlotContent(int slot, @Nullable FluidStack stack);

    @Override
    default ICraftingIngredient getIngredient(int slot) {
        FluidStack fluid = this.getSlotContent(slot);
        if (fluid == null)
            return EmptyIngredient.INSTANCE;
        return IngredientUtils.wrapFluidStack(fluid);
    }
}
