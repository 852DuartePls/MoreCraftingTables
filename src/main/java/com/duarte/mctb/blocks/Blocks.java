package com.duarte.mctb.blocks;

import com.duarte.mctb.blocks.CraftingBlock;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class Blocks {
    public static List<Block> blockList = new ArrayList<Block>();
    //Vanilla
    public static final Block SPRUCE_CRAFTING_TABLE = Blocks.craftingTable("spruce_crafting_table");
    public static final Block BIRCH_CRAFTING_TABLE = Blocks.craftingTable("birch_crafting_table");
    public static final Block ACACIA_CRAFTING_TABLE = Blocks.craftingTable("acacia_crafting_table");
    public static final Block JUNGLE_CRAFTING_TABLE = Blocks.craftingTable("jungle_crafting_table");
    public static final Block DARK_OAK_CRAFTING_TABLE = Blocks.craftingTable("dark_oak_crafting_table");
    public static final Block WARPED_CRAFTING_TABLE = Blocks.craftingTable("warped_crafting_table");
    public static final Block CRIMSON_CRAFTING_TABLE = Blocks.craftingTable("crimson_crafting_table");
    // Biomes O' Plenty
    public static final Block CHERRY_CRAFTING_TABLE = Blocks.craftingTable("cherry_crafting_table");
    public static final Block DEAD_CRAFTING_TABLE = Blocks.craftingTable("dead_crafting_table");
    public static final Block FIR_CRAFTING_TABLE = Blocks.craftingTable("fir_crafting_table");
    public static final Block HELLBARK_CRAFTING_TABLE = Blocks.craftingTable("hellbark_crafting_table");
    public static final Block JACARANDA_CRAFTING_TABLE = Blocks.craftingTable("jacaranda_crafting_table");
    public static final Block MAGIC_CRAFTING_TABLE = Blocks.craftingTable("magic_crafting_table");
    public static final Block MAHOGANY_CRAFTING_TABLE = Blocks.craftingTable("mahogany_crafting_table");
    public static final Block PALM_CRAFTING_TABLE = Blocks.craftingTable("palm_crafting_table");
    public static final Block REDWOOD_CRAFTING_TABLE = Blocks.craftingTable("redwood_crafting_table");
    public static final Block UMBRAN_CRAFTING_TABLE = Blocks.craftingTable("umbran_crafting_table");
    public static final Block WILLOW_CRAFTING_TABLE = Blocks.craftingTable("willow_crafting_table");
    // Quark
    public static final Block AZALEA_CRAFTING_TABLE = Blocks.craftingTable("azalea_crafting_table");
    public static final Block BLOSSOM_CRAFTING_TABLE = Blocks.craftingTable("blossom_crafting_table");

    static Block craftingTable(String id) {
        CraftingBlock createBlock = new CraftingBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.CRAFTING_TABLE));
        createBlock.setRegistryName(new ResourceLocation("mctb", id));
        blockList.add((Block)createBlock);
        return createBlock;
    }

    public static void init() {
    }
}
