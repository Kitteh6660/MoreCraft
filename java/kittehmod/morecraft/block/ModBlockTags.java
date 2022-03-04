package kittehmod.morecraft.block;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags
{
	public static final TagKey<Block> CRATES = BlockTags.create(new ResourceLocation("charm", "crates"));
	public static final TagKey<Block> BOOKCASES = BlockTags.create(new ResourceLocation("charm", "bookcases"));
	public static final TagKey<Block> RUBY_ORES = BlockTags.create(new ResourceLocation(MoreCraft.MODID, "ruby_ores"));
}
