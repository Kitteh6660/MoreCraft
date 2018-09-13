package kittehmod.morecraft.crafting;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import com.google.common.collect.Lists;

import kittehmod.morecraft.MoreCraftBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class RecipeHelper {
	
	private static boolean fixedRecipes = false;
	
	//It's ugly but it'll do for now.
	public static int countItemInGrid(InventoryCrafting matrix, Item item) {
		int amt = 0;
		for (int i = 0; i < 9; i++) {
			if (matrix.getStackInRowAndColumn(i % 3, (int)(i/3)).getItem() == item) { amt++; }
		}
		System.out.println(amt);
		return amt;
	}
	public static int decreaseItemsInGrid(InventoryCrafting matrix, int amount) {
		int amt = 0;
		for (int i = 0; i < 9; i++) {
			if (matrix.getStackInRowAndColumn(i % 3, (int)(i/3)).getCount() > 0) {
				matrix.getStackInRowAndColumn(i % 3, (int)(i/3)).shrink(amount);
			}
		}
		System.out.println(amt);
		return amt;
	}
	public static int countMultiplesLowest(InventoryCrafting matrix, Item item) {
		int amt = 99;
		for (int i = 0; i < 9; i++) {
			if (matrix.getStackInRowAndColumn(i % 3, (int)(i/3)).getCount() > 0 && amt > matrix.getStackInRowAndColumn(i % 3, (int)(i/3)).getCount() && matrix.getStackInRowAndColumn(i % 3, (int)(i/3)).getItem() == item) {
				amt = matrix.getStackInRowAndColumn(i % 3, (int)(i/3)).getCount();
			}
		}
		return amt;
	}
	private static void deductItemsFromPlayer(EntityPlayer player, Item item, int amount) {
		InventoryPlayer inventory = player.inventory;
		for (int i = 0; i < 36; i++) {
			if (inventory.getStackInSlot(i).getItem() == item) {
				inventory.decrStackSize(i, amount);
				break;
			}
		}
	}
	
	public static void processCrafting(ItemCraftedEvent event, EntityPlayer player, InventoryCrafting matrix, Item origCraft, Item targetCraft, Item materialDeducted) {
		World world = player.getEntityWorld();
		int amt = 1;
		if (!world.isRemote) { //Multiplayer handler
			event.crafting.shrink(1);
			decreaseItemsInGrid(matrix, 1);
			event.player.addItemStackToInventory(new ItemStack(targetCraft, 1));
		}
		else { //Singleplayer handler
			if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
				event.crafting.shrink(1);
				amt = countMultiplesLowest(matrix, materialDeducted);
				decreaseItemsInGrid(matrix, amt);
				deductItemsFromPlayer(event.player, origCraft, 1);
				event.player.addItemStackToInventory(new ItemStack(targetCraft, amt));
			}
			else {
				event.crafting.shrink(1);
				decreaseItemsInGrid(matrix, 1);
				event.player.addItemStackToInventory(new ItemStack(targetCraft, 1));
			}
		}
		CraftingManager.findMatchingRecipe(matrix, world);
	}
	
	//Hacky workaround for Netherwood chests and crafting tables.		
	@SubscribeEvent
	public void CraftEvent(ItemCraftedEvent event)
	{
		World world = event.player.getEntityWorld();
		InventoryCrafting matrix = (InventoryCrafting)event.craftMatrix;
		countItemInGrid(matrix, Item.getItemFromBlock(MoreCraftBlocks.NETHERWOOD_PLANKS));
		if (event.crafting.getItem() == Item.getItemFromBlock(Blocks.CHEST) && countItemInGrid(matrix, Item.getItemFromBlock(MoreCraftBlocks.NETHERWOOD_PLANKS)) == 8) {
			processCrafting(event, event.player, matrix, Item.getItemFromBlock(Blocks.CHEST), Item.getItemFromBlock(MoreCraftBlocks.NETHERWOOD_CHEST), Item.getItemFromBlock(MoreCraftBlocks.NETHERWOOD_PLANKS));
		}
		else if (event.crafting.getItem() == Item.getItemFromBlock(Blocks.CRAFTING_TABLE) && countItemInGrid(matrix, Item.getItemFromBlock(MoreCraftBlocks.NETHERWOOD_PLANKS)) == 4) {
			processCrafting(event, event.player, matrix, Item.getItemFromBlock(Blocks.CRAFTING_TABLE), Item.getItemFromBlock(MoreCraftBlocks.NETHERWOOD_CRAFTING_TABLE), Item.getItemFromBlock(MoreCraftBlocks.NETHERWOOD_PLANKS));
		}
	}
	
}
