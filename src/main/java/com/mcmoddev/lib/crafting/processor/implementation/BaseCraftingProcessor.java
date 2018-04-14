package com.mcmoddev.lib.crafting.processor.implementation;

import com.mcmoddev.lib.crafting.base.implementation.BaseCraftingObject;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventory;
import com.mcmoddev.lib.crafting.processor.ICraftingProcessor;

public abstract class BaseCraftingProcessor extends BaseCraftingObject implements ICraftingProcessor {
    private ICraftingInventory tempInput = null;
    private ICraftingInventory tempOutput = null;

    protected BaseCraftingProcessor(String key) {
        super(key);
    }

    protected void setTempInputInventory(ICraftingInventory tempInput) {
        this.tempInput = tempInput;
    }

    protected void setTempOutputInventory(ICraftingInventory tempOutput) {
        this.tempOutput = tempOutput;
    }

    @Override
    public ICraftingInventory getTempInputInventory() {
        return this.tempInput;
    }

    @Override
    public ICraftingInventory getTempOutputInventory() {
        return this.tempOutput;
    }
}
