package net.dernial.deathban.config;

import java.io.File;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import net.dernial.deathban.lib.Reference;
import net.minecraftforge.common.Configuration;


/**
 * Deathban
 * 
 * ConfigurationHandler
 * 
 * @author dernial
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ConfigurationHandler
{
    public static final String CATEGORY_GENERAL = "general";
    
    public static Configuration configuration;
    
    public static void init(File configFile) {

        configuration = new Configuration(configFile);

        try {
            configuration.load();

            /* General configs */
            ConfigurationSettings.DEATHBAN_ENABLED = configuration.get(CATEGORY_GENERAL, ConfigurationSettings.DEATHBAN_ENABLED_CONFIGNAME, ConfigurationSettings.DEATHBAN_ENABLED_DEFAULT).getBoolean(ConfigurationSettings.DEATHBAN_ENABLED_DEFAULT);
            ConfigurationSettings.DEATHBAN_PERMANENT = configuration.get(CATEGORY_GENERAL, ConfigurationSettings.DEATHBAN_PERMANENT_CONFIGNAME, ConfigurationSettings.DEATHBAN_PERMANENT_DEFAULT).getBoolean(ConfigurationSettings.DEATHBAN_PERMANENT_DEFAULT);
            ConfigurationSettings.DEATHBAN_BAN_TIME = configuration.get(CATEGORY_GENERAL, ConfigurationSettings.DEATHBAN_BAN_TIME_CONFIGNAME, ConfigurationSettings.DEATHBAN_BAN_TIME_DEFAULT).getString();
            ConfigurationSettings.DEATHBAN_PVE_ENABLED = configuration.get(CATEGORY_GENERAL, ConfigurationSettings.DEATHBAN_PVE_ENABLED_CONFIGNAME, ConfigurationSettings.DEATHBAN_PVE_ENABLED_DEFAULT).getBoolean(ConfigurationSettings.DEATHBAN_PVE_ENABLED_DEFAULT);
            ConfigurationSettings.DEATHBAN_PVP_ENABLED = configuration.get(CATEGORY_GENERAL, ConfigurationSettings.DEATHBAN_PVP_ENABLED_CONFIGNAME, ConfigurationSettings.DEATHBAN_PVP_ENABLED_DEFAULT).getBoolean(ConfigurationSettings.DEATHBAN_PVP_ENABLED_DEFAULT);
            
       }
        catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its configuration");
        }
        finally {
            configuration.save();
        }
    }
    
    public static void set(String categoryName, String propertyName, String newValue) {

        configuration.load();
        if (configuration.getCategoryNames().contains(categoryName)) {
            if (configuration.getCategory(categoryName).containsKey(propertyName)) {
                configuration.getCategory(categoryName).get(propertyName).set(newValue);
            }
        }
        configuration.save();
    }
}
