package kittehmod.morecraft.item.crafting;

import kittehmod.morecraft.MoreCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRecipeType
{
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, MoreCraft.MODID);
	
	public static final RegistryObject<RecipeType<KilnRecipe>> KILN = RECIPE_TYPES.register("kiln", () -> RecipeType.simple(new ResourceLocation("morecraft", "kiln")));

}
