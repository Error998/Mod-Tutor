package error998.tutor.blocks;

import error998.tutor.Reference;
import error998.tutor.Tutor;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockModel extends Block
{

	public BlockModel()
	{
		super(Material.ROCK);							// Block is based on the stone block
		
		this.setRegistryName(Reference.TutorBlocks.BASIC_MODEL.getRegistryName());						// Unique internal name of the block
		this.setUnlocalizedName(Reference.TutorBlocks.BASIC_MODEL.getUnlocalizedName());				// Unlocalized name of block
		
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
	
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{													// Used by renderer and lighting for visibility of other blocks
		return false;									// Return true if block is a full 1x1x1 block
	}
	
	
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;									// Return true if block is a full 1x1x1 block
	}
	

	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
		return NULL_AABB;								// New collision bounding box, NULL_AABB = stops player from colliding into the block
	}
}
