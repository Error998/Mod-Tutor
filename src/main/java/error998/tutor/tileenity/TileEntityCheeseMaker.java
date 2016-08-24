package error998.tutor.tileenity;

import error998.tutor.init.ModItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;

public class TileEntityCheeseMaker extends TileEntity
{
	
	private int milk_level = 0;
	private int work_done = 0;
	
	public int getMilkLevel()
	{
		System.out.println("Milk in TE getMilkLevel: " + milk_level);
		return this.milk_level;
	}
	
	
	public boolean addMilk()
	{
		if(milk_level < 7)
		{
			milk_level++;
			work_done = 0;
			System.out.println("Milk in TE addMilk: " + milk_level);
			return true;
		}
		return false;
	}
	
	
	public void setMilkLevel(int level)
	{
		milk_level = level;
	}
	
	
	public void doWork()
	{
		work_done++;
		if(work_done >= 10)
		{
			work_done = 0;
			
			workComplete();
		}
	}
	
	
	public void workComplete()
	{
		int amount = milk_level * 2;
		
		if(amount > 0)
		{
			milk_level = 0;
			worldObj.spawnEntityInWorld(new EntityItem(worldObj, pos.getX() + 0.5f, pos.getY() + 1.0f, pos.getZ() + 0.5f, new ItemStack( ModItems.cheese, amount )));
		}
	}
	
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("level", this.milk_level);
		return compound; 
	}

	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		if(compound.hasKey("level"))
		{
			this.milk_level = compound.getInteger("level");
		}
	}
	
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket()
	{
		NBTTagCompound compound = new NBTTagCompound();
		this.writeToNBT(compound);
		
		return new SPacketUpdateTileEntity(pos, getBlockMetadata(), compound);
	}
	
	
	@Override
	public NBTTagCompound getUpdateTag()
	{
		return writeToNBT(new NBTTagCompound());
	}
	
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
	{
		NBTTagCompound compound = pkt.getNbtCompound();
		this.readFromNBT(compound);
	}
}
