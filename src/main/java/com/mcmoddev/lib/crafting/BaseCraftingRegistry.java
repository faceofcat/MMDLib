package com.mcmoddev.lib.crafting;

import javax.annotation.Nullable;
import com.mcmoddev.lib.MMDLib;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryBuilder;

public abstract class BaseCraftingRegistry<T extends IForgeRegistryEntry<T>> {
    private final Class<T> registryEntryClass;
    private final String registryKey;
    private IForgeRegistry<T> registry = null;

    protected BaseCraftingRegistry(final Class<T> registryEntryClass, final String registryKey) {
        this.registryEntryClass = registryEntryClass;

        // TODO: find a way o get mod id from dependent mods... or just pass it in.
        this.registryKey = registryKey;
    }

    @Nullable
    public IForgeRegistry<T> getRegistry() {
        return this.registry;
    }

    public void init() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onRegisterRegistry(RegistryEvent.NewRegistry ev) {
        this.registry = new RegistryBuilder<T>()
            .setName(new ResourceLocation(MMDLib.MODID, this.registryKey))
            .setType(this.registryEntryClass)
            .setMaxID(Integer.MAX_VALUE >> 4)
            .allowModification()
            .add((owner, stage, id, obj, oldObj) -> BaseCraftingRegistry.this.onRegistryModified())
            .add((IForgeRegistry.ClearCallback<T>) (owner, stage) -> BaseCraftingRegistry.this.onRegistryModified())
            .create();
    }

    private void onRegistryModified() {
        this.rebuildInternalCache();
    }

    protected void rebuildInternalCache() {}
}
