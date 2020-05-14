package kittehmod.morecraft.client.gui;

import kittehmod.morecraft.tileentity.NetherwoodSignTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, PlayerEntity player, World world, int x, int y, int z) {
		
		TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, PlayerEntity player, World world, int x, int y, int z) {
		
		TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
		switch(ID) {
			case 1:
				if (tileEntity instanceof NetherwoodSignTileEntity) {
					return new ModEditSignScreen((NetherwoodSignTileEntity)tileEntity);
				}
				break;
		}
		return null;
	}

}
