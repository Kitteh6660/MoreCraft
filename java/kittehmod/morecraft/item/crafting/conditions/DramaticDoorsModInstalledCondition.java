package kittehmod.morecraft.item.crafting.conditions;

import com.google.gson.JsonObject;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class DramaticDoorsModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public DramaticDoorsModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("dramaticdoors");
	}

	public static class Serializer implements IConditionSerializer<DramaticDoorsModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(MoreCraft.MODID, "dramaticdoors_mod_installed");
		}

		@Override
		public void write(JsonObject json, DramaticDoorsModInstalledCondition value) {
			// Nothing to write here...
		}

		@Override
		public DramaticDoorsModInstalledCondition read(JsonObject json) {
			return new DramaticDoorsModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}

