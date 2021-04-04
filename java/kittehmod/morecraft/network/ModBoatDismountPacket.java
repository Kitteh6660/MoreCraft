package kittehmod.morecraft.network;

import java.util.function.Supplier;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class ModBoatDismountPacket {
	
    public ModBoatDismountPacket() {

    }
    
    public static void encode(ModBoatDismountPacket pkt, PacketBuffer buf) {}
    
    public static ModBoatDismountPacket decode(PacketBuffer buf) { return new ModBoatDismountPacket(); }
    
    public static void handle(final ModBoatDismountPacket message, Supplier<NetworkEvent.Context> context) {
    	context.get().enqueueWork(() -> {
    		if (context.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
    			PlayerEntity player = context.get().getSender();
    			player.clearFire();
    		}
    	});
    	context.get().setPacketHandled(true);
    }
	
}

