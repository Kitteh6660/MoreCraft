package kittehmod.morecraft.item.crafting.conditions;

import com.google.gson.JsonObject;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class VariantCraftingTableModInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public VariantCraftingTableModInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return ModList.get().isLoaded("variant_crafting_tables");
	}

	public static class Serializer implements IConditionSerializer<VariantCraftingTableModInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(MoreCraft.MODID, "variant_crafting_table_mod_installed");
		}

		@Override
		public void write(JsonObject json, VariantCraftingTableModInstalledCondition value) {
			// Nothing to write...
		}

		@Override
		public VariantCraftingTableModInstalledCondition read(JsonObject json) {
			return new VariantCraftingTableModInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}

