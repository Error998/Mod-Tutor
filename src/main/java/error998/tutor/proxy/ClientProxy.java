package error998.tutor.proxy;

import error998.tutor.init.ModBlocks;
import error998.tutor.init.ModCrops;
import error998.tutor.init.ModFoods;
import error998.tutor.init.ModItems;
import error998.tutor.tileenity.TileEntityJar;
import error998.tutor.tileenity.render.RendererJar;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy implements CommonProxy  
{
	
	@Override
	public void init()
	{
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		ModCrops.registerRenders();
		ModFoods.registerRenders();
		
		// Tile Entity Special Renderer Registration
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJar.class, new RendererJar());
	}
	
	
	@Override
	public EntityPlayer getEntityPlayer()
	{
		return Minecraft.getMinecraft().thePlayer;
	}
}
 