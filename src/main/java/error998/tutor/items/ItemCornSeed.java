package error998.tutor.items;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import error998.tutor.Reference;
import error998.tutor.Tutor;
import error998.tutor.init.ModCrops;

public class ItemCornSeed extends ItemSeeds
{

	public ItemCornSeed()
	{
		// super( Block.Crop, Block.Soil )
		super(ModCrops.corn_plant, Blocks.FARMLAND);
		
		setUnlocalizedName(Reference.TutorItems.CORN_SEED.getUnlocalizedName());
		setRegistryName(Reference.TutorItems.CORN_SEED.getRegistryName());
		
		setCreativeTab(Tutor.CREATIVE_TAB);
	}
}
