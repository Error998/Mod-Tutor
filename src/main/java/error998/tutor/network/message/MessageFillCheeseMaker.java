package error998.tutor.network.message;

import error998.tutor.Tutor;
import error998.tutor.tileenity.TileEntityCheeseMaker;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageFillCheeseMaker implements IMessage, IMessageHandler<MessageFillCheeseMaker, IMessage>
{
	private int milk_level;
	private int posX, posY, posZ;
	
	public MessageFillCheeseMaker() { }
	

	public MessageFillCheeseMaker(int level, int x, int y, int z)
	{
		this.milk_level = level;
		this.posX = x;
		this.posY = y;
		this.posZ = z;
	}
	
	
	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.milk_level = buf.readInt();
		this.posX = buf.readInt();
		this.posY = buf.readInt();
		this.posZ = buf.readInt();
	}

	
	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(this.milk_level);
		buf.writeInt(this.posX);
		buf.writeInt(this.posY);
		buf.writeInt(this.posZ);
	}


	@Override
	public IMessage onMessage(MessageFillCheeseMaker message, MessageContext ctx)
	{
		if(ctx.side == Side.CLIENT){
			EntityPlayer player = Tutor.proxy.getEntityPlayer();
			
			TileEntity te = player.worldObj.getTileEntity(new BlockPos(message.posX, message.posY, message.posZ));
			if(te instanceof TileEntityCheeseMaker)
			{
				TileEntityCheeseMaker teCheeseMaker = (TileEntityCheeseMaker) te;
				
				teCheeseMaker.setMilkLevel(message.milk_level);
				BlockPos pos = new BlockPos(message.posX, message.posY, message.posZ);
				
				player.worldObj.notifyBlockUpdate(pos, player.worldObj.getBlockState(pos), player.worldObj.getBlockState(pos), 3);	
			}
		}
		return null;
	}
}
