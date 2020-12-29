package com.duarte.mctb.container;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import shadows.fastbench.gui.ContainerFastBench;

public class FastCraftingContainer extends ContainerFastBench {
	private final Block workbench;
    private final IWorldPosCallable worldPos;

	public FastCraftingContainer(int id, PlayerEntity entity, World world, BlockPos pos, Block workbench) {
		super(id, entity, world, pos);
		this.workbench = workbench;
		this.worldPos = IWorldPosCallable.of(world, pos);
	}

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(this.worldPos, playerIn, this.workbench);
    }
}
