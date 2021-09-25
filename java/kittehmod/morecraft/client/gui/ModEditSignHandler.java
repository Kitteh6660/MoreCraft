package kittehmod.morecraft.client.gui;

import java.util.function.Supplier;

import kittehmod.morecraft.blockentity.ModSignBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

//This file is to resolve the invalid DIST.
public class ModEditSignHandler {

	@OnlyIn(Dist.CLIENT)
	public static void deliverPacket(BlockPos pos, Supplier<NetworkEvent.Context> context) {
		Minecraft minecraft = Minecraft.getInstance();
		Level world = minecraft.player.level;
		BlockEntity te = world.getBlockEntity(pos);
		openSignGUI(te);
	}
	
	private static void openSignGUI(BlockEntity tileEntity) {
		Minecraft minecraft = Minecraft.getInstance();
    	ModSignEditScreen gui = new ModSignEditScreen((ModSignBlockEntity)tileEntity, true);
		minecraft.setScreen(gui);
	}

}
