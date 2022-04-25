package net.digitalpear.plogs.init;

import net.digitalpear.plogs.PlogsMod;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class PlogsTags {
    public static String MOD_ID = PlogsMod.MOD_ID;

    public static final TagKey<Block> PIG_LOGS = TagKey.of(Registry.BLOCK_KEY, new Identifier(MOD_ID, "pig_logs"));
    public static final TagKey<Biome> HAS_LOG_PIG = TagKey.of(Registry.BIOME_KEY, new Identifier(MOD_ID, "has_log_pig"));

    public static void init(){
        PlogsMod.LOGGER.info("Registering Mod tags for " + MOD_ID);
    }
}
