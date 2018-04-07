package com.mcmoddev.lib.crafting.recipe.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import com.mcmoddev.lib.crafting.RecipeFactoryRegistry;
import com.mcmoddev.lib.crafting.recipe.CraftingInputInfo;
import com.mcmoddev.lib.crafting.recipe.CraftingOutputInfo;
import com.mcmoddev.lib.crafting.recipe.ICraftingRecipeFactory;
import com.mcmoddev.lib.crafting.recipe.implementation.BasicRecipeFactory;

@SuppressWarnings({"WeakerAccess", "unused"})
public class BasicRecipeFactoryBuilder {
    private String key = "dummy"; // TODO: consider not having a default and just throwing a runtime error if not set
    private Map<String, List<CraftingInputInventoryInfoBuilder>> inputs = new HashMap<>();
    private Map<String, List<CraftingInputInventoryInfoBuilder>> outputs = new HashMap<>();

    public BasicRecipeFactoryBuilder() {}

    public BasicRecipeFactoryBuilder setKey(String key) {
        this.key = key;
        return this;
    }

    private List<CraftingInputInventoryInfoBuilder> ensureInputKey(String key) {
        this.inputs.putIfAbsent(key, new ArrayList<>());
        return this.inputs.get(key);
    }

    public BasicRecipeFactoryBuilder addInput(String key, String inventoryKey, String processorKey) {
        List<CraftingInputInventoryInfoBuilder> builders = this.ensureInputKey(key);

        builders.add(new CraftingInputInventoryInfoBuilder()
            .setInventoryKey(inventoryKey)
            .setProcessorKey(processorKey)
        );

        return this;
    }

    public final ICraftingRecipeFactory build() {
        ICraftingRecipeFactory factory = this.createFactory();

        // TODO: consider making auto-registering an option
        Objects.requireNonNull(RecipeFactoryRegistry.INSTANCE.getRegistry()).register(factory);
        return factory;
    }

    protected ICraftingRecipeFactory createFactory() {
        return new BasicRecipeFactory(this.key, this);
    }

    public List<CraftingInputInfo> getInputs() {
        return this.inputs.entrySet().stream().map(
            set -> new CraftingInputInfo(set.getKey(), set.getValue().stream().map(
                CraftingInputInventoryInfoBuilder::build
            ).collect(Collectors.toList()))
        ).collect(Collectors.toList());
    }

    public List<CraftingOutputInfo> getOutputs() {
        return this.outputs.entrySet().stream().map(
            set -> new CraftingOutputInfo(set.getKey(), set.getValue().stream().map(
                CraftingInputInventoryInfoBuilder::build
            ).collect(Collectors.toList()))
        ).collect(Collectors.toList());
    }
}
