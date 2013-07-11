package net.dernial.deathban.config;

/**
 * Deathban
 * 
 * ConfigurationSettings
 * 
 * @author dernial
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ConfigurationSettings
{
    // Deathban is enabled?
    public static boolean DEATHBAN_ENABLED;
    public static final String DEATHBAN_ENABLED_CONFIGNAME = "deathban.enabled";
    public static final boolean DEATHBAN_ENABLED_DEFAULT = true;

    // Deathban is perminant?
    public static boolean DEATHBAN_PERMANENT;
    public static final String DEATHBAN_PERMANENT_CONFIGNAME = "deathban.permanent";
    public static final boolean DEATHBAN_PERMANENT_DEFAULT = false;    
    
    // Deathban ban time
    public static String DEATHBAN_BAN_TIME;
    public static final String DEATHBAN_BAN_TIME_CONFIGNAME = "deathban.bantime.time";
    public static final String DEATHBAN_BAN_TIME_DEFAULT = "0D0H10M";
    
    // PVP Enabled?
    public static Boolean DEATHBAN_PVP_ENABLED;
    public static final String DEATHBAN_PVP_ENABLED_CONFIGNAME = "deathban.enable.pvp";
    public static final Boolean DEATHBAN_PVP_ENABLED_DEFAULT = true;
    
    // PVE Enabled?
    public static Boolean DEATHBAN_PVE_ENABLED;
    public static final String DEATHBAN_PVE_ENABLED_CONFIGNAME = "deathban.enable.pve";
    public static final Boolean DEATHBAN_PVE_ENABLED_DEFAULT = true;    
}
