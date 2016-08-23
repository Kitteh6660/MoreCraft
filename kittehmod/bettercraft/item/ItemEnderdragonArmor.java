package kittehmod.bettercraft.item;

import kittehmod.bettercraft.MoreCraft;
import kittehmod.bettercraft.client.ClientProxy;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraft.item.ItemArmor.ArmorMaterial;
public class ItemEnderdragonArmor extends ItemArmor
{
	public String armorNamePrefix;
	public ArmorMaterial material;

	public ItemEnderdragonArmor(ArmorMaterial par2EnumArmorMaterial, int par3, int par4, String armornamePrefix)
	{
	    super(par2EnumArmorMaterial, par3, par4);
	    this.material = par2EnumArmorMaterial;
	    par2EnumArmorMaterial.func_78044_b(par4);
	    this.func_77656_e(par2EnumArmorMaterial.func_78046_a(par4));
	    this.field_77777_bU = 1;
	    armorNamePrefix = armornamePrefix;
	}

    public ArmorMaterial getArmorMaterial(ItemStack par1ItemStack)
    {
    	return MoreCraft.ENDERDRAGON_A;
    }
	
    public EnumRarity func_77613_e(ItemStack par1ItemStack)
    {
        return EnumRarity.EPIC;
    }
    
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {

		if (slot == 2)//(stack.toString().contains("legs") || stack.toString().contains("leggings") || stack.toString().contains("pants")) 
		{
			return "bettercraft:textures/models/armor/" + armorNamePrefix + "_layer_2.png";
		}
		else
		{
			return "bettercraft:textures/models/armor/" + armorNamePrefix + "_layer_1.png";
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot){

		ModelBiped armorModel = ClientProxy.armorModels.get(this);

		if (armorModel != null) {
			armorModel.field_78116_c.field_78806_j = armorSlot == 0;
			armorModel.field_178720_f.field_78806_j = false;
			armorModel.field_78115_e.field_78806_j = armorSlot == 1 || armorSlot == 2;
			armorModel.field_178723_h.field_78806_j = armorSlot == 1;
			armorModel.field_178724_i.field_78806_j = armorSlot == 1;
			armorModel.field_178721_j.field_78806_j = armorSlot == 2 || armorSlot == 3;
			armorModel.field_178722_k.field_78806_j = armorSlot == 2 || armorSlot == 3;
			
			armorModel.field_78117_n = entityLiving.func_70093_af();
			armorModel.field_78093_q = entityLiving.func_70115_ae();
			armorModel.field_78091_s = entityLiving.func_70631_g_();
			
			armorModel.field_78120_m = 0;
			armorModel.field_78118_o = false;

			EntityPlayer player = (EntityPlayer)entityLiving;

			ItemStack held_item = player.func_71124_b(0);

			if (held_item != null)
			{
				armorModel.field_78120_m = 1;

				if (player.func_71052_bv() > 0)
				{
					EnumAction enumaction = held_item.func_77975_n();

					if (enumaction == EnumAction.BOW) {
						armorModel.field_78118_o = true;
					} else if (enumaction == EnumAction.BLOCK) {
						armorModel.field_78120_m = 3;
					}
				}
			}
		}

		return armorModel;
	}
	
}