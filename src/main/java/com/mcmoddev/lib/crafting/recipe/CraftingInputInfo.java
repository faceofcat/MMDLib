package com.mcmoddev.lib.crafting.recipe;

import java.util.List;
import com.mcmoddev.lib.crafting.base.implementation.BaseCraftingObject;

public final class CraftingInputInfo extends BaseCraftingObject {
    private final List<CraftingInventoryInfo> sources;

    public CraftingInputInfo(final String key, final List<CraftingInventoryInfo> sources) {
        super(key);

        this.sources = sources;
    }

    public List<CraftingInventoryInfo> getInputSources() {
        // TODO: find out how to do read only lists in java
        return this.sources;
    }
}
