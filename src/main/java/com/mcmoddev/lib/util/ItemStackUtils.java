package com.mcmoddev.lib.util;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import mcp.MethodsReturnNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public final class ItemStackUtils {
    private ItemStackUtils() {}

    public static boolean areEqualIgnoreSize(ItemStack a, ItemStack b) {
        if (!ItemStack.areItemStackTagsEqual(a, b)) {
            return false;
        }

        return ItemStack.areItemsEqual(a, b);
    }

    public static ItemStack copyWithSize(ItemStack source, int size) {
        // for some reason I think there is a forge method for this, but couldn't find it :S
        if (size > 0) {
            ItemStack result = source.copy();
            result.setCount(size);
            return result;
        }
        else {
            return ItemStack.EMPTY;
        }
    }

    public static List<ItemStack> getCombinedInventory(IItemHandler handler) {
        List<ItemStack> list = new ArrayList<>();
        for (int index = 0; index < handler.getSlots(); index++) {
            ItemStack stack = handler.getStackInSlot(index);
            if (stack.isEmpty()) {
                continue;
            }

            ItemStack match = list.stream()
                .filter(it -> ItemStackUtils.areEqualIgnoreSize(it, stack))
                .findFirst()
                .orElse(null);

            if (match == null) {
                list.add(stack.copy());
            } else {
                match.setCount(match.getCount() + stack.getCount());
            }
        }
        return list;
    }

    public static int extractFromCombinedInventory(IItemHandler handler, ItemStack stack, int amount, boolean simulate) {
        if (stack.isEmpty()) {
            return 0;
        }

        ItemStack result = ItemStackUtils.copyWithSize(stack, amount);
        int taken = 0;
        for (int index = 0; index < handler.getSlots(); index++) {
            ItemStack temp = handler.getStackInSlot(index);
            if (temp.isEmpty() || !ItemStackUtils.areEqualIgnoreSize(stack, temp)) {
                continue;
            }

            ItemStack takenStack = handler.extractItem(index, Math.min(result.getCount(), temp.getCount()), simulate);
            taken += takenStack.getCount();
            result.shrink(takenStack.getCount());
            if (result.isEmpty()) {
                break;
            }
        }
        return taken;
    }

    // TODO: convert this if needed
//    fun insertItemInExistingStacks(dest: IItemHandler?, stack: ItemStack, simulate: Boolean): ItemStack {
//        var remaining = stack
//        if ((dest == null) || remaining.isEmpty)
//            return ItemStack.EMPTY
//
//        for (i in 0 until dest.slots) {
//            if (dest.getStackInSlot(i).isEmpty) {
//                continue
//            }
//
//            remaining = dest.insertItem(i, remaining, simulate)
//            if (remaining.isEmpty) {
//                return ItemStack.EMPTY
//            }
//        }
//
//        return remaining
//    }
}
