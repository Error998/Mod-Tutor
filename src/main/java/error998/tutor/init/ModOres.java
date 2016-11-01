package error998.tutor.init;

import java.util.Random;

import error998.tutor.Reference;
import error998.tutor.Tutor;
import error998.tutor.TutorTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModOres extends Block
{

	public ModOres()
	{
		super(Material.ROCK);
		this.setCreativeTab(Tutor.CREATIVE_TAB);
		
	}

	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		// What item must be dropped if block is harvested
		return this == ModBlocks.lead_Ore ? ModItems.lead_chunk : Item.getItemFromBlock(this);
	}
	
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random rand)
	{
		// If harvested block drops an item different to the itemFromBlock() apply fortune to the dropped item.
		// Example Coal block drops coal items instead of coal block items
		if(fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next() , rand, fortune))
		{
			int i = rand.nextInt(fortune + 2) - 1;
			
			if(i < 0)
			{
				i = 0;
			}
			
			return this.quantityDropped(rand) * ( i + 1 );
		}
		else
		{
			return this.quantityDropped(rand);
		}
	}
	
	
	
	@Override
	public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
	{
		super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
	} 
	
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(this);
	}
	
	
	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) 
	{
		Random rand = world instanceof World ? ((World)world).rand : new Random();
        
		// If harvested item differs from block item calculate  xp orbs to drop
		if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {
            int i = 0;

            if (this == ModBlocks.lead_Ore)
            {
                i = MathHelper.getRandomIntegerInRange(rand, 0, 2);
            }
            return i;
        }
        return 0;
	}
}
