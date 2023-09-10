package com.duart.mctb.blocks;

import com.duart.mctb.MoreCraftingTables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.ItemStack;


@Mod.EventBusSubscriber(modid = MoreCraftingTables.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModTab {

    public static final RegistryObject<CreativeModeTab> CUSTOM_TAB = Registration.TABS.register("mctb_tab",
            () -> {
                Block blockToUseAsIcon = ModBlocks.CRAFTING_TABLES[6].get();
                return CreativeModeTab.builder()
                        .title(Component.translatable("itemGroup.custom_tab"))
                        .icon(() -> new ItemStack(blockToUseAsIcon))
                        .build();
            });

    @SubscribeEvent
    public static void setCustomTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == CUSTOM_TAB.get()) {
           for (RegistryObject<CraftingBlock> blockObject : ModBlocks.CRAFTING_TABLES) {
               event.accept(blockObject.get());
           }
        }
    }
}
