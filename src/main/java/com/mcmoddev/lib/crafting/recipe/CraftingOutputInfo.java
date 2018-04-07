package com.mcmoddev.lib.crafting.recipe;

import java.util.List;
import com.mcmoddev.lib.crafting.base.implementation.BaseCraftingObject;

public class CraftingOutputInfo extends BaseCraftingObject {
    private final List<CraftingInventoryInfo> destinations;

    public CraftingOutputInfo(final String key, final List<CraftingInventoryInfo> destinations) {
        super(key);

        this.destinations = destinations;
    }

    public List<CraftingInventoryInfo> getOutputDestinations() {
        // TODO: find out how to do read only lists in java
        return this.destinations;
    }
}
