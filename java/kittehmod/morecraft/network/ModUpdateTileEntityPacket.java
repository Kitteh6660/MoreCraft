package kittehmod.morecraft.network;

import java.util.function.Supplier;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class ModUpdateTileEntityPacket {
	
	private final BlockPos blockPos;
	private final CompoundNBT nbt;

    public ModUpdateTileEntityPacket(BlockPos blockPosIn, CompoundNBT compoundIn) {
        this.blockPos = blockPosIn;
        //this.tileEntityType = tileEntityTypeIn;
        this.nbt = compoundIn;
    }

    public static void encode(ModUpdateTileEntityPacket msg, PacketBuffer buf) {
    	MoreCraft.LOGGER.info("Encoding packet for ModUpdateTileEntityPacket...");
    	buf.writeBlockPos(msg.blockPos);
    	buf.writeCompoundTag(msg.nbt);
    }
    
    public static ModUpdateTileEntityPacket decode(PacketBuffer buf) {
    	MoreCraft.LOGGER.info("Decoding packet for ModUpdateTileEntityPacket...");
    	return new ModUpdateTileEntityPacket(buf.readBlockPos(), buf.readCompoundTag());
    }
	
    public static class Handler {
    	
	    public static void handle(final ModUpdateTileEntityPacket message, Supplier<NetworkEvent.Context> context) {
	    	context.get().enqueueWork(() -> {
	    		World world;
	    		TileEntity te;
	    		if (context.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
		    		MoreCraft.LOGGER.info("Getting NBT info:\n" + message.nbt);
		    		world = context.get().getSender().getEntityWorld();
		    		te = world.getTileEntity(message.blockPos);
		    		if (te != null) {
			    		te.write(message.nbt);
			    		te.read(te.getUpdateTag()); //Now read to make sure it's set.
		    		}
	    		}
	    		else {
	    			Minecraft minecraft = Minecraft.getInstance();
	    			ClientPlayerEntity player = minecraft.player;
	    			world = player.getEntityWorld();
	    			te = world.getTileEntity(message.blockPos);
	    			te.read(message.nbt);
	    			world.notifyBlockUpdate(message.blockPos, te.getBlockState(), te.getBlockState(), 3);
	    		}
	        });
	    	context.get().setPacketHandled(true);
	    }
	    
    }
    
}
