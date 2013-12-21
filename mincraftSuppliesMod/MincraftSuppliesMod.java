package mincraftSuppliesMod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import mincraftSuppliesMod.proxy.CommonProxy;
import mincraftSuppliesMod.RecipeHelper;
import mincraftSuppliesMod.block.BlockStairsGeneric;
import mincraftSuppliesMod.block.SlabClayBright;
import mincraftSuppliesMod.block.SlabClayDark;
import mincraftSuppliesMod.block.SlabClothBright;
import mincraftSuppliesMod.block.SlabClothDark;
import mincraftSuppliesMod.block.StoneBrickWall;
import mincraftSuppliesMod.block.itemBlock.ItemBlockSlabClayBright;
import mincraftSuppliesMod.block.itemBlock.ItemBlockSlabClayDark;
import mincraftSuppliesMod.block.itemBlock.ItemBlockSlabClothBright;
import mincraftSuppliesMod.block.itemBlock.ItemBlockSlabClothDark;
import mincraftSuppliesMod.block.itemBlock.ItemBlockStoneBrickWall;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = "mincraftSuppliesMod",
name = "Supplies Pack",
version = "1.0",
acceptedMinecraftVersions = "1.6.4")
@NetworkMod(clientSideRequired = true, 
			serverSideRequired = false)
public class MincraftSuppliesMod {
	
	@Instance("mincraftSuppliesMod")
	public static MincraftSuppliesMod instance;
	
