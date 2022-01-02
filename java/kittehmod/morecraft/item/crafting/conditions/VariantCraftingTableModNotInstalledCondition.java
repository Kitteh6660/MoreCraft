package kittehmod.morecraft.item.crafting.conditions;

import com.google.gson.JsonObject;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

public class VariantCraftingTableModNotInstalledCondition implements ICondition
{
	private final ResourceLocation location;

	public VariantCraftingTableModNotInstalledCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test() {
		return !ModList.get().isLoaded("variant_crafting_tables");
	}

	public static class Serializer implements IConditionSerializer<VariantCraftingTableModNotInstalledCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(MoreCraft.MODID, "variant_crafting_table_mod_not_installed");
		}

		@Override
		public void write(JsonObject json, VariantCraftingTableModNotInstalledCondition value) {
			// Nothing to write...
		}

		@Override
		public VariantCraftingTableModNotInstalledCondition read(JsonObject json) {
			return new VariantCraftingTableModNotInstalledCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}

