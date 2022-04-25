package net.digitalpear.plogs.init;

import net.digitalpear.plogs.PlogsMod;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.Arrays;

public class PlogsWorldGen {
    public static final RuleTest OAK_LOGS = new TagMatchRuleTest(BlockTags.OAK_LOGS);
    public static final RuleTest CRIMSON_STEMS = new TagMatchRuleTest(BlockTags.CRIMSON_STEMS);


    private static ConfiguredFeature<?, ?> LOG_PIG_GEN_FEATURE = new ConfiguredFeature
            (Feature.ORE, new OreFeatureConfig(
                    OAK_LOGS,
                    Blocks.DIAMOND_BLOCK.getDefaultState(),
                    1)); // vein size

    public static PlacedFeature LOG_PIG_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(LOG_PIG_GEN_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(20), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.getTop())
            )); // height

    private static ConfiguredFeature<?, ?> STEM_HOG_GEN_FEATURE = new ConfiguredFeature
            (Feature.ORE, new OreFeatureConfig(
                    CRIMSON_STEMS,
                    Blocks.DIAMOND_BLOCK.getDefaultState(),
                    0)); // vein size

    public static PlacedFeature STEM_HOG_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(STEM_HOG_GEN_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(20), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.fixed(40), YOffset.getTop())
            )); // height

    public static void init(){


        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(PlogsMod.MOD_ID, "log_pig_overworld"), LOG_PIG_GEN_FEATURE
        );
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(PlogsMod.MOD_ID, "log_pig_overworld"),
                LOG_PIG_PLACED_FEATURE);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier(PlogsMod.MOD_ID, "stem_hoglin_nether"), STEM_HOG_GEN_FEATURE
        );
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(PlogsMod.MOD_ID, "stem_hoglin_nether"),
                STEM_HOG_PLACED_FEATURE);



        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.TOP_LAYER_MODIFICATION,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier(PlogsMod.MOD_ID, "log_pig_overworld")));
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.TOP_LAYER_MODIFICATION,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier(PlogsMod.MOD_ID, "stem_hoglin_nether")));
    }
}
