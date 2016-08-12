package error998.tutor;

import error998.tutor.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TutorTab extends CreativeTabs{

	public TutorTab() {
		super("creativeTab");
	}

	@Override
	public Item getTabIconItem() {
		return ModItems.cheese;
	}

}
