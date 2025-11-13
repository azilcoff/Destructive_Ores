package net.azilcoff.uranium.datagen;

import net.azilcoff.uranium.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createShaped(RecipeCategory.COMBAT, ModItems.URANIUM_SWORD)
                        .pattern(" U ")
                        .pattern(" U ")
                        .pattern(" S ")
                        .input('U', ModItems.URANIUM)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.URANIUM), conditionsFromItem(ModItems.URANIUM))
                        .offerTo(recipeExporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Destructive Ores recipes";
    }
}
