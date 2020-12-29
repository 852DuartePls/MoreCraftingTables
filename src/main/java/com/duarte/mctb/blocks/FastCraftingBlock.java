package com.duarte.mctb.blocks;

import com.duarte.mctb.container.FastCraftingContainer;

import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class FastCraftingBlock extends CraftingTableBlock {
    private static final ITextComponent NAME = new TranslationTextComponent("container.crafting_table");

    public FastCraftingBlock(Properties properties) {
        super(properties);
    }

    @Override
    public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
        return new SimpleNamedContainerProvider((id, inventory, entity) -> new FastCraftingContainer(id, entity, worldIn, pos, this), NAME);
    }
}
