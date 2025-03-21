package me.duart.mctb.tabs;

import me.duart.mctb.blocks.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MctbVanillaTab extends CreativeTabs {

    public MctbVanillaTab() {
        super("vanillacraftingtablestab");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModBlocks.BLOCKS.get(0));
    }
}
