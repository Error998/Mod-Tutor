package error998.tutor.tileenity;

import error998.tutor.init.ModItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCheeseMaker extends TileEntity{
	
	private int milk_level = 0;
	
	
	public int getMilkLevel() {
		System.out.println("Milk in TE getMilkLevel: " + milk_level);
		return this.milk_level;
	}
	
	
	public boolean addMilk(){
		if(milk_level < 7){
			milk_level++;
			System.out.println("Milk in TE addMilk: " + milk_level);
			return true;
		}
		return false;
	}
	
	
	public void removeCheese(){
		if(milk_level > 0){
			milk_level--;
			worldObj.spawnEntityInWorld(new EntityItem(worldObj, pos.getX() + 0.5f, pos.getY() + 1.0f, pos.getZ() + 0.5f, new ItemStack( ModItems.cheese, 2 )));
			System.out.println("Milk in TE removeMilk: " + milk_level);
		}
	}
	
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("level", this.milk_level);
		return compound; 
	}

	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		if(compound.hasKey("level")) {
			this.milk_level = compound.getInteger("level");
		}
	}
	
}
