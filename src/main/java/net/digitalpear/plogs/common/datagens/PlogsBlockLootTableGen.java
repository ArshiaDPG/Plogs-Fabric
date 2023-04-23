package net.digitalpear.plogs.common.datagens;

import net.digitalpear.plogs.init.PlogsBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class PlogsBlockLootTableGen extends FabricBlockLootTableProvider {
    public PlogsBlockLootTableGen(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> biConsumer) {
        makeLoot(biConsumer, PlogsBlocks.LOG_PIG, dropsWithSilkTouch(PlogsBlocks.LOG_PIG));
        makeLoot(biConsumer, PlogsBlocks.LOG_SNOW_PIG, dropsWithSilkTouch(PlogsBlocks.LOG_SNOW_PIG));
        makeLoot(biConsumer, PlogsBlocks.STEM_HOGLIN, dropsWithSilkTouch(PlogsBlocks.STEM_HOGLIN));
        makeLoot(biConsumer, PlogsBlocks.STEM_ZOGLIN, dropsWithSilkTouch(PlogsBlocks.STEM_ZOGLIN));
    }

    public void makeLoot(BiConsumer<Identifier, LootTable.Builder> biConsumer, Block block){
        biConsumer.accept(Registries.BLOCK.getId(block).withPrefixedPath("blocks/"), this.drops(block));
    }
    public void makeLoot(BiConsumer<Identifier, LootTable.Builder> biConsumer, Block block, net.minecraft.loot.LootTable.Builder builder){
        biConsumer.accept(Registries.BLOCK.getId(block).withPrefixedPath("blocks/"), builder);
    }
}
