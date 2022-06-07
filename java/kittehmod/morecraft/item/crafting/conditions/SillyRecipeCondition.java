package kittehmod.morecraft.item.crafting.conditions;

import com.google.gson.JsonObject;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.MoreCraftConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class SillyRecipeCondition implements ICondition
{
	private final ResourceLocation location;

	public SillyRecipeCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return MoreCraftConfig.sillyRecipes.get();
	}

	public static class Serializer implements IConditionSerializer<SillyRecipeCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(MoreCraft.MODID, "silly_recipes");
		}

		@Override
		public void write(JsonObject json, SillyRecipeCondition value) {
			json.addProperty("config", MoreCraftConfig.sillyRecipes.get());
		}

		@Override
		public SillyRecipeCondition read(JsonObject json) {
			return new SillyRecipeCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}

