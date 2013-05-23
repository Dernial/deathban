package net.dernial.deathban.lib;

/**
 * Deathban
 * 
 * Reference
 * 
 * @author dernial
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class Reference
{
    /**
     * The mod id
     */
    public static final String MOD_ID = "deathBan";
    
    /**
     * The mod name
     */
    public static final String MOD_NAME = "DeathBan";
    
    /**
     * The version of the mod
     */
    public static final String VERSION = "@VERSION@ (build @BUILD_NUMBER@)";
    
    public static final String CHANNEL_NAME = MOD_ID;

    // The ban file, is set by init function
    public static String BAN_FILE = "";
    
    // The time/date format to use
    public static final String DATETIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
}
