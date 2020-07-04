package kittehmod.morecraft.block;

import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class SoulGlassBlock extends AbstractGlassBlock
{
    public SoulGlassBlock(Block.Properties properties) {
        super(properties);
    }
    
    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
     }

     public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return false;
     }

     public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return false;
     }

     public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
        return false;
     }

}
