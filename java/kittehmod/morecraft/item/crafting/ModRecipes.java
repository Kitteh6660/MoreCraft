package kittehmod.morecraft.item.crafting;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes
{
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MoreCraft.MODID);
	
	public static RegistryObject<RecipeSerializer<?>> KILN = RECIPE_SERIALIZERS.register("kiln", () -> new KilnRecipeSerializer<>(KilnRecipe::new, 100));
	
	public static final RecipeBookType KILN_RECIPE_BOOK = RecipeBookType.create("morecraft:kiln");

	
    @Mod.EventBusSubscriber(modid = MoreCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration
    {
        @SubscribeEvent
        public static void onRecipeRegistry(final RegistryEvent.Register<RecipeSerializer<?>> e)
        {
            e.getRegistry().registerAll();
        }
    }
}
