package kittehmod.morecraft.container.addons;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;

public class BookcaseSlot extends Slot
{
	public static final Set<Item> ALLOWED_ITEMS = ImmutableSet.of(Items.BOOK, Items.ENCHANTED_BOOK, Items.WRITTEN_BOOK, Items.WRITABLE_BOOK, Items.KNOWLEDGE_BOOK, Items.PAPER, Items.MAP, Items.FILLED_MAP); 
	public static final ResourceLocation ATLAS_REGISTRY_NAME = new ResourceLocation("charm", "atlas");
	
	public BookcaseSlot(IInventory p_i47265_1_, int p_i47265_2_, int p_i47265_3_, int p_i47265_4_) {
		super(p_i47265_1_, p_i47265_2_, p_i47265_3_, p_i47265_4_);
	}

	public boolean mayPlace(ItemStack stack) {
		return ALLOWED_ITEMS.contains(stack.getItem()) || stack.getItem().getRegistryName() == ATLAS_REGISTRY_NAME;
	}
}
