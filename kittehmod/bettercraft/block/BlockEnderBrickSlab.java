package kittehmod.bettercraft.block;

import java.util.List;
import java.util.Random;

import kittehmod.bettercraft.BetterCraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEnderBrickSlab extends BlockSlab 
{

	public static String[] blockStepTypes = new String[] { "enderSlab" };

	@SideOnly(Side.CLIENT)
	private IIcon sideIcon[];

	public BlockEnderBrickSlab(boolean DoubleSlab, Material par3Material) 
	{
		super(DoubleSlab, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setLightOpacity(0);
	}


	// A bit for getting the full slab name, depending on sub-type
	public String getFullSlabName(int meta) {
		if (meta < 0 || meta >= blockStepTypes.length) {
			meta = 0;
		}

		return getUnlocalizedName() + "." + blockStepTypes[meta];
	}

	// Registering the textures for the slab.
	// This has support for side and multiple sub-type textures!
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		sideIcon = new IIcon[2];
		blockIcon = par1IconRegister.registerIcon("bettercraft:NetherPlanks");
		sideIcon[0] = par1IconRegister.registerIcon("bettercraft:NetherPlanks");
	}
	
	/**
	 * From the specified side and block metadata retrieves the blocks texture.
	 * Args: side, metadata
	 */
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return BetterCraft.EndBrickBlock.getIcon(p_149691_1_, p_149691_2_ & 7);
    }

	/**
	 * Takes a block ID, returns true if it's the same as the ID for a stone or
	 * wooden single slab.
	 */
	@SideOnly(Side.CLIENT)
	private static boolean isBlockSingleSlab(Block par0) {
		return par0 == kittehmod.bettercraft.BetterCraft.EndBrickSlab;
	}

    public Item getItem(World par1World, int par2, int par3, int par4)
    {
    	return this == BetterCraft.EndBrickSlab ? Item.getItemFromBlock(BetterCraft.EndBrickSlab) : Item.getItemFromBlock(BetterCraft.EndBrickSlab);
    }

	// Tells game what slab sub-type drops on destruction
	public Item getItemDropped(int par1, Random par2Random, int par3) 
	{
		return Item.getItemFromBlock(kittehmod.bettercraft.BetterCraft.EndBrickSlab);
	}

	// Gets the sub-block type
	@SuppressWarnings("unchecked")
	public void getSubBlocks(Block id, CreativeTabs par2CreativeTabs, List par3List) 
	{
		if (id != kittehmod.bettercraft.BetterCraft.EndBrickSlabFull) 
		{
			for (int i = 0; i < blockStepTypes.length; i++) 
			{
				par3List.add(new ItemStack(id, 1, i));
			}
		}
	}
	
	public String func_150002_b(int p_150002_1_)
    {
        if (p_150002_1_ < 0 || p_150002_1_ >= blockStepTypes.length)
        {
            p_150002_1_ = 0;
        }

        return super.getUnlocalizedName(); // + "." + blockStepTypes[p_150002_1_];
    }
}