package net.dernial.deathban.commands;

import net.dernial.deathban.lib.Command;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;

/**
 * Deathban
 * 
 * CommandHandler
 * 
 * @author dernial
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class CommandHandler extends CommandBase 
{

    @Override
    public String getCommandName() {

        return Command.COMMAND_DEATHBAN;
    }

    @Override
    public int getRequiredPermissionLevel()
    {
        return 3;
    }

    @Override
    public void processCommand(ICommandSender commandSender, String[] args) {

        if (args.length > 0) {
            String commandName = args[0];
            System.arraycopy(args, 1, args, 0, args.length - 1);

            if (commandName.equalsIgnoreCase(Command.COMMAND_ENABLE)) {
                CommandEnable.processCommand(commandSender, args);
            }
            else if (commandName.equalsIgnoreCase(Command.COMMAND_PERMANENT)) {
                CommandPermanent.processCommand(commandSender, args);
            }
            else if (commandName.equalsIgnoreCase(Command.COMMAND_TIME)) {
                CommandTime.processCommand(commandSender, args);
            }
            else if (commandName.equalsIgnoreCase(Command.COMMAND_FORGIVE)) {
                CommandForgive.processCommand(commandSender, args);
            }
            else if (commandName.equalsIgnoreCase(Command.COMMAND_FORGIVEALL)) {
                CommandForgive.forgiveAll(commandSender);
            }
            else
                throw new WrongUsageException(Command.COMMAND_DEATHBAN_USAGE, new Object[0]);
        }
        else
            throw new WrongUsageException(Command.COMMAND_DEATHBAN_USAGE, new Object[0]);
    }

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return Command.COMMAND_DEATHBAN_USAGE;
	}
}
