package com.harrio34.citycraft1;

import net.minecraft.creativetab.CreativeTabs;

import com.harrio34.citycraft1.block.ModBlocks;
import com.harrio34.citycraft1.core.proxy.CommonProxy;
import com.harrio34.citycraft1.core.util.LogHelper;
import com.harrio34.citycraft1.creativetab.CreativeTabCityCraft1;
import com.harrio34.citycraft1.item.ModItems;
import com.harrio34.citycraft1.lib.Reference;
import com.harrio34.citycraft1.lib.Strings;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLFingerprintViolationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = "Reference.MOD_ID", name = "Reference.MOD_NAME", version = "Reference.VERSION")
public class CityCraft
{
	@Instance(Reference.MOD_ID)
    public static CityCraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static CreativeTabs tabsCC1 = new CreativeTabCityCraft1(CreativeTabs.getNextID(), Reference.MOD_ID);

    @EventHandler
    public void invalidFingerprint(FMLFingerprintViolationEvent event) 
    {
        // Report (log) to the user that the version of CityCraft
        // they are using has been changed/tampered with
        if (Reference.FINGERPRINT.equals("@FINGERPRINT@")) 
        {
            LogHelper.warning(Strings.NO_FINGERPRINT_MESSAGE);
        }
        else 
        {	
            LogHelper.severe(Strings.INVALID_FINGERPRINT_MESSAGE);
        }
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) 
    {
    	
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {
        // Initialize mod blocks
        ModBlocks.init();

        // Initialize mod items
        ModItems.init();
    }

    @EventHandler
    public void load(FMLInitializationEvent event) 
    {
    	
    }
}
