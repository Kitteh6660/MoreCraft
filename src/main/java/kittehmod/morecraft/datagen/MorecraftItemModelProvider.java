package kittehmod.morecraft.datagen;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MorecraftItemModelProvider extends ItemModelProvider
{

	public MorecraftItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, MoreCraft.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		// Where items will be generated.
		
	}

}
