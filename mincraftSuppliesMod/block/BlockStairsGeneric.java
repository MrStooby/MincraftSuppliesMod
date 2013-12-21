package mincraftSuppliesMod.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockStairs;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;


public class BlockStairsGeneric extends BlockStairs {
	
	public BlockStairsGeneric(int id, Block par1Block, int metadata) {
		super(id, par1Block, metadata);	
		
		this.setLightOpacity(1);
	}
	
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return this.blockID;
	}
}

