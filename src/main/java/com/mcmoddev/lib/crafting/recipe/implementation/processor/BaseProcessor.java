package com.mcmoddev.lib.crafting.recipe.implementation.processor;

import java.util.ArrayList;
import java.util.List;
import com.mcmoddev.lib.crafting.base.implementation.BaseCraftingObject;
import com.mcmoddev.lib.crafting.recipe.ICraftingProcessor;

public abstract class BaseProcessor extends BaseCraftingObject implements ICraftingProcessor {
    private final List<String> dependencies;

    protected BaseProcessor(String key, final List<String> dependencies) {
        super(key);

        this.dependencies = dependencies;
    }

    protected BaseProcessor(String key) {
        this(key, new ArrayList<>());
    }

    @Override
    public List<String> getDependencies() {
        return this.dependencies;
    }
}
