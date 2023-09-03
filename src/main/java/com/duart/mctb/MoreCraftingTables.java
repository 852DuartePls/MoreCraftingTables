package com.duart.mctb;

import com.duart.mctb.blocks.CraftingBlock;
import com.duart.mctb.blocks.ModBlocks;
import com.duart.mctb.blocks.Registration;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("mctb")
public class MoreCraftingTables {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "mctb";

    public static boolean isClient = false;

    public MoreCraftingTables() {
        ModBlocks.registerBlockItems();
        Registration.register();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::addToExistingTab);
    }

    private void commonSetup(FMLCommonSetupEvent event) {}

    private void doClientStuff(FMLClientSetupEvent event) {
        isClient = true;
    }

    @SubscribeEvent
    public void addToExistingTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            for (RegistryObject<CraftingBlock> blockObject : ModBlocks.CRAFTING_TABLES) {
                event.accept(blockObject.get());
            }
        }
    }
}
