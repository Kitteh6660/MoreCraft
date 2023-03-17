package kittehmod.morecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.client.ClientHelper;
import kittehmod.morecraft.client.model.EnderdragonArmorWingsModel;
import kittehmod.morecraft.init.ModItems;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.item.ItemStack;

public class EnderdragonArmorWingsLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M>
{
	public static final ResourceLocation WINGED_ENDERDRAGON_ARMOUR_TEXTURE = new ResourceLocation(MoreCraft.MODID, "textures/models/armor/winged_enderdragon_layer_1.png");
	private final EnderdragonArmorWingsModel<?> armourModel;

	public EnderdragonArmorWingsLayer(RenderLayerParent<T, M> parent, EntityModelSet modelset) {
		super(parent);
		this.armourModel = new EnderdragonArmorWingsModel<>(modelset.bakeLayer(ClientHelper.WINGED_ENDERDRAGON_ARMOUR_LAYER_LOCATION));
	}

	@SuppressWarnings("unchecked")
	@Override
	public void render(PoseStack posestack, MultiBufferSource mbs, int tick, T entity, float f1, float f2, float f3, float f4, float f5, float f6) {
		ItemStack itemstack = entity.getItemBySlot(EquipmentSlot.CHEST);
		if (shouldRender(itemstack, entity)) {
			ResourceLocation resourcelocation = WINGED_ENDERDRAGON_ARMOUR_TEXTURE;
			posestack.pushPose();
			if (entity.isFallFlying()) {
				posestack.scale(0.8F, 0.8F, 0.8F);
			}
			else {
				if (entity instanceof ArmorStand) {
					posestack.scale(0.7F, 0.7F, 0.7F); // Slightly shrink wings Z scale so you don't see the tips on the other side of 1 block thick wall.
				}
				else {
					posestack.scale(0.7F, 0.7F, 0.8F);
				}
			}
			posestack.translate(0.0D, 0.1D, 0D);
			this.getParentModel().copyPropertiesTo((EntityModel<T>) this.armourModel);
			this.armourModel.setupAnim(entity, f1, f2, f4, f5, f6);
			VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(mbs, RenderType.armorCutoutNoCull(resourcelocation), false, itemstack.hasFoil());
			this.armourModel.renderToBuffer(posestack, vertexconsumer, tick, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
			posestack.popPose();
		}
	}

	public boolean shouldRender(ItemStack stack, T entity) {
		return stack.getItem() == ModItems.WINGED_ENDERDRAGON_CHESTPLATE.get();
	}

}
