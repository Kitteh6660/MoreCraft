package kittehmod.morecraft.client.renderer;

import java.util.Map;
import java.util.stream.Stream;

import org.joml.Quaternionf;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Axis;

import kittehmod.morecraft.entity.NetherBoat;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NetherBoatRenderer extends EntityRenderer<NetherBoat>
{
	/** instance of ModelBoat for rendering */
	private final Map<NetherBoat.Type, Pair<ResourceLocation, BoatModel>> boatResources;

	public NetherBoatRenderer(EntityRendererProvider.Context context, boolean isChest) {
		super(context);
		this.shadowRadius = 0.8F;
		this.boatResources = Stream.of(NetherBoat.Type.values()).collect(ImmutableMap.toImmutableMap((map) -> {
			return map;
		}, (boattype) -> {
			return Pair.of(new ResourceLocation("morecraft", getTextureLocation(boattype, isChest)), this.createBoatModel(context, boattype, isChest));
		}));
	}

	private BoatModel createBoatModel(EntityRendererProvider.Context context, NetherBoat.Type boatType, boolean isChest) {
		ModelLayerLocation modellayerlocation = isChest ? createChestBoatModelName(boatType) : createBoatModelName(boatType);
		ModelPart modelpart = context.bakeLayer(modellayerlocation);
		return isChest ? new ChestBoatModel(modelpart) : new BoatModel(modelpart);
	}

	private static String getTextureLocation(NetherBoat.Type boatType, boolean isChest) {
		return isChest ? "textures/entity/chest_boat/" + boatType.getName() + ".png" : "textures/entity/boat/" + boatType.getName() + ".png";
	}
	
	/** Renders the desired {@code T} type Entity. */
	@Override
	public void render(NetherBoat entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
		matrixStackIn.pushPose();
		matrixStackIn.translate(0.0D, 0.375D, 0.0D);
		matrixStackIn.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));
		float f = (float) entityIn.getHurtTime() - partialTicks;
		float f1 = entityIn.getDamage() - partialTicks;
		if (f1 < 0.0F) {
			f1 = 0.0F;
		}

		if (f > 0.0F) {
			matrixStackIn.mulPose(Axis.XP.rotationDegrees(Mth.sin(f) * f * f1 / 10.0F * (float) entityIn.getHurtDir()));
		}

		float f2 = entityIn.getBubbleAngle(partialTicks);
		if (!Mth.equal(f2, 0.0F)) {
			matrixStackIn.mulPose((new Quaternionf()).setAngleAxis(entityIn.getBubbleAngle(partialTicks) * ((float)Math.PI / 180F), 1.0F, 0.0F, 1.0F));
		}

		Pair<ResourceLocation, BoatModel> pair = getModelWithLocation(entityIn);
		ResourceLocation resourcelocation = pair.getFirst();
		BoatModel boatmodel = pair.getSecond();
		matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
		matrixStackIn.mulPose(Axis.YP.rotationDegrees(90.0F));
		boatmodel.setupAnim(entityIn, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
		VertexConsumer vertexconsumer = bufferIn.getBuffer(boatmodel.renderType(resourcelocation));
		boatmodel.renderToBuffer(matrixStackIn, vertexconsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		if (!entityIn.isUnderWater()) {
			VertexConsumer vertexconsumer1 = bufferIn.getBuffer(RenderType.waterMask());
			boatmodel.waterPatch().render(matrixStackIn, vertexconsumer1, packedLightIn, OverlayTexture.NO_OVERLAY);
		}

		matrixStackIn.popPose();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(NetherBoat entity) {
		switch (entity.getNetherBoatType()) {
			case NETHERWOOD:
				return new ResourceLocation("morecraft:textures/entity/boat/netherwood.png");
			case WARPED:
				return new ResourceLocation("morecraft:textures/entity/boat/warped.png");
			case CRIMSON:
				return new ResourceLocation("morecraft:textures/entity/boat/crimson.png");
			default:
				return new ResourceLocation("morecraft:textures/entity/boat/netherwood.png");
		}
	}

	public Pair<ResourceLocation, BoatModel> getModelWithLocation(NetherBoat boat) { return this.boatResources.get(boat.getNetherBoatType()); }
	
	private static ModelLayerLocation createLocation(String path, String p_171302_) {
		return new ModelLayerLocation(new ResourceLocation("minecraft", path), p_171302_);
		//return new ModelLayerLocation(new ResourceLocation("morecraft", p_171301_), p_171302_);
	}

	public static ModelLayerLocation createBoatModelName(NetherBoat.Type p_171290_) {
		return createLocation("boat/oak", "main");
		//return createLocation("boat/" + p_171290_.getName(), "main");
	}

	public static ModelLayerLocation createChestBoatModelName(NetherBoat.Type p_233551_) {
		return createLocation("chest_boat/oak", "main");
		//return createLocation("chest_boat/" + p_233551_.getName(), "main");
	}
}
