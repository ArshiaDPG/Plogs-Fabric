package net.digitalpear.plogs.client;

import net.digitalpear.plogs.init.PlogsBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class PlogsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(PlogsBlocks.LOG_PIG, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PlogsBlocks.STEM_HOGLIN, RenderLayer.getCutout());
    }
}
