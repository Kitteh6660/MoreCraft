package kittehmod.morecraft.item.crafting.conditions;

import com.google.gson.JsonObject;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.MoreCraftConfig;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class CharmModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public CharmModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("charm");
	}

	public static class Serializer implements IConditionSerializer<CharmModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(MoreCraft.MODID, "charm_mod_installed");
		}

		@Override
		public void write(JsonObject json, CharmModInstalledCondition value) {
			json.addProperty("config", MoreCraftConfig.salvageRecipes.get());
		}

		@Override
		public CharmModInstalledCondition read(JsonObject json) {
			return new CharmModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}

