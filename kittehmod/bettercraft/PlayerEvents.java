package kittehmod.bettercraft;

import kittehmod.bettercraft.block.BlockNetherSapling;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class PlayerEvents
{
	@SubscribeEvent
	public void UseBonemeal(BonemealEvent event) 
	{
		if (event.block == BetterCraft.NetherSapling) {
			if (!event.world.isRemote) {
				((BlockNetherSapling) BetterCraft.NetherSapling).growTree(event.world, event.x, event.y, event.z,event.world.rand);
			}
			event.setResult(Result.ALLOW);// allow the bonemeal consumption and prevent other possible effects
		}
	}
	
	/*@SubscribeEvent
	public void PlantIntoPot(PlayerInteractEvent event)
	{
		//Get held item
		ItemStack heldItem = event.entityPlayer.getCurrentEquippedItem();
		Block interactedBlock = event.world.getBlock(event.x, event.y, event.z);
		//Trigger event
		if (event.action == Action.RIGHT_CLICK_BLOCK && heldItem != null && heldItem.getItem() == Item.getItemFromBlock(BetterCraft.NetherSapling)) {
			if (!event.world.isRemote && interactedBlock == Blocks.flower_pot) {
				BlockFlowerPot flowerPotBlock = (BlockFlowerPot) interactedBlock;
				TileEntityFlowerPot flowerPotData = (TileEntityFlowerPot)event.world.getTileEntity(event.x, event.y, event.z);
				if (flowerPotData.getFlowerPotItem() == null) { //Check if it's empty.
					System.out.println("Attempt to place sapling.");
					flowerPotBlock.createNewTileEntity(event.world, heldItem.getItem().getIdFromItem(heldItem.getItem()));
					event.setResult(Result.ALLOW);
				}
			}
		}
	}*/
}
