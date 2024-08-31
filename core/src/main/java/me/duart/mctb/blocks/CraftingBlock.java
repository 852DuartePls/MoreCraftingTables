package me.duart.mctb.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class CraftingBlock extends CraftingTableBlock {
    private static final Component GUI_TITLE = Component.translatable("container.crafting");

    public CraftingBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public MenuProvider getMenuProvider(@NotNull BlockState state, @NotNull Level worldIn, @NotNull BlockPos pos) {
        return new SimpleMenuProvider((id, inventory, entity) -> new me.duart.mctb.container.CraftingContainer(id, inventory, ContainerLevelAccess.create(worldIn, pos), this), GUI_TITLE);
    }
}