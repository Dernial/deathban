package net.dernial.deathban.commands;


import net.dernial.deathban.config.ConfigurationHandler;
import net.dernial.deathban.config.ConfigurationSettings;
import net.dernial.deathban.handlers.LanguageHandler;
import net.dernial.deathban.lib.Command;
import net.dernial.deathban.lib.Strings;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatMessageComponent;

/**
 * Deathban
 * 
 * CommandEnable
 * 
 * @author dernial
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class CommandEnable
{
    /**
     * Processes the command Enable
     * 
     * @param commandSender ICommandSender passed from CommandHandler
     * @param args the sub args for the command
     */
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
                throw new WrongUsageException(Command.COMMAND_ENABLE_USAGE, new Object[0]);
        }
        else
            throw new WrongUsageException(Command.COMMAND_ENABLE_USAGE, new Object[0]);
    }
    
    // Enabled turned on
    private static void processOnCommand(ICommandSender commandSender) {

        ConfigurationSettings.DEATHBAN_ENABLED = true;
        ConfigurationHandler.set(ConfigurationHandler.CATEGORY_GENERAL, ConfigurationSettings.DEATHBAN_ENABLED_CONFIGNAME, Strings.TRUE);
        commandSender.sendChatToPlayer(ChatMessageComponent.func_111082_b(LanguageHandler.getLocalizedString("command.deathban.enable.turned_on")));
    }
    
    // Enabled turned off
    private static void processOffCommand(ICommandSender commandSender) {

        ConfigurationSettings.DEATHBAN_ENABLED = false;
        ConfigurationHandler.set(ConfigurationHandler.CATEGORY_GENERAL, ConfigurationSettings.DEATHBAN_ENABLED_CONFIGNAME, Strings.FALSE);
        commandSender.sendChatToPlayer(ChatMessageComponent.func_111082_b(LanguageHandler.getLocalizedString("command.deathban.enable.turned_off")));   
    }
}
