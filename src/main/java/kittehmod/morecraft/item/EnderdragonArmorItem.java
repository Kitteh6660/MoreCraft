package kittehmod.morecraft.item;

import java.util.function.Consumer;

import kittehmod.morecraft.client.model.EnderdragonArmorModel;
import kittehmod.morecraft.client.model.EnderdragonLegsModel;
import kittehmod.morecraft.init.ModItems;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import net.minecraft.world.item.ElytraItem;

public class EnderdragonArmorItem extends ArmorItem
{
	public static final EnderdragonArmorModel<? extends HumanoidModel<?>> ENDERDRAGON_ARMOR_MODEL = new EnderdragonArmorModel<HumanoidModel<LivingEntity>>();
	
	public ArmorMaterial material;
		
	public EnderdragonArmorItem(ArmorMaterial materialIn, Type slot, Item.Properties builder) {
		super(materialIn, slot, builder);
	}

	public ArmorMaterial getArmorMaterial(ItemStack par1ItemStack) {
		return ModArmorMaterials.ENDERDRAGON;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return "morecraft:textures/models/armor/enderdragon_layer_" + (slot == EquipmentSlot.LEGS ? "2" : "1") + ".png";
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> defaultModel) {
				if (armorSlot == EquipmentSlot.LEGS) {
					return new EnderdragonLegsModel<HumanoidModel<LivingEntity>>();
				}
				return ENDERDRAGON_ARMOR_MODEL;
			}
		});
	}
	
	
	@Override
	public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
		return stack.getItem() == ModItems.WINGED_ENDERDRAGON_CHESTPLATE.get() && ElytraItem.isFlyEnabled(stack);
	}

	@Override
	public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
		if (!entity.level().isClientSide()) {
			int nextFlightTick = flightTicks + 1;
			if (nextFlightTick % 10 == 0) {
				if (nextFlightTick % 20 == 0) {
					stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.CHEST));
				}
				entity.gameEvent(GameEvent.ELYTRA_GLIDE);
			}
		}
		return true;
	}

}