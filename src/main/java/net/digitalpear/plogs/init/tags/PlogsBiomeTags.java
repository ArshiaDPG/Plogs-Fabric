package net.digitalpear.plogs.init.tags;

import net.digitalpear.plogs.PlogsMod;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class PlogsBiomeTags {
    public static final TagKey<Biome> HAS_PIG_NEST = of("nests/has_pig_nest");
    public static final TagKey<Biome> HAS_HOGLIN_NEST = of("nests/has_hoglin_nest");

    private static TagKey<Biome> of(String id) {
        return TagKey.of(RegistryKeys.BIOME, new Identifier(PlogsMod.MOD_ID, id));
    }
}
