package kittehmod.morecraft.block;

import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags.IOptionalNamedTag;


public class ModBlockTags
{
	public static final IOptionalNamedTag<Block> CRATES = BlockTags.createOptional(new ResourceLocation("charm", "crates"));
	public static final IOptionalNamedTag<Block> BOOKCASES = BlockTags.createOptional(new ResourceLocation("charm", "bookcases"));
}
