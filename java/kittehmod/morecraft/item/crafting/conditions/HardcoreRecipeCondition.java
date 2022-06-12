package kittehmod.morecraft.item.crafting.conditions;

import com.google.gson.JsonObject;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.MoreCraftConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class HardcoreRecipeCondition implements ICondition
{
	private final ResourceLocation location;

	public HardcoreRecipeCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test(IContext context) {
		return MoreCraftConfig.hardcoreRecipes.get();
	}

	public static class Serializer implements IConditionSerializer<HardcoreRecipeCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(MoreCraft.MODID, "hardcore_recipes");
		}

		@Override
		public void write(JsonObject json, HardcoreRecipeCondition value) {
			json.addProperty("config", MoreCraftConfig.hardcoreRecipes.get());
		}

		@Override
		public HardcoreRecipeCondition read(JsonObject json) {
			return new HardcoreRecipeCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}

