package net.digitalpear.plogs.common.datagens;

import net.digitalpear.plogs.init.PlogsBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class PlogsLangGen extends FabricLanguageProvider {
    public PlogsLangGen(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(PlogsBlocks.LOG_PIG, "Log of Pig");
        translationBuilder.add(PlogsBlocks.STEM_HOGLIN, "Stem of Hoglin");
        translationBuilder.add(PlogsBlocks.STEM_ZOGLIN, "Stem of Zoglin");
    }
}
