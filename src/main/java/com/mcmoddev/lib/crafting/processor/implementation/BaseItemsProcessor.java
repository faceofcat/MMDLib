package com.mcmoddev.lib.crafting.processor.implementation;

import com.mcmoddev.lib.crafting.inventory.implementation.ItemHandlerCraftingInventory;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public abstract class BaseItemsProcessor extends BaseCraftingProcessor {
    private IItemHandler itemHandler;

    protected BaseItemsProcessor(String key) {
        super(key);
    }

    protected IItemHandler setTempSlots(int slots) {
        this.itemHandler = new ItemStackHandler(slots);
        this.setTempOutputInventory(new ItemHandlerCraftingInventory(this.getKey(), this.itemHandler));

        return this.itemHandler;
    }
}
