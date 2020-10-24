package kittehmod.morecraft.client;

import kittehmod.morecraft.entity.NetherBoatEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class NetherBoatRenderFactory implements IRenderFactory<NetherBoatEntity> {
	
	public static final NetherBoatRenderFactory INSTANCE = new NetherBoatRenderFactory();
	
	@Override
	public EntityRenderer<? super NetherBoatEntity> createRenderFor(EntityRendererManager manager) 
	{
		try {
			return new NetherBoatEntityRenderer(manager);
		} catch (Exception e) {
			return null;
		}
	}
}
