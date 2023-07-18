package com.duart.mctb.blocks;

import java.util.function.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;


public class Blocks {
    public static final RegistryObject<Block> SPRUCE_CRAFTING_TABLE = register("spruce_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> BIRCH_CRAFTING_TABLE = register("birch_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> ACACIA_CRAFTING_TABLE = register("acacia_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> JUNGLE_CRAFTING_TABLE = register("jungle_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> DARK_OAK_CRAFTING_TABLE = register("dark_oak_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> WARPED_CRAFTING_TABLE = register("warped_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> CRIMSON_CRAFTING_TABLE = register("crimson_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> MANGROVE_CRAFTING_TABLE = register("mangrove_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> BOP_CHERRY_CRAFTING_TABLE = register("bop_cherry_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> DEAD_CRAFTING_TABLE = register("dead_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> FIR_CRAFTING_TABLE = register("fir_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> HELLBARK_CRAFTING_TABLE = register("hellbark_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> JACARANDA_CRAFTING_TABLE = register("jacaranda_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> MAGIC_CRAFTING_TABLE = register("magic_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> MAHOGANY_CRAFTING_TABLE = register("mahogany_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> PALM_CRAFTING_TABLE = register("palm_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> REDWOOD_CRAFTING_TABLE = register("redwood_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> UMBRAN_CRAFTING_TABLE = register("umbran_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> WILLOW_CRAFTING_TABLE = register("willow_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> AZALEA_CRAFTING_TABLE = register("azalea_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> BLOSSOM_CRAFTING_TABLE = register("blossom_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> CHERRY_CRAFTING_TABLE = register("cherry_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));
    public static final RegistryObject<Block> BAMBOO_CRAFTING_TABLE = register("bamboo_crafting_table", () -> new CraftingBlock(BlockBehaviour.Properties.copy((BlockBehaviour)net.minecraft.world.level.block.Blocks.CRAFTING_TABLE)));

    static void register() {}

    public static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem((Block)ret.get(), new Item.Properties()));
        return ret;
    }
}


