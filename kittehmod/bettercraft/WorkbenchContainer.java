package kittehmod.bettercraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;

public class WorkbenchContainer extends Container
{
    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    private World worldObj;

    public WorkbenchContainer(InventoryPlayer inventoryplayer, World world)
    {
        craftMatrix = new InventoryCrafting(this, 3, 3);
        craftResult = new InventoryCraftResult();
        worldObj = world;
        this.func_75146_a(new SlotCrafting(inventoryplayer.field_70458_d, craftMatrix, craftResult, 0, 124, 35));
        for (int i = 0; i < 3; i++)
        {
            for (int l = 0; l < 3; l++)
            {
                this.func_75146_a(new Slot(craftMatrix, l + i * 3, 30 + l * 18, 17 + i * 18));
            }
        }

        for (int column = 0; column < 3; column++)
        {
            for (int row = 0; row < 9; row++)
            {
                this.func_75146_a(new Slot(inventoryplayer, row + column * 9 + 9, 8 + row * 18, 84 + column * 18));
            }
        }

        for (int column = 0; column < 9; column++)
        {
            this.func_75146_a(new Slot(inventoryplayer, column, 8 + column * 18, 142));
        }

        func_75130_a(craftMatrix);
    }

    @Override
    public void func_75130_a (IInventory iinventory)
    {
        craftResult.func_70299_a(0, CraftingManager.func_77594_a().func_82787_a(craftMatrix, worldObj));
    }

    @Override
    public void func_75134_a (EntityPlayer entityplayer)
    {
        super.func_75134_a(entityplayer);
        if (worldObj.field_72995_K)
        {
            return;
        }
        for (int i = 0; i < 9; i++)
        {
            ItemStack itemstack = craftMatrix.func_70301_a(i);
            if (itemstack != null)
            {
                entityplayer.func_70099_a(itemstack, 0);
            }
        }
    }

    @Override
    public boolean func_75145_c (EntityPlayer entityplayer)
    {
        return true;
    }

    @Override
    public ItemStack func_82846_b (EntityPlayer entityplayer, int i)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot) field_75151_b.get(i);
        if (slot != null && slot.func_75216_d())
        {
            ItemStack itemstack1 = slot.func_75211_c();
            itemstack = itemstack1.func_77946_l();
            if (i == 0)
            {
                if (!func_75135_a(itemstack1, 10, 46, true))
                {
                    return null;
                }
            }
            else if (i >= 10 && i < 37)
            {
                if (!func_75135_a(itemstack1, 37, 46, false))
                {
                    return null;
                }
            }
            else if (i >= 37 && i < 46)
            {
                if (!func_75135_a(itemstack1, 10, 37, false))
                {
                    return null;
                }
            }
            else if (!func_75135_a(itemstack1, 10, 46, false))
            {
                return null;
            }
            if (itemstack1.field_77994_a == 0)
            {
                slot.func_75215_d(null);
            }
            else
            {
                slot.func_75218_e();
            }
            if (itemstack1.field_77994_a != itemstack.field_77994_a)
            {
                slot.func_82870_a(entityplayer, itemstack1);
            }
            else
            {
                return null;
            }
        }
        return itemstack;
    }
}
