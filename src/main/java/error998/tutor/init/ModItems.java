package error998.tutor.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import error998.tutor.Reference;
import error998.tutor.items.ItemCheese;
import error998.tutor.items.ItemCheeseCracker;
import error998.tutor.items.ItemCracker;
import error998.tutor.items.ItemTomatoSauce;

public class ModItems
{
	
	public static Item cheese;
	public static Item cracker;
	public static Item cheese_cracker;
	public static Item tomato_sauce;
	
	
	public static void init()
	{
		cheese = new ItemCheese();
		cracker = new ItemCracker();
		cheese_cracker = new ItemCheeseCracker();
		tomato_sauce = new ItemTomatoSauce();	
	}
	
	
	public static void register()
	{
		GameRegistry.register(cheese);
		GameRegistry.register(cracker);
		GameRegistry.register(cheese_cracker);
		GameRegistry.register(tomato_sauce);
	}
	
	
	public static void registerRenders()
	{
		registerRender(cheese);
		registerRender(cracker);
		registerRender(cheese_cracker);
		registerRender(tomato_sauce);
	}
	
	
	// Only called from Client proxy
	private static void registerRender(Item item)
	{
		ModelResourceLocation location = new ModelResourceLocation(item.getRegistryName(), "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, location);
	}
}
