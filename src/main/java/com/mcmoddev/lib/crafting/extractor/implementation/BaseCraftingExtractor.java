package com.mcmoddev.lib.crafting.extractor.implementation;

import java.util.List;
import com.mcmoddev.lib.crafting.extractor.ICraftingExtractor;
import com.mcmoddev.lib.crafting.recipe.implementation.processor.BaseProcessor;

public abstract class BaseCraftingExtractor extends BaseProcessor implements ICraftingExtractor {
    protected BaseCraftingExtractor(String key, final List<String> dependencies) {
        super(key, dependencies);
    }

    protected BaseCraftingExtractor(String key) {
        super(key);
    }
}
