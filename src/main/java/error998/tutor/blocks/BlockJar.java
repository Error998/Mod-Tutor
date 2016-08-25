package error998.tutor.blocks;

import java.util.List;

import com.sun.org.apache.xml.internal.security.encryption.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import error998.tutor.Tutor;
import error998.tutor.init.ModItems;
import error998.tutor.tileenity.TileEntityJar;
import error998.tutor.Reference.TutorBlocks;

public class BlockJar extends Block  implements ITileEntityProvider
{
	// One pixel in units is  1 / 16 = 0.0625
	// Bounding box is 2 3D points from bottom left to top right of model
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 3, 0.0625 * 13, 0.0625 * 13, 0.0625 * 13);
	private static final AxisAlignedBB COLLISION_BOX = new AxisAlignedBB(0.0625 * 4, 0, 0.0625 * 4, 0.0625 * 12, 0.0625 * 12, 0.0625 * 12);

	
	public BlockJar()
	{
		super(Material.GLASS);
		
		setUnlocalizedName(TutorBlocks.JAR.getUnlocalizedName());
		setRegistryName(TutorBlocks.JAR.getRegistryName());
		
		setCreativeTab(Tutor.CREATIVE_TAB);
		setHardness(0.25f);		
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
		return BlockRenderLayer.TRANSLUCENT;
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
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		// Only manipulate items on the server side!
		if(!worldIn.isRemote)
		{
			
			// Get tileEnity that was activated
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			
			// If the tileEnity is a Jar cast it as such. 
			if(tileEntity instanceof TileEntityJar)
			{
				TileEntityJar jar = (TileEntityJar) tileEntity;
				
				// Do we have an item in hand?
				if(heldItem != null)
				{
					// Check if the item in hand is a cracker
					if(heldItem.getItem() == ModItems.cheese_cracker)
					{
						// If we successfully added a cracker remove 1 from heldItem
						if(jar.addCracker())
						{
							heldItem.stackSize--;
							return true;
						}
					}
				}
				jar.removeCracker();
			}
		}
		return true;
	}


	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityJar();
	}
}
