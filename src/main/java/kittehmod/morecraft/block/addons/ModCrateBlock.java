package kittehmod.morecraft.block.addons;

import java.util.List;

import javax.annotation.Nullable;

import kittehmod.morecraft.block.ModWoodType;
import kittehmod.morecraft.blockentity.ModBlockEntityType;
import kittehmod.morecraft.blockentity.addons.ModCrateBlockEntity;
import kittehmod.morecraft.init.ModBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModCrateBlock extends BaseEntityBlock
{
	public static final ResourceLocation CONTENTS = new ResourceLocation("contents");
	private final WoodType wtype;

	public ModCrateBlock(Properties properties, WoodType type) {
		super(properties);
		this.wtype = type;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ModCrateBlockEntity(pos, state);
	}

	public RenderShape getRenderShape(BlockState p_149645_1_) {
		return RenderShape.MODEL;
	}

	public InteractionResult use(BlockState p_225533_1_, Level p_225533_2_, BlockPos p_225533_3_, Player p_225533_4_, InteractionHand p_225533_5_, BlockHitResult p_225533_6_) {
		if (p_225533_2_.isClientSide) {
			return InteractionResult.SUCCESS;
		} else if (p_225533_4_.isSpectator()) {
			return InteractionResult.CONSUME;
		} else {
			BlockEntity blockentity = p_225533_2_.getBlockEntity(p_225533_3_);
			if (blockentity instanceof ModCrateBlockEntity) {
				p_225533_4_.openMenu((ModCrateBlockEntity) blockentity);
				p_225533_4_.awardStat(Stats.OPEN_BARREL);
				PiglinAi.angerNearbyPiglins(p_225533_4_, true);
				return InteractionResult.CONSUME;
			} else {
				return InteractionResult.PASS;
			}
		}
	}

	@Override
	public void playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
		BlockEntity blockentity = world.getBlockEntity(pos);
		if (blockentity instanceof ModCrateBlockEntity) {
			ModCrateBlockEntity cratetileentity = (ModCrateBlockEntity) blockentity;
			if (!world.isClientSide && player.isCreative() && !cratetileentity.isEmpty()) {
				ItemStack itemstack = getTypedItemStack(this.getType());
				blockentity.saveToItem(itemstack);
				if (cratetileentity.hasCustomName()) {
					itemstack.setHoverName(cratetileentity.getCustomName());
				}

				ItemEntity itementity = new ItemEntity(world, (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, itemstack);
				itementity.setDefaultPickUpDelay();
				world.addFreshEntity(itementity);
			} else {
				cratetileentity.unpackLootTable(player);
			}
		}

		super.playerWillDestroy(world, pos, state, player);
	}

	@Nullable
	public WoodType getType() {
		return this.wtype;
	}

	public static ItemStack getTypedItemStack(@Nullable WoodType type) {
		return new ItemStack(getBlockByType(type));
	}

	public static Block getBlockByType(@Nullable WoodType type) {
		if (type == ModWoodType.NETHERWOOD) {
			return ModBlocks.NETHERWOOD_CRATE.get();
		} else {
			return ModBlocks.NETHERWOOD_CRATE.get();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		BlockEntity blockentity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
		if (blockentity instanceof ModCrateBlockEntity) {
			ModCrateBlockEntity cratetileentity = (ModCrateBlockEntity) blockentity;
			builder = builder.withDynamicDrop(CONTENTS, (p_220168_1_, p_220168_2_) -> {
				for (int i = 0; i < cratetileentity.getContainerSize(); ++i) {
					p_220168_2_.accept(cratetileentity.getItem(i));
				}

			});
		}

		return super.getDrops(state, builder);
	}

	public void setPlacedBy(Level p_180633_1_, BlockPos p_180633_2_, BlockState p_180633_3_, LivingEntity p_180633_4_, ItemStack p_180633_5_) {
		if (p_180633_5_.hasCustomHoverName()) {
			BlockEntity blockentity = p_180633_1_.getBlockEntity(p_180633_2_);
			if (blockentity instanceof ModCrateBlockEntity) {
				((ModCrateBlockEntity) blockentity).setCustomName(p_180633_5_.getHoverName());
			}
		}

	}

	@SuppressWarnings("deprecation")
	public void onRemove(BlockState p_196243_1_, Level p_196243_2_, BlockPos p_196243_3_, BlockState p_196243_4_, boolean p_196243_5_) {
		if (!p_196243_1_.is(p_196243_4_.getBlock())) {
			BlockEntity blockentity = p_196243_2_.getBlockEntity(p_196243_3_);
			if (blockentity instanceof ModCrateBlockEntity) {
				p_196243_2_.updateNeighbourForOutputSignal(p_196243_3_, p_196243_1_.getBlock());
			}

			super.onRemove(p_196243_1_, p_196243_2_, p_196243_3_, p_196243_4_, p_196243_5_);
		}
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter getter, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(stack, getter, list, flag);
		CompoundTag CompoundTag = stack.getTagElement("BlockEntityTag");
		if (CompoundTag != null) {
			if (CompoundTag.contains("LootTable", 8)) {
				list.add(Component.literal("???????"));
			}

			if (CompoundTag.contains("Items", 9)) {
				NonNullList<ItemStack> nonnulllist = NonNullList.withSize(27, ItemStack.EMPTY);
				ContainerHelper.loadAllItems(CompoundTag, nonnulllist);
				int i = 0;
				int j = 0;

				for (ItemStack itemstack : nonnulllist) {
					if (!itemstack.isEmpty()) {
						++j;
						if (i <= 4) {
							++i;
							MutableComponent mutablecomponent = itemstack.getHoverName().copy();
							mutablecomponent.append(" x").append(String.valueOf(itemstack.getCount()));
							list.add(mutablecomponent);
						}
					}
				}

				if (j - i > 0) {
					list.add((Component.translatable("container.shulkerBox.more", j - i)).withStyle(ChatFormatting.ITALIC));
				}
			}
		}

	}

	@Override
	public PushReaction getPistonPushReaction(BlockState p_149656_1_) {
		return PushReaction.NORMAL;
	}

	@Override
	public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
		return Shapes.block();
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState p_149740_1_) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState p_180641_1_, Level p_180641_2_, BlockPos p_180641_3_) {
		return AbstractContainerMenu.getRedstoneSignalFromContainer((Container) p_180641_2_.getBlockEntity(p_180641_3_));
	}

	@SuppressWarnings("deprecation")
	@Override
	public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
		ItemStack itemstack = super.getCloneItemStack(getter, pos, state);
		getter.getBlockEntity(pos, ModBlockEntityType.CRATE.get()).ifPresent((p_187446_) -> {
			p_187446_.saveToItem(itemstack);
		});
		return itemstack;
	}
}
