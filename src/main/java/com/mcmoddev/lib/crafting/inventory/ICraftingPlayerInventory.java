package com.mcmoddev.lib.crafting.inventory;

import com.mcmoddev.lib.crafting.base.ICraftingObject;
import net.minecraft.entity.player.EntityPlayer;

public interface ICraftingPlayerInventory extends ICraftingObject {
    ICraftingInventory getInventory(EntityPlayer player);
}
