package kittehmod.morecraft.item.crafting.conditions;

import com.google.gson.JsonObject;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.MoreCraftConfig;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class CharmModNotInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public CharmModNotInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return !ModList.get().isLoaded("charm");
	}

	public static class Serializer implements IConditionSerializer<CharmModNotInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(MoreCraft.MODID, "charm_mod_not_installed");
		}

		@Override
		public void write(JsonObject json, CharmModNotInstalledCondition value) {
			json.addProperty("config", MoreCraftConfig.salvageRecipes.get());
		}

		@Override
		public CharmModNotInstalledCondition read(JsonObject json) {
			return new CharmModNotInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}

