package net.digitalpear.plogs.init.tags;

import net.digitalpear.plogs.PlogsMod;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class PlogsBlockTags {

    public static final TagKey<Block> PIG_LOGS = of("pig_logs");
    public static final TagKey<Block> NETHER_PIG_LOGS = of("nether_pig_logs");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(PlogsMod.MOD_ID, id));
    }
}
