package com.duart.mctb;

import com.duart.mctb.blocks.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import static com.duart.mctb.blocks.Registration.*;


@Mod("mctb")
public class MoreCraftingTables {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "mctb";
    private final IEventBus modEventBus;

    public MoreCraftingTables(IEventBus modEventBus) {
        this.modEventBus = modEventBus;
        register();
        ModBlocks.registerBlockItems();
        NeoForge.EVENT_BUS.register(this);
        LOGGER.info("MoreCraftingTables Loaded");
    }

    public void register() {
        TABS.register(modEventBus);
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        ModBlocks.register();
    }
    
    @SubscribeEvent
    public void onFurnaceFuelBurnTime(@NotNull FurnaceFuelBurnTimeEvent event) {
        Item item = event.getItemStack().getItem();

        if (isCustomCraftingTableItem(item)) {
            event.setBurnTime(300);
        }
    }

    private boolean isCustomCraftingTableItem(Item item) {
        for (DeferredBlock<CraftingBlock> blockObject : ModBlocks.CRAFTING_TABLES) {
            ResourceLocation blockLocation = blockObject.getId();

            if ("mctb:warped_crafting_table".equals(blockLocation.toString()) ||
                    "mctb:crimson_crafting_table".equals(blockLocation.toString())) {
                continue;
            }

            if (item == Item.BY_BLOCK.get(blockObject.get())) {
                return true;
            }
        }
        return false;
    }
}