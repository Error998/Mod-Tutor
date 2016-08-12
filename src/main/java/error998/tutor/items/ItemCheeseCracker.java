package error998.tutor.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import error998.tutor.Reference;
import error998.tutor.Tutor;

public class ItemCheeseCracker extends ItemFood {

	public ItemCheeseCracker() {
		// Hunger bar, saturation, isWolfFood
		super(3, 0.5f, true);
		
		setUnlocalizedName(Reference.TutorItems.CHEESECRACKER.getUnlocalizedName());
		setRegistryName(Reference.TutorItems.CHEESECRACKER.getRegistryName());
		
		setCreativeTab(Tutor.CREATIVE_TAB);
	}
}
