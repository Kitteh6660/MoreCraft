package kittehmod.morecraft.client;

import kittehmod.morecraft.block.ModBlocks;
import kittehmod.morecraft.block.ModWoodType;
import kittehmod.morecraft.blockentity.ModBlockEntityType;
import kittehmod.morecraft.client.gui.BookcaseScreen;
import kittehmod.morecraft.client.gui.CrateScreen;
import kittehmod.morecraft.client.gui.KilnScreen;
import kittehmod.morecraft.client.renderer.ModChestRenderer;
import kittehmod.morecraft.client.renderer.ModSignRenderer;
import kittehmod.morecraft.client.renderer.NetherBoatRenderer;
import kittehmod.morecraft.container.ModContainerType;
import kittehmod.morecraft.entity.ModEntities;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.MinecartRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ClientRenderSetup
{

	public static void setup() {
		Sheets.addWoodType(ModWoodType.NETHERWOOD);

		// Nether Boats
		EntityRenderers.register(ModEntities.CRIMSON_BOAT.get(), NetherBoatRenderer::new);
		EntityRenderers.register(ModEntities.WARPED_BOAT.get(), NetherBoatRenderer::new);
		EntityRenderers.register(ModEntities.NETHERWOOD_BOAT.get(), NetherBoatRenderer::new);

		// Minecarts with Crafting Table
		EntityRenderers.register(ModEntities.OAK_CRAFTING_TABLE_MINECART.get(), (entity) -> { return new MinecartRenderer<>(entity, ModelLayers.CHEST_MINECART); });
		EntityRenderers.register(ModEntities.SPRUCE_CRAFTING_TABLE_MINECART.get(), (entity) -> { return new MinecartRenderer<>(entity, ModelLayers.CHEST_MINECART); });
		EntityRenderers.register(ModEntities.BIRCH_CRAFTING_TABLE_MINECART.get(), (entity) -> { return new MinecartRenderer<>(entity, ModelLayers.CHEST_MINECART); });
		EntityRenderers.register(ModEntities.JUNGLE_CRAFTING_TABLE_MINECART.get(), (entity) -> { return new MinecartRenderer<>(entity, ModelLayers.CHEST_MINECART); });
		EntityRenderers.register(ModEntities.ACACIA_CRAFTING_TABLE_MINECART.get(), (entity) -> { return new MinecartRenderer<>(entity, ModelLayers.CHEST_MINECART); });
		EntityRenderers.register(ModEntities.DARK_OAK_CRAFTING_TABLE_MINECART.get(), (entity) -> { return new MinecartRenderer<>(entity, ModelLayers.CHEST_MINECART); });
		EntityRenderers.register(ModEntities.CRIMSON_CRAFTING_TABLE_MINECART.get(), (entity) -> { return new MinecartRenderer<>(entity, ModelLayers.CHEST_MINECART); });
		EntityRenderers.register(ModEntities.WARPED_CRAFTING_TABLE_MINECART.get(), (entity) -> { return new MinecartRenderer<>(entity, ModelLayers.CHEST_MINECART); });
		EntityRenderers.register(ModEntities.NETHERWOOD_CRAFTING_TABLE_MINECART.get(), (entity) -> { return new MinecartRenderer<>(entity, ModelLayers.CHEST_MINECART); });
		
		// GUIs
		MenuScreens.register(ModContainerType.KILN.get(), KilnScreen::new);
		MenuScreens.register(ModContainerType.CRATE.get(), CrateScreen::new);
		MenuScreens.register(ModContainerType.BOOKCASE.get(), BookcaseScreen::new);
		
		// Block Entities (Formerly Tile Entities)
		BlockEntityRenderers.register(ModBlockEntityType.NETHERWOOD_CHEST.get(), ModChestRenderer::new);
		BlockEntityRenderers.register(ModBlockEntityType.NETHERWOOD_TRAPPED_CHEST.get(), ModChestRenderer::new);
		BlockEntityRenderers.register(ModBlockEntityType.MOD_SIGN.get(), ModSignRenderer::new);

		// For blocks that are transparent or non-solid.
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERWOOD_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERBRICK_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERITE_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.GLASS_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.BONE_DOOR.get(), RenderType.cutout());

		ItemBlockRenderTypes.setRenderLayer(ModBlocks.TALL_NETHERWOOD_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.TALL_NETHERBRICK_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.TALL_NETHERITE_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.TALL_GLASS_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.TALL_BONE_DOOR.get(), RenderType.cutout());
		
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERWOOD_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERBRICK_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERITE_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.GLASS_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.BONE_TRAPDOOR.get(), RenderType.cutout());
		
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOUL_GLASS.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOUL_GLASS_PANE.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.BONE_LADDER.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.FLESH_CARPET.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERWOOD_LADDER.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERWOOD_LEAVES.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.GLOWSTONE_TORCH.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.WALL_GLOWSTONE_TORCH.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.GLOWSTONE_LANTERN.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERWOOD_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERWOOD_LEAF_CARPET.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERWOOD_HEDGE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_NETHERWOOD_SAPLING.get(), RenderType.cutout());

		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERWOOD_POST.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.STRIPPED_NETHERWOOD_POST.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERWOOD_HEDGE.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERWOOD_LEAF_CARPET.get(), RenderType.cutout());
	}

}
