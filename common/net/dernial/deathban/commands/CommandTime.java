package net.dernial.deathban.commands;

import net.dernial.deathban.config.ConfigurationHandler;
import net.dernial.deathban.config.ConfigurationSettings;
import net.dernial.deathban.handlers.LanguageHandler;
import net.dernial.deathban.lib.Command;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;

/**
 * Deathban
 * 
 * CommandTime
 * 
 * @author dernial
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class CommandTime
{
    public static void processCommand(ICommandSender commandSender, String[] args) {

        String subCommand;

        if (args.length > 0) {
            subCommand = args[0];

            if (!subCommand.isEmpty()) {
                ConfigurationSettings.DEATHBAN_BAN_MINUTES = Integer.parseInt(subCommand);
                ConfigurationHandler.set(ConfigurationHandler.CATEGORY_GENERAL, ConfigurationSettings.DEATHBAN_BAN_MINUTES_CONFIGNAME, Integer.toString(ConfigurationSettings.DEATHBAN_BAN_MINUTES));
                commandSender.sendChatToPlayer(LanguageHandler.getLocalizedString("command.deathban.time.setto") + " " + Integer.toString(ConfigurationSettings.DEATHBAN_BAN_MINUTES) + " " + LanguageHandler.getLocalizedString("command.deathban.time.minutes"));
            }
            else
                throw new WrongUsageException(Command.COMMAND_TIME_USAGE, new Object[0]);
        }
        else
            throw new WrongUsageException(Command.COMMAND_TIME_USAGE, new Object[0]);
    }
}
