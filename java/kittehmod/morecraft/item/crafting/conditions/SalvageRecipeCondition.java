package kittehmod.morecraft.item.crafting.conditions;

import com.google.gson.JsonObject;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.MoreCraftConfig;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class SalvageRecipeCondition implements ICondition
{
	private final ResourceLocation location;

	public SalvageRecipeCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return MoreCraftConfig.salvageRecipes.get();
	}

	public static class Serializer implements IConditionSerializer<SalvageRecipeCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(MoreCraft.MODID, "salvage_recipes");
		}

		@Override
		public void write(JsonObject json, SalvageRecipeCondition value) {
			json.addProperty("config", MoreCraftConfig.salvageRecipes.get());
		}

		@Override
		public SalvageRecipeCondition read(JsonObject json) {
			return new SalvageRecipeCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}

