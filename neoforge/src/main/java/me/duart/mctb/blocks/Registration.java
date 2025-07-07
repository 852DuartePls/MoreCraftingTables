package me.duart.mctb.blocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
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
                            }

                            index++;
                        }
                    })
                    .build()
    );

    private static final List<ModRange> MODDED_TAB_RANGES = List.of(
            new ModRange("biomesoplenty", 26, 38),
            new ModRange("quark", 39, 40),
            new ModRange("ad_astra", 41, 43),
            new ModRange("naturesaura", 44, 44),
            new ModRange("undergarden", 45, 47),
            new ModRange("twilightforest", 48, 56),
            new ModRange("regions_unexplored", 57, Integer.MAX_VALUE)
    );

    private record ModRange(String modId, int start, int end) {
    }

    public static final Supplier<CreativeModeTab> CUSTOM_TAB_EXTRA = Registration.TABS.register("mctb_tab_extra", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.custom_tab_modded"))
                    .icon(() -> new ItemStack(ModBlocks.CRAFTING_TABLES.get("cherry").get()))
                    .displayItems((parameters, output) -> {
                        int index = 0;
                        for (Map.Entry<String, DeferredBlock<Block>> entry : ModBlocks.CRAFTING_TABLES.entrySet()) {
                            final int currentIndex = index++;
                            for (ModRange range : MODDED_TAB_RANGES) {
                                if (currentIndex >= range.start() && currentIndex <= range.end()) {
                                    if (ModList.get().isLoaded(range.modId())) {
                                        output.accept(entry.getValue().get());
                                    }
                                    break;
                                }
                            }
                        }
                    })
                    .build()
    );
}
