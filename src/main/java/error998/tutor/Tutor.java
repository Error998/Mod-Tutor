package error998.tutor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import error998.tutor.init.ModBlocks;
import error998.tutor.init.ModCrafting;
import error998.tutor.init.ModItems;
import error998.tutor.init.ModTileEntities;
import error998.tutor.proxy.CommonProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSION)
public class Tutor 
{
	@Instance
	public static Tutor instance;
	
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	
	public static final CreativeTabs CREATIVE_TAB = new TutorTab();
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ModItems.init();
		ModItems.register();
		
		ModBlocks.init();
		ModBlocks.register();
	}
	
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// Init client side renders
		proxy.init();
		
		// Register all crafting recipes
		ModCrafting.register();

		// Register TileEnities
		ModTileEntities.register();
	}
	
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		System.out.println("*** Postint loaded ***");
	}
}
