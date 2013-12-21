package mincraftSuppliesMod.block.itemBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockStoneBrickWall extends ItemBlock {
	
	public ItemBlockStoneBrickWall(int id)
	{
		super(id);
		this.setHasSubtypes(true);
	}
	
	public int getMetadata(int metadata)
	{
		return metadata;
	}
	
	public String getUnlocalizedName(ItemStack stack)
	{
		int metadata = stack.getItemDamage();
		if(metadata > BlockStoneBrick.STONE_BRICK_TYPES.length || metadata < 0)
		{
			metadata = 0;
		}
		return super.getUnlocalizedName() + "." + BlockStoneBrick.STONE_BRICK_TYPES[metadata];
	}
}
