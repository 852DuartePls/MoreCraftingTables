package com.duart.mctb.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final RegistryObject<CraftingBlock>[] CRAFTING_TABLES = new RegistryObject[BlockIds.CRAFTING_TABLES.length];

    static {
        for (int i = 0; i < BlockIds.CRAFTING_TABLES.length; i++) {
            CRAFTING_TABLES[i] = register(BlockIds.CRAFTING_TABLES[i] + "_crafting_table"); }
    }

    public static RegistryObject<CraftingBlock> register(String name) {
        return Registration.BLOCKS.register(name, () -> createCraftingBlock(name));
    }

    private static CraftingBlock createCraftingBlock(String name) {
        return new CraftingBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.CRAFTING_TABLE));
    }

    public static void registerBlockItems() {
        for (RegistryObject<CraftingBlock> blockObject : CRAFTING_TABLES) {
            Registration.ITEMS.register(blockObject.getId().getPath(), () -> new BlockItem(blockObject.get(), new Item.Properties()));
        }
    }
    static void register() {}
}


