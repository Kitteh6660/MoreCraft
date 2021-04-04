package kittehmod.morecraft.client;

import kittehmod.morecraft.block.ModBlocks;
import kittehmod.morecraft.entity.ModEntities;
import kittehmod.morecraft.entity.NetherBoatEntity;
import kittehmod.morecraft.tileentity.ModTileEntityType;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MinecartRenderer;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientRenderSetup {

	@OnlyIn(Dist.CLIENT)
	public static void setup() {
		//Nether Boats
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.CRIMSON_BOAT.get(), new IRenderFactory<NetherBoatEntity>() {
        	@Override
			public EntityRenderer<? super NetherBoatEntity> createRenderFor(EntityRendererManager manager) { return new NetherBoatEntityRenderer(manager); }
		});
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.WARPED_BOAT.get(), new IRenderFactory<NetherBoatEntity>() {
        	@Override
			public EntityRenderer<? super NetherBoatEntity> createRenderFor(EntityRendererManager manager) { return new NetherBoatEntityRenderer(manager); }
		});
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.NETHERWOOD_BOAT.get(), new IRenderFactory<NetherBoatEntity>() {
        	@Override
			public EntityRenderer<? super NetherBoatEntity> createRenderFor(EntityRendererManager manager) { return new NetherBoatEntityRenderer(manager); }
		});
        //Minecarts with Crafting Table
		RenderingRegistry.registerEntityRenderingHandler(ModEntities.OAK_CRAFTING_TABLE_MINECART.get(), new IRenderFactory<AbstractMinecartEntity>() {
			@Override
			public EntityRenderer<? super AbstractMinecartEntity> createRenderFor(EntityRendererManager manager) { return new MinecartRenderer<>(manager); }
		});
		RenderingRegistry.registerEntityRenderingHandler(ModEntities.SPRUCE_CRAFTING_TABLE_MINECART.get(), new IRenderFactory<AbstractMinecartEntity>() {
			@Override
			public EntityRenderer<? super AbstractMinecartEntity> createRenderFor(EntityRendererManager manager) { return new MinecartRenderer<>(manager); }
		});
		RenderingRegistry.registerEntityRenderingHandler(ModEntities.BIRCH_CRAFTING_TABLE_MINECART.get(), new IRenderFactory<AbstractMinecartEntity>() {
			@Override
			public EntityRenderer<? super AbstractMinecartEntity> createRenderFor(EntityRendererManager manager) { return new MinecartRenderer<>(manager); }
		});
		RenderingRegistry.registerEntityRenderingHandler(ModEntities.JUNGLE_CRAFTING_TABLE_MINECART.get(), new IRenderFactory<AbstractMinecartEntity>() {
			@Override
			public EntityRenderer<? super AbstractMinecartEntity> createRenderFor(EntityRendererManager manager) { return new MinecartRenderer<>(manager); }
		});
		RenderingRegistry.registerEntityRenderingHandler(ModEntities.ACACIA_CRAFTING_TABLE_MINECART.get(), new IRenderFactory<AbstractMinecartEntity>() {
			@Override
			public EntityRenderer<? super AbstractMinecartEntity> createRenderFor(EntityRendererManager manager) { return new MinecartRenderer<>(manager); }
		});
		RenderingRegistry.registerEntityRenderingHandler(ModEntities.DARK_OAK_CRAFTING_TABLE_MINECART.get(), new IRenderFactory<AbstractMinecartEntity>() {
			@Override
			public EntityRenderer<? super AbstractMinecartEntity> createRenderFor(EntityRendererManager manager) { return new MinecartRenderer<>(manager); }
		});
		RenderingRegistry.registerEntityRenderingHandler(ModEntities.CRIMSON_CRAFTING_TABLE_MINECART.get(), new IRenderFactory<AbstractMinecartEntity>() {
			@Override
			public EntityRenderer<? super AbstractMinecartEntity> createRenderFor(EntityRendererManager manager) { return new MinecartRenderer<>(manager); }
		});
		RenderingRegistry.registerEntityRenderingHandler(ModEntities.WARPED_CRAFTING_TABLE_MINECART.get(), new IRenderFactory<AbstractMinecartEntity>() {
			@Override
			public EntityRenderer<? super AbstractMinecartEntity> createRenderFor(EntityRendererManager manager) { return new MinecartRenderer<>(manager); }
		});
		RenderingRegistry.registerEntityRenderingHandler(ModEntities.NETHERWOOD_CRAFTING_TABLE_MINECART.get(), new IRenderFactory<AbstractMinecartEntity>() {
			@Override
			public EntityRenderer<? super AbstractMinecartEntity> createRenderFor(EntityRendererManager manager) { return new MinecartRenderer<>(manager); }
		});
        
		// This is for rendering entities and so forth later on
		ClientRegistry.bindTileEntityRenderer(ModTileEntityType.NETHERWOOD_CHEST.get(), NetherwoodChestTileEntityRenderer::new);
		ClientRegistry.bindTileEntityRenderer(ModTileEntityType.NETHERWOOD_TRAPPED_CHEST.get(), NetherwoodChestTileEntityRenderer::new);
		ClientRegistry.bindTileEntityRenderer(ModTileEntityType.MOD_SIGN.get(), NetherwoodSignTileEntityRenderer::new);
		
		RenderTypeLookup.setRenderLayer(ModBlocks.NETHERWOOD_DOOR.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.NETHERBRICK_DOOR.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.NETHERITE_DOOR.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.GLASS_DOOR.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.BONE_DOOR.get(), RenderType.cutout());
		
		RenderTypeLookup.setRenderLayer(ModBlocks.SOUL_GLASS.get(), RenderType.cutoutMipped());
		RenderTypeLookup.setRenderLayer(ModBlocks.SOUL_GLASS_PANE.get(), RenderType.cutoutMipped());
		RenderTypeLookup.setRenderLayer(ModBlocks.BONE_LADDER.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.FLESH_CARPET.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.NETHERWOOD_LADDER.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.NETHERWOOD_LEAVES.get(), RenderType.cutoutMipped());
		RenderTypeLookup.setRenderLayer(ModBlocks.NETHERWOOD_TRAPDOOR.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.NETHERITE_TRAPDOOR.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.GLOWSTONE_TORCH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.WALL_GLOWSTONE_TORCH.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.GLOWSTONE_LANTERN.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.NETHERWOOD_SAPLING.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.NETHERWOOD_LEAF_CARPET.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.NETHERWOOD_HEDGE.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_NETHERWOOD_SAPLING.get(), RenderType.cutout());

		RenderTypeLookup.setRenderLayer(ModBlocks.NETHERWOOD_POST.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.STRIPPED_NETHERWOOD_POST.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(ModBlocks.NETHERWOOD_HEDGE.get(), RenderType.cutoutMipped());
		RenderTypeLookup.setRenderLayer(ModBlocks.NETHERWOOD_LEAF_CARPET.get(), RenderType.cutout());
		
	}
	
}
