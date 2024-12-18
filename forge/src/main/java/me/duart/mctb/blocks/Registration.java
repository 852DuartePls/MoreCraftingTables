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

import java.util.Map;

import static com.duart.mctb.Constants.MOD_ID;

public class Registration {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final RegistryObject<CreativeModeTab> CUSTOM_TAB = TABS.register("mctb_tab", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.custom_tab"))
                    .icon(() -> new ItemStack(ModBlocks.CRAFTING_TABLES.get("spruce").get()))
                    .displayItems((parameters, output) -> {
                        int index = 0;

                        for (Map.Entry<String, RegistryObject<Block>> entry : ModBlocks.CRAFTING_TABLES.entrySet()) {
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

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        TABS.register(eventBus);
    }
}
