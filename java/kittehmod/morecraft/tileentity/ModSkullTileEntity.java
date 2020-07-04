package kittehmod.morecraft.tileentity;

import javax.annotation.Nullable;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class ModSkullTileEntity extends TileEntity implements ITickableTileEntity {

	public ModSkullTileEntity() {
		super(ModTileEntityType.MOD_SKULL.get());
	}

	public void tick() {
		//Block block = this.getBlockState().getBlock();
	}

   /**
    * Retrieves packet to send to the client whenever this Tile Entity is resynced via World.notifyBlockUpdate. For
    * modded TE's, this packet comes back to you clientside in {@link #onDataPacket}
    */
	@Nullable
	public SUpdateTileEntityPacket getUpdatePacket() {
		return new SUpdateTileEntityPacket(this.pos, 4, this.getUpdateTag());
	}

   /**
    * Get an NBT compound to sync to the client with SPacketChunkData, used for initial loading of the chunk or when
    * many blocks change at once. This compound comes back to you clientside in {@link handleUpdateTag}
    */
	public CompoundNBT getUpdateTag() {
		return this.write(new CompoundNBT());
	}

}
