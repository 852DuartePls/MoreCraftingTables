package com.duart.mctb.blocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
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
}
