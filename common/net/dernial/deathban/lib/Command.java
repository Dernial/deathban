package net.dernial.deathban.lib;

/**
 * Deathban
 * 
 * Command
 * 
 * @author dernial
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */public class Command
{
    // Commands
    public static final String COMMAND_DEATHBAN = "deathban";
    public static final String COMMAND_ENABLE = "enable";
    public static final String COMMAND_PERMANENT = "permanent";
    public static final String COMMAND_TIME = "time";   
    public static final String COMMAND_FORGIVE = "forgive";
    public static final String COMMAND_FORGIVEALL = "forgiveall";
    
    // Static command parameters
    public static final String COMMAND_ON = "on";
    public static final String COMMAND_OFF = "off";
    
    // Help strings
    public static final String COMMAND_DEATHBAN_USAGE = "deathban [ enable | time | forgive | forgiveall ]";    
    public static final String COMMAND_ENABLE_USAGE = "deathban enable [ on | off ]";
    public static final String COMMAND_PERMANENT_USAGE = "deathban permanent [ on | off ]";
    public static final String COMMAND_TIME_USAGE = "deathban time [ time in minutes ]";
    public static final String COMMAND_FORGIVE_USAGE = "deathban forgive [ player name ]";
}
