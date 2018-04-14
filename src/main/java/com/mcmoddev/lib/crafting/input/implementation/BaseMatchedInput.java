package com.mcmoddev.lib.crafting.input.implementation;

import com.mcmoddev.lib.crafting.base.implementation.BaseCraftingObject;
import com.mcmoddev.lib.crafting.input.ICraftingInput;
import com.mcmoddev.lib.crafting.input.IMatchedCraftingInput;

public abstract class BaseMatchedInput extends BaseCraftingObject implements IMatchedCraftingInput {
    protected final ICraftingInput matchedInput;

    protected BaseMatchedInput(String key, ICraftingInput matchedInput) {
        super(key);

        this.matchedInput = matchedInput;
    }

    @Override
    public ICraftingInput getMatchedInput() {
        return this.matchedInput;
    }
}
