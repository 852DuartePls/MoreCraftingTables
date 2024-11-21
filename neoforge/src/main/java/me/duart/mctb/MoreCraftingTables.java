package me.duart.mctb;

import com.duart.mctb.Constants;
import me.duart.mctb.blocks.ModBlocks;
import me.duart.mctb.blocks.Registration;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import static me.duart.mctb.blocks.Registration.*;

@Mod(Constants.MOD_ID)
public class MoreCraftingTables {
    private static final Logger LOGGER = LogManager.getLogger();
    private final IEventBus modEventBus;

    public MoreCraftingTables(IEventBus modEventBus) {
        this.modEventBus = modEventBus;
        register();
        ModBlocks.init();
        NeoForge.EVENT_BUS.register(this);
        LOGGER.info("MoreCraftingTables Loaded");
    }

    public void register() {
        TABS.register(modEventBus);
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
    }

    @SubscribeEvent
    public void onFurnaceFuelBurnTime(@NotNull FurnaceFuelBurnTimeEvent event) {
        Item item = event.getItemStack().getItem();

        if (isCustomCraftingTableItem(item)) {
            event.setBurnTime(300);
        }
    }

    private boolean isCustomCraftingTableItem(Item item) {
        return Registration.ITEMS.getEntries().stream()
                .filter(entry -> entry.getId().getPath().endsWith("_crafting_table"))
                .filter(entry -> {
                    String blockId = entry.getId().toString();
                    return !blockId.equals("mctb:warped_crafting_table") && !blockId.equals("mctb:crimson_crafting_table");
                })
                .anyMatch(entry -> item == entry.get());
    }
}