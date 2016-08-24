package error998.tutor.network;

import error998.tutor.Reference;
import error998.tutor.network.message.MessageFillCheeseMaker;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler
{
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
	
	public static void init()
	{
		INSTANCE.registerMessage(MessageFillCheeseMaker.class, MessageFillCheeseMaker.class, 0, Side.CLIENT);
	}
}
