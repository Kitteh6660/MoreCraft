package kittehmod.bettercraft.block;

import java.util.Random;

import kittehmod.bettercraft.BetterCraft;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMoreDoors extends BlockDoor 
{
    private IIcon[] field_150017_a;
    private IIcon[] field_150016_b;

	public BlockMoreDoors(Material par2Material) 
	{
		super(par2Material);
		float f = 0.5F;
		float f1 = 1.0F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
	}

    /**
     * Gets the block's texture. Args: side, meta
     */
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return this.field_150016_b[0];
    }

    public IIcon getIcon(IBlockAccess p_149673_1_, int coordX, int coordY, int coordZ, int p_149673_5_)
    {
        if (p_149673_5_ != 1 && p_149673_5_ != 0)
        {
            int var6 = this.func_150013_e(p_149673_1_, coordX, coordY, coordZ);
            int var7 = var6 & 3;
            boolean var8 = (var6 & 4) != 0;
            boolean var9 = false;
            boolean var10 = (var6 & 8) != 0;

            if (var8)
            {
                if (var7 == 0 && p_149673_5_ == 2)
                {
                    var9 = !var9;
                }
                else if (var7 == 1 && p_149673_5_ == 5)
                {
                    var9 = !var9;
                }
                else if (var7 == 2 && p_149673_5_ == 3)
                {
                    var9 = !var9;
                }
                else if (var7 == 3 && p_149673_5_ == 4)
                {
                    var9 = !var9;
                }
            }
            else
            {
                if (var7 == 0 && p_149673_5_ == 5)
                {
                    var9 = !var9;
                }
                else if (var7 == 1 && p_149673_5_ == 3)
                {
                    var9 = !var9;
                }
                else if (var7 == 2 && p_149673_5_ == 4)
                {
                    var9 = !var9;
                }
                else if (var7 == 3 && p_149673_5_ == 2)
                {
                    var9 = !var9;
                }

                if ((var6 & 16) != 0)
                {
                    var9 = !var9;
                }
            }

            return var10 ? this.field_150017_a[var9 ? 1 : 0] : this.field_150016_b[var9 ? 1 : 0];
        }
        else
        {
            return this.field_150016_b[0];
        }
    }

    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.field_150017_a = new IIcon[2];
        this.field_150016_b = new IIcon[2];
        this.field_150017_a[0] = p_149651_1_.registerIcon("bettercraft:" + this.getTextureName() + "_upper");
        this.field_150016_b[0] = p_149651_1_.registerIcon("bettercraft:" + this.getTextureName() + "_lower");
        this.field_150017_a[1] = new IconFlipped(this.field_150017_a[0], true, false);
        this.field_150016_b[1] = new IconFlipped(this.field_150016_b[0], true, false);
    }

    public Item getItem(World par1World, int par2, int par3, int par4)
    {
    	return this == BetterCraft.doorNether ? BetterCraft.NetherBrickDoor : this == BetterCraft.doorGlass ? BetterCraft.GlassDoor : this == BetterCraft.doorNetherwood ? BetterCraft.NetherwoodDoor : Items.wooden_door;
    }

	public Item getItemDropped(int par1, Random par2Random, int par3) 
	{
        return (par1 & 8) != 0 ? null : (this == BetterCraft.doorNether ? BetterCraft.NetherBrickDoor : this == BetterCraft.doorGlass ? BetterCraft.GlassDoor : this == BetterCraft.doorNetherwood ? BetterCraft.NetherwoodDoor : null);
	}

}