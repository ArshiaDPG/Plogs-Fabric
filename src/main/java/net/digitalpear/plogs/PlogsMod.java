package net.digitalpear.plogs;

import net.digitalpear.plogs.init.PlogsBlocks;
import net.digitalpear.plogs.init.PlogsWorldGen;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlogsMod implements ModInitializer {
    public static String MOD_ID = "plogs";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        PlogsBlocks.init();
        //Worldgen is being tested, is not guaranteed to work
        PlogsWorldGen.init();
    }
}
