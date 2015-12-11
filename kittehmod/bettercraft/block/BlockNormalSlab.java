package kittehmod.bettercraft.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kittehmod.bettercraft.BetterCraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockNormalSlab extends BlockSlab 
{
	public static String[] blockStepTypes = new String[] {"enderSlab", "netherwoodSlab"};

	@SideOnly(Side.CLIENT)
	private IIcon sideIcon[];
	
	public BlockNormalSlab(boolean DoubleSlab, Material par3Material) {
		super(DoubleSlab, par3Material);
		if (!DoubleSlab) this.setCreativeTab(CreativeTabs.tabBlock);
		this.setLightOpacity(0);
	}
	
	public String getFullSlabName(int meta) {
		if (meta < 0 || meta >= blockStepTypes.length) {
			meta = 0;
		}
		return getUnlocalizedName(); // + "." + blockStepTypes[meta];
	}
	
	/*@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		sideIcon = new IIcon[2];
		switch(this.getUnlocalizedName()) {
			case "slabNetherwood":
				blockIcon = par1IconRegister.registerIcon("bettercraft:NetherPlanks");
				sideIcon[0] = par1IconRegister.registerIcon("bettercraft:NetherPlanks");
			case "slabEnderBrick":
				blockIcon = par1IconRegister.registerIcon("bettercraft:EndBrickBlock");
				sideIcon[0] = par1IconRegister.registerIcon("bettercraft:EndBrickBlock");
			default: //Fall back to missing texture if no textures are found.
				blockIcon = par1IconRegister.registerIcon("minecraft:missing_texture");
				sideIcon[0] = par1IconRegister.registerIcon("minecraft:missing_texture");
		}
	}*/
	
	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
    	if (this == BetterCraft.EndBrickSlab || this == BetterCraft.EndBrickSlabFull) {
    		return BetterCraft.EndBrickBlock.getIcon(side, metadata);
    	}
    	else if (this == BetterCraft.NetherWoodSlab || this == BetterCraft.NetherWoodSlabFull) {
    		return BetterCraft.NetherPlanks.getIcon(side, metadata);
    	}
    	return Blocks.wooden_slab.getIcon(side, metadata); //Fallback
    }
    
	//Determine if single or not.
	@SideOnly(Side.CLIENT)
	private static boolean isBlockSingleSlab(Block par0) {
		return par0 == kittehmod.bettercraft.BetterCraft.EndBrickSlab || par0 == kittehmod.bettercraft.BetterCraft.NetherWoodSlab;
	}
	
	//For pick block button
    public Item getItem(World par1World, int par2, int par3, int par4) {
    	if (this == BetterCraft.EndBrickSlab || this == BetterCraft.EndBrickSlabFull) {
    		return Item.getItemFromBlock(BetterCraft.EndBrickSlab);
    	}
    	else if (this == BetterCraft.NetherWoodSlab || this == BetterCraft.NetherWoodSlabFull) {
    		return Item.getItemFromBlock(BetterCraft.NetherWoodSlab);
    	}
    	return Item.getItemFromBlock(Blocks.wooden_slab); //Fallback
    }
    
	// Tells game what slab sub-type drops on destruction
	public Item getItemDropped(int par1, Random par2Random, int par3) 
	{
    	if (this == BetterCraft.EndBrickSlab || this == BetterCraft.EndBrickSlabFull) {
    		return Item.getItemFromBlock(BetterCraft.EndBrickSlab);
    	}
    	else if (this == BetterCraft.NetherWoodSlab || this == BetterCraft.NetherWoodSlabFull) {
    		return Item.getItemFromBlock(BetterCraft.NetherWoodSlab);
    	}
    	return Item.getItemFromBlock(Blocks.wooden_slab); //Fallback
	}
	
	@Override
	public boolean isFlammable(IBlockAccess blockAccess, int x, int y, int z, ForgeDirection direction) {
		return false;
	}
	
	@Override
	public boolean canEntityDestroy(IBlockAccess blockAccess, int x, int y, int z, Entity entity) {
	    if (entity instanceof EntityDragon) {
		    return this != BetterCraft.EndBrickSlab && this != BetterCraft.EndBrickSlabFull;
	    }
	    return true;
	}
}
