package com.mcmoddev.lib.crafting.base.implementation;

import java.util.Objects;
import com.mcmoddev.lib.crafting.base.ICraftingObject;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public abstract class BaseCraftingRegistryObject<T extends IForgeRegistryEntry<T>> extends IForgeRegistryEntry.Impl<T> implements ICraftingObject {
    protected BaseCraftingRegistryObject(final ResourceLocation key) {
        this.setRegistryName(key);
    }

    protected BaseCraftingRegistryObject(final String modId, final String key) {
        this.setRegistryName(modId, key);
    }

    protected BaseCraftingRegistryObject(final String key) {
        this.setRegistryName(key);
    }

    @Override
    public String getKey() {
        ResourceLocation name = this.getRegistryName();
        return Objects.requireNonNull(name).toString();
    }
}
