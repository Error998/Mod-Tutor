package error998.tutor.blocks;

import error998.tutor.Reference;
import error998.tutor.Tutor;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;

public class BlockBasic extends Block
{

	public BlockBasic()
	{
		super(Material.ROCK);							// Block is based on the stone block
		
		this.setRegistryName(Reference.TutorBlocks.BASIC_BLOCK.getRegistryName());						// Unique internal name of the block
		this.setUnlocalizedName(Reference.TutorBlocks.BASIC_BLOCK.getUnlocalizedName());				// Unlocalized name of block
		
		this.setCreativeTab(Tutor.CREATIVE_TAB);		// Add block to creative tab
		this.setHardness(5f);							// How many hits it takes to break block
		this.setResistance(1000f);						// Explosion resistance
		this.setSoundType(SoundType.STONE);				// Walking on block sound
		this.setHarvestLevel("pickaxe", 1); 			// Tool and level required to harvest block: Level 0 = Wood, 1 = Stone, 2 = Iron, 3 = Diamond
		this.setLightLevel(0f);							// Light level the block emits
	}

	
	@Override
	public BlockRenderLayer getBlockLayer()
	{													// http://greyminecraftcoder.blogspot.co.za/2014/12/block-rendering-18.html
		return BlockRenderLayer.SOLID;					// SOLID, CUTOUT, CUTOUT_MIPPED or TRANSLUCENT
	}
	
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;				// ENTITYBLOCK_ANIMATED, INVISIBLE, LIQUID or MODEL
	}
}
