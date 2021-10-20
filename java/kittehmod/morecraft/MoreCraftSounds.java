package kittehmod.morecraft;

import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MoreCraftSounds
{
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MoreCraft.MODID);

	public static final RegistryObject<SoundEvent> BOOKSHELF_OPEN = SOUNDS.register("bookshelf_open", () -> new SoundEvent(new ResourceLocation(MoreCraft.MODID, "bookshelf_open")));
	public static final RegistryObject<SoundEvent> BOOKSHELF_CLOSE = SOUNDS.register("bookshelf_close", () -> new SoundEvent(new ResourceLocation(MoreCraft.MODID, "bookshelf_close")));

    @Mod.EventBusSubscriber(modid = MoreCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration
    {
        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> e)
        {
            e.getRegistry().registerAll();
        }
    }

}
