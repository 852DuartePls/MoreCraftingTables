package com.duart.mctb;

import com.duart.mctb.blocks.Blocks;
import com.duart.mctb.blocks.Registration;
import java.util.function.Supplier;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("mctb")
public class MoreCraftingTables {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "mctb";

    public static boolean isClient = false;

    public MoreCraftingTables() {
        Registration.register();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::buildContents);
    }

    private void commonSetup(FMLCommonSetupEvent event) {}

    private void doClientStuff(FMLClientSetupEvent event) {
        isClient = true;
    }
    @SubscribeEvent
    public void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept((Supplier)Blocks.SPRUCE_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.BIRCH_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.ACACIA_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.JUNGLE_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.DARK_OAK_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.CRIMSON_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.WARPED_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.MANGROVE_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.BOP_CHERRY_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.DEAD_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.FIR_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.HELLBARK_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.JACARANDA_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.MAGIC_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.MAHOGANY_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.PALM_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.REDWOOD_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.UMBRAN_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.WILLOW_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.AZALEA_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.BLOSSOM_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.CHERRY_CRAFTING_TABLE);
            event.accept((Supplier)Blocks.BAMBOO_CRAFTING_TABLE);
        }
    }
}
