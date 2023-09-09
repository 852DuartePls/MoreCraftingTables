package com.duart.mctb;

import com.duart.mctb.blocks.CraftingBlock;
import com.duart.mctb.blocks.ModBlocks;
import com.duart.mctb.blocks.Registration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("mctb")
public class MoreCraftingTables {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "mctb";


    public MoreCraftingTables() {
        ModBlocks.registerBlockItems();
        Registration.register();
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::addToExistingTab);

        LOGGER.info("MoreCraftingTables Loaded");
    }

    @SubscribeEvent
    public void addToExistingTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            for (RegistryObject<CraftingBlock> blockObject : ModBlocks.CRAFTING_TABLES) {
                event.accept(blockObject.get());
            }
        }
    }

    // Allow Crafting Tables to be used as furnace fuel
    @SubscribeEvent
    public void onFurnaceFuelBurnTime(FurnaceFuelBurnTimeEvent event) {
        Item item = event.getItemStack().getItem();

        if (isCustomCraftingTableItem(item)) {
            event.setBurnTime(300);
        }
    }
    private boolean isCustomCraftingTableItem(Item item) {
        for (RegistryObject<CraftingBlock> blockObject : ModBlocks.CRAFTING_TABLES) {
            ResourceLocation blockLocation = blockObject.getId();
            
    //Except from the Warped and Crimson varaints
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
