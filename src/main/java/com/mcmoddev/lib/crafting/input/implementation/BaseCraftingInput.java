package com.mcmoddev.lib.crafting.input.implementation;

import java.util.List;
import javax.annotation.Nullable;
import com.mcmoddev.lib.crafting.base.implementation.BaseCraftingObject;
import com.mcmoddev.lib.crafting.input.ICraftingInput;
import com.mcmoddev.lib.crafting.input.IMatchedCraftingInput;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventory;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventoryProvider;

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

    @Override
    public List<IMatchedCraftingInput> matchInventories(ICraftingInventoryProvider inventories) {
        for(String inventoryKey : this.getInventoryKeys()) {
            ICraftingInventory inventory = inventories.findInventory(inventoryKey);
            if (inventory != null) {
                List<IMatchedCraftingInput> matched = this.matchInventory(inventory);
                if (matched != null) {
                    return matched;
                }
            }
        }

        return null;
    }

    @Nullable
    protected abstract List<IMatchedCraftingInput> matchInventory(ICraftingInventory inventory);
}
