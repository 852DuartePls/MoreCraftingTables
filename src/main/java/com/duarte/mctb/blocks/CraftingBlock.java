package com.duarte.mctb.blocks;

import com.duarte.mctb.container.CraftingContainer;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;


@SuppressWarnings("deprecation")
public class CraftingBlock extends CraftingTableBlock {
    private static final ITextComponent NAME = new TranslationTextComponent("container.crafting_table");


    public CraftingBlock(Properties properties) {
        super(properties);
    }

    @Override
    public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
        return new SimpleNamedContainerProvider((id, inventory, entity) -> new CraftingContainer(id, inventory, IWorldPosCallable.of(worldIn, pos), this), NAME);
    }
}
