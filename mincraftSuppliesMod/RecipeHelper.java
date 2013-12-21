package mincraftSuppliesMod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class RecipeHelper {
	
	public static void addRecipeStairsColored(Block Block, Block useMaterial, int metadata)
	{		
		GameRegistry.addRecipe(new ItemStack(Block, 4, 0), new Object[]{"X  ", "XX ", "XXX", 'X', new ItemStack(useMaterial, 1, metadata)});
	}
	
	public static void addRecipeStairs(Block Block, Block useMaterial)
	{		
		GameRegistry.addRecipe(new ItemStack(Block, 4, 0), new Object[]{"X  ", "XX ", "XXX", 'X', useMaterial});
	}
	
	public static void addRecipeSlabColored(Block Block, Block useMaterial, int metadata)
	{		
		GameRegistry.addRecipe(new ItemStack(Block, 4, 0), new Object[]{"XXX", 'X', new ItemStack(useMaterial, 1, metadata)});
	}
	
	public static void addRecipeWall(Block Block, Block useMaterial, int metadata)
	{		
		GameRegistry.addRecipe(new ItemStack(Block, 2, metadata), new Object[]{"XXX", "XXX", 'X', new ItemStack(useMaterial, 1, metadata)});
	}
	
	public static void addRecipeSlab(Block Block, Block useMaterial, int metadataMinecraft, int metadataColor)
	{		
		GameRegistry.addRecipe(new ItemStack(Block, 6, metadataColor), new Object[]{"XXX", 'X', new ItemStack(useMaterial, 1, metadataMinecraft)});
	}
	
}
