package me.duart.mctb.blocks;

import com.duart.mctb.blocks.BlockIds;
import com.duart.mctb.blocks.CraftingBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.duart.mctb.Constants.id;
import static me.duart.mctb.blocks.Registration.BLOCKS;
import static me.duart.mctb.blocks.Registration.ITEMS;
import static net.minecraft.world.level.block.Blocks.CRAFTING_TABLE;

public class ModBlocks {

    public static final Map<String, DeferredBlock<Block>> CRAFTING_TABLES = createCraftingTables();

    private static @NotNull Map<String, DeferredBlock<Block>> createCraftingTables() {
        Map<String, DeferredBlock<Block>> craftingTables = new LinkedHashMap<>();
        for (String tableName : BlockIds.CRAFTING_TABLES) {
            craftingTables.put(tableName, registerCraftingTable(tableName + "_crafting_table"));
        }
        return craftingTables;
    }

    public static @NotNull DeferredBlock<Block> registerCraftingTable(String name) {
        BlockBehaviour.Properties blockProperties = BlockBehaviour.Properties.ofFullCopy(CRAFTING_TABLE);
        return createRegistry(name, () -> new CraftingBlock(blockProperties), blockProperties, new Item.Properties());
    }

    private static @NotNull DeferredBlock<Block> createRegistry(String name, Supplier<Block> blockSupplier, BlockBehaviour.@NotNull Properties blockProperties, Item.@NotNull Properties itemProperties) {
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, id(name));
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, id(name));

        blockProperties.setId(blockKey);
        itemProperties.useBlockDescriptionPrefix().setId(itemKey);

        DeferredBlock<Block> block = BLOCKS.register(name, blockSupplier);
        ITEMS.register(name, () -> new BlockItem(block.get(), itemProperties));

        return block;
    }

    public static void init() {}
}
