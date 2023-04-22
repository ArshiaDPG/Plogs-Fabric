package net.digitalpear.plogs;

import net.digitalpear.plogs.init.PlogsBlocks;
import net.digitalpear.plogs.init.PlogsPlacedFeatures;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlogsMod implements ModInitializer {
    public static String MOD_ID = "plogs";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        PlogsBlocks.init();
        PlogsPlacedFeatures.init();


        LOGGER.info(MOD_ID + " initialized correctly.");
    }
}
