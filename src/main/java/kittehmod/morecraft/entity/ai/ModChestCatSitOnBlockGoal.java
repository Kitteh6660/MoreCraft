package kittehmod.morecraft.entity.ai;

import kittehmod.morecraft.blockentity.ModChestBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.CatSitOnBlockGoal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.AbstractChestBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class ModChestCatSitOnBlockGoal extends CatSitOnBlockGoal 
{
    public ModChestCatSitOnBlockGoal(Cat catEntity, float speedIn)
    {
        super(catEntity, speedIn);
    }

    /**
     * Return true to set given position as destination
     */
    @Override
    protected boolean isValidTarget(LevelReader worldIn, BlockPos pos)
    {
        if (!worldIn.isEmptyBlock(pos.above()))
        {
            return false;
        }
        else
        {
            BlockState iBlockState = worldIn.getBlockState(pos);
            Block block = iBlockState.getBlock();

            if (block instanceof AbstractChestBlock)
            {
                return ModChestBlockEntity.getOpenCount(worldIn, pos) < 1;
            }

            return super.isValidTarget(worldIn, pos);
        }
    }
}
