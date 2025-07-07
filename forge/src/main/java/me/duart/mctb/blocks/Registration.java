package me.duart.mctb.blocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Map;

import static com.duart.mctb.Constants.MOD_ID;

public class Registration {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final RegistryObject<CreativeModeTab> CUSTOM_TAB = TABS.register("mctb_tab", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.custom_tab"))
                    .icon(() -> new ItemStack(ModBlocks.CRAFTING_TABLES.get("acacia").get()))
                    .displayItems((parameters, output) -> {
                        int index = 0;

                        for (Map.Entry<String, RegistryObject<Block>> entry : ModBlocks.CRAFTING_TABLES.entrySet()) {
                            if (index >= 0 && index <= 25) {
                                output.accept(entry.getValue().get());
                            }

                            index++;
                        }
                    })
                    .build()
    );

    // Only add if mod is present
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

    public static final RegistryObject<CreativeModeTab> CUSTOM_TAB_EXTRA = TABS.register("mctb_tab_extra", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.custom_tab_modded"))
                    .icon(() -> new ItemStack(ModBlocks.CRAFTING_TABLES.get("cherry").get()))
                    .displayItems((parameters, output) -> {
                        int index = 0;
                        for (Map.Entry<String, RegistryObject<Block>> entry : ModBlocks.CRAFTING_TABLES.entrySet()) {
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

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        TABS.register(eventBus);
    }
}
