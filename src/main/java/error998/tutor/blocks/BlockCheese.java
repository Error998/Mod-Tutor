package error998.tutor.blocks;

import com.sun.org.apache.xml.internal.security.encryption.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import error998.tutor.Reference.TutorBlocks;
import error998.tutor.Tutor;

public class BlockCheese extends Block {

	public BlockCheese() {
		super(Material.CAKE);
		
		setUnlocalizedName(TutorBlocks.CHEESE.getUnlocalizedName());
		setRegistryName(TutorBlocks.CHEESE.getRegistryName());
		setCreativeTab(Tutor.CREATIVE_TAB);

		setHardness(1.5f);
		setLightLevel(1.0f);
	}
}
