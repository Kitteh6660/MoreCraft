package kittehmod.morecraft.tileentity;

import kittehmod.morecraft.container.KilnContainer;
import kittehmod.morecraft.item.crafting.IModRecipeType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class KilnTileEntity extends AbstractFurnaceTileEntity {
   public KilnTileEntity() {
      super(ModTileEntityType.KILN.get(), IModRecipeType.KILN);
   }

   protected ITextComponent getDefaultName() {
      return new TranslationTextComponent("container.kiln");
   }

   protected int getBurnTime(ItemStack fuel) {
      return super.getBurnTime(fuel) / 2;
   }

   protected Container createMenu(int id, PlayerInventory player) {
      return new KilnContainer(id, player, this, this.furnaceData);
   }
}
