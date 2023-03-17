package kittehmod.morecraft.entity;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class ModEntityTags
{
	public static final TagKey<EntityType<?>> ENDER_MOBS = TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge", "ender_mobs"));
}
