package mincraftSuppliesMod.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class StoneBrickWall extends BlockWall {

	public StoneBrickWall(int par1, Block par2Block) {
		super(par1, par2Block);		
	}
	
	
	@SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int side, int metadata)
    {
		int k = metadata & 3;
		
		return k == 2 ? Block.stoneBrick.getIcon(0, 2) : 
			   k == 1 ? Block.stoneBrick.getIcon(0, 1) :
				   Block.stoneBrick.getIcon(0, 0);		
    }
	
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
    }
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
		Block.stoneBrick.registerIcons(par1IconRegister);
    }

}
