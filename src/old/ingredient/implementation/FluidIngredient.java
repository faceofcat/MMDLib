package com.mcmoddev.lib.crafting.old.ingredient.implementation;

import javax.annotation.Nullable;
import com.mcmoddev.lib.crafting.old.ingredient.ICraftingIngredient;
import com.mcmoddev.lib.crafting.old.ingredient.IFluidIngredient;
import com.mcmoddev.lib.crafting.old.ingredient.IngredientUtils;
import net.minecraftforge.fluids.FluidStack;

public class FluidIngredient extends BaseCraftingIngredient implements IFluidIngredient {
    private final FluidStack wrapped;

    public FluidIngredient(FluidStack wrapped) {
        super();

        this.wrapped = wrapped;
    }

    @Nullable
    @Override
    public FluidStack getFluidStack() {
        return this.wrapped;
    }

    @Nullable
    @Override
    public ICraftingIngredient mergeInto(ICraftingIngredient other, boolean simulate) {
        if (other instanceof FluidIngredient) {
            FluidStack otherFluid = ((FluidIngredient) other).getFluidStack();
            if ((otherFluid == null)
                || !FluidStack.areFluidStackTagsEqual(this.wrapped, otherFluid)
                || !otherFluid.isFluidEqual(this.wrapped)) {
                return null; // non-matching fluids
            }

            otherFluid = otherFluid.copy();
            otherFluid.amount += this.wrapped.amount;
            if (!simulate) {
                this.wrapped.amount = 0;
            }
            return IngredientUtils.wrapFluidStack(otherFluid);
        }
//        else if (other instanceof ItemIngredient) {
//            // TODO: maybe allow merging of fluid stacks into acceptable item stacks?
//        }
        return null;
    }

    @Override
    public ICraftingIngredient copyWithAmount(int amount) {
        FluidStack stack = this.wrapped.copy();
        stack.amount = amount;
        return IngredientUtils.wrapFluidStack(stack);
    }

    @Override
    public ICraftingIngredient split(int amount, boolean simulate) {
        int maxAmount = Math.min(amount, this.wrapped.amount);
        FluidStack stack = this.wrapped.copy();
        stack.amount = maxAmount;
        if (!simulate) {
            this.wrapped.amount -= maxAmount;
        }
        return IngredientUtils.wrapFluidStack(stack);
    }
}
