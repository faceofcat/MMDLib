package com.mcmoddev.lib.crafting.old.ingredient;

import javax.annotation.Nullable;
import com.mcmoddev.lib.crafting.old.ingredient.implementation.EmptyIngredient;
import com.mcmoddev.lib.crafting.old.ingredient.implementation.FluidIngredient;
import com.mcmoddev.lib.crafting.old.ingredient.implementation.ItemIngredient;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class IngredientUtils {
    public static ICraftingIngredient wrapItemStack(ItemStack stack) {
        return stack.isEmpty() ? EmptyIngredient.INSTANCE : new ItemIngredient(stack);
    }

    public static ICraftingIngredient wrapFluidStack(@Nullable FluidStack stack) {
        return ((stack == null) || (stack.amount == 0)) ? EmptyIngredient.INSTANCE : new FluidIngredient(stack);
    }
}
