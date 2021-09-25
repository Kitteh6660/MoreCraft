package kittehmod.morecraft.blockentity;

import kittehmod.morecraft.container.KilnContainer;
import kittehmod.morecraft.item.crafting.ModRecipeType;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class KilnBlockEntity extends AbstractFurnaceBlockEntity 
{
   public KilnBlockEntity(BlockPos pos, BlockState state) {
      super(ModBlockEntityType.KILN.get(), pos, state, ModRecipeType.KILN);
   }

   protected Component getDefaultName() {
      return new TranslatableComponent("container.kiln");
   }

   protected int getBurnDuration(ItemStack fuel) {
      return super.getBurnDuration(fuel) / 2;
   }

   protected AbstractContainerMenu createMenu(int id, Inventory player) {
      return new KilnContainer(id, player, this, this.dataAccess);
   }
}
