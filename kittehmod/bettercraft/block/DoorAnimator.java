package kittehmod.bettercraft.block;

import net.malisis.doors.door.DoorDescriptor;
import net.malisis.doors.door.DoorRegistry;
import net.malisis.doors.door.movement.RotateAndPlaceMovement;
import net.malisis.doors.door.movement.RotatingDoorMovement;
import net.malisis.doors.door.sound.VanillaDoorSound;
import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class DoorAnimator extends DoorDescriptor
{

	public DoorAnimator(Material material, SoundType sound, String itemName, String textureName)
	{

		setMaterial(material); //default: Material.wood

		setSoundType(sound); //default: Block.soundTypeWood

		setName(itemName); //REQUIRED

		setTextureName(textureName); //REQUIRED

		setMovement(DoorRegistry.getMovement(RotatingDoorMovement.class));
		setSound(DoorRegistry.getSound(VanillaDoorSound.class));
		//setRenderer(DoorRegistry.)
		setOpeningTime(6);
		setDoubleDoor(true);
		setRequireRedstone(false);

		setTab(CreativeTabs.tabRedstone);
	}

}	