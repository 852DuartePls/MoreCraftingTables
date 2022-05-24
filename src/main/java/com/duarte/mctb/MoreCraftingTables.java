package com.duarte.mctb;

import com.duarte.mctb.blocks.BlockItems;
import com.duarte.mctb.blocks.Blocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
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
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        isClient = true;
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registries {

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            Blocks.init();
            Blocks.blockList.forEach(block -> event.getRegistry().register((Block) block));
        }

        @SubscribeEvent
        public static void registerBlockItems(RegistryEvent.Register<Item> event) {
            BlockItems.init();
            BlockItems.itemList.forEach(item -> event.getRegistry().register((Item) item));
        }

}
