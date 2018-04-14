package com.mcmoddev.lib.crafting.processor.implementation;

import com.mcmoddev.lib.crafting.input.IMatchedCraftingItem;
import com.mcmoddev.lib.crafting.processor.CraftingProcessorResult;
import com.mcmoddev.lib.crafting.recipe.RecipeRunningContext;
import net.minecraftforge.items.IItemHandler;

public class ExtractAllItemsProcessor extends BaseItemsProcessor {
    private final IItemHandler tempInventory;

    protected ExtractAllItemsProcessor(String key, IMatchedCraftingItem input) {
        super(key);

        this.tempInventory = this.setTempSlots(1);
    }

    @Override
    public CraftingProcessorResult process(RecipeRunningContext context) {
        return null;
    }
}
