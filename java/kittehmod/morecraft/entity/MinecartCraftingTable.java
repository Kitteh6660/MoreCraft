package kittehmod.morecraft.entity;

import kittehmod.morecraft.block.ModBlocks;
import kittehmod.morecraft.block.ModCraftingTableBlock;
import kittehmod.morecraft.container.MinecartCraftingMenu;
import net.minecraft.network.chat.Component;
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
		return ModBlocks.NETHERWOOD_CRAFTING_TABLE.get().defaultBlockState();
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

	@Override
	public Component getName() {
		return ModCraftingTableBlock.TITLE;
	}
	
	public CraftingTableType getCraftingTableType() {
		return CraftingTableType.NETHERWOOD;
	}

	private static EntityType<MinecartCraftingTable> getEntitySubtype(CraftingTableType type) {
		return ModEntities.NETHERWOOD_CRAFTING_TABLE_MINECART.get();
	}

	public static enum CraftingTableType
	{
		NETHERWOOD
	}

}
