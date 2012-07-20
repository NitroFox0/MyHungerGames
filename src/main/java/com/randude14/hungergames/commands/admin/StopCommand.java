package com.randude14.hungergames.commands.admin;

import com.randude14.hungergames.Defaults.Commands;
import com.randude14.hungergames.GameManager;
import com.randude14.hungergames.commands.SubCommand;
import com.randude14.hungergames.utils.ChatUtils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StopCommand extends SubCommand{

	public StopCommand() {
		super(Commands.ADMIN_STOP);
	}

	@Override
	public boolean handle(CommandSender cs, Command cmd, String[] args) {
		Player player = (Player) cs;
		
		if (args.length < 1) {
			ChatUtils.helpCommand(player, command.getUsage(), cmd.getLabel());
			return true;
		}
				
		game = GameManager.getGame(args[0]);
		if (game == null) {
		    ChatUtils.error(player, "%s does not exist.", args[0]);
		    return true;
		}
		if (!game.checkForGameOver(false)) return game.stopGame(player, false);
		return true;
	}
    
}