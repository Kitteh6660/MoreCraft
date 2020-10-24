package kittehmod.morecraft.item;

import javax.annotation.Nullable;

import kittehmod.morecraft.network.ModSignGUIPacket;
import kittehmod.morecraft.network.MorecraftPacketHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SignItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModSignItem extends SignItem {
	
	public ModSignItem(Item.Properties propertiesIn, Block floorBlockIn, Block wallBlockIn) {
		super(propertiesIn, floorBlockIn, wallBlockIn);
	}

	@Override
	protected boolean onBlockPlaced(BlockPos pos, World worldIn, @Nullable PlayerEntity player, ItemStack stack, BlockState state) {
		boolean flag = setTileEntityNBT(worldIn, player, pos, stack);
		if (player instanceof ServerPlayerEntity && !flag) {
			ModSignGUIPacket msg = new ModSignGUIPacket(pos);
			MorecraftPacketHandler.sendTo(msg, (ServerPlayerEntity)player);
		}
		return flag;
	}

}
