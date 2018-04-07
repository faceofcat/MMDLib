package com.mcmoddev.lib.crafting.input.implementation;

import com.mcmoddev.lib.crafting.base.implementation.BaseCraftingObject;
import com.mcmoddev.lib.crafting.input.ICraftingInput;

public abstract class BaseCraftingInput extends BaseCraftingObject implements ICraftingInput {
    private final int amount;
    private String[] inventoryKeys = null;

    protected BaseCraftingInput(String key, int amount) {
        super(key);
        this.amount = amount; // TODO: maybe complain if this is < 1
    }

    @Override
    public int getAmount() {
        return this.amount;
    }

    @Override
    public String[] getInventoryKeys() {
        return this.inventoryKeys;
    }

    public BaseCraftingInput setInventoryKeys(String[] inventoryKeys) {
        this.inventoryKeys = inventoryKeys;
        return this;
    }
}
