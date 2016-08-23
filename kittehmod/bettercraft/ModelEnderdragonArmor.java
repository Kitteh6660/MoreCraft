package kittehmod.bettercraft;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEnderdragonArmor extends ModelBiped
{
	//fields
	ModelRenderer horn1;
	ModelRenderer horn2;
	ModelRenderer snout;
	ModelRenderer nostril1;
	ModelRenderer nostril2;
	ModelRenderer backspike1;
	ModelRenderer backspike2;
	ModelRenderer leftshoulderspike1;
	ModelRenderer leftshoulderspike2;
	ModelRenderer rightshoulderspike1;
	ModelRenderer rightshoulderspike2;
	ModelRenderer leftclaw1;
	ModelRenderer leftclaw2;
	ModelRenderer leftclaw3;
	ModelRenderer rightclaw1;
	ModelRenderer rightclaw2;
	ModelRenderer rightclaw3;

	public ModelEnderdragonArmor(float expand)
	{
		super(expand, 0, 64, 32);

		//-- HEAD --\\
		//Horns
		horn1 = new ModelRenderer(this, 32, 8);
		horn1.func_78789_a(2.0F, -11F, -1F, 1, 2, 3);
		horn1.func_78793_a(0F, 0F, 0F);
		horn1.func_78787_b(64, 32);
		horn1.field_78809_i = true;
		setRotation(horn1, 0F, 0F, 0F);
		
		horn2 = new ModelRenderer(this, 32, 8);
		horn2.func_78789_a(-3.0F, -11F, -1F, 1, 2, 3);
		horn2.func_78793_a(0F, 0F, 0F);
		horn2.func_78787_b(64, 32);
		horn2.field_78809_i = true;
		setRotation(horn2, 0F, 0F, 0F);
		//Muzzle and Nostrils
		snout = new ModelRenderer(this, 32, 0);
		snout.func_78789_a(-3F, -5.4F, -10F, 6, 2, 6);
		snout.func_78793_a(0F, 0F, 0F);
		snout.func_78787_b(64, 32);
		snout.field_78809_i = true;
		setRotation(snout, 0F, 0F, 0F);
		
		nostril1 = new ModelRenderer(this, 56, 0);
		nostril1.func_78789_a(-2F, -6F, -9F, 1, 1, 2);
		nostril1.func_78793_a(0F, 0F, 0F);
		nostril1.func_78787_b(64, 32);
		nostril1.field_78809_i = true;
		setRotation(nostril1, 0F, 0F, 0F);
		
		nostril2 = new ModelRenderer(this, 56, 0);
		nostril2.func_78789_a(1F, -6F, -9F, 1, 1, 2);
		nostril2.func_78793_a(0F, 0F, 0F);
		nostril2.func_78787_b(64, 32);
		nostril2.field_78809_i = true;
		setRotation(nostril2, 0F, 0F, 0F);
		
		//-- TORSO --\\
		//Back Spikes
		backspike1 = new ModelRenderer(this, 40, 8);
		backspike1.func_78789_a(-0.5F, 2F, 3F, 1, 3, 1);
		backspike1.func_78793_a(0F, 0F, 0F);
		backspike1.func_78787_b(64, 32);
		backspike1.field_78809_i = true;
		setRotation(backspike1, 0F, 0F, 0F);
		
		backspike2 = new ModelRenderer(this, 40, 8);
		backspike2.func_78789_a(-0.5F, 6F, 3F, 1, 3, 1);
		backspike2.func_78793_a(0F, 0F, 0F);
		backspike2.func_78787_b(64, 32);
		backspike2.field_78809_i = true;
		setRotation(backspike2, 0F, 0F, 0F);
		
		//-- ARMS --\\
		//Shoulder Spikes
		leftshoulderspike1 = new ModelRenderer(this, 44, 8);
		leftshoulderspike1.func_78789_a(0F, -5F, 0F, 1, 3, 1);
		leftshoulderspike1.func_78793_a(0F, 0F, 0F); //(5F, 2F, 0F);
		leftshoulderspike1.func_78787_b(64, 32);
		leftshoulderspike1.field_78809_i = true;
		setRotation(leftshoulderspike1, 0F, 0F, 0.3490659F);
		
		leftshoulderspike2 = new ModelRenderer(this, 44, 8);
		leftshoulderspike2.func_78789_a(0F, -5F, -2F, 1, 3, 1);
		leftshoulderspike2.func_78793_a(0F, 0F, 0F); //(5F, 2F, 0F);
		leftshoulderspike2.func_78787_b(64, 32);
		leftshoulderspike2.field_78809_i = true;
		setRotation(leftshoulderspike2, 0F, 0F, 0.3490659F);
		
		rightshoulderspike1 = new ModelRenderer(this, 44, 8);
		rightshoulderspike1.func_78789_a(-1F, -5F, 0F, 1, 3, 1);
		rightshoulderspike1.func_78793_a(0F, 0F, 0F); //(-5F, 2F, 0F);
		rightshoulderspike1.func_78787_b(64, 32);
		rightshoulderspike1.field_78809_i = true;
		setRotation(rightshoulderspike1, 0F, 0F, -0.3490659F);
		
		rightshoulderspike2 = new ModelRenderer(this, 44, 8);
		rightshoulderspike2.func_78789_a(-1F, -5F, -2F, 1, 3, 1);
		rightshoulderspike2.func_78793_a(0F, 0F, 0F); //(-5F, 2F, 0F);
		rightshoulderspike2.func_78787_b(64, 32);
		rightshoulderspike2.field_78809_i = true;
		setRotation(rightshoulderspike2, 0F, 0F, -0.3490659F);
		
		//-- LEGS --\\
		//Toe Claws
		leftclaw1 = new ModelRenderer(this, 48, 8);
		leftclaw1.func_78789_a(1.5F, 11.5F, -4F, 1, 1, 1);
		leftclaw1.func_78793_a(0F, 0F, 0F); //(2F, 12F, 0F);
		leftclaw1.func_78787_b(64, 32);
		leftclaw1.field_78809_i = true;
		setRotation(leftclaw1, 0F, 0F, 0F);

		leftclaw2 = new ModelRenderer(this, 48, 8);
		leftclaw2.func_78789_a(-0.5F, 11.5F, -4F, 1, 1, 1);
		leftclaw2.func_78793_a(0F, 0F, 0F); //(2F, 12F, 0F);
		leftclaw2.func_78787_b(64, 32);
		leftclaw2.field_78809_i = true;
		setRotation(leftclaw2, 0F, 0F, 0F);
		
		leftclaw3 = new ModelRenderer(this, 48, 8);
		leftclaw3.func_78789_a(-2.5F, 11.5F, -4F, 1, 1, 1);
		leftclaw3.func_78793_a(0F, 0F, 0F); //(2F, 12F, 0F);
		leftclaw3.func_78787_b(64, 32);
		leftclaw3.field_78809_i = true;
		setRotation(leftclaw3, 0F, 0F, 0F);

		rightclaw1 = new ModelRenderer(this, 48, 8);
		rightclaw1.func_78789_a(1.5F, 11.5F, -4F, 1, 1, 1);
		rightclaw1.func_78793_a(0F, 0F, 0F); //(-2F, 12F, 0F);
		rightclaw1.func_78787_b(64, 32);
		rightclaw1.field_78809_i = true;
		setRotation(rightclaw1, 0F, 0F, 0F);
		
		rightclaw2 = new ModelRenderer(this, 48, 8);
		rightclaw2.func_78789_a(-0.5F, 11.5F, -4F, 1, 1, 1);
		rightclaw2.func_78793_a(0F, 0F, 0F); //(-2F, 12F, 0F);
		rightclaw2.func_78787_b(64, 32);
		rightclaw2.field_78809_i = true;
		setRotation(rightclaw2, 0F, 0F, 0F);
		
		rightclaw3 = new ModelRenderer(this, 48, 8);
		rightclaw3.func_78789_a(-2.5F, 11.5F, -4F, 1, 1, 1);
		rightclaw3.func_78793_a(0F, 0F, 0F); //(-2F, 12F, 0F);
		rightclaw3.func_78787_b(64, 32);
		rightclaw3.field_78809_i = true;
		setRotation(rightclaw3, 0F, 0F, 0F);
		
		//-- ASSIGNING CHILD --\\
		//Head
		this.field_78116_c.func_78792_a(horn1);
		this.field_78116_c.func_78792_a(horn2);
		snout.func_78792_a(nostril1);
		snout.func_78792_a(nostril2);
		this.field_78116_c.func_78792_a(snout);
		//Torso
		this.field_78115_e.func_78792_a(backspike1);
		this.field_78115_e.func_78792_a(backspike2);
		//Arms
		this.field_178724_i.func_78792_a(leftshoulderspike1);
		this.field_178724_i.func_78792_a(leftshoulderspike2);
		this.field_178723_h.func_78792_a(rightshoulderspike1);
		this.field_178723_h.func_78792_a(rightshoulderspike2);
		//Legs
		this.field_178722_k.func_78792_a(leftclaw1);
		this.field_178722_k.func_78792_a(leftclaw2);
		this.field_178722_k.func_78792_a(leftclaw3);
		this.field_178721_j.func_78792_a(rightclaw1);
		this.field_178721_j.func_78792_a(rightclaw2);
		this.field_178721_j.func_78792_a(rightclaw3);

	}

	public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
		func_78087_a(f, f1, f2, f3, f4, f5, entity);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.field_78795_f = x;
		model.field_78796_g = y;
		model.field_78808_h = z;
	}

}
