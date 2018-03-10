package com.mcmoddev.lib.container.gui.sprite;

import java.util.function.Supplier;
import com.mcmoddev.lib.container.gui.IGuiSprite;
import com.mcmoddev.lib.container.gui.IGuiTexture;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemRendererSprite implements IGuiSprite {
    private final Supplier<ItemStack> itemSupplier;

    public ItemRendererSprite(final ItemStack stack) {
        this(() -> stack);
    }

    public ItemRendererSprite(final Supplier<ItemStack> itemSupplier) {
        this.itemSupplier = itemSupplier;
    }

    @Override
    public IGuiTexture getTexture() {
        return MinecraftStitchedTextures.INSTANCE;
    }

    @Override
    public int getLeft() {
        return 0;
    }

    @Override
    public int getTop() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 16;
    }

    @Override
    public int getHeight() {
        return 16;
    }

    @Override
    public boolean needsAlpha() {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void draw(GuiScreen screen, int left, int top, int width, int height, boolean clip) {
        final ItemStack stack = this.itemSupplier.get();
        if (!stack.isEmpty()) {
            screen.mc.getRenderItem().renderItemAndEffectIntoGUI(stack,
                left + (width - this.getWidth()) / 2,
                top + (height - this.getHeight()) / 2);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void draw(GuiScreen screen, int left, int top, int texLeft, int texTop, int texWidth, int texHeight) {
        throw new RuntimeException("Not supported!");
    }
}
