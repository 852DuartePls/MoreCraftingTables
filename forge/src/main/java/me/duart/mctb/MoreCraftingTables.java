package me.duart.mctb;

import com.duart.mctb.Constants;
import me.duart.mctb.blocks.ModBlocks;
import me.duart.mctb.blocks.Registration;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Mod(Constants.MOD_ID)
public class MoreCraftingTables {
    private static final Logger LOGGER = LogManager.getLogger();

    public MoreCraftingTables(final @NotNull FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        Registration.register(modEventBus);
        ModBlocks.init();

        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("MoreCraftingTables Loaded");
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
