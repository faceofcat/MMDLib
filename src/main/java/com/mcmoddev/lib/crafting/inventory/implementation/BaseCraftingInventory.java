package com.mcmoddev.lib.crafting.inventory.implementation;

import com.mcmoddev.lib.crafting.inventory.ICraftingInventory;

public abstract class BaseCraftingInventory implements ICraftingInventory {
    private final String key;

    protected BaseCraftingInventory(final String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return this.key;
    }
}
