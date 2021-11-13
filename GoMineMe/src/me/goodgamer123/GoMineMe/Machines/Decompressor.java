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
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import me.goodgamer123.GoMineMe.MainClass;
import me.goodgamer123.GoMineMe.CustomItems.Compressed;

public class Decompressor implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
	    Player p = e.getPlayer();
	    if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
	        if (e.getClickedBlock().getType().equals(Material.BIRCH_BUTTON)) {
	        	
				ItemStack Close = new ItemStack(Material.BARRIER);
				ItemMeta CloseMeta = Close.getItemMeta();
				CloseMeta.setDisplayName(ChatColor.RED + "Close");
				Close.setItemMeta(CloseMeta);
				
				ItemStack Filling = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
				ItemMeta FillingMeta = Filling.getItemMeta();
				FillingMeta.setDisplayName(" ");
				Filling.setItemMeta(FillingMeta);
				
				ItemStack done = new ItemStack(Material.EMERALD);
				ItemMeta doneMeta = done.getItemMeta();
				doneMeta.setDisplayName(ChatColor.GREEN + "Click to confirm");
				done.setItemMeta(doneMeta);
				
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
				
	        	Inventory compressor = Bukkit.createInventory(null, 27, ChatColor.BLUE + "§lCompressor");
	        	
	        	if (e.getClickedBlock().getLocation().equals(new Location(p.getWorld(), -144, 226, -9))) compressor = Bukkit.createInventory(null, 36, ChatColor.BLUE + "§lDecompressor 1");
	        	else if (e.getClickedBlock().getLocation().equals(new Location(p.getWorld(), -144, 226, 10))) compressor = Bukkit.createInventory(null, 36, ChatColor.BLUE + "§lDecompressor 2");
	        	else compressor = Bukkit.createInventory(null, 36, ChatColor.BLUE + "§lDecompressor 3");
	        	
	        	for (int i = 0; i < compressor.getSize(); i++) compressor.setItem(i, Filling);
				compressor.setItem(13, new ItemStack(Material.AIR));
				compressor.setItem(27, fast);
				compressor.setItem(30, Close);
				compressor.setItem(32, done);
				p.openInventory(compressor);
	        }
	    }
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getCurrentItem() == null) return;
		
		if (e.getView().getTitle().startsWith(ChatColor.BLUE + "§lDecompressor")) {
			if (e.getClickedInventory() == e.getView().getBottomInventory()) return;
			if (e.getSlot() == 13) return;
			Player p = (Player) e.getWhoClicked();
			
			e.setCancelled(true);
			p.updateInventory();
			
			if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
				p.closeInventory();
			} else if (e.getCurrentItem().getType().equals(Material.LIME_DYE)) {
	        	
				ItemStack Close = new ItemStack(Material.BARRIER);
				ItemMeta CloseMeta = Close.getItemMeta();
				CloseMeta.setDisplayName(ChatColor.RED + "Close");
				Close.setItemMeta(CloseMeta);

				ItemStack Filling = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
				ItemMeta FillingMeta = Filling.getItemMeta();
				FillingMeta.setDisplayName(" ");
				Filling.setItemMeta(FillingMeta);
				
				ItemStack done = new ItemStack(Material.EMERALD);
				ItemMeta doneMeta = done.getItemMeta();
				doneMeta.setDisplayName(ChatColor.GREEN + "Click to confirm");
				done.setItemMeta(doneMeta);
				
				File customYml = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml);
				
				ItemStack fast = new ItemStack(Material.RED_DYE);
				ItemMeta fastMeta = fast.getItemMeta();
				fastMeta.setDisplayName(ChatColor.GOLD + "§lFast decompressor");
				ArrayList<String> fastLore = new ArrayList<String>();
				fastLore.add(ChatColor.RED + "Fast decompressor is disabled");
				fastLore.add(" ");
				fastLore.add(ChatColor.BLUE + "Click to toggle");
				fastMeta.setLore(fastLore);
				fast.setItemMeta(fastMeta);
				
				config.set(p.getName().toLowerCase(), false);
				try { config.save(customYml); } catch (IOException ex) { ex.printStackTrace(); }
				
				Inventory compressor = Bukkit.createInventory(null, 36, e.getView().getTitle());
				
				for (int i = 0; i < compressor.getSize(); i++) compressor.setItem(i, Filling);
				compressor.setItem(13, new ItemStack(Material.AIR));
				compressor.setItem(27, fast);
				compressor.setItem(30, Close);
				compressor.setItem(32, done);
				p.openInventory(compressor);
				
			} else if (e.getCurrentItem().getType().equals(Material.RED_DYE)) {
				
				ItemStack Close = new ItemStack(Material.BARRIER);
				ItemMeta CloseMeta = Close.getItemMeta();
				CloseMeta.setDisplayName(ChatColor.RED + "Close");
				Close.setItemMeta(CloseMeta);

				ItemStack Filling = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
				ItemMeta FillingMeta = Filling.getItemMeta();
				FillingMeta.setDisplayName(" ");
				Filling.setItemMeta(FillingMeta);
				
				ItemStack done = new ItemStack(Material.EMERALD);
				ItemMeta doneMeta = done.getItemMeta();
				doneMeta.setDisplayName(ChatColor.GREEN + "Click to confirm");
				done.setItemMeta(doneMeta);
				
				File customYml = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml);

				ItemStack fast = new ItemStack(Material.LIME_DYE);
				ItemMeta fastMeta = fast.getItemMeta();
				fastMeta.setDisplayName(ChatColor.GOLD + "§lFast decompressor");
				ArrayList<String> fastLore = new ArrayList<String>();
				fastLore.add(ChatColor.GREEN + "Fast decompressor is enabled");
				fastLore.add(" ");
				fastLore.add(ChatColor.BLUE + "Click to toggle");
				fastMeta.setLore(fastLore);
				fast.setItemMeta(fastMeta);
				
				config.set(p.getName().toLowerCase(), true);
				try { config.save(customYml); } catch (IOException ex) { ex.printStackTrace(); }
				
				Inventory compressor = Bukkit.createInventory(null, 36, e.getView().getTitle());
	        	
				for (int i = 0; i < compressor.getSize(); i++) compressor.setItem(i, Filling);
				compressor.setItem(13, new ItemStack(Material.AIR));
				compressor.setItem(27, fast);
				compressor.setItem(30, Close);
				compressor.setItem(32, done);
				p.openInventory(compressor);
			} else if (e.getCurrentItem().getType().equals(Material.EMERALD)) {
				if (e.getInventory().getItem(13) == null) return;
				
				Location BlockLoc;
				Location Red1;
				Location Red2;
				
				if (e.getView().getTitle().contains("1")) {
					BlockLoc = new Location(p.getWorld(), -142, 226, -10);
					Red1 = new Location(p.getWorld(), -141, 229, -10);
					Red2 = new Location(p.getWorld(), -142, 223, -10);
				} else if (e.getView().getTitle().contains("2")) {
					BlockLoc = new Location(p.getWorld(), -142, 226, 9);
					Red1 = new Location(p.getWorld(), -142, 223, 9);
					Red2 = new Location(p.getWorld(), -141, 229, 9);
				} else {
					BlockLoc = new Location(p.getWorld(), -142, 226, 15);
					Red1 = new Location(p.getWorld(), -141, 229, 15);
					Red2 = new Location(p.getWorld(), -142, 223, 15);
				}
				
				ItemStack item = e.getInventory().getItem(13);
				int itemAmount = item.getAmount();
				item.setAmount(1);
				
				if (!item.equals(Compressed.compressedStone()) && !item.equals(Compressed.compressedCoal()) && !item.equals(Compressed.compressedIron()) && !item.equals(Compressed.compressedGold()) && !item.equals(Compressed.compressedDiamond()) && !item.equals(Compressed.compressedEmerald())) return;
				
				File customYml = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml);
				if (itemAmount > 1) {
					if (!config.getBoolean(p.getName().toLowerCase())) {
						item.setAmount(itemAmount - 1);
						p.getInventory().addItem(item);
					}
				}
				
				e.getClickedInventory().setItem(13, new ItemStack(Material.AIR));
				p.closeInventory();
				BlockLoc.getBlock().setType(item.getType());
				new BukkitRunnable() { 
					@Override
					public void run() {
						Red1.getBlock().setType(Material.AIR);
						Red2.getBlock().setType(Material.AIR);
					}
				}.runTaskLater(MainClass.getPlugin(MainClass.class), 20);
				new BukkitRunnable() { 
					@Override
					public void run() {
						BlockLoc.getBlock().setType(Material.AIR);
					}
				}.runTaskLater(MainClass.getPlugin(MainClass.class), 20);
				new BukkitRunnable() { 
					@Override
					public void run() {
						ItemStack itemBack = new ItemStack(item.getType());
						if (!config.getBoolean(p.getName().toLowerCase())) itemBack.setAmount(64);
						else itemBack.setAmount(itemAmount * 64);
						p.getInventory().addItem(itemBack);
					 }
				}.runTaskLater(MainClass.getPlugin(MainClass.class), 40);
				new BukkitRunnable() { 
					@Override
					public void run() {
						Red1.getBlock().setType(Material.REDSTONE_BLOCK);
						Red2.getBlock().setType(Material.REDSTONE_BLOCK);
					}
				}.runTaskLater(MainClass.getPlugin(MainClass.class), 60);
			}
		}
	}
}
