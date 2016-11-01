package error998.tutor.ores;

import error998.tutor.Reference;
import error998.tutor.Tutor;
import error998.tutor.init.ModOres;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class OreLead extends ModOres
{
	public OreLead()
	{
		this.setRegistryName(Reference.TutorBlocks.LEAD_ORE.getRegistryName());						// Unique internal name of the block
		this.setUnlocalizedName(Reference.TutorBlocks.LEAD_ORE.getUnlocalizedName());				// Unlocalized name of block
		
		this.setHardness(2.5f);							// How many hits it takes to break block
		this.setResistance(13f);						// Explosion resistance
		this.setSoundType(SoundType.STONE);				// Walking on block sound
		this.setHarvestLevel("pickaxe", 1); 			// Tool and level required to harvest block: Level 0 = Wood, 1 = Stone, 2 = Iron, 3 = Diamond
		
	}
}
