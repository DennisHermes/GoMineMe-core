package me.goodgamer123.GoMineMe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;

public class Glow implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		
		if (cmd.getName().equalsIgnoreCase("glow")) {
			
			Inventory compressor = Bukkit.createInventory(null, 54, ChatColor.GOLD + "§lGlow");
			compressor.setItem(12, new ItemStack(Material.RED_WOOL));
			compressor.setItem(46, new ItemStack(Material.BARRIER));
			p.openInventory(compressor);
			
		}
		
		return false;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getView().getTitle().equals(ChatColor.GOLD + "§lGlow")) {
			if (e.getCurrentItem() == null) return;
		
			e.setCancelled(true);
			((Player) e.getWhoClicked()).updateInventory();
			
			if (e.getCurrentItem().getType().equals(Material.RED_WOOL)) {
		        e.getWhoClicked().setGlowing(true);
				Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
				board.getTeam("redTeam").addEntry(e.getWhoClicked().getUniqueId().toString());
		        e.getWhoClicked().closeInventory();
			} else if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
				e.getWhoClicked().setGlowing(false);
		        e.getWhoClicked().closeInventory();
			}
		}
	}
	
}


