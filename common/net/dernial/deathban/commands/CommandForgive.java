package net.dernial.deathban.commands;

import net.dernial.deathban.handlers.PlayerDeathHandler;
import net.dernial.deathban.lib.Command;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;

/**
 * Deathban
 * 
 * CommandForgive
 * 
 * @author dernial
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class CommandForgive
{
    /**
     * Processes the command forgive
     * 
     * @param commandSender ICommandSender passed from CommandHandler
     * @param args the sub args for the command (needs player name)
     */
    public static void processCommand(ICommandSender commandSender, String[] args) {

        String subCommand;

        if (args.length > 0) {
            subCommand = args[0];

            if (!subCommand.isEmpty()) {
                if(PlayerDeathHandler.removeBan(subCommand))
                    commandSender.sendChatToPlayer("Player Forgiven.");
                else
                    commandSender.sendChatToPlayer("Player not found or not banned.");
            }
            else
                throw new WrongUsageException(Command.COMMAND_FORGIVE_USAGE, new Object[0]);
        }
        else
            throw new WrongUsageException(Command.COMMAND_FORGIVE_USAGE, new Object[0]);
    }
    
    /**
     * Function to handle the forgiveAll command
     * 
     * @param commandSender ICommandSender passed down from the CommandHandler
     */
    public static void forgiveAll(ICommandSender commandSender) {
        PlayerDeathHandler.clearBans();
        commandSender.sendChatToPlayer("All bans cleared.");     
    }
}
