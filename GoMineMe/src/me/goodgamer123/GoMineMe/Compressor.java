package me.goodgamer123.GoMineMe;

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
import org.bukkit.scheduler.BukkitRunnable;

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

				ItemStack fast = null;
				File customYml2 = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml2);
				
				if (!p.hasPermission("machines.fast")) {
					fast = new ItemStack(Material.ORANGE_DYE);
					ItemMeta fastMeta = Close.getItemMeta();
					fastMeta.setDisplayName(ChatColor.GOLD + "§lFast compressor");
					ArrayList<String> fastLore = new ArrayList<String>();
					fastLore.add(ChatColor.BLUE + "Buy " + ChatColor.GOLD + "§lV" + ChatColor.YELLOW + "§lI" + ChatColor.GOLD + "§lP" + ChatColor.BLUE + " to get access to ");
					fastLore.add(ChatColor.BLUE + "this and other unique functions!");
					fastMeta.setLore(fastLore);
					fast.setItemMeta(fastMeta);
				} else if ((config.get(p.getName().toLowerCase()) == null)) {
					fast = new ItemStack(Material.LIME_DYE);
					ItemMeta fastMeta = Close.getItemMeta();
					fastMeta.setDisplayName(ChatColor.GOLD + "§lFast compressor");
					ArrayList<String> fastLore = new ArrayList<String>();
					fastLore.add(ChatColor.GREEN + "Fast compressor is enabled");
					fastLore.add(" ");
					fastLore.add(ChatColor.BLUE + "Click to toggle");
					fastMeta.setLore(fastLore);
					fast.setItemMeta(fastMeta);
					config.set(p.getName().toLowerCase(), true);
					try {
						config.save(customYml2);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				} else if (config.getBoolean(p.getName().toLowerCase())) {
					fast = new ItemStack(Material.LIME_DYE);
					ItemMeta fastMeta = Close.getItemMeta();
					fastMeta.setDisplayName(ChatColor.GOLD + "§lFast compressor");
					ArrayList<String> fastLore = new ArrayList<String>();
					fastLore.add(ChatColor.GREEN + "Fast compressor is enabled");
					fastLore.add(" ");
					fastLore.add(ChatColor.BLUE + "Click to toggle");
					fastMeta.setLore(fastLore);
					fast.setItemMeta(fastMeta);
				} else {
					fast = new ItemStack(Material.RED_DYE);
					ItemMeta fastMeta = Close.getItemMeta();
					fastMeta.setDisplayName(ChatColor.GOLD + "§lFast compressor");
					ArrayList<String> fastLore = new ArrayList<String>();
					fastLore.add(ChatColor.RED + "Fast compressor is disabled");
					fastLore.add(" ");
					fastLore.add(ChatColor.BLUE + "Click to toggle");
					fastMeta.setLore(fastLore);
					fast.setItemMeta(fastMeta);
				}
				
	        	Inventory compressor = Bukkit.createInventory(null, 27, ChatColor.BLUE + "§lCompressor");
	        	
	        	if (e.getClickedBlock().getLocation().equals(new Location(p.getWorld(), -151, 226, 4))) {
	        		compressor = Bukkit.createInventory(null, 36, ChatColor.BLUE + "§lCompressor 1");
	        	} else {
	        		compressor = Bukkit.createInventory(null, 36, ChatColor.BLUE + "§lCompressor 2");
	        	}
	        	
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
	
	Location loc = new Location(Bukkit.getWorlds().get(0), 0.0, 0.0, 0.0);
	int a = 0;
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getCurrentItem() == null) return;
		Player p = (Player) e.getWhoClicked();
		
		if (e.getView().getTitle().startsWith(ChatColor.BLUE + "§lCompressor")) {
			e.setCancelled(true);
			p.updateInventory();
			
			if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
				p.closeInventory();
			}
			
			if (e.getCurrentItem().getType().equals(Material.LIME_DYE)) {
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

				File customYml2 = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml2);
				
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
				try {
					config.save(customYml2);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				
				Inventory compressor = Bukkit.createInventory(null, 27, ChatColor.BLUE + "§lCompressor");
				if (e.getView().getTitle().contains("1")) {
	        		compressor = Bukkit.createInventory(null, 36, ChatColor.BLUE + "§lCompressor 1");
	        	} else {
	        		compressor = Bukkit.createInventory(null, 36, ChatColor.BLUE + "§lCompressor 2");
	        	}
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
			
			if (e.getCurrentItem().getType().equals(Material.RED_DYE)) {
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

				File customYml2 = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml2);

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
				try {
					config.save(customYml2);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				
				Inventory compressor = Bukkit.createInventory(null, 27, ChatColor.BLUE + "§lCompressor");
				if (e.getView().getTitle().contains("1")) {
	        		compressor = Bukkit.createInventory(null, 36, ChatColor.BLUE + "§lCompressor 1");
	        	} else {
	        		compressor = Bukkit.createInventory(null, 36, ChatColor.BLUE + "§lCompressor 2");
	        	}
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
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE +  "Click to compress stone")) {
				
				File customYml = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml);
				
				a = 0;
				if (config.getBoolean(p.getName().toLowerCase())) {
					for(ItemStack i : p.getInventory().getContents()){
						if(i != null && i.getType() != Material.AIR)
							a += i.getType().equals(Material.STONE) && i.getEnchantments().isEmpty() ? i.getAmount() : 0;
					}
					a = (int) Math.floor(a / 64);
				} else {
					for(ItemStack i : p.getInventory().getContents()){
						if(i != null && i.getType() != Material.AIR)
							a += i.getType().equals(Material.STONE) && !i.getItemMeta().getDisplayName().contains("Compressed") && i.getEnchantments().isEmpty() ? i.getAmount() : 0;
					}
					if (a >= 64) {
						a = 1;
					} else {
						p.sendMessage(ChatColor.RED + "You don't have 64 stone to compress!");
						return;
					}
				}
				
				ItemStack Stone = new ItemStack(Material.STONE);
				Stone.setAmount(a * 64);
				ItemMeta StoneMeta = Stone.getItemMeta();
				StoneMeta.setDisplayName("");
				Stone.setItemMeta(StoneMeta);
				
				if (consumeItem(p, a * 64, Material.STONE)) {
					p.closeInventory();
					
					if (e.getView().getTitle().contains("1")) {
						loc = new Location(p.getWorld(), -151, 226, 4);
					} else {
						loc = new Location(p.getWorld(), -151, 226, -3);
					}
					
					p.getWorld().dropItemNaturally(loc.add(-2, 0, 1), Stone);
					new BukkitRunnable() { 
						 @Override
						 public void run() {
							 loc.add(-1, 0, -1).getBlock().setType(Material.REDSTONE_BLOCK);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 1 * 20);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							loc.getBlock().setType(Material.AIR);
							ItemStack compressed = new ItemStack(Material.STONE);
							compressed.setAmount(a);
							ItemMeta compressedMeta = compressed.getItemMeta();
							compressedMeta.setDisplayName(ChatColor.GRAY + "§lCompressed stone");
							compressedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
							compressedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
							compressed.setItemMeta(compressedMeta);
							p.getInventory().addItem(compressed);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 3 * 20);
				} else {
					p.sendMessage(ChatColor.RED + "You don't have 64 stone to compress!");
				}
				
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE +  "Click to compress coal")) {
				
				File customYml = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml);
				
				a = 0;
				if (config.getBoolean(p.getName().toLowerCase())) {
					for(ItemStack i : p.getInventory().getContents()){
						if(i != null && i.getType() != Material.AIR)
							a += i.getType().equals(Material.COAL_BLOCK) && i.getEnchantments().isEmpty() ? i.getAmount() : 0;
					}
					a = (int) Math.floor(a / 64);
				} else {
					for(ItemStack i : p.getInventory().getContents()){
						if(i != null && i.getType() != Material.AIR)
							a += i.getType().equals(Material.COAL_BLOCK) && !i.getItemMeta().getDisplayName().contains("Compressed") && i.getEnchantments().isEmpty() ? i.getAmount() : 0;
					}
					if (a >= 64) {
						a = 1;
					} else {
						p.sendMessage(ChatColor.RED + "You don't have 64 coal blocks to compress!");
						return;
					}
				}
				
				ItemStack Coal = new ItemStack(Material.COAL_BLOCK);
				Coal.setAmount(a * 64);
				ItemMeta StoneMeta = Coal.getItemMeta();
				StoneMeta.setDisplayName("");
				Coal.setItemMeta(StoneMeta);
				
				if (consumeItem(p, a * 64, Material.COAL_BLOCK)) {
					p.closeInventory();
					
					if (e.getView().getTitle().contains("1")) {
						loc = new Location(p.getWorld(), -151, 226, 4);
					} else {
						loc = new Location(p.getWorld(), -151, 226, -3);
					}
					
					p.getInventory().remove(Coal);
					p.getWorld().dropItemNaturally((loc.add(-2, 0, 1)), Coal);
					new BukkitRunnable() { 
						 @Override
						 public void run() {
							 loc.add(-1, 0, -1).getBlock().setType(Material.REDSTONE_BLOCK);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 1 * 20);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							loc.getBlock().setType(Material.AIR);
							ItemStack compressed = new ItemStack(Material.COAL_BLOCK);
							ItemMeta compressedMeta = compressed.getItemMeta();
							compressedMeta.setDisplayName(ChatColor.DARK_GRAY + "§lCompressed coal");
							compressedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
							compressedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
							compressed.setItemMeta(compressedMeta);
							p.getInventory().addItem(compressed);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 3 * 20);
				} else {
					p.sendMessage(ChatColor.RED + "You don't have 64 coal blocks to compress!");
				}
				
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE +  "Click to compress iron")) {
				
				File customYml = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml);
				
				a = 0;
				if (config.getBoolean(p.getName().toLowerCase())) {
					for(ItemStack i : p.getInventory().getContents()){
						if(i != null && i.getType() != Material.AIR)
							a += i.getType().equals(Material.IRON_BLOCK) && i.getEnchantments().isEmpty() ? i.getAmount() : 0;
					}
					a = (int) Math.floor(a / 64);
				} else {
					for(ItemStack i : p.getInventory().getContents()){
						if(i != null && i.getType() != Material.AIR)
							a += i.getType().equals(Material.IRON_BLOCK) && !i.getItemMeta().getDisplayName().contains("Compressed") && i.getEnchantments().isEmpty() ? i.getAmount() : 0;
					}
					if (a >= 64) {
						a = 1;
					} else {
						p.sendMessage(ChatColor.RED + "You don't have 64 iron blocks to compress!");
						return;
					}
				}
				
				ItemStack Iron = new ItemStack(Material.IRON_BLOCK);
				Iron.setAmount(a * 64);
				ItemMeta StoneMeta = Iron.getItemMeta();
				StoneMeta.setDisplayName("");
				Iron.setItemMeta(StoneMeta);
				
				if (consumeItem(p, a * 64, Material.IRON_BLOCK)) {
					p.closeInventory();
					
					if (e.getView().getTitle().contains("1")) {
						loc = new Location(p.getWorld(), -151, 226, 4);
					} else {
						loc = new Location(p.getWorld(), -151, 226, -3);
					}
					
					p.getInventory().remove(Iron);
					p.getWorld().dropItemNaturally(loc.add(-2, 0, 1), Iron);
					new BukkitRunnable() { 
						 @Override
						 public void run() {
							 loc.add(-1, 0, -1).getBlock().setType(Material.REDSTONE_BLOCK);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 1 * 20);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							loc.getBlock().setType(Material.AIR);
							ItemStack compressed = new ItemStack(Material.IRON_BLOCK);
							ItemMeta compressedMeta = compressed.getItemMeta();
							compressedMeta.setDisplayName(ChatColor.WHITE + "§lCompressed iron");
							compressedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
							compressedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
							compressed.setItemMeta(compressedMeta);
							p.getInventory().addItem(compressed);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 3 * 20);
				} else {
					p.sendMessage(ChatColor.RED + "You don't have 64 iron blocks to compress!");
				}
				
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE +  "Click to compress gold")) {
				
				File customYml = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml);
				
				a = 0;
				if (config.getBoolean(p.getName().toLowerCase())) {
					for(ItemStack i : p.getInventory().getContents()){
						if(i != null && i.getType() != Material.AIR)
							a += i.getType().equals(Material.GOLD_BLOCK) && i.getEnchantments().isEmpty() ? i.getAmount() : 0;
					}
					a = (int) Math.floor(a / 64);
				} else {
					for(ItemStack i : p.getInventory().getContents()){
						if(i != null && i.getType() != Material.AIR)
							a += i.getType().equals(Material.GOLD_BLOCK) && !i.getItemMeta().getDisplayName().contains("Compressed") && i.getEnchantments().isEmpty() ? i.getAmount() : 0;
					}
					if (a >= 64) {
						a = 1;
					} else {
						p.sendMessage(ChatColor.RED + "You don't have 64 gold blocks to compress!");
						return;
					}
				}
				
				ItemStack Gold = new ItemStack(Material.GOLD_BLOCK);
				Gold.setAmount(a * 64);
				ItemMeta StoneMeta = Gold.getItemMeta();
				StoneMeta.setDisplayName("");
				Gold.setItemMeta(StoneMeta);
				
				if (consumeItem(p, a * 64, Material.GOLD_BLOCK)) {
					p.closeInventory();
					
					if (e.getView().getTitle().contains("1")) {
						loc = new Location(p.getWorld(), -151, 226, 4);
					} else {
						loc = new Location(p.getWorld(), -151, 226, -3);
					}
					
					p.getInventory().remove(Gold);
					p.getWorld().dropItemNaturally(loc.add(-2, 0, 1), Gold);
					new BukkitRunnable() { 
						 @Override
						 public void run() {
							 loc.add(-1, 0, -1).getBlock().setType(Material.REDSTONE_BLOCK);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 1 * 20);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							loc.getBlock().setType(Material.AIR);
							ItemStack compressed = new ItemStack(Material.GOLD_BLOCK);
							ItemMeta compressedMeta = compressed.getItemMeta();
							compressedMeta.setDisplayName(ChatColor.GOLD + "§lCompressed gold");
							compressedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
							compressedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
							compressed.setItemMeta(compressedMeta);
							p.getInventory().addItem(compressed);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 3 * 20);
				} else {
					p.sendMessage(ChatColor.RED + "You don't have 64 gold blocks to compress!");
				}
				
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE +  "Click to compress diamond")) {
				
				File customYml = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml);
				
				a = 0;
				if (config.getBoolean(p.getName().toLowerCase())) {
					for(ItemStack i : p.getInventory().getContents()){
						if(i != null && i.getType() != Material.AIR)
							a += i.getType().equals(Material.DIAMOND_BLOCK) && i.getEnchantments().isEmpty() ? i.getAmount() : 0;
					}
					a = (int) Math.floor(a / 64);
				} else {
					for(ItemStack i : p.getInventory().getContents()){
						if(i != null && i.getType() != Material.AIR)
							a += i.getType().equals(Material.DIAMOND_BLOCK) && !i.getItemMeta().getDisplayName().contains("Compressed") && i.getEnchantments().isEmpty() ? i.getAmount() : 0;
					}
					if (a >= 64) {
						a = 1;
					} else {
						p.sendMessage(ChatColor.RED + "You don't have 64 diamond blocks to compress!");
						return;
					}
				}
				
				ItemStack Diamond = new ItemStack(Material.DIAMOND_BLOCK);
				Diamond.setAmount(a * 64);
				ItemMeta StoneMeta = Diamond.getItemMeta();
				StoneMeta.setDisplayName("");
				Diamond.setItemMeta(StoneMeta);
				
				if (consumeItem(p, a * 64, Material.DIAMOND_BLOCK)) {
					p.closeInventory();
					
					if (e.getView().getTitle().contains("1")) {
						loc = new Location(p.getWorld(), -151, 226, 4);
					} else {
						loc = new Location(p.getWorld(), -151, 226, -3);
					}
					
					p.getInventory().remove(Diamond);
					p.getWorld().dropItemNaturally(loc.add(-2, 0, 1), Diamond);
					new BukkitRunnable() { 
						 @Override
						 public void run() {
							 loc.add(-1, 0, -1).getBlock().setType(Material.REDSTONE_BLOCK);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 1 * 20);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							loc.getBlock().setType(Material.AIR);
							ItemStack compressed = new ItemStack(Material.DIAMOND_BLOCK);
							ItemMeta compressedMeta = compressed.getItemMeta();
							compressedMeta.setDisplayName(ChatColor.AQUA + "§lCompressed diamond");
							compressedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
							compressedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
							compressed.setItemMeta(compressedMeta);
							p.getInventory().addItem(compressed);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 3 * 20);
				} else {
					p.sendMessage(ChatColor.RED + "You don't have 64 diamond blocks to compress!");
				}
				
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE +  "Click to compress emerald")) {
				
				File customYml = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml);
				
				a = 0;
				if (config.getBoolean(p.getName().toLowerCase())) {
					for(ItemStack i : p.getInventory().getContents()){
						if(i != null && i.getType() != Material.AIR)
							a += i.getType().equals(Material.EMERALD_BLOCK) && i.getEnchantments().isEmpty() ? i.getAmount() : 0;
					}
					a = (int) Math.floor(a / 64);
				} else {
					for(ItemStack i : p.getInventory().getContents()){
						if(i != null && i.getType() != Material.AIR)
							a += i.getType().equals(Material.EMERALD_BLOCK) && !i.getItemMeta().getDisplayName().contains("Compressed") && i.getEnchantments().isEmpty() ? i.getAmount() : 0;
					}
					if (a >= 64) {
						a = 1;
					} else {
						p.sendMessage(ChatColor.RED + "You don't have 64 emerald blocks to compress!");
						return;
					}
				}
				
				ItemStack Emerald = new ItemStack(Material.EMERALD_BLOCK);
				Emerald.setAmount(a * 64);
				ItemMeta StoneMeta = Emerald.getItemMeta();
				StoneMeta.setDisplayName("");
				Emerald.setItemMeta(StoneMeta);
				
				if (consumeItem(p, a * 64, Material.EMERALD_BLOCK)) {
					p.closeInventory();
					
					if (e.getView().getTitle().contains("1")) {
						loc = new Location(p.getWorld(), -151, 226, 4);
					} else {
						loc = new Location(p.getWorld(), -151, 226, -3);
					}
					p.getInventory().remove(Emerald);
					p.getWorld().dropItemNaturally(loc.add(-2, 0, 1), Emerald);
					new BukkitRunnable() { 
						 @Override
						 public void run() {
							 loc.add(-1, 0, -1).getBlock().setType(Material.REDSTONE_BLOCK);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 1 * 20);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							loc.getBlock().setType(Material.AIR);
							ItemStack compressed = new ItemStack(Material.EMERALD_BLOCK);
							ItemMeta compressedMeta = compressed.getItemMeta();
							compressedMeta.setDisplayName(ChatColor.GREEN + "§lCompressed emerald");
							compressedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
							compressedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
							compressed.setItemMeta(compressedMeta);
							p.getInventory().addItem(compressed);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 3 * 20);
				} else {
					p.sendMessage(ChatColor.RED + "You don't have 64 emerald blocks to compress!");
				}
				
			}
		}
		
	}

	public static boolean consumeItem(Player p, int amount, Material type) {
		Inventory inventory = p.getInventory();
        if (amount <= 0) return false;
        int size = inventory.getSize();
        for (int slot = 0; slot < size; slot++) {
            ItemStack is = inventory.getItem(slot);
            if (is == null) continue;
            if (type == is.getType() && !is.getItemMeta().getDisplayName().contains("Compressed")) {
                int newAmount = is.getAmount() - amount;
                if (newAmount > 0) {
                    is.setAmount(newAmount);
                    break;
                } else {
                    inventory.clear(slot);
                    amount = -newAmount;
                    if (amount == 0) break;
                }
            }
        }
      return true;
    }
	
}
