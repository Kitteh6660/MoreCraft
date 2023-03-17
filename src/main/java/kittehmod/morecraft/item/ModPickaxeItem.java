package kittehmod.morecraft.item;

import java.util.Random;

import kittehmod.morecraft.block.ModBlockTags;
import kittehmod.morecraft.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModPickaxeItem extends PickaxeItem
{

	public ModPickaxeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (this.getTier() == ModTier.BLAZE) {
			target.setSecondsOnFire(4);
		} else if (this.getTier() == ModTier.WITHERBONE) {
			target.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 0));
		}
		stack.hurtAndBreak(2, attacker, (entity) -> { entity.broadcastBreakEvent(EquipmentSlot.MAINHAND); });
		return true;
	}

	@Override
	public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
		boolean result = super.mineBlock(stack, level, state, pos, entity);
		if (this == ModItems.EMERALD_PICKAXE.get() && result && !level.isClientSide) {
			if (level.getBlockState(pos).getBlock() instanceof DropExperienceBlock && EnchantmentHelper.getTagEnchantmentLevel(Enchantments.SILK_TOUCH, stack) <= 0) {
				Random rand = new Random();
				int chance = 2; // Default chance of 2%.
				int range = 100; // Default random range from 0 to 99.
				// Alters the chance based on ore mined.
				if (state.is(BlockTags.COAL_ORES)) {
					chance = 1;
				}
				if (state.is(BlockTags.COPPER_ORES)) {
					chance = 2;
				}
				if (state.is(BlockTags.IRON_ORES)) {
					chance = 3;
				}
				if (state.is(BlockTags.GOLD_ORES)) {
					chance = 5;
				}
				if (state.is(BlockTags.LAPIS_ORES)) {
					chance = 4;
				}
				if (state.is(BlockTags.REDSTONE_ORES)) {
					chance = 2;
				}
				if (state.is(ModBlockTags.RUBY_ORES)) {
					chance = 10;
				}
				if (state.is(BlockTags.EMERALD_ORES)) {
					chance = 5;
				}
				if (state.is(BlockTags.DIAMOND_ORES)) {
					chance = 10;
				}
				// Alters based on Fortune level.
				range -= (EnchantmentHelper.getTagEnchantmentLevel(Enchantments.BLOCK_FORTUNE, stack) * 4);
				if (range < 80) range = 80; // Accounts for any mods that allows Fortune greater than III.
				// Now roll.
				if (rand.nextInt(range) < chance) {
					boolean hasChanged = false;
					for (int i = 0; i < 3; i++) {
						BlockPos alterPos = pos;
						int offsetX = rand.nextInt() % 12;
						int offsetY = rand.nextInt() % 12;
						int offsetZ = rand.nextInt() % 12;
						alterPos = pos.offset(offsetX, offsetY, offsetZ);
						if (level.getBlockState(alterPos).is(BlockTags.STONE_ORE_REPLACEABLES)) {
							level.playSound((Player)entity, alterPos, SoundEvents.VILLAGER_CELEBRATE, SoundSource.BLOCKS, 1, 1);
							level.setBlock(alterPos, Blocks.EMERALD_ORE.defaultBlockState(), 11);
							hasChanged = true;
							break;
						}
						if (level.getBlockState(alterPos).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)) {
							level.playSound((Player)entity, alterPos, SoundEvents.VILLAGER_CELEBRATE, SoundSource.BLOCKS, 1, 1);
							level.setBlock(alterPos, Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState(), 11);
							hasChanged = true;
							break;
						}
					}
					if (hasChanged && entity instanceof Player) {
						((Player)entity).displayClientMessage(Component.translatable("messages.morecraft.emerald_pickaxe_effect"), true);
					}
				}
			}
		}
		return result;
	}
}
