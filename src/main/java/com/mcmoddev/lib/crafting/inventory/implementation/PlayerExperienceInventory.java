package com.mcmoddev.lib.crafting.inventory.implementation;

import com.mcmoddev.lib.crafting.ingredient.ICraftingIngredient;
import com.mcmoddev.lib.crafting.ingredient.implementation.PlayerExperienceIngredient;
import com.mcmoddev.lib.crafting.inventory.ICraftingInventory;
import net.minecraft.entity.player.EntityPlayer;

public class PlayerExperienceInventory extends BaseCraftingPlayerInventory {
    protected PlayerExperienceInventory(String key) {
        super(key);
    }

    @Override
    public ICraftingInventory getInventory(EntityPlayer player) {
        return null;
    }

    public static class PlayerExperience extends BaseCraftingInventory {
        private final EntityPlayer player;

        protected PlayerExperience(final String key, final EntityPlayer player) {
            super(key);

            this.player = player;
        }

        @Override
        public int getSlots() { return 1; }

        @Override
        public ICraftingIngredient getIngredient(int slot) {
            return new PlayerExperienceIngredient(this.player.experienceTotal);
        }

        @Override
        public ICraftingIngredient take(ICraftingIngredient ingredient, boolean simulate) {
            if (ingredient instanceof PlayerExperienceIngredient) {
                int amount = ingredient.getAmount();
                int toTake = Math.min(this.player.experienceTotal, amount);

                if ((toTake > 0) && !simulate) {
                    this.player.addExperience(-toTake);
                }
                return new PlayerExperienceIngredient(toTake);
            }
            return super.take(ingredient, simulate);
        }

        @Override
        public ICraftingIngredient insert(ICraftingIngredient ingredient, boolean simulate) {
            if (ingredient instanceof PlayerExperienceIngredient) {
                if (!simulate) {
                    this.player.addExperience(ingredient.getAmount());
                }
                return new PlayerExperienceIngredient(0);
            }
            return super.insert(ingredient, simulate);
        }
    }
}
