package error998.tutor.tileenity;

import error998.tutor.init.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityJar extends TileEntity
{
	
	private int crackerCount = 0;
	
	
	public boolean addCracker()
	{
		if(crackerCount < 8)
		{
			this.crackerCount++;
			
			sendBlockUpdateToClient();
			
			return true;
		}
		return false;
	}
	
	
	public void removeCracker()
	{
		if(crackerCount > 0)
		{
			worldObj.spawnEntityInWorld(new EntityItem(worldObj, pos.getX() + 0.5f, pos.getY() + 1.0f, pos.getZ() + 0.5f, new ItemStack(ModItems.cheese_cracker)));
			
			this.crackerCount--;
			sendBlockUpdateToClient();
		}
	}
	
	
	public int getCrackerCount()
	{
		return this.crackerCount;
	}
	
	
	private void sendBlockUpdateToClient()
	{
		markDirty();
		IBlockState state = worldObj.getBlockState(pos);
		worldObj.notifyBlockUpdate(pos, state, state, 3);
	}
	
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("CrackerCount", this.crackerCount);
		return compound; 
	}

	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		this.crackerCount = compound.getInteger("CrackerCount");
	}
	
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		NBTTagCompound tag = pkt.getNbtCompound();
		this.readFromNBT(tag);
	}
	
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return new SPacketUpdateTileEntity(pos, getBlockMetadata(), tag);
	}
}
