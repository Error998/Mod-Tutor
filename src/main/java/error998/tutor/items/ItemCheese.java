package error998.tutor.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import error998.tutor.Reference;
import error998.tutor.Tutor;

public class ItemCheese extends ItemFood {

	public ItemCheese() {
		// (Hunger fill out of 20, isWolfFood)
		super(2, false);
		
		setUnlocalizedName(Reference.TutorItems.CHEESE.getUnlocalizedName());
		setRegistryName(Reference.TutorItems.CHEESE.getRegistryName());
		
		setCreativeTab(Tutor.CREATIVE_TAB);
	}
}
