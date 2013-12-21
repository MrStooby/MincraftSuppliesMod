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

public class SlabClothBright extends BlockStep {

	public static final String[] StepTypesBright = new String[] {"Lime", "Magenta", "Orange", "Pink", "Red", "LGray", "White", "Yellow"};
	
	
	public SlabClothBright(int id, boolean isdouble)
	{
		super(id, isdouble);
		if(!this.isDoubleSlab)
		{
			this.setLightOpacity(0);
		}
		
		this.setCreativeTab(CreativeTabs.tabBlock)
        .setHardness(2.0F)
        .setResistance(10.0F)
        .setStepSound(Block.soundClothFootstep)
        .setUnlocalizedName("SlabClothBright");
	}
	
	@SideOnly(Side.CLIENT)
	private static boolean isBlockSingleSlab(int id)
	{
		return id == MincraftSuppliesMod.singleSlabClothBright.blockID;
	}
	
	@SideOnly(Side.CLIENT)
	public int idPicked(World world, int x, int y, int z)
	{
		return MincraftSuppliesMod.singleSlabClothBright.blockID;
	}
	
	
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return MincraftSuppliesMod.singleSlabClothBright.blockID;
	}
	
	protected ItemStack createStackedBlock(int metadata)
	{
		return new ItemStack(MincraftSuppliesMod.singleSlabClothBright.blockID, 2, metadata & 7);
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
		if(id != MincraftSuppliesMod.doubleSlabClothBright.blockID)
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
		
		return k == 0 ? Block.cloth.getIcon(side, 5) : // Lime
			   k == 1 ? Block.cloth.getIcon(side, 2) : // Maganta
			   k == 2 ? Block.cloth.getIcon(side, 1) : // Orange
			   k == 3 ? Block.cloth.getIcon(side, 6) : // Pink
				   k == 4 ? Block.cloth.getIcon(side, 14) : // Rouge
					   k == 5 ? Block.cloth.getIcon(side, 8 ) : // Gray
						   k == 6 ? Block.cloth.getIcon(side, 0) : // Blanc
							   k == 7 ? Block.cloth.getIcon(side, 4) : // Jaune
				   Block.cloth.getIcon(side, 0); 
	}
}
