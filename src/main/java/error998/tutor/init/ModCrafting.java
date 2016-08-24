package error998.tutor.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting
{
	
	public static void register()
	{
		// new ItemStack(*Block*, *Amount*, *Meta*)
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.cheese), "CCC", "CCC", "CCC", 'C', ModItems.cheese);
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.jar), " O ", "GGG", "BBB", 'O', Blocks.LOG, 'G', new ItemStack(Blocks.STAINED_GLASS_PANE, 1, 0), 'B', new ItemStack(Blocks.STAINED_GLASS, 1, 11));
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.cheese_cracker), "C", "K", 'C', ModItems.cheese, 'K', ModItems.cracker);
	}
}
