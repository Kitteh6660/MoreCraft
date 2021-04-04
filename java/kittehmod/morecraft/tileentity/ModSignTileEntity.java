package kittehmod.morecraft.tileentity;

import java.util.function.Function;
import javax.annotation.Nullable;

import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.block.BlockState;
import net.minecraft.command.CommandSource;
import net.minecraft.command.ICommandSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModSignTileEntity extends TileEntity
{
	public final ITextComponent[] signText = new ITextComponent[] { new StringTextComponent(""), new StringTextComponent(""), new StringTextComponent(""), new StringTextComponent("") };
	@OnlyIn(Dist.CLIENT)
	private boolean field_214070_b;
	private int lineBeingEdited = -1;
	private int field_214071_g = -1;
	private int field_214072_h = -1;
	private boolean isEditable = true;
	private PlayerEntity player;
	private final IReorderingProcessor[] renderText = new IReorderingProcessor[4];
	private DyeColor textColor = DyeColor.BLACK;

	public ModSignTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	public ModSignTileEntity() {
		super(ModTileEntityType.MOD_SIGN.get());
	}

	@Override
	public CompoundNBT save(CompoundNBT compound) {
		super.save(compound);
		for (int i = 0; i < 4; ++i) {
			String s = ITextComponent.Serializer.toJson(this.signText[i]);
			compound.putString("Text" + (i + 1), s);
		}
		compound.putString("Color", this.textColor.getName());
		return compound;
	}

	@Override
	public void load(BlockState state, CompoundNBT compound) {
		this.isEditable = false;
		super.load(state, compound);
		this.textColor = DyeColor.byName(compound.getString("Color"), DyeColor.BLACK);

		for (int i = 0; i < 4; ++i) {
			String s = compound.getString("Text" + (i + 1));
			ITextComponent itextcomponent = ITextComponent.Serializer.fromJson(s.isEmpty() ? "\"\"" : s);
			if (this.level instanceof ServerWorld) {
				try {
					this.signText[i] = TextComponentUtils.updateForEntity(this.getCommandSource((ServerPlayerEntity) null), itextcomponent, (Entity) null, 0);
				} catch (CommandSyntaxException var6) {
					this.signText[i] = itextcomponent;
				}
			} else {
				this.signText[i] = itextcomponent;
			}

			this.renderText[i] = null;
		}

	}

	@OnlyIn(Dist.CLIENT)
	public ITextComponent getText(int line) {
		return this.signText[line];
	}

	public void setText(int line, ITextComponent p_212365_2_) {
		this.signText[line] = p_212365_2_;
		this.renderText[line] = null;
	}

	@Nullable
	@OnlyIn(Dist.CLIENT)
	public IReorderingProcessor getRenderMessage(int p_242686_1_, Function<ITextComponent, IReorderingProcessor> p_242686_2_) {
		if (this.renderText[p_242686_1_] == null && this.signText[p_242686_1_] != null) {
			this.renderText[p_242686_1_] = p_242686_2_.apply(this.signText[p_242686_1_]);
		}

		return this.renderText[p_242686_1_];
	}

	/**
	 * Retrieves packet to send to the client whenever this Tile Entity is resynced
	 * via World.notifyBlockUpdate. For modded TE's, this packet comes back to you
	 * clientside in {@link #onDataPacket}
	 */
	@Nullable
	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		return new SUpdateTileEntityPacket(this.worldPosition, 1, this.getUpdateTag());
	}

	/**
	 * Get an NBT compound to sync to the client with SPacketChunkData, used for
	 * initial loading of the chunk or when many blocks change at once. This
	 * compound comes back to you clientside in {@link handleUpdateTag}
	 */
	@Override
	public CompoundNBT getUpdateTag() {
		return this.save(new CompoundNBT());
	}
	
	@Override
	public void handleUpdateTag(BlockState state, CompoundNBT compound) {
		this.load(state, compound);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		// Handle your Data
		BlockState blockState = level.getBlockState(worldPosition);
		this.load(blockState, pkt.getTag());
		//MorecraftPacketHandler.sendToServerSync(new ModUpdateTileEntityPacket(this.pos, this.getUpdateTag()));
	}

	/**
	 * Checks if players can use this tile entity to access operator (permission
	 * level 2) commands either directly or indirectly, such as give or setblock. A
	 * similar method exists for entities at
	 * {@link net.minecraft.entity.Entity#ignoreItemEntityData()}.
	 * <p>
	 * For example,
	 * {@link net.minecraft.tileentity.TileEntitySign#onlyOpsCanSetNbt() signs}
	 * (player right-clicking) and
	 * {@link net.minecraft.tileentity.TileEntityCommandBlock#onlyOpsCanSetNbt()
	 * command blocks} are considered accessible.
	 * </p>
	 * 
	 * @return true if this block entity offers ways for unauthorized players to use
	 *         restricted commands
	 */
	public boolean onlyOpsCanSetNbt() {
		return true;
	}

	public boolean getIsEditable() {
		return this.isEditable;
	}

	/**
	 * Sets the sign's isEditable flag to the specified parameter.
	 */
	@OnlyIn(Dist.CLIENT)
	public void setEditable(boolean isEditableIn) {
		this.isEditable = isEditableIn;
		if (!isEditableIn) {
			this.player = null;
		}

	}

	public void setPlayer(PlayerEntity playerIn) {
		this.player = playerIn;
	}

	public PlayerEntity getPlayer() {
		return this.player;
	}

	public boolean executeCommand(PlayerEntity playerIn) {
		for (ITextComponent itextcomponent : this.signText) {
			Style style = itextcomponent == null ? null : itextcomponent.getStyle();
			if (style != null && style.getClickEvent() != null) {
				ClickEvent clickevent = style.getClickEvent();
				if (clickevent.getAction() == ClickEvent.Action.RUN_COMMAND) {
					playerIn.getServer().getCommands().performCommand(this.getCommandSource((ServerPlayerEntity) playerIn), clickevent.getValue());
				}
			}
		}

		return true;
	}

	public CommandSource getCommandSource(@Nullable ServerPlayerEntity playerIn) {
		String s = playerIn == null ? "Sign" : playerIn.getName().getString();
		ITextComponent itextcomponent = (ITextComponent) (playerIn == null ? new StringTextComponent("Sign") : playerIn.getDisplayName());
		return new CommandSource(ICommandSource.NULL, new Vector3d((double) this.getBlockPos().getX() + 0.5D, (double) this.getBlockPos().getY() + 0.5D, (double) this.getBlockPos().getZ() + 0.5D), Vector2f.ZERO, (ServerWorld) this.level, 2, s, itextcomponent, this.level
				.getServer(), playerIn);
	}

	public DyeColor getTextColor() {
		return this.textColor;
	}

	public boolean setTextColor(DyeColor newColor) {
		if (newColor != this.getTextColor()) {
			this.textColor = newColor;
			this.setChanged();
			this.level.sendBlockUpdated(this.getBlockPos(), this.level.getBlockState(this.getBlockPos()), this.getBlockState(), 3);
			return true;
		} else {
			return false;
		}
	}

	@OnlyIn(Dist.CLIENT)
	public void func_214062_a(int p_214062_1_, int p_214062_2_, int p_214062_3_, boolean p_214062_4_) {
		this.lineBeingEdited = p_214062_1_;
		this.field_214071_g = p_214062_2_;
		this.field_214072_h = p_214062_3_;
		this.field_214070_b = p_214062_4_;
	}

	@OnlyIn(Dist.CLIENT)
	public void func_214063_g() {
		this.lineBeingEdited = -1;
		this.field_214071_g = -1;
		this.field_214072_h = -1;
		this.field_214070_b = false;
	}

	@OnlyIn(Dist.CLIENT)
	public boolean func_214069_r() {
		return this.field_214070_b;
	}

	@OnlyIn(Dist.CLIENT)
	public int getLineBeingEdited() {
		return this.lineBeingEdited;
	}

	@OnlyIn(Dist.CLIENT)
	public int func_214065_t() {
		return this.field_214071_g;
	}

	@OnlyIn(Dist.CLIENT)
	public int func_214067_u() {
		return this.field_214072_h;
	}

}
