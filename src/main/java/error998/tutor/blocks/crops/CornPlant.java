package error998.tutor.blocks.crops;

import java.util.Random;

import error998.tutor.Tutor;
import error998.tutor.init.ModFoods;
import error998.tutor.init.ModItems;
import error998.tutor.Reference.TutorBlocks;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CornPlant extends BlockCrops 
{
	public static final PropertyInteger CORN_AGE = PropertyInteger.create("age", 0, 3);
	// Bounding box, for each growth stage
	private static final AxisAlignedBB[] CORN_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.6875D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D)};	
	
	public CornPlant()
	{
		setUnlocalizedName(TutorBlocks.CORN_PLANT.getUnlocalizedName());
		setRegistryName(TutorBlocks.CORN_PLANT.getRegistryName());
		setCreativeTab(Tutor.CREATIVE_TAB);
		
	}
	
	
    protected PropertyInteger getAgeProperty()
    {
        return CORN_AGE;
    }

    
    public int getMaxAge()
    {
        return 3;
    }

    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (rand.nextInt(3) == 0)
        {
            this.checkAndDropBlock(worldIn, pos, state);
        }
        else
        {
            super.updateTick(worldIn, pos, state, rand);
        }
    }

    
    protected int getBonemealAgeIncrease(World worldIn)
    {
        return super.getBonemealAgeIncrease(worldIn) / 3;
    }

    
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {CORN_AGE});
    }

    
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        // Adjust bounding box based on the growth stage of the plant
    	return CORN_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
    }

	    
	@Override
	protected Item getSeed()
	{
		// Seeds that plant will drop
		return ModFoods.corn_seed;
	}
	
	
	@Override
	protected Item getCrop()
	{
		// Item that harvested full grown plant will drop
		return ModFoods.corn;
	}
	
}
