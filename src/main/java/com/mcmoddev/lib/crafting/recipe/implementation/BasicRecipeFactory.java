package com.mcmoddev.lib.crafting.recipe.implementation;

import java.util.List;
import java.util.Objects;
import com.mcmoddev.lib.crafting.base.implementation.BaseCraftingRegistryObject;
import com.mcmoddev.lib.crafting.recipe.CraftingInputInfo;
import com.mcmoddev.lib.crafting.recipe.CraftingOutputInfo;
import com.mcmoddev.lib.crafting.recipe.ICraftingRecipeFactory;
import com.mcmoddev.lib.crafting.recipe.builder.BasicRecipeFactoryBuilder;

@SuppressWarnings("WeakerAccess")
public class BasicRecipeFactory extends BaseCraftingRegistryObject<ICraftingRecipeFactory> implements ICraftingRecipeFactory {
    private final BasicRecipeFactoryBuilder builder;

    private boolean wasBuilt = false;
    private List<CraftingInputInfo> inputs = null;
    private List<CraftingOutputInfo> outputs = null;

    public BasicRecipeFactory(final String key, BasicRecipeFactoryBuilder builder) {
        super(key);

        // doing this because the inner stuff must be created at a later stage in game
        // as it might not be registered yet
        this.builder = builder;
    }

    protected void ensureIsBuilt() {
        if (this.wasBuilt) {
            return;
        }
        this.wasBuilt = true;

        Objects.requireNonNull(this.inputs = this.builder.getInputs());
        Objects.requireNonNull(this.outputs = this.builder.getOutputs());
    }

    @Override
    public List<CraftingInputInfo> getInputs() {
        this.ensureIsBuilt();
        return this.inputs;
    }

    @Override
    public List<CraftingOutputInfo> getOutputs() {
        this.ensureIsBuilt();
        return this.outputs;
    }
}
