package com.mcmoddev.lib.crafting.inventory;

import java.util.List;
import javax.annotation.Nullable;

public interface ICraftingInventoryProvider {
    List<ICraftingInventory> getInventories();

    @Nullable
    default ICraftingInventory findInventory(String key) {
        for(ICraftingInventory inventory : this.getInventories()) {
            if (inventory.getKey().equals(key)) {
                return inventory;
            }
        }
        return null;
    }
}
