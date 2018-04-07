package com.mcmoddev.lib.crafting.ingredient;

public interface ICraftingIngredient {
    int getAmount();

    default boolean isEmpty() {
        return (this.getAmount() == 0);
    }

    ICraftingIngredient copyWithAmount(int amount);

    public final static ICraftingIngredient EMPTY = new ICraftingIngredient() {
        @Override
        public int getAmount() { return 0; }

        @Override
        public ICraftingIngredient copyWithAmount(int amount) {
            throw new RuntimeException("Cannot copy the EMPTY ingredient!");
        }
    };
}
