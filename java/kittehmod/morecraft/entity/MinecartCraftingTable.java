package kittehmod.morecraft.entity;

import kittehmod.morecraft.block.ModBlocks;
import kittehmod.morecraft.container.MinecartCraftingMenu;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecartContainer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

public class MinecartCraftingTable extends AbstractMinecartContainer
{
	public MinecartCraftingTable(EntityType<? extends MinecartCraftingTable> workbenchCart, Level world) {
		super(workbenchCart, world);
	}

	public MinecartCraftingTable(Level worldIn, double x, double y, double z, CraftingTableType type) {
		super(getEntitySubtype(type), x, y, z, worldIn);
	}

	public InteractionResult interact(Player player, InteractionHand hand) {
		InteractionResult ret = super.interact(player, hand);
		if (ret.consumesAction()) return ret;
		player.openMenu(this);
		if (!player.level.isClientSide) {
			return InteractionResult.CONSUME;
		} else {
			return InteractionResult.SUCCESS;
		}
	}

	@Override
	public BlockState getDisplayBlockState() {
		return this.getDefaultDisplayBlockState();
	}

	@Override
	public BlockState getDefaultDisplayBlockState() {
		Block block;
		switch (this.getCraftingTableType()) {
		case OAK:
			block = Blocks.CRAFTING_TABLE;
			break;
		case SPRUCE:
			block = ModBlocks.SPRUCE_CRAFTING_TABLE.get();
			break;
		case BIRCH:
			block = ModBlocks.BIRCH_CRAFTING_TABLE.get();
			break;
		case JUNGLE:
			block = ModBlocks.JUNGLE_CRAFTING_TABLE.get();
			break;
		case ACACIA:
			block = ModBlocks.ACACIA_CRAFTING_TABLE.get();
			break;
		case DARK_OAK:
			block = ModBlocks.DARK_OAK_CRAFTING_TABLE.get();
			break;
		case CRIMSON:
			block = ModBlocks.CRIMSON_CRAFTING_TABLE.get();
			break;
		case WARPED:
			block = ModBlocks.WARPED_CRAFTING_TABLE.get();
			break;
		case NETHERWOOD:
			block = ModBlocks.NETHERWOOD_CRAFTING_TABLE.get();
			break;
		default:
			block = Blocks.CRAFTING_TABLE;
		}
		return block.defaultBlockState();
	}

	public int getDefaultDisplayTileOffset() {
		return 8;
	}

	public AbstractContainerMenu createMenu(int cid, Inventory playerInventoryIn) {
		return new MinecartCraftingMenu(cid, playerInventoryIn, ContainerLevelAccess.create(this.level, this.blockPosition()), this);
	}

	@Override
	public Type getMinecartType() {
		return AbstractMinecartContainer.Type.CHEST; // Arbitrarily set but its only purpose is to make the errors shut up.
	}

	public static MinecartCraftingTable create(Level worldIn, double x, double y, double z, CraftingTableType type) {
		return new MinecartCraftingTable(worldIn, x, y, z, type);
	}

	@Override
	public int getContainerSize() {
		return 9;
	}

	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public void destroy(DamageSource source) {
		super.destroy(source);
		if (!source.isExplosion() && this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
			this.spawnAtLocation(this.getDisplayBlockState().getBlock());
		}
	}

	/*@Override
	public ITextComponent getName() {
		if (!this.hasCustomName()) {
			return this.getCustomName();
		}
		else {
			return ModCraftingTableBlock.TITLE;
		}
	}*/
	
	public CraftingTableType getCraftingTableType() {
		if (this.getType() == ModEntities.OAK_CRAFTING_TABLE_MINECART.get()) {
			return CraftingTableType.OAK;
		} else if (this.getType() == ModEntities.SPRUCE_CRAFTING_TABLE_MINECART.get()) {
			return CraftingTableType.SPRUCE;
		} else if (this.getType() == ModEntities.BIRCH_CRAFTING_TABLE_MINECART.get()) {
			return CraftingTableType.BIRCH;
		} else if (this.getType() == ModEntities.JUNGLE_CRAFTING_TABLE_MINECART.get()) {
			return CraftingTableType.JUNGLE;
		} else if (this.getType() == ModEntities.ACACIA_CRAFTING_TABLE_MINECART.get()) {
			return CraftingTableType.ACACIA;
		} else if (this.getType() == ModEntities.DARK_OAK_CRAFTING_TABLE_MINECART.get()) {
			return CraftingTableType.DARK_OAK;
		} else if (this.getType() == ModEntities.CRIMSON_CRAFTING_TABLE_MINECART.get()) {
			return CraftingTableType.CRIMSON;
		} else if (this.getType() == ModEntities.WARPED_CRAFTING_TABLE_MINECART.get()) {
			return CraftingTableType.WARPED;
		} else if (this.getType() == ModEntities.NETHERWOOD_CRAFTING_TABLE_MINECART.get()) {
			return CraftingTableType.NETHERWOOD;
		} else {
			return CraftingTableType.OAK;
		}
	}

	private static EntityType<MinecartCraftingTable> getEntitySubtype(CraftingTableType type) {
		switch (type) {
		case OAK:
			return ModEntities.OAK_CRAFTING_TABLE_MINECART.get();
		case SPRUCE:
			return ModEntities.SPRUCE_CRAFTING_TABLE_MINECART.get();
		case BIRCH:
			return ModEntities.BIRCH_CRAFTING_TABLE_MINECART.get();
		case JUNGLE:
			return ModEntities.JUNGLE_CRAFTING_TABLE_MINECART.get();
		case ACACIA:
			return ModEntities.ACACIA_CRAFTING_TABLE_MINECART.get();
		case DARK_OAK:
			return ModEntities.DARK_OAK_CRAFTING_TABLE_MINECART.get();
		case CRIMSON:
			return ModEntities.CRIMSON_CRAFTING_TABLE_MINECART.get();
		case WARPED:
			return ModEntities.WARPED_CRAFTING_TABLE_MINECART.get();
		case NETHERWOOD:
			return ModEntities.NETHERWOOD_CRAFTING_TABLE_MINECART.get();
		default:
			return ModEntities.OAK_CRAFTING_TABLE_MINECART.get();
		}
	}

	public static enum CraftingTableType
	{
		OAK, SPRUCE, BIRCH, JUNGLE, ACACIA, DARK_OAK, CRIMSON, WARPED, NETHERWOOD
	}

}
