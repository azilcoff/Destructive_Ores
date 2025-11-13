package net.azilcoff.uranium.world;

import net.azilcoff.uranium.Uranium;
import net.azilcoff.uranium.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> URANIUM_ORE_KEY = registerKey("uranium_ore");


    public static void bootstrap (Registerable<ConfiguredFeature<?, ?>> context){
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldUraniumReplaceables = List.of(
                OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.URANIUM_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_URANIUM_ORE.getDefaultState())
        );

        registerFeature(context, URANIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldUraniumReplaceables,5));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void registerFeature(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key,
                                                                                          F featureEntry, FC featureConfigEntry){
        context.register(key, new ConfiguredFeature<>(featureEntry, featureConfigEntry));
    }

    private static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String id){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Uranium.MOD_ID, id));
    }
}
