package error998.tutor.proxy;

import error998.tutor.init.ModBlocks;
import error998.tutor.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class ClientProxy implements CommonProxy  
{
	
	@Override
	public void init()
	{
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}
	
	
	@Override
	public EntityPlayer getEntityPlayer()
	{
		return Minecraft.getMinecraft().thePlayer;
	}
}
 