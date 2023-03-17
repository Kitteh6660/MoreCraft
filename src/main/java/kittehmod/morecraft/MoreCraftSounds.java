package kittehmod.morecraft;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MoreCraftSounds
{
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MoreCraft.MODID);

	public static final RegistryObject<SoundEvent> BOOKSHELF_OPEN = SOUNDS.register("bookshelf_open", () -> new SoundEvent(new ResourceLocation(MoreCraft.MODID, "bookshelf_open")));
	public static final RegistryObject<SoundEvent> BOOKSHELF_CLOSE = SOUNDS.register("bookshelf_close", () -> new SoundEvent(new ResourceLocation(MoreCraft.MODID, "bookshelf_close")));
}
