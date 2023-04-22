package net.digitalpear.plogs.init;

import net.digitalpear.plogs.PlogsMod;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class PlogsPlacedFeatures {
    public static String MOD_ID = PlogsMod.MOD_ID;

    public static void init(){
        RegistryKey<PlacedFeature> log_pig_patch = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier(MOD_ID, "pig_nest"));
        BiomeModifications.addFeature(BiomeSelectors.tag(PlogsTags.HAS_PIG_NEST), GenerationStep.Feature.VEGETAL_DECORATION, log_pig_patch);

        RegistryKey<PlacedFeature> stem_hoglin_patch = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier(MOD_ID, "hoglin_nest"));
        BiomeModifications.addFeature(BiomeSelectors.tag(PlogsTags.HAS_HOGLIN_NEST), GenerationStep.Feature.VEGETAL_DECORATION, stem_hoglin_patch);

        PlogsMod.LOGGER.info("Registering features for " + MOD_ID);
    }
}
