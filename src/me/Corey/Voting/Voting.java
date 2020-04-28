package me.Corey.Voting;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Voting implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("Vote")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Bro... you're in charge of the console you should know the voting websites...");
				return true;
			}
			Player player = (Player) sender;
			if (!player.hasPermission("vote.use")) {
				player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
				return true;
			}
			if (args.length == 0) {
				// /vote
				TextComponent message = new TextComponent("Click here for the voting website!");
				message.setColor(ChatColor.DARK_PURPLE);
				message.setBold(true);
				message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://minecraftservers.org/server/579291"));
				message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
						new ComponentBuilder("Click here to go to our voting websites!").color(ChatColor.GRAY).italic(true).create()));
				player.spigot().sendMessage(message);
				return true;
			}
			player.sendMessage(ChatColor.RED + "Usage: /vote");
			return true;
		}
		return false;
	}

}
