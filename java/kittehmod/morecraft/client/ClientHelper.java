package kittehmod.morecraft.client;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientHelper {
	
	public static final ResourceLocation NETHERWOOD_SIGN_LOCATION = new ResourceLocation(MoreCraft.MODID, "entity/signs/netherwood");

	public static final ResourceLocation NETHERWOOD_CHEST = new ResourceLocation(MoreCraft.MODID, "entity/chest/netherwood");
	public static final ResourceLocation NETHERWOOD_CHEST_LEFT = new ResourceLocation(MoreCraft.MODID, "entity/chest/netherwood_left");
	public static final ResourceLocation NETHERWOOD_CHEST_RIGHT = new ResourceLocation(MoreCraft.MODID, "entity/chest/netherwood_right");
	public static final ResourceLocation NETHERWOOD_CHEST_TRAPPED = new ResourceLocation(MoreCraft.MODID, "entity/chest/netherwood_trapped");
	public static final ResourceLocation NETHERWOOD_CHEST_TRAPPED_LEFT = new ResourceLocation(MoreCraft.MODID, "entity/chest/netherwood_trapped_left");
	public static final ResourceLocation NETHERWOOD_CHEST_TRAPPED_RIGHT = new ResourceLocation(MoreCraft.MODID, "entity/chest/netherwood_trapped_right");

	public static final ResourceLocation ENDERDRAGON_ARMOUR_TEXTURE = new ResourceLocation(MoreCraft.MODID, "models/armor/enderdragon");
	
	public static final ModelLayerLocation ENDERDRAGON_ARMOUR_LAYER = new ModelLayerLocation(new ResourceLocation("morecraft", "armor/enderdragon"), "main");
	
	
	@SubscribeEvent
	public static void onStitch(TextureStitchEvent.Pre event) {
		if (event.getMap().location().equals(Sheets.SIGN_SHEET)) {
			event.addSprite(NETHERWOOD_SIGN_LOCATION);
		}
		else if (event.getMap().location().equals(Sheets.CHEST_SHEET)) {
			event.addSprite(NETHERWOOD_CHEST);
			event.addSprite(NETHERWOOD_CHEST_LEFT);
			event.addSprite(NETHERWOOD_CHEST_RIGHT);
			event.addSprite(NETHERWOOD_CHEST_TRAPPED);
			event.addSprite(NETHERWOOD_CHEST_TRAPPED_LEFT);
			event.addSprite(NETHERWOOD_CHEST_TRAPPED_RIGHT);
		}
	}
	
	public static ResourceLocation chooseChestTexture(ChestType type, Boolean trapped) {
		if (type == ChestType.SINGLE) {
			return trapped ? NETHERWOOD_CHEST_TRAPPED : NETHERWOOD_CHEST;
		}
		else if (type == ChestType.LEFT) {
			return trapped ? NETHERWOOD_CHEST_TRAPPED_LEFT : NETHERWOOD_CHEST_LEFT;
		}
		else if (type == ChestType.RIGHT) {
			return trapped ? NETHERWOOD_CHEST_TRAPPED_RIGHT : NETHERWOOD_CHEST_RIGHT;
		}
		else {
			return trapped ? NETHERWOOD_CHEST_TRAPPED : NETHERWOOD_CHEST;
		}
	}
}