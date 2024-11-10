package me.duart.mctb.blocks;

import me.duart.mctb.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static me.duart.mctb.blocks.Registration.BLOCKS;
import static me.duart.mctb.blocks.Registration.ITEMS;
import static net.minecraft.world.level.block.Blocks.CRAFTING_TABLE;

public class ModBlocks {

    public static final Map<String, RegistryObject<Block>> CRAFTING_TABLES = createCraftingTables();

    private static @NotNull Map<String, RegistryObject<Block>> createCraftingTables() {
        Map<String, RegistryObject<Block>> craftingTables = new HashMap<>();
        for (String tableName : BlockIds.CRAFTING_TABLES) {
            craftingTables.put(tableName, registerCraftingTable(tableName + "_crafting_table"));
        }
        return craftingTables;
    }

    private static RegistryObject<Block> registerCraftingTable(String name) {
        BlockBehaviour.Properties blockProperties = BlockBehaviour.Properties.ofFullCopy(CRAFTING_TABLE);
        return createRegistry(name, () -> new CraftingBlock(blockProperties), blockProperties, new Item.Properties());
    }

    private static RegistryObject<Block> createRegistry(String name, Supplier<Block> blockSupplier, BlockBehaviour.@NotNull Properties blockProperties, Item.@NotNull Properties itemProperties) {
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name));
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name));

        blockProperties.setId(blockKey);
        itemProperties.useBlockDescriptionPrefix().setId(itemKey);

        RegistryObject<Block> block = BLOCKS.register(name, blockSupplier);
        ITEMS.register(name, () -> new BlockItem(block.get(), itemProperties));

        return block;
    }

    public static void init() {}
}
