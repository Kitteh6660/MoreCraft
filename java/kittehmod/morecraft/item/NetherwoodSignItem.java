package kittehmod.morecraft.item;

import javax.annotation.Nullable;

import kittehmod.morecraft.client.gui.ModEditSignScreen;
import kittehmod.morecraft.tileentity.NetherwoodSignTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SignItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;

public class NetherwoodSignItem extends SignItem {
	
	public NetherwoodSignItem(Item.Properties propertiesIn, Block floorBlockIn, Block wallBlockIn) {
		super(propertiesIn, floorBlockIn, wallBlockIn);
	}

	@Override
	protected boolean onBlockPlaced(BlockPos pos, World worldIn, @Nullable PlayerEntity player, ItemStack stack, BlockState state) {
		boolean flag = setTileEntityNBT(worldIn, player, pos, stack);
		if (!worldIn.isRemote && !flag && player != null) {
			//player.openSignEditor((NetherwoodSignTileEntity)worldIn.getTileEntity(pos));
			NetherwoodSignTileEntity te = ((NetherwoodSignTileEntity)worldIn.getTileEntity(pos));
			DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
				openGUI(te);
			});
		}
		return flag;
	}
	
	@OnlyIn(Dist.CLIENT)
	private void openGUI(NetherwoodSignTileEntity tileEntityIn) {
		Minecraft mc = Minecraft.getInstance();
		mc.displayGuiScreen(new ModEditSignScreen(tileEntityIn));		
	}
}
