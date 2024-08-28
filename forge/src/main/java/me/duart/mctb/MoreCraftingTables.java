package me.duart.mctb;

import me.duart.mctb.blocks.CraftingBlock;
import me.duart.mctb.blocks.ModBlocks;
import me.duart.mctb.blocks.Registration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Mod(Constants.MOD_ID)
public class MoreCraftingTables {
    private static final Logger LOGGER = LogManager.getLogger();

    public MoreCraftingTables() {
        ModBlocks.registerBlockItems();
        Registration.register();
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
        for (RegistryObject<CraftingBlock> blockObject : ModBlocks.CRAFTING_TABLES) {
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