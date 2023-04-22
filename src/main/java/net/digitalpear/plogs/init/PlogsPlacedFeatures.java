package net.digitalpear.plogs.init;

import net.digitalpear.plogs.PlogsMod;
import net.digitalpear.plogs.init.tags.PlogsBiomeTags;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationConfiguredFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class PlogsPlacedFeatures {


    public static final RegistryKey<PlacedFeature> PIG_NEST = of("pig_nest");
    public static final RegistryKey<PlacedFeature> HOGLIN_NEST = of("hoglin_nest");


    public static RegistryKey<PlacedFeature> of(String id) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(PlogsMod.MOD_ID, id));
    }
    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntry<ConfiguredFeature<?, ?>> registryEntry11 = registryEntryLookup.getOrThrow(VegetationConfiguredFeatures.PATCH_MELON);
        PlacedFeatures.register(featureRegisterable, PIG_NEST, registryEntry11, RarityFilterPlacementModifier.of(64), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        PlacedFeatures.register(featureRegisterable, HOGLIN_NEST, registryEntry11, RarityFilterPlacementModifier.of(64), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }
    public static void init(){

        BiomeModifications.addFeature(BiomeSelectors.tag(PlogsBiomeTags.HAS_PIG_NEST), GenerationStep.Feature.VEGETAL_DECORATION, PIG_NEST);
        BiomeModifications.addFeature(BiomeSelectors.tag(PlogsBiomeTags.HAS_HOGLIN_NEST), GenerationStep.Feature.VEGETAL_DECORATION, HOGLIN_NEST);
    }
}
