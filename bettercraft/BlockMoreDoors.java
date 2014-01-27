package kittehmod.bettercraft;

import java.util.Random;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMoreDoors extends BlockDoor 
{
	public Item placerItem;
	public Icon topDoorIcon;
	public Icon[] flippedIcons = new Icon[2];

	public BlockMoreDoors(int par1, Material par2Material) 
	{
		super(par1, par2Material);
		float f = 0.5F;
		float f1 = 1.0F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
	}

	public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) 
	{
		if (par5 == 1 || par5 == 0) 
		{
			return this.blockIcon;
		}
		int meta = getFullMetadata(par1IBlockAccess, par2, par3, par4);
		boolean flag = (meta & 4) != 0;
		int halfMeta = meta & 3;
		boolean flipped = false;

		if (flag) 
		{
			if (halfMeta == 0 && par5 == 2)
				flipped = !flipped;
			else if (halfMeta == 1 && par5 == 5)
				flipped = !flipped;
			else if (halfMeta == 2 && par5 == 3)
				flipped = !flipped;
			else if (halfMeta == 3 && par5 == 4)
				flipped = !flipped;
		} else {
			if (halfMeta == 0 && par5 == 5)
				flipped = !flipped;
			else if (halfMeta == 1 && par5 == 3)
				flipped = !flipped;
			else if (halfMeta == 2 && par5 == 4)
				flipped = !flipped;
			else if (halfMeta == 3 && par5 == 2)
				flipped = !flipped;
			if ((meta & 16) != 0)
				flipped = !flipped;
		}

		if (flipped)
			return flippedIcons[(meta & 8) != 0 ? 1 : 0];
		else
			return (meta & 8) != 0 ? this.topDoorIcon : this.blockIcon;
	}

	public Icon getIcon(int par1, int par2) 
	{
		return this.blockIcon;
	}

	@Override
	public void registerIcons(IconRegister iconRegister) 
	{
		this.blockIcon = iconRegister.registerIcon("bettercraft:"
				+ this.getUnlocalizedName().substring(5) + "_lower");
		this.topDoorIcon = iconRegister.registerIcon("bettercraft:"
				+ this.getUnlocalizedName().substring(5) + "_upper");
		this.flippedIcons[0] = new IconFlipped(blockIcon, true, false);
		this.flippedIcons[1] = new IconFlipped(topDoorIcon, true, false);
	}

    public int idPicked(World par1World, int par2, int par3, int par4)
    {
		switch(this.blockID)
		{
		case 178 : return (BetterCraft.NetherBrickDoor.itemID);
		case 179 : return (BetterCraft.GlassDoor.itemID);
		case 180 : return (BetterCraft.NetherwoodDoor.itemID);
		default : return Item.doorWood.itemID;
		}
    }

	public int idDropped(int par1, Random par2Random, int par3) 
	{
        return (par1 & 8) != 0 ? 0 : (this.blockID == 178 ? BetterCraft.NetherBrickDoor.itemID : this.blockID == 179 ? BetterCraft.GlassDoor.itemID : this.blockID == 180 ? BetterCraft.NetherwoodDoor.itemID : null);

	/*	switch(this.blockID)
		{
		case 178 : return (BetterCraft.NetherBrickDoor.itemID);
		case 179 : return (BetterCraft.GlassDoor.itemID);
		case 180 : return (BetterCraft.NetherwoodDoor.itemID);
		default : return Item.doorWood.itemID;
		}*/
	}

    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (this.blockMaterial == Material.iron)
        {
            return false; //Allow items to interact with the door
        }
        else
        {
            int i1 = this.getFullMetadata(par1World, par2, par3, par4);
            int j1 = i1 & 7;
            j1 ^= 4;

            if ((i1 & 8) == 0)
            {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, j1, 2);
                par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
            }
            else
            {
                par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, j1, 2);
                par1World.markBlockRangeForRenderUpdate(par2, par3 - 1, par4, par2, par3, par4);
            }

            par1World.playAuxSFXAtEntity(par5EntityPlayer, 1003, par2, par3, par4, 0);
            return true;
        }
    }
}