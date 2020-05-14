package kittehmod.morecraft.network;

import java.util.function.Supplier;

import kittehmod.morecraft.tileentity.NetherwoodSignTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.network.PacketBuffer;
//import net.minecraft.network.play.IServerPlayNetHandler;
//import net.minecraft.network.play.client.CUpdateSignPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class ModUpdateSignPacket /*extends CUpdateSignPacket*/ {
	
	private final BlockPos pos;
	private final ITextComponent[] lines;

	//Might be removed
    public ModUpdateSignPacket(BlockPos pos, ITextComponent line1, ITextComponent line2, ITextComponent line3, ITextComponent line4) {
        this.pos = pos;
        this.lines = new ITextComponent[]{line1, line2, line3, line4};
    }
    
    //public ModUpdateSignPacket() {}

    public static void encode(ModUpdateSignPacket msg, PacketBuffer buf) {
    	buf.writeBlockPos(msg.pos);
    	for (int i = 0; i < 4; i++) {
    		buf.writeTextComponent(msg.lines[i]);
    	}
    }
    
    public static ModUpdateSignPacket decode(PacketBuffer buf) {
    	return new ModUpdateSignPacket(buf.readBlockPos(), buf.readTextComponent(), buf.readTextComponent(), buf.readTextComponent(), buf.readTextComponent());
    }

    public static class Handler {
    	
	    public static void handle(final ModUpdateSignPacket message, Supplier<NetworkEvent.Context> context) {
	    	context.get().enqueueWork(() -> {
	    		World world;
	    		TileEntity te;
	    		if (context.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
	    			world = context.get().getSender().getEntityWorld();
	    			te = context.get().getSender().getEntityWorld().getTileEntity(message.pos);
		    		if (te instanceof NetherwoodSignTileEntity) {
		    			world.notifyBlockUpdate(message.pos, te.getBlockState(), te.getBlockState(), 3);
		    		}
	    		}
	    		else {
	    			Minecraft minecraft = Minecraft.getInstance();
	    			ClientPlayerEntity player = minecraft.player;
	    			world = player.getEntityWorld();
	    			te = world.getTileEntity(message.pos);
	    			if (te instanceof NetherwoodSignTileEntity) {
	    				for (int i = 0; i < 4; i++) {
	    					((NetherwoodSignTileEntity) te).setText(i, message.lines[i]);
	    				}
	    			}
	    		}
	        });
	    	context.get().setPacketHandled(true);
	    }
	    
    }
    
    /*public void writePacketData(PacketBuffer buf) throws IOException {
    	buf.writeBlockPos(this.pos);

        for(int i = 0; i < 4; ++i) {
        	buf.writeTextComponent(this.lines[i]);
        }

	}

	public void processPacket(IServerPlayNetHandler handler) {
    	 handler.processUpdateSign(this);
	}

	public BlockPos getPosition() {
		return this.pos;
	}

	public String[] getLines() {
		return this.lines;
	}*/
    
    
    
}
