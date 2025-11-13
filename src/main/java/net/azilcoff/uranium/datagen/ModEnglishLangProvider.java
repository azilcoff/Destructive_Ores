package net.azilcoff.uranium.datagen;

import net.azilcoff.uranium.block.ModBlocks;
import net.azilcoff.uranium.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    public ModEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.URANIUM, "Uranium");
        translationBuilder.add(ModItems.URANIUM_SWORD,"Uranium Sword");
        translationBuilder.add("effect.dores.high_radiation","High Radiation");
        translationBuilder.add(ModBlocks.URANIUM_ORE,"Uranium Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_URANIUM_ORE, "Deepslate Uranium Ore");
    }
}
