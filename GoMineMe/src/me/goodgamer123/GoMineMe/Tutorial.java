package me.goodgamer123.GoMineMe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Tutorial implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("explorer")) {
			Villager villager = (Villager) p.getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
			villager.setCustomName(ChatColor.BLUE + "§lExplorer");
			villager.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.0D);
			villager.setRemoveWhenFarAway(false);
		}
        
		return false;
	}
	
	@EventHandler
	public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent e) {
		if (e.getRightClicked().getType().equals(EntityType.VILLAGER)) {
			if (e.getRightClicked().getCustomName().equals(ChatColor.BLUE + "§lExplorer")) {
				e.setCancelled(true);
				Player p = (Player) e.getPlayer();
				
				p.sendMessage(ChatColor.BLUE + "§l[explorer] " + ChatColor.AQUA + "Hey, welcome to this fantastic area!");
				
				new BukkitRunnable() { 
					@Override
					public void run() {
						p.sendMessage(ChatColor.BLUE + "§l[explorer] " + ChatColor.AQUA + "I have been looking around here for a few days.");
					}
				}.runTaskLater(MainClass.getPlugin(MainClass.class), 60);
				
				new BukkitRunnable() { 
					@Override
					public void run() {
						p.sendMessage(ChatColor.BLUE + "§l[explorer] " + ChatColor.AQUA + "Come with me and I will show you what I have already discovered!");
					}
				}.runTaskLater(MainClass.getPlugin(MainClass.class), 120);
				
				new BukkitRunnable() { 
					@Override
					public void run() {
						Bukkit.dispatchCommand(p, "st play tutorial");
					}
				}.runTaskLater(MainClass.getPlugin(MainClass.class), 200);
			}
		}
	}
	
}
