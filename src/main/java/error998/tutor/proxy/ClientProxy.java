package error998.tutor.proxy;

import error998.tutor.init.ModBlocks;
import error998.tutor.init.ModItems;

public class ClientProxy implements CommonProxy  
{
	@Override
	public void init() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}
}
 