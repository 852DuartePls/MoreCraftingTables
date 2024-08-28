package me.duart.mctb.blocks;

import me.duart.mctb.BlockIds;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final List<DeferredBlock<CraftingBlock>> CRAFTING_TABLES = createCraftingTables();

    private static List<DeferredBlock<CraftingBlock>> createCraftingTables() {
        List<DeferredBlock<CraftingBlock>> craftingTables = new ArrayList<>();
        for (String tableName : BlockIds.CRAFTING_TABLES) {
            craftingTables.add(register(tableName + "_crafting_table"));
        }
        return craftingTables;
    }

    public static DeferredBlock<CraftingBlock> register(String name) {
        return Registration.registerBlock(name, ModBlocks::createCraftingBlock);
    }

    @Contract(" -> new")
    private static @NotNull CraftingBlock createCraftingBlock() {
        return new CraftingBlock(BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.CRAFTING_TABLE));
    }

    public static void registerBlockItems() {
        for (DeferredBlock<CraftingBlock> blockObject : CRAFTING_TABLES) {
            Registration.ITEMS.register(blockObject.getId().getPath(), () -> new BlockItem(blockObject.get(), new Item.Properties()));
        }
    }

    public static void register() {
    }
}