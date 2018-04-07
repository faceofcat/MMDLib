package com.mcmoddev.lib.crafting.inventory.implementation;

import com.mcmoddev.lib.crafting.base.implementation.BaseCraftingObject;
import com.mcmoddev.lib.crafting.inventory.ICraftingPlayerInventory;

public abstract class BaseCraftingPlayerInventory extends BaseCraftingObject implements ICraftingPlayerInventory {
    protected BaseCraftingPlayerInventory(String key) {
        super(key);
    }
}
