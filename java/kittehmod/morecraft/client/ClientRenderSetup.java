package kittehmod.morecraft.client;

import kittehmod.morecraft.block.ModBlocks;
import kittehmod.morecraft.entity.ModEntities;
import kittehmod.morecraft.entity.NetherBoatEntity;
import kittehmod.morecraft.tileentity.ModTileEntityType;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientRenderSetup {

	@OnlyIn(Dist.CLIENT)
	public static void setup() {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.NETHERWOOD_BOAT.get(), new IRenderFactory<NetherBoatEntity>() {
        	@Override
			public EntityRenderer<? super NetherBoatEntity> createRenderFor(EntityRendererManager manager) { return new NetherBoatEntityRenderer(manager); }
		});
		
		// This is for rendering entities and so forth later on
		ClientRegistry.bindTileEntityRenderer(ModTileEntityType.NETHERWOOD_CHEST.get(), NetherwoodChestTileEntityRenderer::new);
		ClientRegistry.bindTileEntityRenderer(ModTileEntityType.NETHERWOOD_TRAPPED_CHEST.get(), NetherwoodChestTileEntityRenderer::new);
		ClientRegistry.bindTileEntityRenderer(ModTileEntityType.MOD_SIGN.get(), NetherwoodSignTileEntityRenderer::new);
		//ClientRegistry.bindTileEntityRenderer(TileEntityType.Builder.create(ModSkullTileEntity::new, ModBlocks.SPIDER_HEAD.get(), ModBlocks.CAVE_SPIDER_HEAD.get(), ModBlocks.ZOMBIE_PIGMAN_HEAD.get(), ModBlocks.BLAZE_HEAD.get(), ModBlocks.ENDERMAN_HEAD.get()).build(null), ModSkullTileEntityRenderer::new);
		
		RenderTypeLookup.setRenderLayer(ModBlocks.NETHERWOOD_DOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.NETHERBRICK_DOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.NETHERITE_DOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.GLASS_DOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.BONE_DOOR.get(), RenderType.getCutout());
		
		RenderTypeLookup.setRenderLayer(ModBlocks.SOUL_GLASS.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(ModBlocks.SOUL_GLASS_PANE.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(ModBlocks.BONE_LADDER.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.NETHERWOOD_TRAPDOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.NETHERWOOD_LEAVES.get(), RenderType.getCutoutMipped());
		RenderTypeLookup.setRenderLayer(ModBlocks.GLOWSTONE_TORCH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.WALL_GLOWSTONE_TORCH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.NETHERWOOD_SAPLING.get(), RenderType.getCutout());

	}
	
}
