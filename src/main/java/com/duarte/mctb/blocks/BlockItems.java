package com.duarte.mctb.blocks;

import com.duarte.mctb.MoreCraftingTables;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class BlockItems {

    public static List<Item> itemList = new ArrayList<>();

    // Vanilla //
    public static final Item SPRUCE_CRAFTING_TABLE = createItem(new BlockItem(Blocks.SPRUCE_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.SPRUCE_CRAFTING_TABLE));
    public static final Item BIRCH_CRAFTING_TABLE = createItem(new BlockItem(Blocks.BIRCH_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.BIRCH_CRAFTING_TABLE));
    public static final Item ACACIA_CRAFTING_TABLE = createItem(new BlockItem(Blocks.ACACIA_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.ACACIA_CRAFTING_TABLE));
    public static final Item JUNGLE_CRAFTING_TABLE = createItem(new BlockItem(Blocks.JUNGLE_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.JUNGLE_CRAFTING_TABLE));
    public static final Item DARK_OAK_CRAFTING_TABLE = createItem(new BlockItem(Blocks.DARK_OAK_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.DARK_OAK_CRAFTING_TABLE));
    public static final Item CRIMSON_CRAFTING_TABLE = createItem(new BlockItem(Blocks.CRIMSON_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.CRIMSON_CRAFTING_TABLE));
    public static final Item WARPED_CRAFTING_TABLE = createItem(new BlockItem(Blocks.WARPED_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.WARPED_CRAFTING_TABLE));

	// Stone Crafting Table //
	public static final Item WARPED_CRAFTING_TABLE = createItem(new BlockItem(Blocks.STONE_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.STONE_CRAFTING_TABLE));

    // Biomes o' Plenty //
    public static final Item CHERRY_CRAFTING_TABLE = createItem(new BlockItem(Blocks.CHERRY_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.CHERRY_CRAFTING_TABLE));
    public static final Item DEAD_CRAFTING_TABLE = createItem(new BlockItem(Blocks.DEAD_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.DEAD_CRAFTING_TABLE));
    public static final Item FIR_CRAFTING_TABLE = createItem(new BlockItem(Blocks.FIR_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.FIR_CRAFTING_TABLE));
    public static final Item HELLBARK_CRAFTING_TABLE = createItem(new BlockItem(Blocks.HELLBARK_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.HELLBARK_CRAFTING_TABLE));
    public static final Item JACARANDA_CRAFTING_TABLE = createItem(new BlockItem(Blocks.JACARANDA_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.JACARANDA_CRAFTING_TABLE));
    public static final Item MAHOGANY_CRAFTING_TABLE = createItem(new BlockItem(Blocks.MAHOGANY_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.MAHOGANY_CRAFTING_TABLE));
    public static final Item PALM_CRAFTING_TABLE = createItem(new BlockItem(Blocks.PALM_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.PALM_CRAFTING_TABLE));
    public static final Item REDWOOD_CRAFTING_TABLE = createItem(new BlockItem(Blocks.REDWOOD_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.REDWOOD_CRAFTING_TABLE));
    public static final Item UMBRAN_CRAFTING_TABLE = createItem(new BlockItem(Blocks.UMBRAN_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.UMBRAN_CRAFTING_TABLE));
    public static final Item WILLOW_CRAFTING_TABLE = createItem(new BlockItem(Blocks.WILLOW_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.WILLOW_CRAFTING_TABLE));
    public static final Item MAGIC_CRAFTING_TABLE = createItem(new BlockItem(Blocks.MAGIC_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.MAGIC_CRAFTING_TABLE));
    
    
    public static Item createItem(Item item, ResourceLocation id) {
        if (id != null && !id.equals(new ResourceLocation("minecraft:air"))) {
            item.setRegistryName(id);
            itemList.add(item);
            return item;
        } else {
            return null;
        }
    }

    public static Item createItem(Item item, String id) {
        item.setRegistryName(new ResourceLocation(MoreCraftingTables.MOD_ID, id));
        itemList.add(item);
        return item;
    }

    public static void init() {

    }
}
