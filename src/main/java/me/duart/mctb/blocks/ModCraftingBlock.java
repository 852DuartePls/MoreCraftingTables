package me.duart.mctb.blocks;

import me.duart.mctb.MoreCraftingTables;
import me.duart.mctb.utils.IHasModel;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.item.Item;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

public class ModCraftingBlock extends BlockWorkbench implements IHasModel {

    public ModCraftingBlock(String name) {
        super();
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.DECORATIONS);
        setSoundType(SoundType.WOOD);
        setHarvestLevel("axe", 0);
        setHardness(2.5F);
        setResistance(2.5F);
    }

    @Override
    public void registerModels() {
        MoreCraftingTables.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote) return true;
        playerIn.displayGui(new InterfaceCraftingTable(worldIn, pos));
        playerIn.addStat(StatList.CRAFTING_TABLE_INTERACTION);
        return true;
    }

    public static class InterfaceCraftingTable implements IInteractionObject {

        private final World world;
        private final BlockPos position;

        public InterfaceCraftingTable(World worldIn, BlockPos pos) {
            this.world = worldIn;
            this.position = pos;
        }

        @Override
        public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
            return new ContainerCraftingTable(playerInventory, this.world, this.position);
        }

        @Override
        public String getGuiID() {
            return "minecraft:crafting_table";
        }

        @Override
        public String getName() {
            return "crafting_table";
        }

        @Override
        public boolean hasCustomName() {
            return false;
        }

        @Override
        public ITextComponent getDisplayName() {
            return new TextComponentTranslation("container.crafting");
        }
    }

    public static class ContainerCraftingTable extends ContainerWorkbench {

        private final World world;
        private final BlockPos position;


        public ContainerCraftingTable(InventoryPlayer playerInventory, World worldIn, BlockPos posIn) {
            super(playerInventory, worldIn, posIn);
            this.world = worldIn;
            this.position = posIn;
        }

        public boolean canInteractWith(EntityPlayer playerIn) {
            if (!(this.world.getBlockState(this.position).getBlock() instanceof ModCraftingBlock)) {
                return false;
            }
            return playerIn.getDistanceSq((double) this.position.getX() + 0.5D, (double) this.position.getY() + 0.5D, (double) this.position.getZ() + 0.5D) <= 64.0D;
        }
    }
}
