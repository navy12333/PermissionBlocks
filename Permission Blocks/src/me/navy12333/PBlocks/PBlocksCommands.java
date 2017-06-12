package me.navy12333.PBlocks;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PBlocksCommands implements CommandExecutor{



	@Override
	public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
		Player player = (Player) sender;
		if(player instanceof Player)
		{
		if (alias.equalsIgnoreCase("pblocks")) {
			player.sendMessage(ChatColor.GRAY + "Coded by: " + ChatColor.LIGHT_PURPLE + "Navy12333.");
			player.sendMessage(ChatColor.GRAY + "https://www.youtube.com/channel/UCTvEj736VB9wjycck58RlXw");
		}
		}
		return false;
	}
}
