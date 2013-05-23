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
    public static int DEATHBAN_BAN_MINUTES;
    public static final String DEATHBAN_BAN_MINUTES_CONFIGNAME = "deathban.bantime.minutes";
    public static final int DEATHBAN_BAN_MINUTES_DEFAULT = 1440;
}
