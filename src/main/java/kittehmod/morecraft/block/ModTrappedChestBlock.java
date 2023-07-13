package kittehmod.morecraft.block;

import kittehmod.morecraft.blockentity.ModChestBlockEntity;
import kittehmod.morecraft.blockentity.ModTrappedChestBlockEntity;
import kittehmod.morecraft.init.ModBlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class ModTrappedChestBlock extends ModChestBlock
{
   public ModTrappedChestBlock(BlockBehaviour.Properties p_57573_) {
      super(p_57573_, () -> {
         return ModBlockEntityType.NETHERWOOD_TRAPPED_CHEST.get();
      });
   }

   public BlockEntity newBlockEntity(BlockPos p_154834_, BlockState p_154835_) {
      return new ModTrappedChestBlockEntity(p_154834_, p_154835_);
   }

   protected Stat<ResourceLocation> getOpenChestStat() {
      return Stats.CUSTOM.get(Stats.TRIGGER_TRAPPED_CHEST);
   }

   public boolean isSignalSource(BlockState p_57587_) {
      return true;
   }

   public int getSignal(BlockState p_57577_, BlockGetter p_57578_, BlockPos p_57579_, Direction p_57580_) {
      return Mth.clamp(ModChestBlockEntity.getOpenCount(p_57578_, p_57579_), 0, 15);
   }

   public int getDirectSignal(BlockState p_57582_, BlockGetter p_57583_, BlockPos p_57584_, Direction p_57585_) {
      return p_57585_ == Direction.UP ? p_57582_.getSignal(p_57583_, p_57584_, p_57585_) : 0;
   }
}
