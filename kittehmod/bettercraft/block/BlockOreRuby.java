package kittehmod.bettercraft.block;

import java.util.Random;

import kittehmod.bettercraft.MoreCraftItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockOreRuby extends Block 
{

	public BlockOreRuby(Material material) 
	{
		super(material);
		this.setHarvestLevel("pickaxe", 2);
		this.func_149647_a(CreativeTabs.field_78030_b);
	}
	
	public Item func_180660_a(IBlockState state, Random rand, int fortune)
	{
        return MoreCraftItems.ruby;
	}
	
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int func_149745_a(Random random)
    {
        return 1;
    }

    /**
     * Get the quantity dropped based on the given fortune level
     */
    public int func_149679_a(int fortune, Random random)
    {
        if (fortune > 0 && Item.func_150898_a(this) != this.func_180660_a((IBlockState)this.func_176194_O().func_177619_a().iterator().next(), random, fortune))
        {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return this.func_149745_a(random) * (i + 1);
        }
        else
        {
            return this.func_149745_a(random);
        }
    }

    /**
     * Spawns this Block's drops into the World as EntityItems.
     */
    public void func_180653_a(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.func_180653_a(worldIn, pos, state, chance, fortune);
    }
    @Override
    public int getExpDrop(net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        IBlockState state = world.func_180495_p(pos);
        Random rand = world instanceof World ? ((World)world).field_73012_v : new Random();
        if (this.func_180660_a(state, rand, fortune) != Item.func_150898_a(this))
        {
            int i = 0;
            i = MathHelper.func_76136_a(rand, 2, 5);
            return i;
        }
        return 0;
    }
	
}