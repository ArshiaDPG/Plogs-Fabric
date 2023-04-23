package net.digitalpear.plogs.common.datagens.tags;

import net.digitalpear.plogs.init.PlogsBlocks;
import net.digitalpear.plogs.init.tags.PlogsBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class PlogsBlockTagGen extends FabricTagProvider<Block> {
    /**
     * Constructs a new {@link FabricTagProvider} with the default computed path.
     *
     * <p>Common implementations of this class are provided.
     *
     * @param output           the {@link FabricDataOutput} instance
     * @param registriesFuture the backing registry for the tag type
     */
    public PlogsBlockTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BLOCK, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(PlogsBlockTags.PIG_LOGS).forceAddTag(PlogsBlockTags.PIG_LOGS_THAT_BURN).forceAddTag(PlogsBlockTags.NETHER_PIG_LOGS);
        getOrCreateTagBuilder(PlogsBlockTags.PIG_LOGS_THAT_BURN).add(PlogsBlocks.LOG_PIG).add(PlogsBlocks.LOG_SNOW_PIG);
        getOrCreateTagBuilder(PlogsBlockTags.NETHER_PIG_LOGS).add(PlogsBlocks.STEM_HOGLIN).add(PlogsBlocks.STEM_ZOGLIN);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).forceAddTag(PlogsBlockTags.PIG_LOGS_THAT_BURN);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).forceAddTag(PlogsBlockTags.PIG_LOGS);
    }
}
