package error998.tutor.init;

import error998.tutor.blocks.BlockCheese;
import error998.tutor.blocks.BlockCheeseMaker;
import error998.tutor.blocks.BlockJar;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	public static Block cheese;
	public static Block jar;
	public static Block cheesemaker;
	
	
	public static void init() {
		cheese = new BlockCheese();
		jar = new BlockJar();
		cheesemaker = new BlockCheeseMaker();
	}
	
	
	public static void register() {
		registerBlock(cheese);
		registerBlock(jar);
		registerBlock(cheesemaker);
	}
	
	private static void registerBlock(Block block) {
		// Register Block
		GameRegistry.register(block);
		
		// Create new item of block and register it
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		item.setUnlocalizedName(block.getUnlocalizedName());
		GameRegistry.register(item);
	}
	
	
	public static void registerRenders() {
		registerRender(cheese);
		registerRender(jar);
		registerRender(cheesemaker);
	}
	
	
	private static void registerRender(Block block) {
		ModelResourceLocation location = new ModelResourceLocation(block.getRegistryName(), "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, location);
	}
}
