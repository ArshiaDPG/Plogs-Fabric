package net.digitalpear.plogs.init;

import net.digitalpear.plogs.PlogsMod;
import net.digitalpear.plogs.client.PlogsModClient;
import net.digitalpear.plogs.common.blocks.AbstractPigLogBlock;
import net.digitalpear.plogs.common.blocks.StemHoglinBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class PlogsBlocks {
    public static String MOD_ID = PlogsMod.MOD_ID;


    public static boolean isSnowPigLoaded() {
        return FabricLoader.getInstance().getModContainer("snowpig").isPresent();
    }


    public static BlockItem createBlockItem(String blockID, Block block){
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, blockID), new BlockItem(block, new FabricItemSettings()));
    }
    private static Block createBlockWithItem(String blockID, Block block){
        createBlockItem(blockID, block);
        return Registry.register(Registries.BLOCK, new Identifier(MOD_ID, blockID), block);
    }
    public static AbstractBlock.Settings makePigLog(Block log){
        return AbstractBlock.Settings.of(log.getDefaultState().getMaterial()).sounds(log.getDefaultState().getSoundGroup()).hardness(log.getHardness() / 2.0F).resistance(log.getBlastResistance() / 2.0F);
    }


    public static final Block LOG_PIG = createBlockWithItem("log_pig", new AbstractPigLogBlock(EntityType.PIG, Blocks.OAK_LOG, makePigLog(Blocks.OAK_LOG)));
    public static final Block STEM_HOGLIN = createBlockWithItem("stem_hoglin", new StemHoglinBlock(EntityType.HOGLIN, Blocks.CRIMSON_STEM, makePigLog(Blocks.CRIMSON_STEM)));
    public static final Block STEM_ZOGLIN = createBlockWithItem("stem_zoglin", new AbstractPigLogBlock(EntityType.ZOGLIN, Blocks.WARPED_STEM, makePigLog(Blocks.WARPED_STEM)));
    public static final Block LOG_SNOW_PIG = createBlockWithItem("log_snow_pig", new AbstractPigLogBlock(new Identifier("snowpig", "snow_pig"), Blocks.SPRUCE_LOG, makePigLog(Blocks.SPRUCE_LOG)));


    public static void init(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(LOG_PIG);
            entries.add(STEM_HOGLIN);
            entries.add(STEM_ZOGLIN);
            if (isSnowPigLoaded()){
                entries.add(LOG_SNOW_PIG);
            }
        });


    }
}
