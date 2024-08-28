package me.duart.mctb.blocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class Registration {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("mctb");
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("mctb");
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "mctb");

    public static DeferredBlock<CraftingBlock> registerBlock(String name, Supplier<CraftingBlock> blockSupplier) {
        return Registration.BLOCKS.register(name, blockSupplier);
    }

    public static final Supplier<CreativeModeTab> CUSTOM_TAB = Registration.TABS.register("mctb_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.custom_tab"))
                    .icon(() -> new ItemStack(ModBlocks.CRAFTING_TABLES.get(6).get()))
                    .displayItems((params, output) -> {
                        for (DeferredBlock<CraftingBlock> blockObject : ModBlocks.CRAFTING_TABLES) {
                            output.accept(blockObject.get());
                        }
                    })
                    .build()
    );
}
