package com.duarte.mctb.blocks;

import com.duarte.mctb.MoreCraftingTables;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class Blocks {
    public static List<Block> blockList = new ArrayList<>();


    public static final Block SPRUCE_CRAFTING_TABLE = craftingTable("spruce_crafting_table");
    public static final Block BIRCH_CRAFTING_TABLE = craftingTable("birch_crafting_table");
    public static final Block ACACIA_CRAFTING_TABLE = craftingTable("acacia_crafting_table");
    public static final Block JUNGLE_CRAFTING_TABLE = craftingTable("jungle_crafting_table");
    public static final Block DARK_OAK_CRAFTING_TABLE = craftingTable("dark_oak_crafting_table");
    public static final Block WARPED_CRAFTING_TABLE = craftingTable("warped_crafting_table");
    public static final Block CRIMSON_CRAFTING_TABLE = craftingTable("crimson_crafting_table");


    static Block craftingTable(String id) {
        Block createBlock = new CraftingBlock(AbstractBlock.Properties.from(net.minecraft.block.Blocks.CRAFTING_TABLE));
        createBlock.setRegistryName(new ResourceLocation(MoreCraftingTables.MOD_ID, id));
        blockList.add(createBlock);
        return createBlock;
    }

    public static void init() {
    }

}
