package com.mcmoddev.lib.crafting.input.implementation;

import java.util.List;
import com.mcmoddev.lib.crafting.input.ICraftingInput;
import com.mcmoddev.lib.crafting.input.IMatchedCraftingItem;

public class MatchedItemInput extends BaseMatchedInput implements IMatchedCraftingItem {
    protected final List<MatchedItemStack> matchedStacks;

    public MatchedItemInput(String key, ICraftingInput matchedInput, List<MatchedItemStack> matchedStacks) {
        super(key, matchedInput);

        this.matchedStacks = matchedStacks;
    }

    @Override
    public List<MatchedItemStack> getMatchedStacks() {
        return this.matchedStacks;
    }
}
