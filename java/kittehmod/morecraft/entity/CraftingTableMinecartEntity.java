package kittehmod.morecraft.entity;

import kittehmod.morecraft.block.ModBlocks;
import kittehmod.morecraft.container.MinecartWorkbenchContainer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraft.entity.item.minecart.ContainerMinecartEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.network.IPacket;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class CraftingTableMinecartEntity extends ContainerMinecartEntity implements IInventory, INamedContainerProvider
{
	public CraftingTableMinecartEntity(EntityType<? extends CraftingTableMinecartEntity> workbenchCart, World world) {
		super(workbenchCart, world);
	}

	public CraftingTableMinecartEntity(World worldIn, double x, double y, double z, CraftingTableType type) {
		super(getEntitySubtype(type), x, y, z, worldIn);
	}

	public ActionResultType interact(PlayerEntity player, Hand hand) {
		ActionResultType ret = super.interact(player, hand);
		if (ret.consumesAction()) return ret;
		player.openMenu(this);
		if (!player.level.isClientSide) {
			return ActionResultType.CONSUME;
		} else {
			return ActionResultType.SUCCESS;
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

	public Container createMenu(int cid, PlayerInventory playerInventoryIn) {
		return new MinecartWorkbenchContainer(cid, playerInventoryIn, IWorldPosCallable.create(this.level, this.blockPosition()), this);
	}

	@Override
	public Type getMinecartType() {
		return AbstractMinecartEntity.Type.CHEST; // Arbitrarily set but its only purpose is to make the errors shut up.
	}

	public static CraftingTableMinecartEntity create(World worldIn, double x, double y, double z, CraftingTableType type) {
		return new CraftingTableMinecartEntity(worldIn, x, y, z, type);
	}

	@Override
	public int getContainerSize() {
		return 9;
	}

	public IPacket<?> getAddEntityPacket() {
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

	private static EntityType<CraftingTableMinecartEntity> getEntitySubtype(CraftingTableType type) {
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
