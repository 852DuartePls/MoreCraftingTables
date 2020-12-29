package com.duarte.mctb.blocks;

import java.util.ArrayList;
import java.util.List;

import com.duarte.mctb.MoreCraftingTables;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

public class Blocks {
    public static List<Block> blockList = new ArrayList<>();


 // Vanilla //
    public static final Block SPRUCE_CRAFTING_TABLE = craftingTable("spruce_crafting_table");
    public static final Block BIRCH_CRAFTING_TABLE = craftingTable("birch_crafting_table");
    public static final Block ACACIA_CRAFTING_TABLE = craftingTable("acacia_crafting_table");
    public static final Block JUNGLE_CRAFTING_TABLE = craftingTable("jungle_crafting_table");
    public static final Block DARK_OAK_CRAFTING_TABLE = craftingTable("dark_oak_crafting_table");
    public static final Block WARPED_CRAFTING_TABLE = craftingTable("warped_crafting_table");
    public static final Block CRIMSON_CRAFTING_TABLE = craftingTable("crimson_crafting_table");

    // Biomes 'o Plenty
    public static final Block CHERRY_CRAFTING_TABLE = craftingTable("cherry_crafting_table");
    public static final Block DEAD_CRAFTING_TABLE = craftingTable("dead_crafting_table");
    public static final Block FIR_CRAFTING_TABLE = craftingTable("fir_crafting_table");
    public static final Block HELLBARK_CRAFTING_TABLE = craftingTable("hellbark_crafting_table");
    public static final Block JACARANDA_CRAFTING_TABLE = craftingTable("jacaranda_crafting_table");
    public static final Block MAGIC_CRAFTING_TABLE = craftingTable("magic_crafting_table");
    public static final Block MAHOGANY_CRAFTING_TABLE = craftingTable("mahogany_crafting_table");
    public static final Block PALM_CRAFTING_TABLE = craftingTable("palm_crafting_table");
    public static final Block REDWOOD_CRAFTING_TABLE = craftingTable("redwood_crafting_table");
    public static final Block UMBRAN_CRAFTING_TABLE = craftingTable("umbran_crafting_table");
    public static final Block WILLOW_CRAFTING_TABLE = craftingTable("willow_crafting_table");


    static Block craftingTable(String id) {
        Block createBlock = new CraftingBlock(AbstractBlock.Properties.from(net.minecraft.block.Blocks.CRAFTING_TABLE));
        createBlock.setRegistryName(new ResourceLocation(MoreCraftingTables.MOD_ID, id));
        blockList.add(createBlock);
        return createBlock;
    }

    public static void init() {
    }

}
