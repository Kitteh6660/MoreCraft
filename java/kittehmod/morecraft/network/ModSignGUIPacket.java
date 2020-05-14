package kittehmod.morecraft.network;

import java.util.function.Supplier;

import kittehmod.morecraft.client.gui.ModEditSignScreen;
import kittehmod.morecraft.tileentity.NetherwoodSignTileEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.network.NetworkEvent;

public class ModSignGUIPacket {
	
	private final TileEntity tileentity;
	
    public ModSignGUIPacket(TileEntity tileEntityIn) {
    	this.tileentity = tileEntityIn;
    }
    
    public void encode(ModSignGUIPacket pkt, PacketBuffer buf) {}
    
    private TileEntity getTileEntity() {
    	return this.tileentity;
    }
    
    public void handle(final ModUpdateSignPacket message, Supplier<NetworkEvent.Context> context) {
    	context.get().enqueueWork(
    		() -> new ModEditSignScreen((NetherwoodSignTileEntity)this.getTileEntity())
    	);
    	context.get().setPacketHandled(true);
    }
	
}
