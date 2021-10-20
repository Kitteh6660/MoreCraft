package kittehmod.morecraft.item.crafting.conditions;

import com.google.gson.JsonObject;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.MoreCraftConfig;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class QuarkModNotInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public QuarkModNotInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return !ModList.get().isLoaded("quark");
	}

	public static class Serializer implements IConditionSerializer<QuarkModNotInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(MoreCraft.MODID, "quark_mod_not_installed");
		}

		@Override
		public void write(JsonObject json, QuarkModNotInstalledCondition value) {
			json.addProperty("config", MoreCraftConfig.salvageRecipes.get());
		}

		@Override
		public QuarkModNotInstalledCondition read(JsonObject json) {
			return new QuarkModNotInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}

