package com.harrio34.citycraft1.core.handlers;

import java.util.EnumSet;

import com.harrio34.citycraft1.configuration.ConfigurationHandler;
import com.harrio34.citycraft1.configuration.ConfigurationSettings;
import com.harrio34.citycraft1.core.util.VersionHelper;
import com.harrio34.citycraft1.lib.Reference;
import com.harrio34.citycraft1.lib.Strings;

import net.minecraftforge.common.Configuration;



import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class VersionCheckTickHandler implements ITickHandler {


    private static boolean initialized = false;

    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData) {

    }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData) {

        if (ConfigurationSettings.DISPLAY_VERSION_RESULT) {
            if (!initialized) {
                for (TickType tickType : type) {
                    if (tickType == TickType.CLIENT) {
                        if (FMLClientHandler.instance().getClient().currentScreen == null) {
                            if (VersionHelper.getResult() != VersionHelper.UNINITIALIZED || VersionHelper.getResult() != VersionHelper.FINAL_ERROR) {

                                initialized = true;

                                if (VersionHelper.getResult() == VersionHelper.OUTDATED) {
                                    FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(VersionHelper.getResultMessageForClient());
                                    ConfigurationHandler.set(Configuration.CATEGORY_GENERAL, ConfigurationSettings.DISPLAY_VERSION_RESULT_CONFIGNAME, Strings.FALSE);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public EnumSet<TickType> ticks() {

        return EnumSet.of(TickType.CLIENT);
    }

    @Override
    public String getLabel() {

        return Reference.MOD_NAME + ": " + this.getClass().getSimpleName();
    }

}
