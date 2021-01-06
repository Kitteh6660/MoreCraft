package kittehmod.morecraft.client.gui;

import java.util.function.Supplier;

import kittehmod.morecraft.tileentity.ModSignTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkEvent;

//This file is to resolve the invalid DIST.
public class ModSignClientHandler {

	@OnlyIn(Dist.CLIENT)
	public static void deliverPacket(BlockPos pos, Supplier<NetworkEvent.Context> context) {
		Minecraft minecraft = Minecraft.getInstance();
		World world = minecraft.player.getEntityWorld();
		TileEntity te = world.getTileEntity(pos);
		openSignGUI(te);
	}
	
	private static void openSignGUI(TileEntity tileEntity) {
		Minecraft minecraft = Minecraft.getInstance();
    	ModEditSignScreen gui = new ModEditSignScreen((ModSignTileEntity)tileEntity);
		minecraft.displayGuiScreen(gui);
	}
}
