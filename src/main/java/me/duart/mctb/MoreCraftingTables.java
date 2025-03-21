package me.duart.mctb;

import me.duart.mctb.proxy.CommonProxy;
import me.duart.mctb.tabs.MctbModdedTab;
import me.duart.mctb.tabs.MctbVanillaTab;
import me.duart.mctb.utils.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class MoreCraftingTables {

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
    public static CommonProxy proxy;

    public static final CreativeTabs VANILLA_TAB = new MctbVanillaTab();
    public static final CreativeTabs MODDED_TAB = new MctbModdedTab();

    @Mod.EventHandler
    public void preInit(FMLInitializationEvent event) {}

}
