package com.mcmoddev.lib.crafting.recipe;

import com.mcmoddev.lib.crafting.inventory.ICraftingInventory;
import com.mcmoddev.lib.crafting.temp.ICraftingInput;
import com.mcmoddev.lib.crafting.temp.ICraftingInputExtractor;

public final class MatchedRecipeInput extends MatchedRecipeIngredient {
    private final ICraftingInput input;
    private final ICraftingInputExtractor extractor;

    MatchedRecipeInput(final ICraftingInput input, final ICraftingInventory inventory, final ICraftingInputExtractor extractor) {
        super(inventory);

        this.input = input;
        this.extractor = extractor;
    }

    @Override
    public String getKey() {
        return this.input.getKey();
    }

    public ICraftingInput getInput() {
        return this.input;
    }

    public ICraftingInputExtractor getExtractor() {
        return this.extractor;
    }
}
