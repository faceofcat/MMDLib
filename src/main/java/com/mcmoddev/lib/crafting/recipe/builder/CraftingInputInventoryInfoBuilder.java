package com.mcmoddev.lib.crafting.recipe.builder;

import java.util.Objects;
import com.mcmoddev.lib.crafting.ProcessorFactoryRegistry;
import com.mcmoddev.lib.crafting.recipe.CraftingInventoryInfo;
import net.minecraft.util.ResourceLocation;

public class CraftingInputInventoryInfoBuilder {
    private String inventoryKey;
    private String processorKey;

    public CraftingInputInventoryInfoBuilder setInventoryKey(String inventoryKey) {
        this.inventoryKey = inventoryKey;
        return this;
    }

    public CraftingInputInventoryInfoBuilder setProcessorKey(String processorKey) {
        this.processorKey = processorKey;
        return this;
    }

    public CraftingInventoryInfo build() {
        return new CraftingInventoryInfo(this.inventoryKey,
            Objects.requireNonNull(
                Objects.requireNonNull(
                    ProcessorFactoryRegistry.INSTANCE.getRegistry()
                ).getValue(
                    new ResourceLocation(this.processorKey)
                )
            )
        );
    }
}
