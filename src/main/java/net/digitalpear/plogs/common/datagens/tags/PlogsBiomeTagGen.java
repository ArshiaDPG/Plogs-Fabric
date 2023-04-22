package net.digitalpear.plogs.common.datagens.tags;

import net.digitalpear.plogs.init.tags.PlogsBiomeTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

import java.util.concurrent.CompletableFuture;

public class PlogsBiomeTagGen extends FabricTagProvider<Biome> {
    /**
     * Constructs a new {@link FabricTagProvider} with the default computed path.
     *
     * <p>Common implementations of this class are provided.
     *
     * @param output           the {@link FabricDataOutput} instance
     * @param registriesFuture the backing registry for the tag type
     */
    public PlogsBiomeTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BIOME, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(PlogsBiomeTags.HAS_PIG_NEST).add(BiomeKeys.FOREST).add(BiomeKeys.PLAINS).add(BiomeKeys.MEADOW);
        getOrCreateTagBuilder(PlogsBiomeTags.HAS_HOGLIN_NEST).add(BiomeKeys.CRIMSON_FOREST);
    }
}
