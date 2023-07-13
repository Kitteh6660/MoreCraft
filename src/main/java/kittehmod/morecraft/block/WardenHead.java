package kittehmod.morecraft.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public interface WardenHead
{	
	default int getListenerRange() {
		return 8;
	}
	
	static boolean canActivate(BlockState state) {
		return true;
	}
	
	default boolean canJumpscare(Level level, BlockState state, BlockPos pos) {
		return false;
	}
	
	default void jumpscarePlayer(Level level, BlockState state, BlockPos pos, Player player) {}
	
	default void setJumpscareCooldown(Level level, BlockState state, BlockPos pos) {}
	
	default void resetJumpscareCooldown(Level level, BlockState state, BlockPos pos) {}
	
}
