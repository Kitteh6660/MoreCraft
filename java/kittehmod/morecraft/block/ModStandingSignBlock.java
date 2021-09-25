package kittehmod.morecraft.block;

import kittehmod.morecraft.blockentity.ModSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.BlockHitResult;

public class ModStandingSignBlock extends StandingSignBlock 
{	
	public ModStandingSignBlock(Block.Properties properties, WoodType woodtype) {
		super(properties, woodtype);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ModSignBlockEntity(pos, state);
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
		BlockEntity blockentity = worldIn.getBlockEntity(pos);
		if (worldIn.isClientSide) {
			return InteractionResult.SUCCESS;
		} else {
			if (blockentity instanceof ModSignBlockEntity) {
				ModSignBlockEntity signBlockEntity = (ModSignBlockEntity) blockentity;
				ItemStack itemstack = player.getItemInHand(handIn);
				if (itemstack.getItem() instanceof DyeItem && player.getAbilities().mayBuild) {
					boolean flag = signBlockEntity.setColor(((DyeItem)itemstack.getItem()).getDyeColor());
					if (flag && !player.isCreative()) {
						itemstack.shrink(1);
					}
				}
				else if (itemstack.getItem() == Items.GLOW_INK_SAC && player.getAbilities().mayBuild) {
					boolean flag = signBlockEntity.setHasGlowingText(true);
					if (flag && !player.isCreative()) {
						itemstack.shrink(1);
					}
				}
				else if (itemstack.getItem() == Items.INK_SAC && player.getAbilities().mayBuild) {
					boolean flag = signBlockEntity.setHasGlowingText(false);
					if (flag && !player.isCreative()) {
						itemstack.shrink(1);
					}
				}
				return signBlockEntity.executeClickCommands((ServerPlayer)player) ? InteractionResult.SUCCESS : InteractionResult.PASS;
			} else {
				return InteractionResult.PASS;
			}
		}
	}
}
