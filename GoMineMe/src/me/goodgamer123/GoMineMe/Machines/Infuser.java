package me.goodgamer123.GoMineMe.Machines;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.goodgamer123.GoMineMe.MainClass;

public class Infuser implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
	    if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
	        if (e.getClickedBlock().getType().equals(Material.DARK_OAK_BUTTON)) {
	        	ItemStack Close = new ItemStack(Material.BARRIER);
				ItemMeta CloseMeta = Close.getItemMeta();
				CloseMeta.setDisplayName(ChatColor.RED + "Close");
				Close.setItemMeta(CloseMeta);
				
				ItemStack Filling = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
				ItemMeta FillingMeta = Filling.getItemMeta();
				FillingMeta.setDisplayName(" ");
				Filling.setItemMeta(FillingMeta);
				
				ItemStack hopper = new ItemStack(Material.HOPPER);
				ItemMeta hopperMeta = hopper.getItemMeta();
				hopperMeta.setDisplayName(" ");
				hopper.setItemMeta(hopperMeta);
				
				ItemStack done = new ItemStack(Material.EMERALD);
				ItemMeta doneMeta = done.getItemMeta();
				doneMeta.setDisplayName(ChatColor.GREEN + "Click to confirm");
				done.setItemMeta(doneMeta);
				
				ItemStack result = new ItemStack(Material.BLACK_WOOL);
				ItemMeta resultMeta = result.getItemMeta();
				ArrayList<String> resultLore = new ArrayList<String>();
				resultMeta.setDisplayName(ChatColor.BLUE + "Insert an item in the top slot");
				resultMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				resultMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				resultLore.add(ChatColor.BLUE + "and an item in te bottom slot!");
				resultMeta.setLore(resultLore);
				result.setItemMeta(resultMeta);
				
				File customYml = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml);

				ItemStack fast = null;
				ItemMeta fastMeta = Close.getItemMeta();
				fastMeta.setDisplayName(ChatColor.GOLD + "§lFast decompressor");
				ArrayList<String> fastLore = new ArrayList<String>();
				
				if (!p.hasPermission("machines.fast")) {
					fast = new ItemStack(Material.ORANGE_DYE);
					fastLore.add(ChatColor.BLUE + "Buy " + ChatColor.GOLD + "§lV" + ChatColor.YELLOW + "§lI" + ChatColor.GOLD + "§lP" + ChatColor.BLUE + " to get access to ");
					fastLore.add(ChatColor.BLUE + "this and other unique functions!");
				} else if ((config.get(p.getName().toLowerCase()) == null)) {
					fast = new ItemStack(Material.LIME_DYE);
					fastLore.add(ChatColor.GREEN + "Fast decompressor is enabled");
					fastLore.add(" ");
					fastLore.add(ChatColor.BLUE + "Click to toggle");
					config.set(p.getName().toLowerCase(), true);
					try { config.save(customYml); } catch (IOException ex) { ex.printStackTrace(); }
				} else if (config.getBoolean(p.getName().toLowerCase())) {
					fast = new ItemStack(Material.LIME_DYE);
					fastLore.add(ChatColor.GREEN + "Fast decompressor is enabled");
					fastLore.add(" ");
					fastLore.add(ChatColor.BLUE + "Click to toggle");
				} else {
					fast = new ItemStack(Material.RED_DYE);
					fastLore.add(ChatColor.RED + "Fast decompressor is disabled");
					fastLore.add(" ");
					fastLore.add(ChatColor.BLUE + "Click to toggle");
				}
				
				fastMeta.setLore(fastLore);
				fast.setItemMeta(fastMeta);
				
	        	Inventory compressor = Bukkit.createInventory(null, 54, ChatColor.BLUE + "§lInfuser");
	        	
	        	if (e.getClickedBlock().getLocation().equals(new Location(p.getWorld(), -156, 227, 18))) compressor = Bukkit.createInventory(null, 54, ChatColor.BLUE + "§lInfuser 1");
	        	else if (e.getClickedBlock().getLocation().equals(new Location(p.getWorld(), -164, 227, 18))) compressor = Bukkit.createInventory(null, 54, ChatColor.BLUE + "§lInfuser 2");
	        	else compressor = Bukkit.createInventory(null, 54, ChatColor.BLUE + "§lInfuser 3");
	        	
	        	for (int i = 0; i < compressor.getSize(); i++) {
					compressor.setItem(i, Filling);
				}
				compressor.setItem(12, new ItemStack(Material.AIR));
				compressor.setItem(21, hopper);
				compressor.setItem(30, new ItemStack(Material.AIR));
				compressor.setItem(14, result);
				compressor.setItem(32, done);
				compressor.setItem(48, fast);
				compressor.setItem(50, Close);
				p.openInventory(compressor);
	        }
	    }
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getCurrentItem() == null) return;
		
		if (e.getSlot() == 12) {
			
			return;
		} else if (e.getSlot() == 30) {
			ItemStack item = e.getInventory().getItem(30);
			item.setType(e.getCurrentItem().getType());
			if (e.getInventory().getItem(14) != null) {
				
			}
			return;
		}
		
		if (e.getView().getBottomInventory() == e.getClickedInventory()) return;
		Player p = (Player) e.getWhoClicked();
		
		if (e.getView().getTitle().startsWith(ChatColor.BLUE + "§lInfuser")) {
			e.setCancelled(true);
			p.updateInventory();
			
			if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
				p.closeInventory();
			} else if (e.getCurrentItem().getType().equals(Material.LIME_DYE)) {
				
			}
		}
	}
	
}
