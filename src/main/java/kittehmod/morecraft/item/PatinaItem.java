package kittehmod.morecraft.item;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopper.WeatherState;
import net.minecraft.world.level.block.state.BlockState;

public class PatinaItem extends Item
{
	public PatinaItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public InteractionResult useOn(UseOnContext context) {
		Player player = context.getPlayer();
		Level level = context.getLevel();
		BlockPos pos = context.getClickedPos();
		if (!level.isClientSide()) {
			BlockState state = level.getBlockState(pos);
			if (state.getBlock() instanceof WeatheringCopper) {
				WeatheringCopper copper = (WeatheringCopper) state.getBlock();
				if (copper.getAge() != WeatherState.OXIDIZED) {
					if (!player.isCreative()) {
						context.getItemInHand().shrink(1);
					}
					player.swing(context.getHand());
					copper.getNext(state).ifPresent((newState) -> { level.setBlockAndUpdate(pos, newState); } );
					level.playSound(player, pos, SoundEvents.DYE_USE, SoundSource.BLOCKS, 0.2F, 0.3F);
					return InteractionResult.SUCCESS;
				}
			}
		}
		return InteractionResult.PASS;
	}

}
