package me.goodgamer123.GoMineMe;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryClose implements Listener {

	@EventHandler
	public void InventoryCloseEvent(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();
        
        if (e.getView().getTitle().startsWith(ChatColor.DARK_PURPLE + "§lInfuser")) {
        	if (e.getInventory().getItem(12) != null) p.getInventory().addItem(e.getInventory().getItem(12));
        	if (e.getInventory().getItem(30) != null) p.getInventory().addItem(e.getInventory().getItem(30));
        
        } else if (e.getView().getTitle().startsWith(ChatColor.BLUE + "§lDecompressor")) {
        	if (e.getInventory().getItem(13) != null) p.getInventory().addItem(e.getInventory().getItem(13));
        
        } else if (e.getView().getTitle().equals(ChatColor.BLUE + "§lPickaxe upgrade")) {
        	if (e.getInventory().getItem(31) != null) p.getInventory().addItem(e.getInventory().getItem(31));
        }
    }
	
}
