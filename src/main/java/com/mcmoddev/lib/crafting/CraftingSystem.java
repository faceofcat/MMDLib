package com.mcmoddev.lib.crafting;

public final class CraftingSystem {
    private CraftingSystem() { }

    public static void init() {
        for (Registry registry : Registry.values()) {
            registry.registry.init();
        }
    }

    public enum Registry {
        PROCESSOR_FACTORIES(ProcessorFactoryRegistry.INSTANCE),
        RECIPE_FACTORIES(RecipeFactoryRegistry.INSTANCE);

        private final BaseCraftingRegistry registry;
        Registry(final BaseCraftingRegistry registry) {
            this.registry = registry;
        }
    }
}
