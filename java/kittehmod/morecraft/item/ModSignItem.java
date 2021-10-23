package kittehmod.morecraft.item;

import javax.annotation.Nullable;

import kittehmod.morecraft.network.ModSignGUIPacket;
import kittehmod.morecraft.network.MorecraftPacketHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class ModSignItem extends SignItem {
	
	public ModSignItem(Item.Properties propertiesIn, Block floorBlockIn, Block wallBlockIn) {
		super(propertiesIn, floorBlockIn, wallBlockIn);
	}

	@Override
	protected boolean updateCustomBlockEntityTag(BlockPos pos, Level worldIn, @Nullable Player player, ItemStack stack, BlockState state) {
		boolean flag = super.updateCustomBlockEntityTag(worldIn, player, pos, stack);
		if (player instanceof ServerPlayer && !flag) {
			ModSignGUIPacket msg = new ModSignGUIPacket(pos);
			MorecraftPacketHandler.sendToClient(msg, (ServerPlayer) player);
		}
		return flag;
	}

}
