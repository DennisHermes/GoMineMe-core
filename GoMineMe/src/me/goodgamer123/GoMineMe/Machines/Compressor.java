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

public class Compressor implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
	    Player p = e.getPlayer();
	    if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
	        if (e.getClickedBlock().getType().equals(Material.STONE_BUTTON)) {
	        	
	        	ItemStack Stone = new ItemStack(Material.STONE);
				ItemMeta StoneMeta = Stone.getItemMeta();
				StoneMeta.setDisplayName(ChatColor.BLUE +  "Click to compress stone");
				Stone.setItemMeta(StoneMeta);
				
				ItemStack Coal = new ItemStack(Material.COAL_BLOCK);
				ItemMeta CoalMeta = Coal.getItemMeta();
				CoalMeta.setDisplayName(ChatColor.BLUE +  "Click to compress coal");
				Coal.setItemMeta(CoalMeta);
				
				ItemStack Iron = new ItemStack(Material.IRON_BLOCK);
				ItemMeta IronMeta = Iron.getItemMeta();
				IronMeta.setDisplayName(ChatColor.BLUE +  "Click to compress iron");
				Iron.setItemMeta(IronMeta);
				
				ItemStack Gold = new ItemStack(Material.GOLD_BLOCK);
				ItemMeta GoldMeta = Gold.getItemMeta();
				GoldMeta.setDisplayName(ChatColor.BLUE +  "Click to compress gold");
				Gold.setItemMeta(GoldMeta);
				
				ItemStack Diamond = new ItemStack(Material.DIAMOND_BLOCK);
				ItemMeta DiamondMeta = Diamond.getItemMeta();
				DiamondMeta.setDisplayName(ChatColor.BLUE +  "Click to compress diamond");
				Diamond.setItemMeta(DiamondMeta);
				
				ItemStack Emerald = new ItemStack(Material.EMERALD_BLOCK);
				ItemMeta EmeraldMeta = Emerald.getItemMeta();
				EmeraldMeta.setDisplayName(ChatColor.BLUE +  "Click to compress emerald");
				Emerald.setItemMeta(EmeraldMeta);
	        	
				ItemStack Close = new ItemStack(Material.BARRIER);
				ItemMeta CloseMeta = Close.getItemMeta();
				CloseMeta.setDisplayName(ChatColor.RED + "Close");
				Close.setItemMeta(CloseMeta);

				ItemStack Filling = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				ItemMeta FillingMeta = Filling.getItemMeta();
				FillingMeta.setDisplayName(" ");
				Filling.setItemMeta(FillingMeta);
				
				File customYml = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml);
				
				ItemStack fast = null;
				ItemMeta fastMeta = Close.getItemMeta();
				fastMeta.setDisplayName(ChatColor.GOLD + "§lFast compressor");
				ArrayList<String> fastLore = new ArrayList<String>();
				
				if (!p.hasPermission("machines.fast")) {
					fast = new ItemStack(Material.ORANGE_DYE);
					fastLore.add(ChatColor.BLUE + "Buy " + ChatColor.GOLD + "§lV" + ChatColor.YELLOW + "§lI" + ChatColor.GOLD + "§lP" + ChatColor.BLUE + " to get access to ");
					fastLore.add(ChatColor.BLUE + "this and other unique functions!");
				} else if ((config.get(p.getName().toLowerCase()) == null)) {
					fast = new ItemStack(Material.LIME_DYE);
					fastLore.add(ChatColor.GREEN + "Fast compressor is enabled");
					fastLore.add(" ");
					fastLore.add(ChatColor.BLUE + "Click to toggle");
					config.set(p.getName().toLowerCase(), true);
					try { config.save(customYml); } catch (IOException ex) { ex.printStackTrace(); }
				} else if (config.getBoolean(p.getName().toLowerCase())) {
					fast = new ItemStack(Material.LIME_DYE);
					fastLore.add(ChatColor.GREEN + "Fast compressor is enabled");
					fastLore.add(" ");
					fastLore.add(ChatColor.BLUE + "Click to toggle");
				} else {
					fast = new ItemStack(Material.RED_DYE);
					fastLore.add(ChatColor.RED + "Fast compressor is disabled");
					fastLore.add(" ");
					fastLore.add(ChatColor.BLUE + "Click to toggle");
				}
				
				fastMeta.setLore(fastLore);
				fast.setItemMeta(fastMeta);
				
	        	Inventory compressor = Bukkit.createInventory(null, 36, ChatColor.GREEN + "§lCompressor");
	        	
	        	if (e.getClickedBlock().getLocation().equals(new Location(p.getWorld(), -151, 226, 4))) compressor = Bukkit.createInventory(null, 36, ChatColor.GREEN + "§lCompressor 1");
	        	else compressor = Bukkit.createInventory(null, 36, ChatColor.GREEN + "§lCompressor 2");
	        	
	        	for (int i = 0; i < compressor.getSize(); i++) compressor.setItem(i, Filling);
				compressor.setItem(10, Stone);
				compressor.setItem(11, Coal);
				compressor.setItem(12, Iron);
				compressor.setItem(14, Gold);
				compressor.setItem(15, Diamond);
				compressor.setItem(16, Emerald);
				compressor.setItem(30, fast);
				compressor.setItem(32, Close);
				p.openInventory(compressor);
	        }
	    }
	}
	
	Location loc = null;
	int amount = 0;
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getCurrentItem() == null) return;
		Player p = (Player) e.getWhoClicked();
		
		if (e.getView().getTitle().startsWith(ChatColor.GREEN + "§lCompressor")) {
			if (e.getClickedInventory() == e.getView().getBottomInventory()) return;
			
			e.setCancelled(true);
			p.updateInventory();
			
			if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
				p.closeInventory();
			} else if (e.getCurrentItem().getType().equals(Material.LIME_DYE)) {
				ItemStack Stone = new ItemStack(Material.STONE);
				ItemMeta StoneMeta = Stone.getItemMeta();
				StoneMeta.setDisplayName(ChatColor.BLUE +  "Click to compress stone");
				Stone.setItemMeta(StoneMeta);
				
				ItemStack Coal = new ItemStack(Material.COAL_BLOCK);
				ItemMeta CoalMeta = Coal.getItemMeta();
				CoalMeta.setDisplayName(ChatColor.BLUE +  "Click to compress coal");
				Coal.setItemMeta(CoalMeta);
				
				ItemStack Iron = new ItemStack(Material.IRON_BLOCK);
				ItemMeta IronMeta = Iron.getItemMeta();
				IronMeta.setDisplayName(ChatColor.BLUE +  "Click to compress iron");
				Iron.setItemMeta(IronMeta);
				
				ItemStack Gold = new ItemStack(Material.GOLD_BLOCK);
				ItemMeta GoldMeta = Gold.getItemMeta();
				GoldMeta.setDisplayName(ChatColor.BLUE +  "Click to compress gold");
				Gold.setItemMeta(GoldMeta);
				
				ItemStack Diamond = new ItemStack(Material.DIAMOND_BLOCK);
				ItemMeta DiamondMeta = Diamond.getItemMeta();
				DiamondMeta.setDisplayName(ChatColor.BLUE +  "Click to compress diamond");
				Diamond.setItemMeta(DiamondMeta);
				
				ItemStack Emerald = new ItemStack(Material.EMERALD_BLOCK);
				ItemMeta EmeraldMeta = Emerald.getItemMeta();
				EmeraldMeta.setDisplayName(ChatColor.BLUE +  "Click to compress emerald");
				Emerald.setItemMeta(EmeraldMeta);
	        	
				ItemStack Close = new ItemStack(Material.BARRIER);
				ItemMeta CloseMeta = Close.getItemMeta();
				CloseMeta.setDisplayName(ChatColor.RED + "Close");
				Close.setItemMeta(CloseMeta);

				ItemStack Filling = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				ItemMeta FillingMeta = Filling.getItemMeta();
				FillingMeta.setDisplayName(" ");
				Filling.setItemMeta(FillingMeta);
				
				File customYml = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml);
				
				ItemStack fast = new ItemStack(Material.RED_DYE);
				ItemMeta fastMeta = Close.getItemMeta();
				fastMeta.setDisplayName(ChatColor.GOLD + "§lFast compressor");
				ArrayList<String> fastLore = new ArrayList<String>();
				fastLore.add(ChatColor.RED + "Fast compressor is disabled");
				fastLore.add(" ");
				fastLore.add(ChatColor.BLUE + "Click to toggle");
				fastMeta.setLore(fastLore);
				fast.setItemMeta(fastMeta);
				
				config.set(p.getName().toLowerCase(), false);
				try { config.save(customYml); } catch (IOException ex) { ex.printStackTrace(); }
				
				Inventory compressor = Bukkit.createInventory(null, 36, e.getView().getTitle());
	        	
				for (int i = 0; i < compressor.getSize(); i++) compressor.setItem(i, Filling);
				compressor.setItem(10, Stone);
				compressor.setItem(11, Coal);
				compressor.setItem(12, Iron);
				compressor.setItem(14, Gold);
				compressor.setItem(15, Diamond);
				compressor.setItem(16, Emerald);
				compressor.setItem(30, fast);
				compressor.setItem(32, Close);
				p.openInventory(compressor);
			} else if (e.getCurrentItem().getType().equals(Material.RED_DYE)) {
				ItemStack Stone = new ItemStack(Material.STONE);
				ItemMeta StoneMeta = Stone.getItemMeta();
				StoneMeta.setDisplayName(ChatColor.BLUE +  "Click to compress stone");
				Stone.setItemMeta(StoneMeta);
				
				ItemStack Coal = new ItemStack(Material.COAL_BLOCK);
				ItemMeta CoalMeta = Coal.getItemMeta();
				CoalMeta.setDisplayName(ChatColor.BLUE +  "Click to compress coal");
				Coal.setItemMeta(CoalMeta);
				
				ItemStack Iron = new ItemStack(Material.IRON_BLOCK);
				ItemMeta IronMeta = Iron.getItemMeta();
				IronMeta.setDisplayName(ChatColor.BLUE +  "Click to compress iron");
				Iron.setItemMeta(IronMeta);
				
				ItemStack Gold = new ItemStack(Material.GOLD_BLOCK);
				ItemMeta GoldMeta = Gold.getItemMeta();
				GoldMeta.setDisplayName(ChatColor.BLUE +  "Click to compress gold");
				Gold.setItemMeta(GoldMeta);
				
				ItemStack Diamond = new ItemStack(Material.DIAMOND_BLOCK);
				ItemMeta DiamondMeta = Diamond.getItemMeta();
				DiamondMeta.setDisplayName(ChatColor.BLUE +  "Click to compress diamond");
				Diamond.setItemMeta(DiamondMeta);
				
				ItemStack Emerald = new ItemStack(Material.EMERALD_BLOCK);
				ItemMeta EmeraldMeta = Emerald.getItemMeta();
				EmeraldMeta.setDisplayName(ChatColor.BLUE +  "Click to compress emerald");
				Emerald.setItemMeta(EmeraldMeta);
	        	
				ItemStack Close = new ItemStack(Material.BARRIER);
				ItemMeta CloseMeta = Close.getItemMeta();
				CloseMeta.setDisplayName(ChatColor.RED + "Close");
				Close.setItemMeta(CloseMeta);

				ItemStack Filling = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				ItemMeta FillingMeta = Filling.getItemMeta();
				FillingMeta.setDisplayName(" ");
				Filling.setItemMeta(FillingMeta);
				
				File customYml = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml);

				ItemStack fast = new ItemStack(Material.LIME_DYE);
				ItemMeta fastMeta = Close.getItemMeta();
				fastMeta.setDisplayName(ChatColor.GOLD + "§lFast compressor");
				ArrayList<String> fastLore = new ArrayList<String>();
				fastLore.add(ChatColor.GREEN + "Fast compressor is enabled");
				fastLore.add(" ");
				fastLore.add(ChatColor.BLUE + "Click to toggle");
				fastMeta.setLore(fastLore);
				fast.setItemMeta(fastMeta);
				
				config.set(p.getName().toLowerCase(), true);
				try { config.save(customYml); } catch (IOException ex) { ex.printStackTrace(); }
				
				Inventory compressor = Bukkit.createInventory(null, 36, e.getView().getTitle());
				
				for (int i = 0; i < compressor.getSize(); i++) compressor.setItem(i, Filling);
				compressor.setItem(10, Stone);
				compressor.setItem(11, Coal);
				compressor.setItem(12, Iron);
				compressor.setItem(14, Gold);
				compressor.setItem(15, Diamond);
				compressor.setItem(16, Emerald);
				compressor.setItem(30, fast);
				compressor.setItem(32, Close);
				p.openInventory(compressor);
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().startsWith(ChatColor.BLUE +  "Click to compress ")) {
				
				if (!p.getInventory().containsAtLeast(new ItemStack(e.getCurrentItem().getType()), 64)) {
					p.sendMessage(ChatColor.RED + "You don't have 64 " + e.getCurrentItem().getType().toString().replace("_BLOCK", "").toLowerCase() + " blocks to compress!");
					return;
				}
				
				p.closeInventory();
				
				File customYml = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml);
				
				if (e.getView().getTitle().contains("1")) loc = new Location(p.getWorld(), -151, 226, 4);
				else loc = new Location(p.getWorld(), -151, 226, -3);
				
				if (config.getBoolean(p.getName().toLowerCase())) {
					for (int i = 0; i < p.getInventory().getSize(); i++) {
						if (p.getInventory().getItem(i) != null) {
							if (p.getInventory().getItem(i).getType().equals(e.getCurrentItem().getType()) && p.getInventory().getItem(i).getAmount() == 64) {
								amount = amount + 1;
								p.getInventory().setItem(i, new ItemStack(Material.AIR));
							}
						}
					}
				} else {
					for (int i = 0; i < p.getInventory().getSize(); i++) {
						if (p.getInventory().getItem(i) != null) {
							if (p.getInventory().getItem(i).getType().equals(e.getCurrentItem().getType()) && p.getInventory().getItem(i).getAmount() == 64) {
								p.getInventory().setItem(i, new ItemStack(Material.AIR));
								amount = 1;
								break;
							}
						}
					}
				}
				
				ItemStack item = new ItemStack(e.getCurrentItem().getType());
				item.setAmount(64);
				
				p.getWorld().dropItemNaturally(loc.add(-2, 0, 1), item);
				
				new BukkitRunnable() { 
					@Override
					public void run() {
						loc.add(-1, 0, -1).getBlock().setType(Material.REDSTONE_BLOCK);
					}
				}.runTaskLater(MainClass.getPlugin(MainClass.class), 1 * 20);
				new BukkitRunnable() { 
					@Override
					public void run() {
						ItemStack newItem = new ItemStack(Material.STONE);
						if (e.getCurrentItem().getType().equals(Material.STONE)) newItem = Compressed.compressedStone();
						else if (e.getCurrentItem().getType().equals(Material.COAL_BLOCK)) newItem = Compressed.compressedCoal();
						else if (e.getCurrentItem().getType().equals(Material.IRON_BLOCK)) newItem = Compressed.compressedIron();
						else if (e.getCurrentItem().getType().equals(Material.GOLD_BLOCK)) newItem = Compressed.compressedGold();
						else if (e.getCurrentItem().getType().equals(Material.DIAMOND_BLOCK)) newItem = Compressed.compressedDiamond();
						else if (e.getCurrentItem().getType().equals(Material.EMERALD_BLOCK)) newItem = Compressed.compressedEmerald();
						if (config.getBoolean(p.getName().toLowerCase())) newItem.setAmount(amount);
						p.getInventory().addItem(newItem);
					}
				}.runTaskLater(MainClass.getPlugin(MainClass.class), 3 * 20);
			}
		}
	}
}
