package kittehmod.bettercraft;

import kittehmod.bettercraft.block.BlockNetherSapling;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerEvents
{
	@SubscribeEvent
	public void UseBonemeal(BonemealEvent event) 
	{
		if (event.block == MoreCraftBlocks.netherwood_sapling) {
			if (!event.world.isRemote) {
				((BlockNetherSapling) MoreCraftBlocks.netherwood_sapling).grow(event.world, event.pos, null, event.world.rand);
			}
			event.setResult(Result.ALLOW);// allow the bonemeal consumption and prevent other possible effects
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
