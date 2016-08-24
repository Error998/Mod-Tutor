package error998.tutor.tileenity;

import error998.tutor.init.ModItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityJar extends TileEntity
{
	
	private int crackerCount = 0;
	
	
	public boolean addCracker()
	{
		if(crackerCount < 8)
		{
			crackerCount++;
			return true;
		}
		return false;
	}
	
	
	public void removeCracker()
	{
		if(crackerCount > 0)
		{
			worldObj.spawnEntityInWorld(new EntityItem(worldObj, pos.getX() + 0.5f, pos.getY() + 1.0f, pos.getZ() + 0.5f, new ItemStack(ModItems.cracker)));
			
			crackerCount--;
		}
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
}
