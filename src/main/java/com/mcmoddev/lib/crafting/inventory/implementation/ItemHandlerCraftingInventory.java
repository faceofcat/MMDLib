package com.mcmoddev.lib.crafting.inventory.implementation;

import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredient;
import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredientItem;
import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredientPositional;
import com.mcmoddev.lib.crafting.ingredient.implementation.CraftingIngredientItem;
import com.mcmoddev.lib.util.ItemStackUtils;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

public class ItemHandlerCraftingInventory extends BaseCraftingInventory {
    private final IItemHandler inventory;

    public ItemHandlerCraftingInventory(final String key, final IItemHandler inventory) {
        super(key);

        this.inventory = inventory;
    }

    @Override
    public int getSlots() {
        return this.inventory.getSlots();
    }

    @Override
    public ICraftingIngredient getIngredient(int slot) {
        return new CraftingIngredientItem(this.inventory.getStackInSlot(slot));
    }

    @Override
    public ICraftingIngredient take(ICraftingIngredient ingredient, boolean simulate) {
        ICraftingIngredient takenBySuper = super.take(ingredient, simulate);
        if (!takenBySuper.isEmpty()) {
            return takenBySuper;
        }

        if (ingredient instanceof ICraftingIngredientItem) {
            ICraftingIngredientPositional positional = (ingredient instanceof ICraftingIngredientPositional)
                ? (ICraftingIngredientPositional) ingredient
                : null;
            ICraftingIngredientItem item = (ICraftingIngredientItem) ingredient;

            if (positional == null) {
                int taken = ItemStackUtils.extractFromCombinedInventory(this.inventory, item.getStack(), item.getAmount(), simulate);
                return item.copyWithAmount(taken);
            }
            else {
                ItemStack taken = this.inventory.extractItem(positional.getSlot(), item.getAmount(), true);
                if (ItemStackUtils.areEqualIgnoreSize(taken, item.getStack())) {
                    return new CraftingIngredientItem(simulate
                        ? taken
                        : this.inventory.extractItem(positional.getSlot(), item.getAmount(), false)
                    );
                }
            }
        }
        // TODO: fluid and energy

        return ICraftingIngredient.EMPTY;
    }
}
