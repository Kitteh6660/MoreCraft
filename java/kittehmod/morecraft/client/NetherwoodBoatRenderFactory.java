package kittehmod.morecraft.client;

import kittehmod.morecraft.entity.NetherwoodBoatEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class NetherwoodBoatRenderFactory implements IRenderFactory<NetherwoodBoatEntity> {
	
	public static final NetherwoodBoatRenderFactory INSTANCE = new NetherwoodBoatRenderFactory();
	
	@Override
	public EntityRenderer<? super NetherwoodBoatEntity> createRenderFor(EntityRendererManager manager) 
	{
		try {
			return new NetherwoodBoatEntityRenderer(manager);
		} catch (Exception e) {
			return null;
		}
	}
}
