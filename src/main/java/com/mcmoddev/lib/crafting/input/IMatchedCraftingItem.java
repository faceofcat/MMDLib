package com.mcmoddev.lib.crafting.input;

import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

public interface IMatchedCraftingItem extends IMatchedCraftingInput {
    List<MatchedItemStack> getMatchedStacks();

    public static final class MatchedItemStack {
        public final IItemHandler inventory;
        public final int inventorySlot;
        public final int amount;

        public MatchedItemStack(final IItemHandler inventory, final int inventorySlot, final int amount) {
            this.inventory = inventory;
            this.inventorySlot = inventorySlot;
            this.amount = amount;
        }

        public ItemStack getCurrentStack() {
            return this.inventory.getStackInSlot(this.inventorySlot).copy();
        }

        public ItemStack extractItems(int amount, boolean simulate) {
            return this.inventory.extractItem(this.inventorySlot, amount, simulate);
        }
    }
}
