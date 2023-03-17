//Disabled for now.
/*package kittehmod.morecraft.item.crafting.conditions;

import com.google.gson.JsonObject;

import kittehmod.morecraft.MoreCraft;
import kittehmod.morecraft.MoreCraftConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class MissingVariantStonesCondition implements ICondition
{
	private final ResourceLocation location;

	public MissingVariantStonesCondition(ResourceLocation location) {
		this.location = location;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}

	@Override
	public boolean test(IContext context) {
		return MoreCraftConfig.missingStoneVariants.get();
	}

	public static class Serializer implements IConditionSerializer<MissingVariantStonesCondition> {
		private final ResourceLocation location;

		public Serializer() {
			this.location = new ResourceLocation(MoreCraft.MODID, "missing_stone_variant_blocks");
		}

		@Override
		public void write(JsonObject json, MissingVariantStonesCondition value) {
			json.addProperty("config", MoreCraftConfig.missingStoneVariants.get());
		}

		@Override
		public MissingVariantStonesCondition read(JsonObject json) {
			return new MissingVariantStonesCondition(this.location);
		}

		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
}*/

