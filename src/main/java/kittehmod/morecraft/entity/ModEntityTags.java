package kittehmod.morecraft.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class ModEntityTags
{
	public static final TagKey<EntityType<?>> ENDER_MOBS = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge", "ender_mobs"));
}
