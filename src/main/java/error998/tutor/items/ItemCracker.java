package error998.tutor.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import error998.tutor.Reference;
import error998.tutor.Tutor;

public class ItemCracker extends ItemFood
{

	public ItemCracker()
	{
		super(1,false);
		
		setUnlocalizedName(Reference.TutorItems.CRACKER.getUnlocalizedName());
		setRegistryName(Reference.TutorItems.CRACKER.getRegistryName());
		
		setCreativeTab(Tutor.CREATIVE_TAB);
	}
}
