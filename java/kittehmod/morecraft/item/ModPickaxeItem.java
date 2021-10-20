package kittehmod.morecraft.item;

import java.util.Random;

import kittehmod.morecraft.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ModPickaxeItem extends PickaxeItem {

	public ModPickaxeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}
	
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (this.getTier() == ModItemTier.BLAZE) {
			target.setSecondsOnFire(4);
		}
		else if (this.getTier() == ModItemTier.WITHERBONE) {
			target.addEffect(new EffectInstance(Effects.WITHER, 100, 0));
		}
		stack.hurtAndBreak(2, attacker, (p_220045_0_) -> {
			p_220045_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
		});
		return true;
	}
	
	@Override
	public boolean mineBlock(ItemStack stack, World level, BlockState state, BlockPos pos, LivingEntity entity) {
		boolean result = super.mineBlock(stack, level, state, pos, entity);
		if (this == ModItems.EMERALD_PICKAXE.get() && result && !level.isClientSide) {
			if (level.getBlockState(pos).getBlock() instanceof OreBlock && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, stack) <= 0) {
				Random rand = new Random();
				int chance = 2; // Default chance of 2%.
				int range = 100; // Default random range from 0 to 99.
				// Alters the chance based on ore mined.
				if (state.is(Blocks.COAL_ORE)) {
					chance = 1;
				}
				if (state.is(Blocks.IRON_ORE)) {
					chance = 3;
				}
				if (state.is(Blocks.GOLD_ORE)) {
					chance = 5;
				}
				if (state.is(Blocks.LAPIS_ORE)) {
					chance = 4;
				}
				if (state.is(Blocks.REDSTONE_ORE)) {
					chance = 2;
				}
				if (state.is(ModBlocks.RUBY_ORE.get())) {
					chance = 10;
				}
				if (state.is(Blocks.EMERALD_ORE)) {
					chance = 5;
				}
				if (state.is(Blocks.DIAMOND_ORE)) {
					chance = 10;
				}
				// Alters based on Fortune level.
				range -= (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, stack) * 4);
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
						if (level.getBlockState(alterPos).is(BlockTags.BASE_STONE_OVERWORLD)) {
							level.playSound((PlayerEntity)entity, alterPos, SoundEvents.VILLAGER_CELEBRATE, SoundCategory.BLOCKS, 1, 1);
							level.setBlock(alterPos, Blocks.EMERALD_ORE.defaultBlockState(), 11);
							hasChanged = true;
							break;
						}
					}
					if (hasChanged && entity instanceof PlayerEntity) {
						((PlayerEntity)entity).displayClientMessage(new TranslationTextComponent("messages.morecraft.emerald_pickaxe_effect"), true);
					}
				}
			}
		}
		return result;
	}
}