	@SidedProxy(clientSide = "mincraftSuppliesMod.proxy.ClientProxy", 
				serverSide = "mincraftSuppliesMod.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	
	// Slab & DoubleSlab
		public static Block doubleSlabClothBright, singleSlabClothBright;
		public static Block doubleSlabClothDark, singleSlabClothDark;
		public static Block doubleSlabClayBright, singleSlabClayBright;
		public static Block doubleSlabClayDark, singleSlabClayDark;
		
	// Stairs
		public static Block stairsClothWhite, stairsClothOrange, stairsClothMagenta, stairsClothLBlue, stairsClothYellow, stairsClothLime, stairsClothPink, stairsClothGray, stairsClothLGray, stairsClothCyan, stairsClothPurple, stairsClothBlue, stairsClothBrown, stairsClothGreen, stairsClothRed, stairsClothBlack;
		public static Block stairsClayWhite, stairsClayOrange, stairsClayMagenta, stairsClayLBlue, stairsClayYellow, stairsClayLime, stairsClayPink, stairsClayGray, stairsClayLGray, stairsClayCyan, stairsClayPurple, stairsClayBlue, stairsClayBrown, stairsClayGreen, stairsClayRed, stairsClayBlack;
		public static Block stairsWoodOak, stairsWoodSpruce;
		public static Block stairsGold, stairsIron;
				
	// Wall
		public static Block stoneBrickWall;
		
	// Declaration des IDs
		public static int singleSlabClothBrightID, doubleSlabClothBrightID, singleSlabClothDarkID, doubleSlabClothDarkID;
		public static int singleSlabClayBrightID, doubleSlabClayBrightID, singleSlabClayDarkID, doubleSlabClayDarkID;
		public static int stairsWoodOakID, stairsWoodSpruceID, stairsGoldID, stairsIronID;
		public static int stairsClothID, stairsClayID;
		public static int stoneBrickWallID;
		
		@EventHandler
		public void PreInit(FMLPreInitializationEvent event)
		{
			//Configuration
			Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
			try
			{
				cfg.load();				
				
				singleSlabClothBrightID = cfg.getBlock("SingleSlab_Cloth_Bright", 2060).getInt();
				doubleSlabClothBrightID = cfg.getBlock("DoubleSlab_Cloth_Bright", 2061).getInt();
				singleSlabClothDarkID = cfg.getBlock("SingleSlab_Cloth_Dark", 2062).getInt();
				doubleSlabClothDarkID = cfg.getBlock("DoubleSlab_Cloth_Dark", 2063).getInt();
				singleSlabClayBrightID = cfg.getBlock("SingleSlab_Clay_Bright", 2064).getInt();
				doubleSlabClayBrightID = cfg.getBlock("DoubleSlab_Clay_Bright", 2065).getInt();
				singleSlabClayDarkID = cfg.getBlock("SingleSlab_Clay_Dark", 2066).getInt();
				doubleSlabClayDarkID = cfg.getBlock("DoubleSlab_Clay_Dark", 2067).getInt();
								
				stairsWoodOakID = cfg.getBlock("Stair_Wood_Oak", 2300).getInt();
				stairsWoodSpruceID = cfg.getBlock("Stair_Wood_Spruce", 2301).getInt();
				stairsIronID = cfg.getBlock("Stair_Iron", 2310).getInt();
				stairsGoldID = cfg.getBlock("Stair_Gold", 2311).getInt();				
				stairsClothID = cfg.getBlock("Stair_Cloth", 2400).getInt();
				stairsClayID = cfg.getBlock("Stair_Clay", 2420).getInt();
				
				stoneBrickWallID = cfg.getBlock("stonebrick_wall", 2130).getInt();
								
			}
			catch(Exception ex)
			{
				event.getModLog().severe("Failed to load configuration");
			}		
			finally
			{
				if(cfg.hasChanged())
				{
					cfg.save();
				}
			}
			
						
			
			//Blocks			 
			 singleSlabClothBright = new SlabClothBright(singleSlabClothBrightID, false);
			 doubleSlabClothBright = new SlabClothBright(doubleSlabClothBrightID, true);
			 singleSlabClothDark = new SlabClothDark(singleSlabClothDarkID, false);
			 doubleSlabClothDark = new SlabClothDark(doubleSlabClothDarkID, true);
			 singleSlabClayBright = new SlabClayBright(singleSlabClayBrightID, false);
			 doubleSlabClayBright = new SlabClayBright(doubleSlabClayBrightID, true);
			 singleSlabClayDark = new SlabClayDark(singleSlabClayDarkID, false);
			 doubleSlabClayDark = new SlabClayDark(doubleSlabClayDarkID, true);
			 
			 
			 stairsWoodOak = new BlockStairsGeneric(stairsWoodOakID, Block.wood, 0).setUnlocalizedName("stairsWoodOak");
			 stairsWoodSpruce = new BlockStairsGeneric(stairsWoodSpruceID, Block.wood, 1).setUnlocalizedName("stairsWoodSpruce");			 
			 stairsGold 	= new BlockStairsGeneric(stairsGoldID, Block.blockGold, 0).setUnlocalizedName("stairsGold");
			 stairsIron 	= new BlockStairsGeneric(stairsIronID, Block.blockIron, 0).setUnlocalizedName("stairsIron");		 
			 
			 stairsClothWhite 	= new BlockStairsGeneric(stairsClothID, Block.cloth, 0).setUnlocalizedName("stairsClothWhite");
			 stairsClothOrange 	= new BlockStairsGeneric(stairsClothID + 1, Block.cloth, 1).setUnlocalizedName("stairsClothOrange");
			 stairsClothMagenta = new BlockStairsGeneric(stairsClothID + 2, Block.cloth, 2).setUnlocalizedName("stairsClothMagenta");
			 stairsClothLBlue 	= new BlockStairsGeneric(stairsClothID + 3, Block.cloth, 3).setUnlocalizedName("stairsClothLBlue");
			 stairsClothYellow 	= new BlockStairsGeneric(stairsClothID + 4, Block.cloth, 4).setUnlocalizedName("stairsClothYellow");
			 stairsClothLime 	= new BlockStairsGeneric(stairsClothID + 5 , Block.cloth,  5).setUnlocalizedName("stairsClothLime");
			 stairsClothPink 	= new BlockStairsGeneric(stairsClothID + 6 , Block.cloth,  6).setUnlocalizedName("stairsClothPink");
			 stairsClothGray 	= new BlockStairsGeneric(stairsClothID + 7 , Block.cloth,  7).setUnlocalizedName("stairsClothGray");
			 stairsClothLGray 	= new BlockStairsGeneric(stairsClothID + 8 , Block.cloth,  8).setUnlocalizedName("stairsClothLGray");
			 stairsClothCyan 	= new BlockStairsGeneric(stairsClothID + 9 , Block.cloth,  9).setUnlocalizedName("stairsClothCyan");
			 stairsClothPurple 	= new BlockStairsGeneric(stairsClothID + 10, Block.cloth, 10).setUnlocalizedName("stairsClothPurple");
			 stairsClothBlue 	= new BlockStairsGeneric(stairsClothID + 11, Block.cloth, 11).setUnlocalizedName("stairsClothBlue");
			 stairsClothBrown 	= new BlockStairsGeneric(stairsClothID + 12, Block.cloth, 12).setUnlocalizedName("stairsClothBrown");
			 stairsClothGreen 	= new BlockStairsGeneric(stairsClothID + 13, Block.cloth, 13).setUnlocalizedName("stairsClothGreen");
			 stairsClothRed 	= new BlockStairsGeneric(stairsClothID + 14, Block.cloth, 14).setUnlocalizedName("stairsClothRed");
			 stairsClothBlack 	= new BlockStairsGeneric(stairsClothID + 15, Block.cloth, 15).setUnlocalizedName("stairsClothBlack");
			 
			 stairsClayWhite 	= new BlockStairsGeneric(stairsClayID, Block.stainedClay, 0).setUnlocalizedName("stairsClayWhite");
			 stairsClayOrange 	= new BlockStairsGeneric(stairsClayID + 1, Block.stainedClay, 1).setUnlocalizedName("stairsClayOrange");
			 stairsClayMagenta  = new BlockStairsGeneric(stairsClayID + 2, Block.stainedClay, 2).setUnlocalizedName("stairsClayMagenta");
			 stairsClayLBlue 	= new BlockStairsGeneric(stairsClayID + 3, Block.stainedClay, 3).setUnlocalizedName("stairsClayLBlue");
			 stairsClayYellow 	= new BlockStairsGeneric(stairsClayID + 4, Block.stainedClay, 4).setUnlocalizedName("stairsClayYellow");
			 stairsClayLime 	= new BlockStairsGeneric(stairsClayID + 5 , Block.stainedClay,  5).setUnlocalizedName("stairsClayLime");
			 stairsClayPink 	= new BlockStairsGeneric(stairsClayID + 6 , Block.stainedClay,  6).setUnlocalizedName("stairsClayPink");
			 stairsClayGray 	= new BlockStairsGeneric(stairsClayID + 7 , Block.stainedClay,  7).setUnlocalizedName("stairsClayGray");
			 stairsClayLGray 	= new BlockStairsGeneric(stairsClayID + 8 , Block.stainedClay,  8).setUnlocalizedName("stairsClayLGray");
			 stairsClayCyan 	= new BlockStairsGeneric(stairsClayID + 9 , Block.stainedClay,  9).setUnlocalizedName("stairsClayCyan");
			 stairsClayPurple 	= new BlockStairsGeneric(stairsClayID + 10, Block.stainedClay, 10).setUnlocalizedName("stairsClayPurple");
			 stairsClayBlue 	= new BlockStairsGeneric(stairsClayID + 11, Block.stainedClay, 11).setUnlocalizedName("stairsClayBlue");
			 stairsClayBrown 	= new BlockStairsGeneric(stairsClayID + 12, Block.stainedClay, 12).setUnlocalizedName("stairsClayBrown");
			 stairsClayGreen 	= new BlockStairsGeneric(stairsClayID + 13, Block.stainedClay, 13).setUnlocalizedName("stairsClayGreen");
			 stairsClayRed 		= new BlockStairsGeneric(stairsClayID + 14, Block.stainedClay, 14).setUnlocalizedName("stairsClayRed");
			 stairsClayBlack 	= new BlockStairsGeneric(stairsClayID + 15, Block.stainedClay, 15).setUnlocalizedName("stairsClayBlack");
			 
			
			 stoneBrickWall = new StoneBrickWall(stoneBrickWallID, Block.stoneBrick).setUnlocalizedName("stoneBrickWall");

		}

		@EventHandler
		public void Init(FMLInitializationEvent event)
		{
			//Registry			
			GameRegistry.registerBlock(singleSlabClothBright, ItemBlockSlabClothBright.class, "singleSlabClothBright");
			GameRegistry.registerBlock(doubleSlabClothBright, ItemBlockSlabClothBright.class, "doubleSlabClothBright");
			GameRegistry.registerBlock(singleSlabClothDark, ItemBlockSlabClothDark.class, "singleSlabClothDark");
			GameRegistry.registerBlock(doubleSlabClothDark, ItemBlockSlabClothDark.class, "doubleSlabClothDark");
			GameRegistry.registerBlock(singleSlabClayBright, ItemBlockSlabClayBright.class, "singleSlabClayBright");
			GameRegistry.registerBlock(doubleSlabClayBright, ItemBlockSlabClayBright.class, "doubleSlabClayBright");
			GameRegistry.registerBlock(singleSlabClayDark, ItemBlockSlabClayDark.class, "singleSlabClayDark");
			GameRegistry.registerBlock(doubleSlabClayDark, ItemBlockSlabClayDark.class, "doubleSlabClayDark");
			
			GameRegistry.registerBlock(stairsClothWhite, "stairsClothWhite");
			GameRegistry.registerBlock(stairsClothOrange, "stairsClothOrange");
			GameRegistry.registerBlock(stairsClothMagenta, "stairsClothMagenta");
			GameRegistry.registerBlock(stairsClothLBlue, "stairsClothLBlue");
			GameRegistry.registerBlock(stairsClothYellow, "stairsClothYellow");
			GameRegistry.registerBlock(stairsClothLime, "stairsClothLime");
			GameRegistry.registerBlock(stairsClothPink, "stairsClothPink");
			GameRegistry.registerBlock(stairsClothGray, "stairsClothGray");
			GameRegistry.registerBlock(stairsClothLGray, "stairsClothLGray");
			GameRegistry.registerBlock(stairsClothCyan, "stairsClothCyan");
			GameRegistry.registerBlock(stairsClothPurple, "stairsClothPurple");
			GameRegistry.registerBlock(stairsClothBlue, "stairsClothBlue");
			GameRegistry.registerBlock(stairsClothBrown, "stairsClothBrown");
			GameRegistry.registerBlock(stairsClothGreen, "stairsClothGreen");
			GameRegistry.registerBlock(stairsClothRed, "stairsClothRed");
			GameRegistry.registerBlock(stairsClothBlack, "stairsClothBlack");
			
			GameRegistry.registerBlock(stairsClayWhite, "stairsClayWhite");
			GameRegistry.registerBlock(stairsClayOrange, "stairsClayOrange");
			GameRegistry.registerBlock(stairsClayMagenta, "stairsClayMagenta");
			GameRegistry.registerBlock(stairsClayLBlue, "stairsClayLBlue");
			GameRegistry.registerBlock(stairsClayYellow, "stairsClayYellow");
			GameRegistry.registerBlock(stairsClayLime, "stairsClayLime");
			GameRegistry.registerBlock(stairsClayPink, "stairsClayPink");
			GameRegistry.registerBlock(stairsClayGray, "stairsClayGray");
			GameRegistry.registerBlock(stairsClayLGray, "stairsClayLGray");
			GameRegistry.registerBlock(stairsClayCyan, "stairsClayCyan");
			GameRegistry.registerBlock(stairsClayPurple, "stairsClayPurple");
			GameRegistry.registerBlock(stairsClayBlue, "stairsClayBlue");
			GameRegistry.registerBlock(stairsClayBrown, "stairsClayBrown");
			GameRegistry.registerBlock(stairsClayGreen, "stairsClayGreen");
			GameRegistry.registerBlock(stairsClayRed, "stairsClayRed");
			GameRegistry.registerBlock(stairsClayBlack, "stairsClayBlack");
			
			GameRegistry.registerBlock(stairsWoodOak, "stairsWoodOak");
			GameRegistry.registerBlock(stairsWoodSpruce, "stairsWoodSpruce");
			GameRegistry.registerBlock(stairsGold, "stairsGold");
			GameRegistry.registerBlock(stairsIron, "stairsIron");
			
			GameRegistry.registerBlock(stoneBrickWall, ItemBlockStoneBrickWall.class, "stoneBrickWall");
						

			//Render
			proxy.registerRender();
			
			
			//Recipe		
			RecipeHelper.addRecipeStairsColored(stairsClayWhite, Block.stainedClay, 0);
			RecipeHelper.addRecipeStairsColored(stairsClayOrange, Block.stainedClay, 1);
			RecipeHelper.addRecipeStairsColored(stairsClayMagenta, Block.stainedClay, 2);
			RecipeHelper.addRecipeStairsColored(stairsClayLBlue, Block.stainedClay, 3);
			RecipeHelper.addRecipeStairsColored(stairsClayYellow, Block.stainedClay, 4);
			RecipeHelper.addRecipeStairsColored(stairsClayLime, Block.stainedClay, 5);
			RecipeHelper.addRecipeStairsColored(stairsClayPink, Block.stainedClay, 6);
			RecipeHelper.addRecipeStairsColored(stairsClayGray, Block.stainedClay, 7);
			RecipeHelper.addRecipeStairsColored(stairsClayLGray, Block.stainedClay, 8);
			RecipeHelper.addRecipeStairsColored(stairsClayCyan, Block.stainedClay, 9);
			RecipeHelper.addRecipeStairsColored(stairsClayPurple, Block.stainedClay, 10);
			RecipeHelper.addRecipeStairsColored(stairsClayBlue, Block.stainedClay, 11);
			RecipeHelper.addRecipeStairsColored(stairsClayBrown, Block.stainedClay, 12);
			RecipeHelper.addRecipeStairsColored(stairsClayGreen, Block.stainedClay, 13);
			RecipeHelper.addRecipeStairsColored(stairsClayRed, Block.stainedClay, 14);
			RecipeHelper.addRecipeStairsColored(stairsClayBlack, Block.stainedClay, 15);
			
			RecipeHelper.addRecipeStairsColored(stairsClothWhite, Block.cloth, 0);
			RecipeHelper.addRecipeStairsColored(stairsClothOrange, Block.cloth, 1);
			RecipeHelper.addRecipeStairsColored(stairsClothMagenta, Block.cloth, 2);
			RecipeHelper.addRecipeStairsColored(stairsClothLBlue, Block.cloth, 3);
			RecipeHelper.addRecipeStairsColored(stairsClothYellow, Block.cloth, 4);
			RecipeHelper.addRecipeStairsColored(stairsClothLime, Block.cloth, 5);
			RecipeHelper.addRecipeStairsColored(stairsClothPink, Block.cloth, 6);
			RecipeHelper.addRecipeStairsColored(stairsClothGray, Block.cloth, 7);
			RecipeHelper.addRecipeStairsColored(stairsClothLGray, Block.cloth, 8);
			RecipeHelper.addRecipeStairsColored(stairsClothCyan, Block.cloth, 9);
			RecipeHelper.addRecipeStairsColored(stairsClothPurple, Block.cloth, 10);
			RecipeHelper.addRecipeStairsColored(stairsClothBlue, Block.cloth, 11);
			RecipeHelper.addRecipeStairsColored(stairsClothBrown, Block.cloth, 12);
			RecipeHelper.addRecipeStairsColored(stairsClothGreen, Block.cloth, 13);
			RecipeHelper.addRecipeStairsColored(stairsClothRed, Block.cloth, 14);
			RecipeHelper.addRecipeStairsColored(stairsClothBlack, Block.cloth, 15);		

			RecipeHelper.addRecipeStairsColored(stairsWoodOak, Block.wood, 0);
			RecipeHelper.addRecipeStairsColored(stairsWoodSpruce, Block.wood, 1);			
			RecipeHelper.addRecipeStairs(stairsGold, Block.blockGold);
			RecipeHelper.addRecipeStairs(stairsIron, Block.blockIron);
						
			RecipeHelper.addRecipeWall(stoneBrickWall, Block.stoneBrick, 0);
			RecipeHelper.addRecipeWall(stoneBrickWall, Block.stoneBrick, 1);
			RecipeHelper.addRecipeWall(stoneBrickWall, Block.stoneBrick, 2);
			
			RecipeHelper.addRecipeSlab(singleSlabClothBright, Block.cloth, 0, 6);
			RecipeHelper.addRecipeSlab(singleSlabClothBright, Block.cloth, 1, 2);
			RecipeHelper.addRecipeSlab(singleSlabClothBright, Block.cloth, 2, 1);
			RecipeHelper.addRecipeSlab(singleSlabClothDark, Block.cloth, 3, 5);
			RecipeHelper.addRecipeSlab(singleSlabClothBright, Block.cloth, 4, 7);
			RecipeHelper.addRecipeSlab(singleSlabClothBright, Block.cloth, 5, 0);
			RecipeHelper.addRecipeSlab(singleSlabClothBright, Block.cloth, 6, 3);
			RecipeHelper.addRecipeSlab(singleSlabClothDark, Block.cloth, 7, 6);
			RecipeHelper.addRecipeSlab(singleSlabClothBright, Block.cloth, 8, 5);
			RecipeHelper.addRecipeSlab(singleSlabClothDark, Block.cloth, 9, 3);
			RecipeHelper.addRecipeSlab(singleSlabClothDark, Block.cloth, 10, 7);
			RecipeHelper.addRecipeSlab(singleSlabClothDark, Block.cloth, 11, 1);
			RecipeHelper.addRecipeSlab(singleSlabClothDark, Block.cloth, 12, 2);
			RecipeHelper.addRecipeSlab(singleSlabClothDark, Block.cloth, 13, 4);
			RecipeHelper.addRecipeSlab(singleSlabClothBright, Block.cloth, 14, 4);
			RecipeHelper.addRecipeSlab(singleSlabClothDark, Block.cloth, 15, 0);
			
			RecipeHelper.addRecipeSlab(singleSlabClayBright, Block.stainedClay, 0, 6);
			RecipeHelper.addRecipeSlab(singleSlabClayBright, Block.stainedClay, 1, 2);
			RecipeHelper.addRecipeSlab(singleSlabClayBright, Block.stainedClay, 2, 1);
			RecipeHelper.addRecipeSlab(singleSlabClayDark, Block.stainedClay, 3, 5);
			RecipeHelper.addRecipeSlab(singleSlabClayBright, Block.stainedClay, 4, 7);
			RecipeHelper.addRecipeSlab(singleSlabClayBright, Block.stainedClay, 5, 0);
			RecipeHelper.addRecipeSlab(singleSlabClayBright, Block.stainedClay, 6, 3);
			RecipeHelper.addRecipeSlab(singleSlabClayDark, Block.stainedClay, 7, 6);
			RecipeHelper.addRecipeSlab(singleSlabClayBright, Block.stainedClay, 8, 5);
			RecipeHelper.addRecipeSlab(singleSlabClayDark, Block.stainedClay, 9, 3);
			RecipeHelper.addRecipeSlab(singleSlabClayDark, Block.stainedClay, 10, 7);
			RecipeHelper.addRecipeSlab(singleSlabClayDark, Block.stainedClay, 11, 1);
			RecipeHelper.addRecipeSlab(singleSlabClayDark, Block.stainedClay, 12, 2);
			RecipeHelper.addRecipeSlab(singleSlabClayDark, Block.stainedClay, 13, 4);
			RecipeHelper.addRecipeSlab(singleSlabClayBright, Block.stainedClay, 14, 4);
			RecipeHelper.addRecipeSlab(singleSlabClayDark, Block.stainedClay, 15, 0);
			
		}

		@EventHandler
		public void PostInit(FMLPostInitializationEvent event)
		{
			
		}
	}
