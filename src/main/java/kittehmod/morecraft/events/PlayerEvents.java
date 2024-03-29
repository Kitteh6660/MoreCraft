package kittehmod.morecraft.events;

import kittehmod.morecraft.enchantments.ModEnchantments;
import kittehmod.morecraft.entity.ModEntityTags;
import kittehmod.morecraft.entity.NetherBoat;
import kittehmod.morecraft.init.ModItems;
import kittehmod.morecraft.item.ModArmorItem;
import kittehmod.morecraft.item.ModArmorMaterials;
import kittehmod.morecraft.network.ModBoatDismountPacket;
import kittehmod.morecraft.network.MorecraftPacketHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopper.WeatherState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.level.BlockEvent.BlockToolModificationEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerEvents
{
	
	//A chance to gain Copper Patina upon scraping copper.
	@SubscribeEvent
	public void copperScrapeEvent(BlockToolModificationEvent event) {
		LevelAccessor level = event.getLevel();
		if (event.getHeldItemStack().getItem() instanceof AxeItem && event.getToolAction()  == ToolActions.AXE_SCRAPE && !level.isClientSide()) {
			if (event.getState().getBlock() instanceof WeatheringCopper) {
				WeatheringCopper copper = (WeatheringCopper) event.getState().getBlock();
				if (copper.getAge() != WeatherState.UNAFFECTED) {
					float chance = 0.4F + EnchantmentHelper.getEnchantmentLevel(Enchantments.BLOCK_FORTUNE, event.getPlayer()) * 0.2F; 
					if (level.getRandom().nextFloat() < chance) {
						BlockPos pos = event.getPos().relative(event.getPlayer().getDirection().getOpposite(), 1);
						ItemEntity entity = new ItemEntity((Level) level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.PATINA.get(), 1));
						level.addFreshEntity(entity);
						event.setResult(Result.ALLOW);
					}
				}
				else {
					event.setResult(Result.DEFAULT);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void LavaBoatDismount(EntityMountEvent event) {
		if (event.isDismounting() && event.getEntityMounting() instanceof LivingEntity && event.getEntityBeingMounted() instanceof NetherBoat) {
			event.getEntityMounting().clearFire();
			if (event.getEntityMounting() instanceof Player && event.getEntityMounting().level().isClientSide()) {
				MorecraftPacketHandler.sendToServer(new ModBoatDismountPacket()); // Has to be called otherwise fire won't properly get extinguished.
			}
			event.setResult(Result.ALLOW);
		}
	}

	@SubscribeEvent
	public void onAttackEvent(LivingAttackEvent event) {
		LivingEntity entity = event.getEntity();
		if (entity != null && entity.getVehicle() != null && entity.getVehicle() instanceof NetherBoat) {
			if (event.getSource().is(DamageTypes.LAVA) && !entity.isEyeInFluidType(ForgeMod.LAVA_TYPE.get())) {
				event.setCanceled(true);
				event.getEntity().clearFire();
			}
		}
	}

	// Armour set effects that alter hurting
	@SubscribeEvent
	public void onHurtEvent(LivingHurtEvent event) {
		LivingEntity entity = event.getEntity();
		// Ruby armour
		int blockChance = 0;
		float damage = 0;
		blockChance += ModArmorItem.countPiecesOfMaterial(entity, ModArmorMaterials.RUBY);
		int rand = (int) (Math.random() * 40); // Each piece is 2.5% chance to completely nullify damage.
		if (blockChance > rand) {
			if (entity instanceof Player) {
				((Player) entity).displayClientMessage(Component.translatable("messages.morecraft.ruby_armour_block"), true);
			}
			event.setCanceled(true);
		}
		// Alter fire damage taken based on Obsidian or Spider Silk. Obsidian decreases
		// fire damage, Spider Silk increases fire damage.
		if (event.getSource().is(DamageTypes.IN_FIRE) || event.getSource().is(DamageTypes.ON_FIRE)) {
			damage = event.getAmount();
			event.setAmount(damage * ModArmorItem.getFireDmgMultiplier(entity));
		}
		// Alter Warden damage taken based on Magic Protection. A workaround for Warden's enchantment bypass.
		if (event.getSource().is(DamageTypes.SONIC_BOOM)) {
			damage = event.getAmount();
			int protectionLevels = ModArmorItem.getTotalMagicProtectionLevels(entity);
			float f = Mth.clamp(protectionLevels * 2, 0, 20);
			event.setAmount(damage * (1 - (f / 25.0F)));
		}
		// Alter damage when done against Ender-type mobs.
		if ((event.getSource().getDirectEntity() != null && event.getSource().getDirectEntity() instanceof LivingEntity) && (entity.getType().is(ModEntityTags.ENDER_MOBS))) {
			LivingEntity attacker = (LivingEntity)event.getSource().getDirectEntity();
			damage = event.getAmount();
			if (attacker.getMainHandItem() != null && EnchantmentHelper.getTagEnchantmentLevel(ModEnchantments.ENDER_BANE.get(), attacker.getMainHandItem()) > 0) {
				damage += EnchantmentHelper.getTagEnchantmentLevel(ModEnchantments.ENDER_BANE.get(), attacker.getMainHandItem()) * 1.25F;
				event.setAmount(damage);
			}
		}
	}

	@SubscribeEvent
	public void onFallEvent(LivingFallEvent event) {
		if (event.getEntity() instanceof LivingEntity) {
			LivingEntity entity = event.getEntity();
			if (entity.getItemBySlot(EquipmentSlot.FEET) != null && entity.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.SLIME_BOOTS.get()) {
				float mult = (float) (event.getDamageMultiplier() * 0.25);
				float dist = event.getDistance();
				if (!entity.isSuppressingBounce()) {
					Vec3 vec3 = entity.getDeltaMovement();
					if (vec3.y < 0.0D) {
						double d0 = entity instanceof LivingEntity ? 1.0D : 0.8D;
						entity.setDeltaMovement(vec3.x, -vec3.y * d0, vec3.z);
					}
				}
				else {
					mult = (float) (event.getDamageMultiplier() * 0.4);
				}
				event.setDamageMultiplier(mult);
				entity.getItemBySlot(EquipmentSlot.FEET).hurtAndBreak(dist < 50 ? (int)Math.ceil(dist / 5) : 10, entity, (ent) -> {
	               ent.broadcastBreakEvent(EquipmentSlot.FEET);
	            });
				event.setResult(Result.DEFAULT);
			}
		}
	}

	// Blaze armour set effects
	@SubscribeEvent
	public void onTickPlayerEvent(PlayerTickEvent event) {
		if (ModArmorItem.countPiecesOfMaterial(event.player, ModArmorMaterials.BLAZE) >= 4) {
			MobEffectInstance effect = event.player.getEffect(MobEffects.FIRE_RESISTANCE);
			if (effect == null || effect.getDuration() < 10) {
				event.player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
			}
		}
	}
}
