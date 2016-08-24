package error998.tutor.blocks;

import java.util.List;
import com.sun.org.apache.xml.internal.security.encryption.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import error998.tutor.Tutor;
import error998.tutor.tileenity.TileEntityCheeseMaker;
import error998.tutor.tileenity.TileEntityJar;
import error998.tutor.Reference.TutorBlocks;
import error998.tutor.init.ModItems;
import error998.tutor.network.PacketHandler;
import error998.tutor.network.message.MessageFillCheeseMaker;


public class BlockCheeseMaker extends Block implements ITileEntityProvider
{
	// One pixel in units is  1 / 16 = 0.0625
	// Bounding box is 2 3D points from bottom left to top right of model
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0625 * 1.5, 0, 0.0625 * 1.5, 0.0625 * 14.5, 0.0625 * 13, 0.0625 * 14.5);
	private static final AxisAlignedBB COLLISION_BOX = new AxisAlignedBB(0.0625 * 2.5, 0, 0.0625 * 2.5, 0.0625 * 13.5, 0.0625 * 12, 0.0625 * 13.5);

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyInteger MILK_LEVEL = PropertyInteger.create("level", 0, 7);
	
	
	
	public BlockCheeseMaker()
	{
		super(Material.GLASS);
		
		setUnlocalizedName(TutorBlocks.CHEESE_MAKER.getUnlocalizedName());
		setRegistryName(TutorBlocks.CHEESE_MAKER.getRegistryName());
		setCreativeTab(Tutor.CREATIVE_TAB);
		setHardness(0.8f);	
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.SOUTH));
	}
	
	
	// Block isn't a full cube
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	
	
	// Block has transparency
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	
	// Block isn't solid
	@Override
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT_MIPPED;
	}
	
	
	// Re-adjust bounding box to fit new model
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return BOUNDING_BOX;
	}
	
	
	// Re-adjust the collision box to fit new model
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn)
	{
		addCollisionBoxToList(pos, entityBox, collidingBoxes, COLLISION_BOX);
	}


	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityCheeseMaker();
	}
	
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(MILK_LEVEL, state.getValue(MILK_LEVEL)), 2);
	}
	
	
	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
			IBlockState state = super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
			return state.withProperty(MILK_LEVEL, Integer.valueOf(0));
	}
	
	
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        // Since we only allow horizontal rotation we need only 2 bits for facing. North, South, West, East start at index 2 so we have to add 2 here.
        return getDefaultState().withProperty(FACING, EnumFacing.getFront((meta & 3) + 2));
    }

    
    @Override
    public int getMetaFromState(IBlockState state)
    {
        // Since we only allow horizontal rotation we need only 2 bits for facing. North, South, West, East start at index 2 so we have to subtract 2 here.
        return state.getValue(FACING).getIndex()-2;
    }

    
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] { FACING, MILK_LEVEL });
    }
	
    
    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
    	TileEntityCheeseMaker cheeseMaker = (TileEntityCheeseMaker) worldIn.getTileEntity(pos);
    	
    	return state.withProperty(MILK_LEVEL, cheeseMaker.getMilkLevel());
    }
    
    
    @Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		// Only manipulate items on the server side!
		if(worldIn.isRemote)
		{ 
			return false;
		}
		
		// Only want to perform action with the main hand
		if(hand == hand.OFF_HAND)
		{ 
			return false; 
		}
		
		// Get tileEnity that was activated
		TileEntity tileEntity = worldIn.getTileEntity(pos);
			
		// If the tileEnity is a TECheeseMaker cast it as such. 
		if(tileEntity instanceof TileEntityCheeseMaker)
		{
			TileEntityCheeseMaker cheesemaker = (TileEntityCheeseMaker) tileEntity;
				
			// Do we have an item in hand?
			if(heldItem != null)
			{
				// Check if the item in hand is a milk bucket
				if(heldItem.getItem() == Items.MILK_BUCKET)
				{
					// If we successfully added a bucket of milk remove 1 from heldItem
					System.out.println("Trying to add milk to machine");
					if(cheesemaker.addMilk())
					{	
						// Remove milk bucket and return an empty bucket to player if not in creative
						if(!playerIn.capabilities.isCreativeMode)
						{
							heldItem.stackSize--;
							playerIn.setHeldItem(hand, new ItemStack(Items.BUCKET));
						}
						System.out.println("Milk added to machine successfully");
					} 
					else
					{
						// Failed to add milk to machine
						System.out.println("Failed to add milk to machine, Milk level: " + cheesemaker.getMilkLevel());
					}
				}
				else
				{ 
					// Item in hand isn't a milk bucket
				}
			}
			else
			{
				// Hand is empty
				if(side == side.UP){
					System.out.println("do work");
					cheesemaker.doWork();
				}
			}
			PacketHandler.INSTANCE.sendToAllAround(new MessageFillCheeseMaker(cheesemaker.getMilkLevel(), pos.getX(), pos.getY(), pos.getZ()), new TargetPoint(playerIn.dimension, pos.getX(), pos.getY(), pos.getZ(), 128D));
			worldIn.markBlockRangeForRenderUpdate(pos, pos);
		}		
		return true;
	}
}