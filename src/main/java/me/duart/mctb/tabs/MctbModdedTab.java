package me.duart.mctb.tabs;

import me.duart.mctb.blocks.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MctbModdedTab extends CreativeTabs {

    public MctbModdedTab() {
        super("moddedcraftingtablestab");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModBlocks.BLOCKS.get(6));
    }
}
