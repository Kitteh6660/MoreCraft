package kittehmod.morecraft.network;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent.Context;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class MorecraftPacketHandler {

	private static final String PROTOCOL_VERSION = "1";
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

	private static <MSG> void registerMessage(Class<MSG> type, BiConsumer<MSG, PacketBuffer> encoder, Function<PacketBuffer, MSG> decoder, BiConsumer<MSG, Supplier<Context>> consumer) {
		HANDLER.registerMessage(index++, type, encoder, decoder, consumer);
	}
	
	public static void sendToServerSync(Object msg)
	{
		sendToServer(msg);
		sendToAllPlayers(msg);
	}
	
	public static void sendToServerAndOneClient(Object msg, NetworkManager netManager)
	{
		sendToServer(msg);
		sendToByNetManager(msg, netManager);
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
	public static void sendTo(Object msg, ServerPlayerEntity player)
	{
		MoreCraft.LOGGER.info("Sending to " + player);
		if (!(player instanceof FakePlayer))
		{
			HANDLER.sendTo(msg, player.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
		}
	}
	
	public static void sendToByNetManager(Object msg, NetworkManager netManager)
	{
		HANDLER.sendTo(msg, netManager, NetworkDirection.PLAY_TO_CLIENT);
	}
	
	public static void sendToAllPlayers(Object msg) {
		HANDLER.send(PacketDistributor.ALL.noArg(), msg);
	}
	
}
