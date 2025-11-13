package net.azilcoff.uranium.datagen;

import net.azilcoff.uranium.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import static net.azilcoff.uranium.tag.ModBlockTags.*;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(INCORRECT_FOR_URANIUM)
                .forceAddTag(BlockTags.INCORRECT_FOR_IRON_TOOL);

        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.URANIUM_ORE, ModBlocks.DEEPSLATE_URANIUM_ORE);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.URANIUM_ORE, ModBlocks.DEEPSLATE_URANIUM_ORE);
    }
}
