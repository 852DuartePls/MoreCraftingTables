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

    public static final Item SPRUCE_CRAFTING_TABLE = createItem(new BlockItem(Blocks.SPRUCE_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.SPRUCE_CRAFTING_TABLE));
    public static final Item BIRCH_CRAFTING_TABLE = createItem(new BlockItem(Blocks.BIRCH_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.BIRCH_CRAFTING_TABLE));
    public static final Item ACACIA_CRAFTING_TABLE = createItem(new BlockItem(Blocks.ACACIA_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.ACACIA_CRAFTING_TABLE));
    public static final Item JUNGLE_CRAFTING_TABLE = createItem(new BlockItem(Blocks.JUNGLE_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.JUNGLE_CRAFTING_TABLE));
    public static final Item DARK_OAK_CRAFTING_TABLE = createItem(new BlockItem(Blocks.DARK_OAK_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.DARK_OAK_CRAFTING_TABLE));
    public static final Item WARPED_CRAFTING_TABLE = createItem(new BlockItem(Blocks.WARPED_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.WARPED_CRAFTING_TABLE));
    public static final Item CRIMSON_CRAFTING_TABLE = createItem(new BlockItem(Blocks.CRIMSON_CRAFTING_TABLE, new Item.Properties().group(ItemGroup.DECORATIONS)), Registry.BLOCK.getKey(Blocks.CRIMSON_CRAFTING_TABLE));

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
