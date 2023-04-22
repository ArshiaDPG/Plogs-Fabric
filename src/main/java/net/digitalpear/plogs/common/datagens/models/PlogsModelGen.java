package net.digitalpear.plogs.common.datagens.models;

import net.digitalpear.plogs.PlogsMod;
import net.digitalpear.plogs.common.blocks.AbstractPigLogBlock;
import net.digitalpear.plogs.init.PlogsBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class PlogsModelGen extends FabricModelProvider {
    public static final Model PIG_LOG_BASE = block("log_pig_base", PlogsTextureKeys.LOG_END, PlogsTextureKeys.LOG_SIDE, PlogsTextureKeys.HOLE);


    private static Model block(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier(PlogsMod.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }
    private static Model block(String id,String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier(id, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    public PlogsModelGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        makePigLog(blockStateModelGenerator, (AbstractPigLogBlock) PlogsBlocks.LOG_PIG);
        makePigLog(blockStateModelGenerator, (AbstractPigLogBlock) PlogsBlocks.STEM_HOGLIN);
        makePigLog(blockStateModelGenerator, (AbstractPigLogBlock) PlogsBlocks.STEM_ZOGLIN);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
    public TextureMap pigLog(Block block, EntityType<?> entityType) {
        return new TextureMap()
                .put(PlogsTextureKeys.LOG_SIDE, ModelIds.getBlockModelId(block))
                .put(PlogsTextureKeys.LOG_END, ModelIds.getBlockSubModelId(block, "_top"))
                .put(PlogsTextureKeys.HOLE, getPig(entityType));
    }
    public TextureMap pigLog(Block block, EntityType<?> entityType, String modName) {
        return new TextureMap()
                .put(PlogsTextureKeys.LOG_SIDE, ModelIds.getBlockModelId(block))
                .put(PlogsTextureKeys.LOG_END, ModelIds.getBlockSubModelId(block, "_top"))
                .put(PlogsTextureKeys.HOLE, getPig(entityType, modName));
    }

    public static Identifier getPig(EntityType<?> entityType, String namespace) {
        return new Identifier(namespace, Registries.ENTITY_TYPE.getId(entityType).getPath()).withSuffixedPath("_hole").withPrefixedPath("block/");
    }
    public static Identifier getPig(EntityType<?> entityType) {
        return Registries.ENTITY_TYPE.getId(entityType).withSuffixedPath("_hole").withPrefixedPath("block/");
    }

    public void makePigLog(BlockStateModelGenerator blockStateModelGenerator, AbstractPigLogBlock plog){
        Identifier MODEL = PIG_LOG_BASE.upload(plog, pigLog(plog.getLog(), plog.getPigType(), PlogsMod.MOD_ID), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(plog);
    }
    public void makePigLog(BlockStateModelGenerator blockStateModelGenerator, AbstractPigLogBlock plog, String modName){
        Identifier MODEL = PIG_LOG_BASE.upload(plog, pigLog(plog.getLog(), plog.getPigType(), modName), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(plog);
    }

}
