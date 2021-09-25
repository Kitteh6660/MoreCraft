package kittehmod.morecraft.network;

import java.util.function.Supplier;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fmllegacy.network.NetworkDirection;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

public class ModBoatDismountPacket {
	
    public ModBoatDismountPacket() {

    }
    
    public static void encode(ModBoatDismountPacket pkt, FriendlyByteBuf buf) {}
    
    public static ModBoatDismountPacket decode(FriendlyByteBuf buf) { return new ModBoatDismountPacket(); }
    
    public static void handle(final ModBoatDismountPacket message, Supplier<NetworkEvent.Context> context) {
    	context.get().enqueueWork(() -> {
    		if (context.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
    			Player player = context.get().getSender();
    			player.clearFire();
    		}
    	});
    	context.get().setPacketHandled(true);
    }
	
}

