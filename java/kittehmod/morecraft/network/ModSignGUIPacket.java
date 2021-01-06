package kittehmod.morecraft.network;

import java.util.function.Supplier;

import kittehmod.morecraft.client.gui.ModEditSignHandler;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class ModSignGUIPacket {
	
	private final BlockPos pos;
	
    public ModSignGUIPacket(BlockPos pos) {
    	this.pos = pos;
    }
    
    public static void encode(ModSignGUIPacket pkt, PacketBuffer buf) {
    	buf.writeBlockPos(pkt.pos);
    }
    
    public static ModSignGUIPacket decode(PacketBuffer buf) {
    	return new ModSignGUIPacket(buf.readBlockPos());
    }
    
    public static void handle(final ModSignGUIPacket message, Supplier<NetworkEvent.Context> context) {
    	context.get().enqueueWork(() -> {
    		if (context.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
    			//GUI is client-side only.
    		}
    		else if (context.get().getDirection() == NetworkDirection.PLAY_TO_CLIENT) {
    			ModEditSignHandler.deliverPacket(message.pos, context);
    		}
    		
    	});
    	context.get().setPacketHandled(true);
    }
	
}
