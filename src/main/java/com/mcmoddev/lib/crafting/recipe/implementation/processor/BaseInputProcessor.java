package com.mcmoddev.lib.crafting.recipe.implementation.processor;

import java.util.ArrayList;
import java.util.List;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventory;
import com.mcmoddev.lib.crafting.temp.ICraftingInput;

@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class BaseInputProcessor extends BaseProcessor {
    protected final ICraftingInventory source;
    protected final ICraftingInput input;

    protected BaseInputProcessor(final String key, final List<String> dependencies,
                                 final ICraftingInventory source,
                                 final ICraftingInput input) {
        super(key, dependencies);

        this.source = source;
        this.input = input;
    }

    protected BaseInputProcessor(String key,
                                 final ICraftingInventory source,
                                 final ICraftingInput input) {
        this(key, new ArrayList<>(), source, input);
    }
}
