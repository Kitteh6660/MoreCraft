package kittehmod.morecraft.network;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;

public class ModUpdateTileEntityPacket {
	
	private final BlockPos blockPos;
	private final CompoundTag nbt;

    public ModUpdateTileEntityPacket(BlockPos blockPosIn, CompoundTag compoundIn) {
        this.blockPos = blockPosIn;
        this.nbt = compoundIn;
    }

    public static void encode(ModUpdateTileEntityPacket msg, FriendlyByteBuf buf) {
    	buf.writeBlockPos(msg.blockPos);
    	buf.writeNbt(msg.nbt);
    }
    
    public static ModUpdateTileEntityPacket decode(FriendlyByteBuf buf) {
    	return new ModUpdateTileEntityPacket(buf.readBlockPos(), buf.readNbt());
    }
	
    public static class Handler {
    	
	    public static void handle(final ModUpdateTileEntityPacket message, Supplier<NetworkEvent.Context> context) {
	    	context.get().enqueueWork(() -> {
	    		Level world;
	    		BlockEntity te;
	    		if (context.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
		    		world = context.get().getSender().getLevel();
		    		te = world.getBlockEntity(message.blockPos);
		    		if (te != null && message.nbt != null) {
			    		te.save(message.nbt);
		    		}
	    		}
	        });
	    	context.get().setPacketHandled(true);
	    }
	    
    }
    
}
