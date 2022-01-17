package kittehmod.morecraft.entity;

import kittehmod.morecraft.block.ModBlocks;
import kittehmod.morecraft.block.ModCraftingTableBlock;
import kittehmod.morecraft.container.MinecartWorkbenchContainer;
import net.minecraft.block.BlockState;
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
import net.minecraft.util.text.ITextComponent;
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
		return ModBlocks.NETHERWOOD_CRAFTING_TABLE.get().defaultBlockState();
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

	@Override
	public ITextComponent getName() {
		return ModCraftingTableBlock.TITLE;
	}
	
	public CraftingTableType getCraftingTableType() {
		return CraftingTableType.NETHERWOOD;
	}

	private static EntityType<CraftingTableMinecartEntity> getEntitySubtype(CraftingTableType type) {
		return ModEntities.NETHERWOOD_CRAFTING_TABLE_MINECART.get();
	}

	public static enum CraftingTableType
	{
		NETHERWOOD
	}

}
