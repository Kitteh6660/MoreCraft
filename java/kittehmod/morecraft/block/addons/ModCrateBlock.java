package kittehmod.morecraft.block.addons;

import java.util.List;

import javax.annotation.Nullable;

import kittehmod.morecraft.block.ModBlocks;
import kittehmod.morecraft.block.ModWoodType;
import kittehmod.morecraft.tileentity.addons.ModCrateTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.material.PushReaction;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModCrateBlock extends ContainerBlock
{
	public static final ResourceLocation CONTENTS = new ResourceLocation("contents");
	private final WoodType wtype;

	public ModCrateBlock(Properties properties, WoodType type) {
		super(properties);
		this.wtype = type;
	}

	@Override
	public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
		return new ModCrateTileEntity();
	}

	public BlockRenderType getRenderShape(BlockState p_149645_1_) {
		return BlockRenderType.MODEL;
	}

	public ActionResultType use(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
		if (p_225533_2_.isClientSide) {
			return ActionResultType.SUCCESS;
		} else if (p_225533_4_.isSpectator()) {
			return ActionResultType.CONSUME;
		} else {
			TileEntity tileentity = p_225533_2_.getBlockEntity(p_225533_3_);
			if (tileentity instanceof ModCrateTileEntity) {
				p_225533_4_.openMenu((ModCrateTileEntity) tileentity);
				p_225533_4_.awardStat(Stats.OPEN_BARREL);
				PiglinTasks.angerNearbyPiglins(p_225533_4_, true);
				return ActionResultType.CONSUME;
			}
			else {
				return ActionResultType.PASS;
			}
		}
	}

	@Override
	public void playerWillDestroy(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		TileEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof ModCrateTileEntity) {
			ModCrateTileEntity cratetileentity = (ModCrateTileEntity) tileentity;
			if (!world.isClientSide && player.isCreative() && !cratetileentity.isEmpty()) {
				ItemStack itemstack = getTypedItemStack(this.getType());
				CompoundNBT compoundnbt = cratetileentity.saveToTag(new CompoundNBT());
				if (!compoundnbt.isEmpty()) {
					itemstack.addTagElement("BlockEntityTag", compoundnbt);
				}

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
		TileEntity tileentity = builder.getOptionalParameter(LootParameters.BLOCK_ENTITY);
		if (tileentity instanceof ModCrateTileEntity) {
			ModCrateTileEntity cratetileentity = (ModCrateTileEntity) tileentity;
			builder = builder.withDynamicDrop(CONTENTS, (p_220168_1_, p_220168_2_) -> {
				for (int i = 0; i < cratetileentity.getContainerSize(); ++i) {
					p_220168_2_.accept(cratetileentity.getItem(i));
				}

			});
		}

		return super.getDrops(state, builder);
	}

	public void setPlacedBy(World p_180633_1_, BlockPos p_180633_2_, BlockState p_180633_3_, LivingEntity p_180633_4_, ItemStack p_180633_5_) {
		if (p_180633_5_.hasCustomHoverName()) {
			TileEntity tileentity = p_180633_1_.getBlockEntity(p_180633_2_);
			if (tileentity instanceof ModCrateTileEntity) {
				((ModCrateTileEntity) tileentity).setCustomName(p_180633_5_.getHoverName());
			}
		}

	}

	@SuppressWarnings("deprecation")
	public void onRemove(BlockState p_196243_1_, World p_196243_2_, BlockPos p_196243_3_, BlockState p_196243_4_, boolean p_196243_5_) {
		if (!p_196243_1_.is(p_196243_4_.getBlock())) {
			TileEntity tileentity = p_196243_2_.getBlockEntity(p_196243_3_);
			if (tileentity instanceof ModCrateTileEntity) {
				p_196243_2_.updateNeighbourForOutputSignal(p_196243_3_, p_196243_1_.getBlock());
			}

			super.onRemove(p_196243_1_, p_196243_2_, p_196243_3_, p_196243_4_, p_196243_5_);
		}
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack p_190948_1_, @Nullable IBlockReader p_190948_2_, List<ITextComponent> p_190948_3_, ITooltipFlag p_190948_4_) {
		super.appendHoverText(p_190948_1_, p_190948_2_, p_190948_3_, p_190948_4_);
		CompoundNBT compoundnbt = p_190948_1_.getTagElement("BlockEntityTag");
		if (compoundnbt != null) {
			if (compoundnbt.contains("LootTable", 8)) {
				p_190948_3_.add(new StringTextComponent("???????"));
			}

			if (compoundnbt.contains("Items", 9)) {
				NonNullList<ItemStack> nonnulllist = NonNullList.withSize(27, ItemStack.EMPTY);
				ItemStackHelper.loadAllItems(compoundnbt, nonnulllist);
				int i = 0;
				int j = 0;

				for (ItemStack itemstack : nonnulllist) {
					if (!itemstack.isEmpty()) {
						++j;
						if (i <= 4) {
							++i;
							IFormattableTextComponent iformattabletextcomponent = itemstack.getHoverName().copy();
							iformattabletextcomponent.append(" x").append(String.valueOf(itemstack.getCount()));
							p_190948_3_.add(iformattabletextcomponent);
						}
					}
				}

				if (j - i > 0) {
					p_190948_3_.add((new TranslationTextComponent("container.shulkerBox.more", j - i)).withStyle(TextFormatting.ITALIC));
				}
			}
		}

	}

	@Override
	public PushReaction getPistonPushReaction(BlockState p_149656_1_) {
		return PushReaction.NORMAL;
	}

	@Override
	public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
		return VoxelShapes.block();
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState p_149740_1_) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState p_180641_1_, World p_180641_2_, BlockPos p_180641_3_) {
		return Container.getRedstoneSignalFromContainer((IInventory) p_180641_2_.getBlockEntity(p_180641_3_));
	}

	@SuppressWarnings("deprecation")
	@Override
	public ItemStack getCloneItemStack(IBlockReader p_185473_1_, BlockPos p_185473_2_, BlockState p_185473_3_) {
		ItemStack itemstack = super.getCloneItemStack(p_185473_1_, p_185473_2_, p_185473_3_);
		ModCrateTileEntity cratetileentity = (ModCrateTileEntity) p_185473_1_.getBlockEntity(p_185473_2_);
		CompoundNBT compoundnbt = cratetileentity.saveToTag(new CompoundNBT());
		if (!compoundnbt.isEmpty()) {
			itemstack.addTagElement("BlockEntityTag", compoundnbt);
		}

		return itemstack;
	}
}
