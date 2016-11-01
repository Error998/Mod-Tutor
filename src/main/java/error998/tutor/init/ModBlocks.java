package error998.tutor.init;

import error998.tutor.blocks.BlockBasic;
import error998.tutor.blocks.BlockCheese;
import error998.tutor.blocks.BlockCheeseMaker;
import error998.tutor.blocks.BlockJar;
import error998.tutor.blocks.BlockModel;
import error998.tutor.ores.OreLead;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks
{
	public static Block lead_Ore;
	
	public static Block cheese;
	public static Block jar;
	public static Block cheesemaker;
	public static Block basicblock;
	public static Block basicmodel;
	
	
	public static void init()
	{
		lead_Ore = new OreLead();
		
		cheese = new BlockCheese();
		jar = new BlockJar();
		cheesemaker = new BlockCheeseMaker();
		basicblock = new BlockBasic();
		basicmodel = new BlockModel();
	}
	
	
	public static void register()
	{
		registerBlock(lead_Ore);
		
		registerBlock(cheese);
		registerBlock(jar);
		registerBlock(cheesemaker);
		registerBlock(basicblock);
		registerBlock(basicmodel);
	}
	
	
	private static void registerBlock(Block block)
	{
		// Register Block
		GameRegistry.register(block);
		
		// Create new item of block and register it
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		item.setUnlocalizedName(block.getUnlocalizedName());
		GameRegistry.register(item);
	}
	
	
	public static void registerRenders()
	{
		registerRender(lead_Ore);
		
		registerRender(cheese);
		registerRender(jar);
		registerRender(cheesemaker);
		registerRender(basicblock);
		registerRender(basicmodel);
	}
	
	
	private static void registerRender(Block block)
	{
		ModelResourceLocation location = new ModelResourceLocation(block.getRegistryName(), "inventory");
		final int DEFAULT_ITEM_SUBTYPE = 0;
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), DEFAULT_ITEM_SUBTYPE, location);		
	}
}
