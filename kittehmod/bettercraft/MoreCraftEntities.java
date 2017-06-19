package kittehmod.bettercraft;

import kittehmod.bettercraft.entity.EntityNetherwoodBoat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MoreCraftEntities {

	public static void registerEntities() {
		//Tile Entities
    	GameRegistry.registerTileEntity(TileEntityNetherwoodChest.class, "tileentitynetherchest");
    	
    	//Entities
        EntityRegistry.registerModEntity(new ResourceLocation("bettercraft:netherwood_boat"), EntityNetherwoodBoat.class, "netherwood_boat", 0, MoreCraft.instance, 48, 3, true);
	}
	
}
