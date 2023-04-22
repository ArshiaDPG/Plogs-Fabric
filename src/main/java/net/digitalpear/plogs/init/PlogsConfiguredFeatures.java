package net.digitalpear.plogs.init;

import net.digitalpear.plogs.PlogsMod;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class PlogsConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> PIG_NEST = of("pig_nest");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HOGLIN_NEST = of("hoglin_nest");


    public static RegistryKey<ConfiguredFeature<?, ?>> of(String id) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(PlogsMod.MOD_ID, id));
    }
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        ConfiguredFeatures.register(featureRegisterable, PIG_NEST, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(50, 7, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(PlogsBlocks.LOG_PIG)), BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.noFluid(), BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), Blocks.GRASS_BLOCK)))));
        ConfiguredFeatures.register(featureRegisterable, HOGLIN_NEST, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(50, 7, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(PlogsBlocks.LOG_PIG)), BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.noFluid(), BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), Blocks.CRIMSON_NYLIUM)))));
    }
}
