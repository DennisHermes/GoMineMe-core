package me.goodgamer123.GoMineMe;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Start implements Listener, CommandExecutor {
	
	public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("start")) {
			int cooldownTime = 1439;
	        if(cooldowns.containsKey(sender.getName())) {
	            long minLeft = ((cooldowns.get(sender.getName())/60000)+cooldownTime) - (System.currentTimeMillis()/60000);
	            long hoursLeft = (long) Math.floor(minLeft / 60);
	            if(minLeft>0) {
	            	minLeft = minLeft - (hoursLeft*60);
	                sender.sendMessage(ChatColor.RED + "You can get a new pickaxe in "+ hoursLeft +" hours and " + minLeft + " minutes!");
	                return true;
	            }
	        }
	        cooldowns.put(sender.getName(), System.currentTimeMillis());
	        ItemStack pickaxe = new ItemStack(Material.WOODEN_PICKAXE);
		    ItemMeta pickaxemeta = pickaxe.getItemMeta();
		    pickaxemeta.setDisplayName(ChatColor.BLUE + "Starter pickaxe");
		    pickaxemeta.setUnbreakable(true);
		    pickaxemeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		    pickaxemeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		    pickaxe.setItemMeta(pickaxemeta);
			p.getInventory().addItem(pickaxe);
	        return true;
		}
		return false;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if (!e.getPlayer().hasPlayedBefore()) {
			ItemStack pickaxe = new ItemStack(Material.WOODEN_PICKAXE);
		    ItemMeta pickaxemeta = pickaxe.getItemMeta();
		    pickaxemeta.setDisplayName(ChatColor.BLUE + "Starter pickaxe");
		    pickaxemeta.setUnbreakable(true);
		    pickaxemeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		    pickaxemeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		    pickaxe.setItemMeta(pickaxemeta);
			e.getPlayer().getInventory().addItem(pickaxe);
		}
	}
}
