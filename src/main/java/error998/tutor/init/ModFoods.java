package error998.tutor.init;


import error998.tutor.items.ItemCorn;
import error998.tutor.items.ItemCornSeed;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModFoods
{
	public static Item corn;
	public static Item corn_seed;
	
		
	public static void init()
	{
		corn = new ItemCorn();
		corn_seed = new ItemCornSeed();
			
	}
	
	
	public static void register()
	{
		GameRegistry.register(corn);
		GameRegistry.register(corn_seed);
		
	}
	
	
	public static void registerRenders()
	{
		registerRender(corn);
		registerRender(corn_seed);

	}
	
	
	// Only called from Client proxy
	private static void registerRender(Item item)
	{
		ModelResourceLocation location = new ModelResourceLocation(item.getRegistryName(), "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, location);
	}
}
