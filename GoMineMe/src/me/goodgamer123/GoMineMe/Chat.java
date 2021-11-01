package me.goodgamer123.GoMineMe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Chat implements Listener, CommandExecutor {

	public static boolean AllowChat = true;
	
	@EventHandler
	public void ChatEvent(AsyncPlayerChatEvent e) {
		if(!AllowChat){
			if (!e.getPlayer().hasPermission("chat.bypass")) {
				e.setCancelled(true);
				for(Player p : Bukkit.getOnlinePlayers()) {
					if (p.hasPermission("chat.muteread")) {
					      p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "Chat muted" + ChatColor.DARK_GRAY + "] " + ChatColor.RESET + e.getPlayer().getDisplayName() + ChatColor.DARK_GRAY + " >> " + ChatColor.GRAY + e.getMessage());
					}
				}
				e.getPlayer().sendMessage(ChatColor.RED + "The chat is currently muted!");
			}
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		
		if (cmd.getName().equalsIgnoreCase("clearchat")) {
			int count = 0;
			while (count < 100) {
				Bukkit.broadcastMessage("");
				count = count + 1;
			}
			new BukkitRunnable() { 
				 @Override
				 public void run() {
					 Bukkit.broadcastMessage(ChatColor.BLACK + "§l[" + ChatColor.DARK_PURPLE + "§lStaff" + ChatColor.BLACK + "§l]" + ChatColor.GRAY + " The chat has been cleared by " + ChatColor.DARK_PURPLE + "§l" + p.getName());
				 }
			 }.runTaskLater(MainClass.getPlugin(MainClass.class), 3);
		}
		
		if (cmd.getName().equalsIgnoreCase("togglechat")) {
			if (AllowChat) {
				AllowChat = false;
				Bukkit.broadcastMessage(ChatColor.BLACK + "§l[" + ChatColor.DARK_PURPLE + "§lStaff" + ChatColor.BLACK + "§l] " + ChatColor.GRAY + "Chat " + ChatColor.RED + "§lmuted" + ChatColor.GRAY + " by " + p.getName());
			} else {
				AllowChat = true;
				Bukkit.broadcastMessage(ChatColor.BLACK + "§l[" + ChatColor.DARK_PURPLE + "§lStaff" + ChatColor.BLACK + "§l] " + ChatColor.GRAY + "Chat " + ChatColor.GREEN + "§lunmuted" + ChatColor.GRAY + " by " + p.getName());
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("broadcast")) {
			if (args.length > 0) {
				String message = "";
	    		for(int i = 0; i < args.length; i++) {
	    			message = message + args[i] + " ";
	    		}
	    		message = message.replaceAll("&", "§");
	    		Bukkit.broadcastMessage(ChatColor.BLACK + "§l[" + ChatColor.DARK_PURPLE + "§lStaff" + ChatColor.BLACK + "§l] " + ChatColor.GRAY + "Broadcast" + ChatColor.DARK_GRAY + " >> " + ChatColor.RESET + message);
			} else {
				p.sendMessage(ChatColor.RED + "/broadcast <message>");
			}
		}
		
		return false;
	}
}
