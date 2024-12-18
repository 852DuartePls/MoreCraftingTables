package me.duart.mctb.blocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Map;
import java.util.function.Supplier;

public class Registration {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("mctb");
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("mctb");
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "mctb");

    public static final Supplier<CreativeModeTab> CUSTOM_TAB = Registration.TABS.register("mctb_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.custom_tab"))
                    .icon(() -> new ItemStack(ModBlocks.CRAFTING_TABLES.get("spruce").get()))
                    .displayItems((params, output) -> {
                        int index = 0;

                        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.CRAFTING_TABLES.entrySet()) {
                            if (index >= 0 && index <= 25) {
                                output.accept(entry.getValue().get());
                            } else if (index >= 26 && index <= 38) {
                                if (ModList.get().isLoaded("biomesoplenty")) {
                                    output.accept(entry.getValue().get());
                                }
                            } else if (index >= 39 && index <= 40) {
                                if (ModList.get().isLoaded("quark")) {
                                    output.accept(entry.getValue().get());
                                }
                            } else if (index >= 41 && index <= 43) {
                                if (ModList.get().isLoaded("ad_astra")) {
                                    output.accept(entry.getValue().get());
                                }
                            } else if (index == 44) {
                                if (ModList.get().isLoaded("naturesaura")) {
                                    output.accept(entry.getValue().get());
                                }
                            } else if (index >= 45 && index <= 47) {
                                if (ModList.get().isLoaded("undergarden")) {
                                    output.accept(entry.getValue().get());
                                }
                            } else if (index >= 48 && index <= 56) {
                                if (ModList.get().isLoaded("twilightforest")) {
                                    output.accept(entry.getValue().get());
                                }
                            } else if (index >= 57) {
                                if (ModList.get().isLoaded("regions_unexplored")) {
                                    output.accept(entry.getValue().get());
                                }
                            }

                            index++;
                        }
                    })
                    .build()
    );
}
