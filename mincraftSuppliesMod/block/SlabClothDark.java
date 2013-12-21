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

public class SlabClothDark extends BlockStep {

	public static final String[] StepTypesDark = new String[] {"Black", "Blue", "Brown", "Cyan", "Green", "LBlue", "Gray", "Purple"};
	
	
	public SlabClothDark(int id, boolean isdouble)
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
        .setUnlocalizedName("SlabClothDark");
	}
	
	@SideOnly(Side.CLIENT)
	private static boolean isBlockSingleSlab(int id)
	{
		return id == MincraftSuppliesMod.singleSlabClothDark.blockID;
	}
	
	
	@SideOnly(Side.CLIENT)
	public int idPicked(World world, int x, int y, int z)
	{
		return MincraftSuppliesMod.singleSlabClothDark.blockID;
	}
	
	public int idDropped(int metadata, Random rand, int fortune)
	{
		return MincraftSuppliesMod.singleSlabClothDark.blockID;
	}
	
	protected ItemStack createStackedBlock(int metadata)
	{
		return new ItemStack(MincraftSuppliesMod.singleSlabClothDark.blockID, 2, metadata & 7);
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
		if(id != MincraftSuppliesMod.doubleSlabClothDark.blockID)
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
		
		return k == 0 ? Block.cloth.getIcon(side, 15) : // Noir
			   k == 1 ? Block.cloth.getIcon(side, 11) : // Bleu 
			   k == 2 ? Block.cloth.getIcon(side, 12) : // Marron
			   k == 3 ? Block.cloth.getIcon(side, 9) : // Cyan
				   k == 4 ? Block.cloth.getIcon(side, 13) : // Green
					   k == 5 ? Block.cloth.getIcon(side, 3) : // LBlue
						   k == 6 ? Block.cloth.getIcon(side, 7) : // Gris
							   k == 7 ? Block.cloth.getIcon(side, 10) : // Violet
				   Block.cloth.getIcon(side, 0); //
	}
}
