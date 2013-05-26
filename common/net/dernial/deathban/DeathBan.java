package net.dernial.deathban;

import java.io.File;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import net.dernial.deathban.commands.CommandHandler;
import net.dernial.deathban.config.ConfigurationHandler;
import net.dernial.deathban.handlers.EventHandler;
import net.dernial.deathban.handlers.LanguageHandler;
import net.dernial.deathban.handlers.PlayerDeathHandler;
import net.dernial.deathban.lib.Reference;
import net.dernial.deathban.handlers.BanHandler;
import net.minecraftforge.common.MinecraftForge;

/**
 * Deathban
 * 
 * DeathBan
 * 
 * @author dernial
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired=false, serverSideRequired=false, connectionHandler=BanHandler.class)
public class DeathBan {

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        // Initialize the configuration
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CHANNEL_NAME + File.separator + Reference.MOD_ID + ".cfg"));
        
        // Configure location of banned names
        Reference.BAN_FILE = event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CHANNEL_NAME + File.separator + "banfile.cfg";
        
        // Load the banned players
        PlayerDeathHandler.loadBans(Reference.BAN_FILE);
    }
    

    @Init
    public void init(FMLInitializationEvent event) {
        // Register event handler
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        
        // Load the language files
        LanguageHandler.loadLanguages();
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        
    }
    
    @ServerStarting
    public void serverStarting(FMLServerStartingEvent event){
        // Register Commands
        event.registerServerCommand(new CommandHandler());
    }
}
