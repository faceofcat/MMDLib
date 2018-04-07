//package com.mcmoddev.lib.crafting.inventory.implementation;
//
//import javax.annotation.Nullable;
//import ICraftingIngredient;
//import IFluidInventory;
//import IItemInventory;
//import IItemInventoryExtractor;
//import IItemInventoryInserter;
//import net.minecraft.item.ItemStack;
//import net.minecraftforge.items.IItemHandler;
//import net.minecraftforge.items.IItemHandlerModifiable;
//
//public class ItemHandlerCraftingInventory extends BaseCraftingInventory
//    implements IItemInventory, IItemInventoryExtractor, IItemInventoryInserter {
//
//    private final IItemHandler itemHandler;
//
//    public ItemHandlerCraftingInventory(final String key, final IItemHandler itemHandler) {
//        super(key);
//
//        this.itemHandler = itemHandler;
//    }
//
//    @Override
//    public int getSlots() {
//        return this.itemHandler.getSlots();
//    }
//
//    @Override
//    public ItemStack getSlotContent(int slot) {
//        return this.itemHandler.getStackInSlot(slot);
//    }
//
//    @Override
//    public boolean setSlotContent(int slot, ItemStack stack) {
//        if (this.itemHandler instanceof IItemHandlerModifiable) {
//            try {
//                ((IItemHandlerModifiable)this.itemHandler).setStackInSlot(slot, stack);
//                return true;
//            }
//            catch(RuntimeException ignored) {}
//        }
//
//        ItemStack result = this.itemHandler.insertItem(slot, stack, true);
//        if (result.isEmpty()) {
//            this.itemHandler.insertItem(slot, stack, false);
//            return true;
//        }
//
//        return false;
//    }
//
//    @Nullable
//    @Override
//    public ICraftingIngredient extractItemFrom(IFluidInventory inventory, int slot, boolean simulate) {
//        return null;
//    }
//
//    @Nullable
//    @Override
//    public ICraftingIngredient insertItemInto(IFluidInventory inventory, int slot, boolean simulate) {
//        return null;
//    }
//}
