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

public class SlabClayDark extends BlockStep {

	public static final String[] StepTypesDark = new String[] {"Black", "Blue", "Brown", "Cyan", "Green", "LBlue", "Gray", "Purple"};
	
	
	public SlabClayDark(int id, boolean isdouble)
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
        .setUnlocalizedName("SlabClayDark");
	}
	
	@SideOnly(Side.CLIENT)
	private static boolean isBlockSingleSlab(int id)
	{
		return id == MincraftSuppliesMod.singleSlabClayDark.blockID;
	}
	/*
	public int quantityDropped(Random par1Random)
    {
		if(this.isDoubleSlab)
		{
			return 2;
		}
		
		return 1;
    }*/
	
	@SideOnly(Side.CLIENT)
	public int idPicked(World world, int x, int y, int z)
	{
		return MincraftSuppliesMod.singleSlabClayDark.blockID;
	}
	
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return MincraftSuppliesMod.singleSlabClayDark.blockID;
	}
	
	protected ItemStack createStackedBlock(int metadata)
	{
		return new ItemStack(MincraftSuppliesMod.singleSlabClayDark.blockID, 2, metadata & 7);
	}
	
	public String getFullSlabName(int metadata)
	{
		if(metadata < 0 || metadata >= StepTypesDark.length)
		{
			metadata = 0;
		}
	
		return super.getUnlocalizedName() + "." + StepTypesDark[metadata];
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int id, CreativeTabs creativeTabs, List list)
	{
		if(id != MincraftSuppliesMod.doubleSlabClayDark.blockID)
			{
			for(int i = 0; i < StepTypesDark.length; i++)
			{
				list.add(new ItemStack(id, 1, i));
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		int k = metadata & 7;
		
		return k == 0 ? Block.stainedClay.getIcon(side, 15) : // Noir
			   k == 1 ? Block.stainedClay.getIcon(side, 11) : // Bleu 
			   k == 2 ? Block.stainedClay.getIcon(side, 12) : // Marron
			   k == 3 ? Block.stainedClay.getIcon(side, 9) : // Cyan
				   k == 4 ? Block.stainedClay.getIcon(side, 13) : // Green
					   k == 5 ? Block.stainedClay.getIcon(side, 3) : // LBlue
						   k == 6 ? Block.stainedClay.getIcon(side, 7) : // Gris
							   k == 7 ? Block.stainedClay.getIcon(side, 10) : // Violet
				   Block.stainedClay.getIcon(side, 0); //
	}
}
