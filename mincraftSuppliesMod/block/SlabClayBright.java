package mincraftSuppliesMod.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mincraftSuppliesMod.MincraftSuppliesMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStep;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class SlabClayBright extends BlockStep {

	public static final String[] StepTypesBright = new String[] {"Lime", "Magenta", "Orange", "Pink", "Red", "LGray", "White", "Yellow"};
	
	
	public SlabClayBright(int id, boolean isdouble)
	{
		super(id, isdouble);
		if(!this.isDoubleSlab)
		{
			this.setLightOpacity(0);
		}
		
		this.setCreativeTab(CreativeTabs.tabBlock)
        .setHardness(1.25F)
        .setResistance(7.0F)
        .setStepSound(Block.soundStoneFootstep)
        .setUnlocalizedName("SlabClayBright");
	}
	
	@SideOnly(Side.CLIENT)
	private static boolean isBlockSingleSlab(int id)
	{
		return id == MincraftSuppliesMod.singleSlabClayBright.blockID;
	}
	
	@SideOnly(Side.CLIENT)
	public int idPicked(World world, int x, int y, int z)
	{
		return MincraftSuppliesMod.singleSlabClayBright.blockID;
	}
	
	
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return MincraftSuppliesMod.singleSlabClayBright.blockID;
	}
	
	protected ItemStack createStackedBlock(int metadata)
	{
		return new ItemStack(MincraftSuppliesMod.singleSlabClayBright.blockID, 2, metadata & 7);
	}
	
	public String getFullSlabName(int metadata)
	{
		if(metadata < 0 || metadata >= StepTypesBright.length)
		{
			metadata = 0;
		}
	
		return super.getUnlocalizedName() + "." + StepTypesBright[metadata];
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int id, CreativeTabs creativeTabs, List list)
	{
		if(id != MincraftSuppliesMod.doubleSlabClayBright.blockID)
			{
			for(int i = 0; i < StepTypesBright.length; i++)
			{
				list.add(new ItemStack(id, 1, i));
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		int k = metadata & 7;
		
		return k == 0 ? Block.stainedClay.getIcon(side, 5) : // Lime
			   k == 1 ? Block.stainedClay.getIcon(side, 2) : // Maganta
			   k == 2 ? Block.stainedClay.getIcon(side, 1) : // Orange
			   k == 3 ? Block.stainedClay.getIcon(side, 6) : // Pink
				   k == 4 ? Block.stainedClay.getIcon(side, 14) : // Rouge
					   k == 5 ? Block.stainedClay.getIcon(side, 8 ) : // Gray
						   k == 6 ? Block.stainedClay.getIcon(side, 0) : // Blanc
							   k == 7 ? Block.stainedClay.getIcon(side, 4) : // Jaune
				   Block.stainedClay.getIcon(side, 0); 
	}
}
