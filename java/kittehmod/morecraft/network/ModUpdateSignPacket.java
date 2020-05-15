package kittehmod.morecraft.network;

import java.util.function.Supplier;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.tileentity.NetherwoodSignTileEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

//This is necessary for updating sign before writing to NBT as otherwise, the signs won't save and would be blank after load.
public class ModUpdateSignPacket {

	private final BlockPos blockPos;
	private final ITextComponent[] lines;

    public ModUpdateSignPacket(BlockPos blockPosIn, ITextComponent line1, ITextComponent line2, ITextComponent line3, ITextComponent line4) {
        this.blockPos = blockPosIn;
        this.lines = new ITextComponent[]{line1, line2, line3, line4};
    }

    public static void encode(ModUpdateSignPacket msg, PacketBuffer buf) {
    	MoreCraft.LOGGER.info("Encoding packet for ModUpdateTileEntityPacket...");
    	buf.writeBlockPos(msg.blockPos);
        for(int i = 0; i < 4; ++i) {
            buf.writeTextComponent(msg.lines[i]);
        }
    }
    
    public static ModUpdateSignPacket decode(PacketBuffer buf) {
    	MoreCraft.LOGGER.info("Decoding packet for ModUpdateTileEntityPacket...");
    	return new ModUpdateSignPacket(buf.readBlockPos(), buf.readTextComponent(), buf.readTextComponent(), buf.readTextComponent(), buf.readTextComponent());
    }
	
    public static class Handler {
    	
	    public static void handle(final ModUpdateSignPacket message, Supplier<NetworkEvent.Context> context) {
	    	context.get().enqueueWork(() -> {
	    		World world;
	    		TileEntity te;
	    		if (context.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
		    		world = context.get().getSender().getEntityWorld();
		    		te = world.getTileEntity(message.blockPos);
		    		if (te != null && te instanceof NetherwoodSignTileEntity) {
		    			NetherwoodSignTileEntity sign = (NetherwoodSignTileEntity)te;
		    			for (int i = 0; i < 4; i++) {
		    				sign.setText(i, message.lines[i]);
		    			}
		    		}
	    		}
	        });
	    	context.get().setPacketHandled(true);
	    }
	    
    }
	
}
