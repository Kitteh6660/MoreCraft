package kittehmod.bettercraft;

import kittehmod.bettercraft.block.BlockNetherSapling;
import kittehmod.bettercraft.entity.EntityNetherwoodBoat;
import kittehmod.bettercraft.item.ItemNormalAxe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemPickupEvent;

public class PlayerEvents
{
	@SubscribeEvent
	public void UseBonemeal(BonemealEvent event) 
	{
		if (event.getBlock() == MoreCraftBlocks.NETHERWOOD_SAPLING) {
			if (!event.getWorld().isRemote) {
				((BlockNetherSapling) MoreCraftBlocks.NETHERWOOD_SAPLING).grow(event.getWorld(), event.getPos(), null, event.getWorld().rand);
			}
			event.setResult(Result.ALLOW);// allow the bonemeal consumption and prevent other possible effects
		}
	}
	
	@SubscribeEvent
	public void PickUpWoods(ItemPickupEvent event)
	{
		if (event.pickedUp.getEntityItem().getItem() == Item.getItemFromBlock(MoreCraftBlocks.NETHERWOOD_LOG)) {
			event.player.addStat(AchievementList.MINE_WOOD);
		}
	}

	@SubscribeEvent
	public void CraftedNetherCraftingTable(ItemCraftedEvent event)
	{
		if (event.crafting.getItem() == Item.getItemFromBlock(MoreCraftBlocks.NETHERWOOD_CRAFTING_TABLE)) {
			event.player.addStat(AchievementList.BUILD_WORK_BENCH);
		}
	}
	
	@SubscribeEvent
	public void AxeEnchantmentOnAnvil(AnvilUpdateEvent event)
	{
		if (event.getLeft().getItem().equals(ItemNormalAxe.class) && event.getRight().getItem().equals(ItemEnchantedBook.class)) {
			ItemEnchantedBook enchBook = (ItemEnchantedBook)event.getRight().getItem();
			NBTTagList enchList = enchBook.getEnchantments(new ItemStack(event.getRight().getItem()));
			for (int i = 0; i < enchList.tagCount(); i++)
			{
				NBTTagCompound enchantment = ((NBTTagList)enchList).getCompoundTagAt(i);
				if (enchantment.getTag("id").getId() == 16 || enchantment.getTag("id").getId() == 17 || enchantment.getTag("id").getId() == 18) {
					event.setResult(Result.ALLOW); //Force allow
				}
			}
		}
	}
	
	@SubscribeEvent
	public void LavaBoatAntiHurt(LivingAttackEvent event)
	{
		if (event.getEntityLiving().getRidingEntity() instanceof EntityNetherwoodBoat) {
			if (event.getSource().equals(DamageSource.onFire) || event.getSource().equals(DamageSource.inFire) || event.getSource().equals(DamageSource.lava)) {
				event.setCanceled(true);
				event.getEntityLiving().extinguish();
			}
		}
	}
	
	/*@SubscribeEvent
	public void PlantIntoPot(PlayerInteractEvent event)
	{
		//Get held item
		ItemStack heldItem = event.entityPlayer.getCurrentEquippedItem();
		Block interactedBlock = event.world.getBlockState(event.pos).getBlock();
		if (heldItem == null || interactedBlock == null) {
			event.setResult(Result.DENY);
			return;
		}
		//Trigger event
		if (event.action == Action.RIGHT_CLICK_BLOCK && heldItem != null && heldItem.getItem() == Item.getItemFromBlock(MoreCraftBlocks.netherwood_sapling)) {
			if (!event.world.isRemote && interactedBlock == Blocks.flower_pot) {
				BlockFlowerPot flowerPotBlock = (BlockFlowerPot) interactedBlock;
				TileEntityFlowerPot flowerPotData = (TileEntityFlowerPot)event.world.getTileEntity(event.pos);
				if (flowerPotData.getFlowerPotItem() == null) { //Check if it's empty.
					System.out.println("Attempt to place sapling.");
					flowerPotBlock.createNewTileEntity(event.world, heldItem.getItem().getIdFromItem(heldItem.getItem()));
					event.setResult(Result.ALLOW);
				}
			}
		}
	}*/
}
