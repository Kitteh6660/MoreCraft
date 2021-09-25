package kittehmod.morecraft.network;

import java.util.function.Supplier;

import kittehmod.morecraft.blockentity.ModSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.fmllegacy.network.NetworkDirection;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

//This is necessary for updating sign before writing to NBT as otherwise, the signs won't save and would be blank after load.
public class ModUpdateSignPacket {

	private final BlockPos blockPos;
	private final Component[] lines;
	private final int color;

    public ModUpdateSignPacket(BlockPos blockPosIn, Component line1, Component line2, Component line3, Component line4, int colorIn) {
        this.blockPos = blockPosIn;
        this.lines = new Component[]{line1, line2, line3, line4};
        this.color = colorIn;
    }

    public static void encode(ModUpdateSignPacket msg, FriendlyByteBuf buf) {
    	buf.writeBlockPos(msg.blockPos);
        for(int i = 0; i < 4; ++i) {
            buf.writeComponent(msg.lines[i]);
        }
        buf.writeInt(msg.color);
    }
    
    public static ModUpdateSignPacket decode(FriendlyByteBuf buf) {
    	return new ModUpdateSignPacket(buf.readBlockPos(), buf.readComponent(), buf.readComponent(), buf.readComponent(), buf.readComponent(), buf.readInt());
    }
	
    public static class Handler {
    	
		public static void handle(final ModUpdateSignPacket message, Supplier<NetworkEvent.Context> context) {
	    	context.get().enqueueWork(() -> {
	    		Level world;
	    		BlockEntity te;
	    		if (context.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
		    		world = context.get().getSender().getLevel();
		    		te = world.getBlockEntity(message.blockPos);
		    		if (te != null && te instanceof ModSignBlockEntity) {
		    			ModSignBlockEntity sign = (ModSignBlockEntity)te;
		    			for (int i = 0; i < 4; i++) {
		    				sign.setMessage(i, message.lines[i]);
		    			}
		    			sign.setColor(DyeColor.byId(message.color));
		    		}
	    		}
	    		if (context.get().getDirection() == NetworkDirection.PLAY_TO_CLIENT) {
	    			//No code here!
	    		}
	        });
	    	context.get().setPacketHandled(true);
	    }
	    
    }
	
}
