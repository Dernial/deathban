package net.dernial.deathban.commands;

import net.dernial.deathban.config.ConfigurationHandler;
import net.dernial.deathban.config.ConfigurationSettings;
import net.dernial.deathban.handlers.LanguageHandler;
import net.dernial.deathban.handlers.TimeHandler;
import net.dernial.deathban.lib.Command;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatMessageComponent;

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

        if (args.length > 1) {
            subCommand = args[1];

            if (!subCommand.isEmpty()) {
                TimeHandler clTime = new TimeHandler(subCommand);
                
                ConfigurationSettings.DEATHBAN_BAN_TIME = clTime.buildString();
                ConfigurationHandler.set(ConfigurationHandler.CATEGORY_GENERAL, ConfigurationSettings.DEATHBAN_BAN_TIME_CONFIGNAME, ConfigurationSettings.DEATHBAN_BAN_TIME);
                commandSender.sendChatToPlayer(ChatMessageComponent.func_111082_b(LanguageHandler.getLocalizedString("command.deathban.time.setto") + " " + Integer.toString(clTime.days) + " " + LanguageHandler.getLocalizedString("command.deathban.time.days") + " " + Integer.toString(clTime.hours) + " " + LanguageHandler.getLocalizedString("command.deathban.time.hours") + " " + Integer.toString(clTime.minutes) + " " + LanguageHandler.getLocalizedString("command.deathban.time.minutes")));
            }
            else
            {
            	sendCurrentBanTime(commandSender);
            }
        }
        else {
        	sendCurrentBanTime(commandSender);
        }
    }
    
    private static void sendCurrentBanTime(ICommandSender commandSender) {
    	TimeHandler clTime = new TimeHandler(ConfigurationSettings.DEATHBAN_BAN_TIME);
    	commandSender.sendChatToPlayer(ChatMessageComponent.func_111082_b(LanguageHandler.getLocalizedString("command.deathban.time.current") + " " + Integer.toString(clTime.days) + " " + LanguageHandler.getLocalizedString("command.deathban.time.days") + " " + Integer.toString(clTime.hours) + " " + LanguageHandler.getLocalizedString("command.deathban.time.hours") + " " + Integer.toString(clTime.minutes) + " " + LanguageHandler.getLocalizedString("command.deathban.time.minutes")));
    }
}
