package error998.tutor.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import error998.tutor.Reference;
import error998.tutor.Tutor;

public class ItemTomatoSauce extends Item
{

	public ItemTomatoSauce()
	{
		setUnlocalizedName(Reference.TutorItems.TOMATOSAUCE.getUnlocalizedName());
		setRegistryName(Reference.TutorItems.TOMATOSAUCE.getRegistryName());
		
		setCreativeTab(Tutor.CREATIVE_TAB);
	}
}
