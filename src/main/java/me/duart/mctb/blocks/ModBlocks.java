package me.duart.mctb.blocks;

import me.duart.mctb.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.registries.IForgeRegistryModifiable;

import java.util.*;

@Mod.EventBusSubscriber(modid = "mctb")
public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<>();
    public static final List<Item> ITEMS = new ArrayList<>();

    private static final String[] CUSTOM_CRAFTING_TABLES = {
            // Vanilla
            "spruce_crafting_table", "birch_crafting_table", "jungle_crafting_table",
            "acacia_crafting_table", "dark_oak_crafting_table",

            // Biomes O' Plenty
            "sacred_oak_crafting_table",
            "cherry_crafting_table", "umbran_crafting_table", "fir_crafting_table",
            "ethereal_crafting_table", "magic_crafting_table", "mangrove_crafting_table",
            "palm_crafting_table", "redwood_crafting_table", "willow_crafting_table",
            "pine_crafting_table", "hellbark_crafting_table", "jacaranda_crafting_table",
            "mahogany_crafting_table", "ebony_crafting_table", "eucalyptus_crafting_table",

            // Thaumcraft
            "greatwood_crafting_table", "silverwood_crafting_table"
    };

    static {
        for (String name : CUSTOM_CRAFTING_TABLES) {
            Block block = new ModCraftingBlock(name);
            BLOCKS.add(block);
        }
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onItemBlockRegister(RegistryEvent.Register<Item> event) {
        for (Block block : BLOCKS) {
            ITEMS.add(new ItemBlock(block).setRegistryName(Objects.requireNonNull(block.getRegistryName())));
        }
        event.getRegistry().registerAll(ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Block block : BLOCKS) {
            if (block instanceof IHasModel) {
                ((IHasModel) block).registerModels();
            }
        }
    }

    // A weird workaround to remove the vanilla crafting table recipe,
    // and then re-add it, but now it only accepts oak planks,
    // but it also accepts planks in the "plankWood" group,
    // to keep modded compatibility with unlisted modded planks.
    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        IForgeRegistryModifiable<IRecipe> modRegistry = (IForgeRegistryModifiable<IRecipe>) event.getRegistry();
        modRegistry.remove(new ResourceLocation("minecraft:crafting_table"));

        ItemStack output = new ItemStack(Blocks.CRAFTING_TABLE);
        Set<Integer> blacklistMetadata = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));  // Spruce, Birch, Jungle, Acacia, Dark Oak

        if (OreDictionary.getOres("plankWood").stream()
                .anyMatch(stack -> stack.getItem() instanceof ItemBlock && Block.getBlockFromItem(stack.getItem()) instanceof BlockPlanks
                        && !blacklistMetadata.contains(stack.getMetadata()))) {

            GameRegistry.addShapedRecipe(new ResourceLocation("mctb:custom_crafting_table"), null, output,
                    "##", "##", '#', new OreIngredient("plankWood"));
        }
    }
}
