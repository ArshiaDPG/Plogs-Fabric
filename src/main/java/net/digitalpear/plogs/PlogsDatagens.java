package net.digitalpear.plogs;

import net.digitalpear.plogs.common.datagens.PlogsLangGen;
import net.digitalpear.plogs.common.datagens.models.PlogsModelGen;
import net.digitalpear.plogs.common.datagens.providers.PlogsConfiguredFeatureProvider;
import net.digitalpear.plogs.common.datagens.providers.PlogsPlacedFeatureProvider;
import net.digitalpear.plogs.common.datagens.tags.PlogsBiomeTagGen;
import net.digitalpear.plogs.common.datagens.tags.PlogsBlockTagGen;
import net.digitalpear.plogs.init.PlogsConfiguredFeatures;
import net.digitalpear.plogs.init.PlogsPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class PlogsDatagens implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.createPack().addProvider(PlogsLangGen::new);
        fabricDataGenerator.createPack().addProvider(PlogsModelGen::new);

        fabricDataGenerator.createPack().addProvider(PlogsConfiguredFeatureProvider::new);
        fabricDataGenerator.createPack().addProvider(PlogsPlacedFeatureProvider::new);

        fabricDataGenerator.createPack().addProvider(PlogsBiomeTagGen::new);
        fabricDataGenerator.createPack().addProvider(PlogsBlockTagGen::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, PlogsConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, PlogsPlacedFeatures::bootstrap);
    }
}
