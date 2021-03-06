package kittehmod.morecraft.block;

import kittehmod.morecraft.container.ModWorkbenchContainer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ModCraftingTableBlock extends CraftingTableBlock
{
	public static final ITextComponent TITLE = new TranslationTextComponent("container.crafting");
    
	public ModCraftingTableBlock(Block.Properties properties) 
	{
		super(properties);
	}

    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
    {
    	if (worldIn.isClientSide) {
    		return ActionResultType.SUCCESS;
    	} else {
    		player.openMenu(state.getMenuProvider(worldIn, pos));
    		player.awardStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
    		return ActionResultType.CONSUME;
    	}
    }
    
    @Override
    public INamedContainerProvider getMenuProvider(BlockState state, World worldIn, BlockPos pos) {
        return new SimpleNamedContainerProvider((id, inventory, player) -> {
           return new ModWorkbenchContainer(id, inventory, IWorldPosCallable.create(worldIn, pos), this.getBlock());
        }, TITLE);
    }
    
}
