package kittehmod.morecraft.network;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.network.Connection;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fmllegacy.network.NetworkDirection;
import net.minecraftforge.fmllegacy.network.NetworkEvent;
import net.minecraftforge.fmllegacy.network.NetworkRegistry;
import net.minecraftforge.fmllegacy.network.PacketDistributor;
import net.minecraftforge.fmllegacy.network.simple.SimpleChannel;

public class MorecraftPacketHandler {

	private static final String PROTOCOL_VERSION = "2";
	public static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder
			.named(new ResourceLocation(MoreCraft.MODID, "main_channel"))
			.clientAcceptedVersions(PROTOCOL_VERSION::equals)
			.serverAcceptedVersions(PROTOCOL_VERSION::equals)
			.networkProtocolVersion(() -> PROTOCOL_VERSION)
			.simpleChannel();
	
	private static int index;
	
	public static void register() {
		registerMessage(ModBoatDismountPacket.class, ModBoatDismountPacket::encode, ModBoatDismountPacket::decode,  ModBoatDismountPacket::handle);
		registerMessage(ModSignGUIPacket.class, ModSignGUIPacket::encode, ModSignGUIPacket::decode,  ModSignGUIPacket::handle);
		registerMessage(ModUpdateSignPacket.class, ModUpdateSignPacket::encode, ModUpdateSignPacket::decode, ModUpdateSignPacket.Handler::handle);
		registerMessage(ModUpdateTileEntityPacket.class, ModUpdateTileEntityPacket::encode, ModUpdateTileEntityPacket::decode, ModUpdateTileEntityPacket.Handler::handle);
	}

	private static <MSG> void registerMessage(Class<MSG> type, BiConsumer<MSG, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, MSG> decoder, BiConsumer<MSG, Supplier<NetworkEvent.Context>> consumer) {
		HANDLER.registerMessage(index++, type, encoder, decoder, consumer);
	}
	
	/**
	 * Sends a packet to the server.<br>
	 * Must be called Client side. 
	 */
	public static void sendToServer(Object msg)
	{
		HANDLER.sendToServer(msg);
	}
	
	/**
	 * Send a packet to a specific player.<br>
	 * Must be called Server side. 
	 */
	public static void sendToClient(Object msg, ServerPlayer player)
	{
		if (!(player instanceof FakePlayer))
		{
			HANDLER.sendTo(msg, player.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
		}
	}
	
	public static void sendToByNetManager(Object msg, Connection netManager)
	{
		HANDLER.sendTo(msg, netManager, NetworkDirection.PLAY_TO_CLIENT);
	}
	
	public static void sendToAllPlayers(Object msg) {
		HANDLER.send(PacketDistributor.ALL.noArg(), msg);
	}
	
}
