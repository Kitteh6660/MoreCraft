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
	public static final TagKey<Block> KILNS = BlockTags.create(new ResourceLocation(MoreCraft.MODID, "kilns"));
	public static final TagKey<Block> NETHERWOOD_SAPLING_PLANTABLES = BlockTags.create(new ResourceLocation(MoreCraft.MODID, "netherwood_sapling_plantables"));
	public static final TagKey<Block> BANISTERS = BlockTags.create(new ResourceLocation("twilightforest", "banisters"));
}
