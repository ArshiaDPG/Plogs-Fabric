package net.digitalpear.plogs.init;

import net.digitalpear.plogs.PlogsMod;
import net.digitalpear.plogs.common.LogPigBlock;
import net.digitalpear.plogs.common.StemHoglinBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
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

    public static final Block LOG_PIG = createBlockWithItem("log_pig", new LogPigBlock(Blocks.OAK_LOG,FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN)), ItemGroup.DECORATIONS);
    public static final Block STEM_HOGLIN = createBlockWithItem("stem_hoglin", new StemHoglinBlock(Blocks.CRIMSON_STEM,FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.DULL_PINK)), ItemGroup.DECORATIONS);

    public static void init(){
        PlogsMod.LOGGER.info("Registering Mod Blocks for " + MOD_ID);
    }
}
