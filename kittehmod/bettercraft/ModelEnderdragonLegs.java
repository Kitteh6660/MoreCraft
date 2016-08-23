package kittehmod.bettercraft;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEnderdragonLegs extends ModelBiped
{
	//fields
	ModelRenderer leftlegplate1;
	ModelRenderer leftlegplate2;
	ModelRenderer leftlegplate3;
	ModelRenderer rightlegplate1;
	ModelRenderer rightlegplate2;
	ModelRenderer rightlegplate3;
	ModelRenderer loincloth;
	ModelRenderer tailbase;
	ModelRenderer tailspike1;
	ModelRenderer tailspike2;
	ModelRenderer tailspike3;

	public ModelEnderdragonLegs(float expand)
	{
		super(expand, 0, 64, 32);

		field_78090_t = 64;
		field_78089_u = 32;

		//-- LEGS --\\
		leftlegplate1 = new ModelRenderer(this, 32, 0);
		leftlegplate1.func_78789_a(2.0F, -1.5F, -1.5F, 1, 3, 3);
		leftlegplate1.func_78793_a(0F, 0F, 0F);
		leftlegplate1.func_78787_b(64, 32);
		leftlegplate1.field_78809_i = true;
		setRotation(leftlegplate1, 0.7853982F, 0F, -0.0872665F);

		leftlegplate2 = new ModelRenderer(this, 32, 0);
		leftlegplate2.func_78789_a(1.8F, -0.5F, -2.5F, 1, 3, 3);
		leftlegplate2.func_78793_a(0F, 0F, 0F);
		leftlegplate2.func_78787_b(64, 32);
		leftlegplate2.field_78809_i = true;
		setRotation(leftlegplate2, 0.7853982F, 0F, -0.0872665F);

		leftlegplate3 = new ModelRenderer(this, 32, 0);
		leftlegplate3.func_78789_a(1.6F, 0.5F, -3.5F, 1, 3, 3);
		leftlegplate3.func_78793_a(0F, 0F, 0F);
		leftlegplate3.func_78787_b(64, 32);
		leftlegplate3.field_78809_i = true;
		setRotation(leftlegplate3, 0.7853982F, 0F, -0.0872665F);

		rightlegplate1 = new ModelRenderer(this, 32, 0);
		rightlegplate1.func_78789_a(-3.0F, -1.5F, -1.5F, 1, 3, 3);
		rightlegplate1.func_78793_a(0F, 0F, 0F);
		rightlegplate1.func_78787_b(64, 32);
		rightlegplate1.field_78809_i = true;
		setRotation(rightlegplate1, 0.7853982F, 0F, 0.0872665F);

		rightlegplate2 = new ModelRenderer(this, 32, 0);
		rightlegplate2.func_78789_a(-2.8F, -0.5F, -2.5F, 1, 3, 3);
		rightlegplate2.func_78793_a(0F, 0F, 0F);
		rightlegplate2.func_78787_b(64, 32);
		rightlegplate2.field_78809_i = true;
		setRotation(rightlegplate2, 0.7853982F, 0F, 0.0872665F);

		rightlegplate3 = new ModelRenderer(this, 32, 0);
		rightlegplate3.func_78789_a(-2.6F, 0.5F, -3.5F, 1, 3, 3);
		rightlegplate3.func_78793_a(0F, 0F, 0F);
		rightlegplate3.func_78787_b(64, 32);
		rightlegplate3.field_78809_i = true;
		setRotation(rightlegplate3, 0.7853982F, 0F, 0.0872665F);

		loincloth = new ModelRenderer(this, 32, 6);
		loincloth.func_78789_a(-2F, 11.5F, -1.9F, 4, 5, 1);
		loincloth.func_78793_a(0F, 0F, 0F);
		loincloth.func_78787_b(64, 32);
		loincloth.field_78809_i = true;
		setRotation(loincloth, -0.0523599F, 0F, 0F);

		tailbase = new ModelRenderer(this, 42, 0);
		tailbase.func_78789_a(-1F, 5.5F, 9.966666F, 2, 2, 9);
		tailbase.func_78793_a(0F, 0F, 0F);
		tailbase.func_78787_b(64, 32);
		tailbase.field_78809_i = true;
		setRotation(tailbase, -0.8726646F, 0F, 0F);
		
		tailspike1 = new ModelRenderer(this, 42, 12);
		tailspike1.func_78789_a(-0.5F, 4.5F, 11F, 1, 2, 2);
		tailspike1.func_78793_a(0F, 0F, 0F);
		tailspike1.func_78787_b(64, 32);
		tailspike1.field_78809_i = true;
		setRotation(tailspike1, 0F, 0F, 0F);
		
		tailspike2 = new ModelRenderer(this, 42, 12);
		tailspike2.func_78789_a(-0.5F, 4.5F, 13.5F, 1, 2, 2);
		tailspike2.func_78793_a(0F, 0F, 0F);
		tailspike2.func_78787_b(64, 32);
		tailspike2.field_78809_i = true;
		setRotation(tailspike2, 0F, 0F, 0F);
		
		tailspike3 = new ModelRenderer(this, 42, 12);
		tailspike3.func_78789_a(-0.5F, 4.5F, 16F, 1, 2, 2);
		tailspike3.func_78793_a(0F, 0F, 0F);
		tailspike3.func_78787_b(64, 32);
		tailspike3.field_78809_i = true;
		setRotation(tailspike3, 0F, 0F, 0F);

		this.field_178722_k.func_78792_a(leftlegplate1);
		this.field_178722_k.func_78792_a(leftlegplate2);
		this.field_178722_k.func_78792_a(leftlegplate3);
		this.field_178721_j.func_78792_a(rightlegplate1);
		this.field_178721_j.func_78792_a(rightlegplate2);
		this.field_178721_j.func_78792_a(rightlegplate3);
		this.field_78115_e.func_78792_a(loincloth);
		tailbase.func_78792_a(tailspike1);
		tailbase.func_78792_a(tailspike2);
		tailbase.func_78792_a(tailspike3);
		this.field_78115_e.func_78792_a(tailbase);
	}

	public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
		func_78087_a(f, f1, f2, f3, f4, f5, entity);
		//Move part depending on sneak
		setRotation(loincloth, this.field_78117_n ? -0.5F : -0.0523599F, 0F, 0F);
		loincloth.field_82908_p = this.field_78117_n ? -0.06F : 0F;
		loincloth.field_82907_q = this.field_78117_n ? 0.06F : 0F;
		loincloth.field_78798_e = this.field_78117_n ? (float) Math.PI : 0F;

	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.field_78795_f = x;
		model.field_78796_g = y;
		model.field_78808_h = z;
	}

}
