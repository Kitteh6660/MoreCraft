package kittehmod.morecraft.item.crafting.conditions;

import com.google.gson.JsonObject;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class CharmModuleRecipeCondition implements ICondition
{
	private final ResourceLocation location;
	private final String flag;

	public CharmModuleRecipeCondition(ResourceLocation location, String flag) {
		this.location = location;
		this.flag = flag;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		if (ModList.get().isLoaded("charm")) {
			JsonObject dummyObject = new JsonObject();
			dummyObject.addProperty("type", "charm:module_enabled");
			dummyObject.addProperty("module", "charm:" + this.flag);
			return CraftingHelper.getCondition(dummyObject).test();
		}
		return false;
	}

	public static class Serializer implements IConditionSerializer<CharmModuleRecipeCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(MoreCraft.MODID, "charm_module");
		}

		@Override
		public void write(JsonObject json, CharmModuleRecipeCondition value) {
			json.addProperty("module", value.flag);
		}

		@Override
		public CharmModuleRecipeCondition read(JsonObject json) {
			return new CharmModuleRecipeCondition(this.location, json.getAsJsonPrimitive("module").getAsString());
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}
