package net.digitalpear.plogs.init;

import net.digitalpear.plogs.PlogsMod;
import net.digitalpear.plogs.common.blocks.AbstractPigLogBlock;
import net.digitalpear.plogs.common.blocks.StemHoglinBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


@SuppressWarnings("unused")
public class PlogsBlocks {
    public static String MOD_ID = PlogsMod.MOD_ID;

    public static boolean isFDLoaded() {
        return FabricLoader.getInstance().getModContainer("snowpig").isPresent();
    }
    public static BlockItem createBlockItem(String blockID, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM, new Identifier(MOD_ID, blockID), new BlockItem(block, new FabricItemSettings().group(group)));
    }
    private static Block createBlockWithItem(String blockID, Block block, ItemGroup group){
        createBlockItem(blockID, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(MOD_ID, blockID), block);
    }
    private static AbstractBlock.Settings createPigLogBlock(Block baseBlock){
        return FabricBlockSettings.of(baseBlock.getDefaultState().getMaterial(), baseBlock.getDefaultMapColor()).sounds(BlockSoundGroup.WOOD);
    }
    private static AbstractBlock.Settings createPigStemBlock(Block baseBlock){
        return FabricBlockSettings.of(baseBlock.getDefaultState().getMaterial(), baseBlock.getDefaultMapColor()).sounds(BlockSoundGroup.NETHER_STEM);
    }

    public static final Block LOG_PIG = createBlockWithItem("log_pig", new AbstractPigLogBlock(EntityType.PIG, Blocks.OAK_LOG,createPigLogBlock(Blocks.OAK_LOG)), ItemGroup.DECORATIONS);
    public static final Block STEM_HOGLIN = createBlockWithItem("stem_hoglin", new StemHoglinBlock(EntityType.HOGLIN, Blocks.CRIMSON_STEM,createPigStemBlock(Blocks.CRIMSON_STEM)), ItemGroup.DECORATIONS);
    public static final Block STEM_ZOGLIN = createBlockWithItem("stem_zoglin", new AbstractPigLogBlock(EntityType.ZOGLIN, Blocks.WARPED_STEM,createPigStemBlock(Blocks.WARPED_STEM)), ItemGroup.DECORATIONS);


    public static void init(){
        PlogsMod.LOGGER.info("Registering blocks for " + MOD_ID);
    }
}
