package kittehmod.morecraft.block;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;

public class ModBlockTags
{
	public static final Tag.Named<Block> CRATES = BlockTags.createOptional(new ResourceLocation("charm", "crates"));
	public static final Tag.Named<Block> BOOKCASES = BlockTags.createOptional(new ResourceLocation("charm", "bookcases"));
	public static final Tag.Named<Block> RUBY_ORES = BlockTags.createOptional(new ResourceLocation(MoreCraft.MODID, "ruby_ores"));
}
