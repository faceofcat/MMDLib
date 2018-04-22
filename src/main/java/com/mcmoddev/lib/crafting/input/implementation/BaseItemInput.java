package com.mcmoddev.lib.crafting.input.implementation;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredient;
import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredientItem;
import com.mcmoddev.lib.crafting.input.ICraftingItemInput;
import com.mcmoddev.lib.crafting.input.IMatchedCraftingInput;
import com.mcmoddev.lib.crafting.input.IMatchedCraftingItem;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventory;
import com.mcmoddev.lib.crafting.inventory.implementation.ItemHandlerCraftingInventory;
import com.mcmoddev.lib.util.ItemStackUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.IItemHandler;

public abstract class BaseItemInput extends BaseCraftingInput implements ICraftingItemInput {
    private NonNullList<ItemStack> stacksCache = null;

    protected BaseItemInput(String key, int amount) {
        super(key, amount);
    }

    @Override
    public final List<ItemStack> getPossibleInputs() {
        if (this.stacksCache == null) {
            this.stacksCache = NonNullList.create();
            this.populatePossibleInputs(this.stacksCache);
        }
        return this.stacksCache;
    }

    abstract void populatePossibleInputs(NonNullList<ItemStack> stacks);

    @Nullable
    @Override
    public List<IMatchedCraftingInput> matchInventory(ICraftingInventory inventory) {
        throw new RuntimeException("Something went wrong!");
    }

    @Nullable
    @Override
    public IMatchedCraftingInput matchIngredient(ICraftingInventory inventory, int slot) {
        if (inventory instanceof ItemHandlerCraftingInventory) {
            ICraftingIngredient ingredient = inventory.getIngredient(slot);
            if (ingredient instanceof ICraftingIngredientItem) {
                IItemHandler handler = ((ItemHandlerCraftingInventory) inventory).getItemHandler();
                List<IMatchedCraftingItem.MatchedItemStack> matched = this.matchStacks(
                    handler, slot, (ICraftingIngredientItem) ingredient);
                if (!matched.isEmpty()) {
                    return new MatchedItemInput(this.getKey(), this, matched);
                }
            }
        }
        return null;
    }

    protected List<IMatchedCraftingItem.MatchedItemStack> matchStacks(IItemHandler inventory, int slot, ICraftingIngredientItem ingredient) {
        List<IMatchedCraftingItem.MatchedItemStack> result = new ArrayList<>();
        List<ItemStack> stacks = this.getPossibleInputs();
        if (!stacks.isEmpty()) {
            ItemStack stackToMatch = ingredient.getStack();
            for(ItemStack stack: stacks) {
                if ((stack.getCount() >= stackToMatch.getCount())
                    && ItemStackUtils.areEqualIgnoreSize(stack, stackToMatch)) {
                    result.add(new IMatchedCraftingItem.MatchedItemStack(inventory, slot, stack.getCount()));
                }
            }
        }
        return result;
    }
}
