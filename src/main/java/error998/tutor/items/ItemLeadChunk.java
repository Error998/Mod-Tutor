package error998.tutor.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import error998.tutor.Reference;
import error998.tutor.Tutor;

public class ItemLeadChunk extends Item
{

	public ItemLeadChunk()
	{
		
		setUnlocalizedName(Reference.TutorItems.LEAD_CHUNK.getUnlocalizedName());
		setRegistryName(Reference.TutorItems.LEAD_CHUNK.getRegistryName());
		
		setCreativeTab(Tutor.CREATIVE_TAB);
	}
}
