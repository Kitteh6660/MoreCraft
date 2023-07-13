package kittehmod.morecraft.client;

import kittehmod.morecraft.block.ModWoodType;
import kittehmod.morecraft.client.gui.BookcaseScreen;
import kittehmod.morecraft.client.gui.CrateScreen;
import kittehmod.morecraft.client.gui.KilnScreen;
import kittehmod.morecraft.client.renderer.ModChestRenderer;
import kittehmod.morecraft.client.renderer.NetherBoatRenderer;
import kittehmod.morecraft.client.renderer.WardenSkullBlockRenderer;
import kittehmod.morecraft.container.ModContainerType;
import kittehmod.morecraft.entity.ModEntities;
import kittehmod.morecraft.init.ModBlockEntityType;
import kittehmod.morecraft.init.ModBlocks;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ClientRenderSetup
{

	@SuppressWarnings("deprecation")
	public static void setup() {
		Sheets.addWoodType(ModWoodType.NETHERWOOD);

		// Nether Boats
		EntityRenderers.register(ModEntities.NETHER_BOAT.get(), (boat) -> {return new NetherBoatRenderer(boat, false); } );
		EntityRenderers.register(ModEntities.NETHER_CHEST_BOAT.get(), (boat) -> {return new NetherBoatRenderer(boat, true); });

		// GUIs
		MenuScreens.register(ModContainerType.KILN.get(), KilnScreen::new);
		MenuScreens.register(ModContainerType.CRATE.get(), CrateScreen::new);
		MenuScreens.register(ModContainerType.BOOKCASE.get(), BookcaseScreen::new);
		
		// Block Entities (Formerly Tile Entities)
		BlockEntityRenderers.register(ModBlockEntityType.NETHERWOOD_CHEST.get(), ModChestRenderer::new);
		BlockEntityRenderers.register(ModBlockEntityType.NETHERWOOD_TRAPPED_CHEST.get(), ModChestRenderer::new);
		BlockEntityRenderers.register(ModBlockEntityType.MOD_SIGN.get(), SignRenderer::new);
		BlockEntityRenderers.register(ModBlockEntityType.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
		BlockEntityRenderers.register(ModBlockEntityType.WARDEN_HEAD.get(), WardenSkullBlockRenderer::new);

		// For blocks that are transparent or non-solid.
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERWOOD_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERBRICK_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERITE_DOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.GLASS_DOOR.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOUL_GLASS_DOOR.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.BONE_DOOR.get(), RenderType.cutout());
		
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERWOOD_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERBRICK_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERITE_TRAPDOOR.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.GLASS_TRAPDOOR.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOUL_GLASS_TRAPDOOR.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.BONE_TRAPDOOR.get(), RenderType.cutout());
		
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOUL_GLASS.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOUL_GLASS_PANE.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.BONE_LADDER.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.FLESH_CARPET.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERWOOD_LADDER.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.NETHERWOOD_LEAVES.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.GLOW_INK_TORCH.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.WALL_GLOW_INK_TORCH.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.GLOWSTONE_TORCH.get(), RenderType.cutout());
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
