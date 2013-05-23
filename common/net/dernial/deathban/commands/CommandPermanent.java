package net.dernial.deathban.commands;

import net.dernial.deathban.config.ConfigurationHandler;
import net.dernial.deathban.config.ConfigurationSettings;
import net.dernial.deathban.lib.Command;
import net.dernial.deathban.lib.Strings;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;

/**
 * Deathban
 * 
 * CommandPermanent
 * 
 * @author dernial
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class CommandPermanent
{
    public static void processCommand(ICommandSender commandSender, String[] args) {

        String subCommand;

        if (args.length > 0) {
            subCommand = args[0];

            if (subCommand.equalsIgnoreCase(Command.COMMAND_ON)) {
                processOnCommand(commandSender);
            }
            else if (subCommand.equalsIgnoreCase(Command.COMMAND_OFF)) {
                processOffCommand(commandSender);
            }
            else
                throw new WrongUsageException(Command.COMMAND_PERMANENT_USAGE, new Object[0]);
        }
        else
            throw new WrongUsageException(Command.COMMAND_PERMANENT_USAGE, new Object[0]);
    }
    
    private static void processOnCommand(ICommandSender commandSender) {

        ConfigurationSettings.DEATHBAN_PERMANENT = true;
        ConfigurationHandler.set(ConfigurationHandler.CATEGORY_GENERAL, ConfigurationSettings.DEATHBAN_PERMANENT_CONFIGNAME, Strings.TRUE);
        commandSender.sendChatToPlayer("DeathBan is now permanent");
    }

    private static void processOffCommand(ICommandSender commandSender) {

        ConfigurationSettings.DEATHBAN_PERMANENT = false;
        ConfigurationHandler.set(ConfigurationHandler.CATEGORY_GENERAL, ConfigurationSettings.DEATHBAN_PERMANENT_CONFIGNAME, Strings.FALSE);
        commandSender.sendChatToPlayer("DeathBan is now timed.");    
    }
}
