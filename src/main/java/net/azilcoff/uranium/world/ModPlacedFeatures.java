package net.azilcoff.uranium.world;

import net.azilcoff.uranium.Uranium;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;


public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> URANIUM_PLACEMENT_KEY = registerKey("uranium_placement");

    public static void bootstrap (Registerable<PlacedFeature> context){
        RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        registerFeaturePlacement(context,URANIUM_PLACEMENT_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.URANIUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(
                        12,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-50), YOffset.fixed( -15))
                ));
    }

    private static void registerFeaturePlacement(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> feature
            , List<PlacementModifier> modifiers){
        context.register(key, new PlacedFeature(feature,List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        registerFeaturePlacement(context, key, configuration, List.of(modifiers));
    }

    private static RegistryKey<PlacedFeature> registerKey(String id){
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Uranium.MOD_ID, id));
    }
}
