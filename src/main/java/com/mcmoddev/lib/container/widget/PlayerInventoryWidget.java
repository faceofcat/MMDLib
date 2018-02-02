package com.mcmoddev.lib.container.widget;

import java.util.Collection;
import java.util.List;
import com.google.common.collect.Lists;
import com.mcmoddev.lib.container.IContainerSlot;
import com.mcmoddev.lib.container.PlayerInventory;
import com.mcmoddev.lib.container.slots.PlayerInventorySlot;
import net.minecraft.entity.player.EntityPlayer;

public class PlayerInventoryWidget extends BaseWidget {
    private final PlayerInventory[] inventories;
    private final EntityPlayer player;

    private List<IContainerSlot> cachedSlots = null;

    public PlayerInventoryWidget(String key, EntityPlayer player, PlayerInventory... inventories) {
        super(key,false); // dirty state is handled by the slots themselves

        this.player = player;
        this.inventories = inventories;
    }

    @Override
    public Collection<IContainerSlot> getSlots() {
        if (this.cachedSlots != null) {
            return this.cachedSlots;

        }
        List<IContainerSlot> slots = Lists.newArrayList();

        for(PlayerInventory inventory: this.inventories) {
            slots.addAll(PlayerInventorySlot.createSlots(this.player, inventory));
        }

        return (this.cachedSlots = slots);
    }
}
