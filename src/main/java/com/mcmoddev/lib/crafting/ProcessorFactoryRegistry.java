package com.mcmoddev.lib.crafting;

import com.mcmoddev.lib.crafting.recipe.ICraftingProcessorFactory;

public class ProcessorFactoryRegistry extends BaseCraftingRegistry<ICraftingProcessorFactory> {
    private ProcessorFactoryRegistry() {
        super(ICraftingProcessorFactory.class, "");
    }

    public final static ProcessorFactoryRegistry INSTANCE = new ProcessorFactoryRegistry();
}
