package com.harrio34.citycraft1;

import java.io.File;
import java.util.Arrays;

import com.harrio34.citycraft1.block.ModBlocks;
import com.harrio34.citycraft1.command.CommandHandler;
import com.harrio34.citycraft1.configuration.ConfigurationHandler;
import com.harrio34.citycraft1.core.handlers.ActionRequestHandler;
import com.harrio34.citycraft1.core.handlers.AddonHandler;
import com.harrio34.citycraft1.core.handlers.CraftingHandler;
import com.harrio34.citycraft1.core.handlers.EntityLivingHandler;
import com.harrio34.citycraft1.core.handlers.FuelHandler;
import com.harrio34.citycraft1.core.handlers.ItemEventHandler;
import com.harrio34.citycraft1.core.handlers.PlayerDestroyItemHandler;
import com.harrio34.citycraft1.core.handlers.VersionCheckTickHandler;
import com.harrio34.citycraft1.core.handlers.WorldTransmutationHandler;
import com.harrio34.citycraft1.core.item.ModItems;
import com.harrio34.citycraft1.core.proxy.CommonProxy;
import com.harrio34.citycraft1.core.util.LogHelper;
import com.harrio34.citycraft1.core.util.VersionHelper;
import com.harrio34.citycraft1.creativetab.CreativeTabCityCraft1;
import com.harrio34.citycraft1.lib.Reference;
import com.harrio34.citycraft1.lib.Strings;
import com.harrio34.citycraft1.nbt.NBTHelper;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLFingerprintViolationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLInterModComms.IMCEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = "Reference.MOD_ID", name = "Reference.MOD_NAME", version = "Reference.VERSION")
public class CityCraft
{
	@Instance(Reference.MOD_ID)
    public static CityCraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static CreativeTabs tabsCC1 = new CreativeTabCityCraft1(CreativeTabs.getNextID(), Reference.MOD_ID);

    @EventHandler
    public void invalidFingerprint(FMLFingerprintViolationEvent event) {

        // Report (log) to the user that the version of Equivalent Exchange 3
        // they are using has been changed/tampered with
        if (Reference.FINGERPRINT.equals("@FINGERPRINT@")) {
            LogHelper.warning(Strings.NO_FINGERPRINT_MESSAGE);
        }
        else {
            LogHelper.severe(Strings.INVALID_FINGERPRINT_MESSAGE);
        }
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) 
    {

        // Initialize the custom commands
        CommandHandler.initCommands(event);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        // Initialize the log helper
        LogHelper.init();

        // Initialize the configuration
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CHANNEL_NAME + File.separator + Reference.MOD_ID + ".cfg"));

        // Conduct the version check and log the result
        VersionHelper.execute();

        // Initialize the Version Check Tick Handler (Client only)
        TickRegistry.registerTickHandler(new VersionCheckTickHandler(), Side.CLIENT);

        // Initialize the Render Tick Handler (Client only)
        proxy.registerRenderTickHandler();

        // Register the KeyBinding Handler (Client only)
        proxy.registerKeyBindingHandler();

        // Register the Sound Handler (Client only)
        proxy.registerSoundHandler();

        // Initialize mod blocks
        ModBlocks.init();

        // Initialize mod items
        ModItems.init();
    }

    @EventHandler
    @SuppressWarnings("unchecked")
    public void load(FMLInitializationEvent event) {

        // Register the GUI Handler
        NetworkRegistry.instance().registerGuiHandler(instance, proxy);

        // Register the PlayerDestroyItem Handler
        MinecraftForge.EVENT_BUS.register(new PlayerDestroyItemHandler());

        // Register the Item Pickup Handler
        MinecraftForge.EVENT_BUS.register(new ItemEventHandler());

        // Register the EntityLiving Handler
        MinecraftForge.EVENT_BUS.register(new EntityLivingHandler());

        MinecraftForge.EVENT_BUS.register(new ActionRequestHandler());

        MinecraftForge.EVENT_BUS.register(new WorldTransmutationHandler());

        GameRegistry.registerCraftingHandler(new CraftingHandler());

        // Register the DrawBlockHighlight Handler
        proxy.registerDrawBlockHighlightHandler();

        // Initialize mod tile entities
        proxy.registerTileEntities();

        // Initialize custom rendering and pre-load textures (Client only)
        proxy.initRenderingAndTextures();

        // Add in the ability to dye Block/Item
        CraftingManager.getInstance().getRecipeList().add(new Item());

        // Register the Fuel Handler
        GameRegistry.registerFuelHandler(new FuelHandler());
    }

    @EventHandler
    public void modsLoaded(FMLPostInitializationEvent event) {

        // Initialize the Addon Handler
        AddonHandler.init();

    }
}
