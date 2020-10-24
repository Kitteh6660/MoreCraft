package kittehmod.morecraft.client;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, MoreCraft.MODID, existingFileHelper);
	}
	
	@Override
	protected void registerModels() {
		//Nothing here...
	}
	
	@Override
	public String getName() {
		return "Mod Item Models";
	}
}
