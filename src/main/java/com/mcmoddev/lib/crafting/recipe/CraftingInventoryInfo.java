package com.mcmoddev.lib.crafting.recipe;

public class CraftingInventoryInfo {
    private final String inventoryKey;
    private final ICraftingProcessorFactory processorFactory;

    public CraftingInventoryInfo(final String inventoryKey, final ICraftingProcessorFactory processorFactory) {
        this.inventoryKey = inventoryKey;
        this.processorFactory = processorFactory;
    }

    public String getInventoryKey() {
        return this.inventoryKey;
    }

    public ICraftingProcessorFactory getProcessorFactory() {
        return this.processorFactory;
    }
}
