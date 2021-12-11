package kittehmod.morecraft.network;

import java.util.function.Supplier;

import kittehmod.morecraft.client.gui.ModEditSignHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;

public class ModSignGUIPacket {
	
	private final BlockPos pos;
	
    public ModSignGUIPacket(BlockPos pos) {
    	this.pos = pos;
    }
    
    public static void encode(ModSignGUIPacket pkt, FriendlyByteBuf buf) {
    	buf.writeBlockPos(pkt.pos);
    }
    
    public static ModSignGUIPacket decode(FriendlyByteBuf buf) {
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
