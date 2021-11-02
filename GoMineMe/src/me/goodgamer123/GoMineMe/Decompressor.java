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

public class Decompressor implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
	    Player p = e.getPlayer();
	    if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
	        if (e.getClickedBlock().getType().equals(Material.BIRCH_BUTTON)) {
	        	
	        	ItemStack Stone = new ItemStack(Material.STONE);
				ItemMeta StoneMeta = Stone.getItemMeta();
				StoneMeta.setDisplayName(ChatColor.BLUE +  "Click to decompress stone");
				Stone.setItemMeta(StoneMeta);
				
				ItemStack Coal = new ItemStack(Material.COAL_BLOCK);
				ItemMeta CoalMeta = Coal.getItemMeta();
				CoalMeta.setDisplayName(ChatColor.BLUE +  "Click to decompress coal");
				Coal.setItemMeta(CoalMeta);
				
				ItemStack Iron = new ItemStack(Material.IRON_BLOCK);
				ItemMeta IronMeta = Iron.getItemMeta();
				IronMeta.setDisplayName(ChatColor.BLUE +  "Click to decompress iron");
				Iron.setItemMeta(IronMeta);
				
				ItemStack Gold = new ItemStack(Material.GOLD_BLOCK);
				ItemMeta GoldMeta = Gold.getItemMeta();
				GoldMeta.setDisplayName(ChatColor.BLUE +  "Click to decompress gold");
				Gold.setItemMeta(GoldMeta);
				
				ItemStack Diamond = new ItemStack(Material.DIAMOND_BLOCK);
				ItemMeta DiamondMeta = Diamond.getItemMeta();
				DiamondMeta.setDisplayName(ChatColor.BLUE +  "Click to decompress diamond");
				Diamond.setItemMeta(DiamondMeta);
				
				ItemStack Emerald = new ItemStack(Material.EMERALD_BLOCK);
				ItemMeta EmeraldMeta = Emerald.getItemMeta();
				EmeraldMeta.setDisplayName(ChatColor.BLUE +  "Click to decompress emerald");
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
					fastMeta.setDisplayName(ChatColor.GOLD + "§lFast decompressor");
					ArrayList<String> fastLore = new ArrayList<String>();
					fastLore.add(ChatColor.BLUE + "Buy " + ChatColor.GOLD + "§lV" + ChatColor.YELLOW + "§lI" + ChatColor.GOLD + "§lP" + ChatColor.BLUE + " to get access to ");
					fastLore.add(ChatColor.BLUE + "this and other unique functions!");
					fastMeta.setLore(fastLore);
					fast.setItemMeta(fastMeta);
				} else if ((config.get(p.getName().toLowerCase()) == null)) {
					fast = new ItemStack(Material.LIME_DYE);
					ItemMeta fastMeta = Close.getItemMeta();
					fastMeta.setDisplayName(ChatColor.GOLD + "§lFast decompressor");
					ArrayList<String> fastLore = new ArrayList<String>();
					fastLore.add(ChatColor.GREEN + "Fast decompressor is enabled");
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
					fastMeta.setDisplayName(ChatColor.GOLD + "§lFast decompressor");
					ArrayList<String> fastLore = new ArrayList<String>();
					fastLore.add(ChatColor.GREEN + "Fast decompressor is enabled");
					fastLore.add(" ");
					fastLore.add(ChatColor.BLUE + "Click to toggle");
					fastMeta.setLore(fastLore);
					fast.setItemMeta(fastMeta);
				} else {
					fast = new ItemStack(Material.RED_DYE);
					ItemMeta fastMeta = Close.getItemMeta();
					fastMeta.setDisplayName(ChatColor.GOLD + "§lFast decompressor");
					ArrayList<String> fastLore = new ArrayList<String>();
					fastLore.add(ChatColor.RED + "Fast decompressor is disabled");
					fastLore.add(" ");
					fastLore.add(ChatColor.BLUE + "Click to toggle");
					fastMeta.setLore(fastLore);
					fast.setItemMeta(fastMeta);
				}
				
	        	Inventory compressor = Bukkit.createInventory(null, 27, ChatColor.BLUE + "§lCompressor");
	        	
	        	if (e.getClickedBlock().getLocation().equals(new Location(p.getWorld(), -144, 226, -9))) {
	        		compressor = Bukkit.createInventory(null, 36, ChatColor.BLUE + "§lDecompressor 1");
	        	} else if (e.getClickedBlock().getLocation().equals(new Location(p.getWorld(), -144, 226, 10))) {
	        		compressor = Bukkit.createInventory(null, 36, ChatColor.BLUE + "§lDecompressor 2");
	        	} else {
	        		compressor = Bukkit.createInventory(null, 36, ChatColor.BLUE + "§lDecompressor 3");
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
		
		if (e.getView().getTitle().startsWith(ChatColor.BLUE + "§lDecompressor")) {
			e.setCancelled(true);
			p.updateInventory();
			
			if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
				p.closeInventory();
			}
			
			if (e.getCurrentItem().getType().equals(Material.LIME_DYE)) {
				ItemStack Stone = new ItemStack(Material.STONE);
				ItemMeta StoneMeta = Stone.getItemMeta();
				StoneMeta.setDisplayName(ChatColor.BLUE +  "Click to decompress stone");
				Stone.setItemMeta(StoneMeta);
				
				ItemStack Coal = new ItemStack(Material.COAL_BLOCK);
				ItemMeta CoalMeta = Coal.getItemMeta();
				CoalMeta.setDisplayName(ChatColor.BLUE +  "Click to decompress coal");
				Coal.setItemMeta(CoalMeta);
				
				ItemStack Iron = new ItemStack(Material.IRON_BLOCK);
				ItemMeta IronMeta = Iron.getItemMeta();
				IronMeta.setDisplayName(ChatColor.BLUE +  "Click to decompress iron");
				Iron.setItemMeta(IronMeta);
				
				ItemStack Gold = new ItemStack(Material.GOLD_BLOCK);
				ItemMeta GoldMeta = Gold.getItemMeta();
				GoldMeta.setDisplayName(ChatColor.BLUE +  "Click to decompress gold");
				Gold.setItemMeta(GoldMeta);
				
				ItemStack Diamond = new ItemStack(Material.DIAMOND_BLOCK);
				ItemMeta DiamondMeta = Diamond.getItemMeta();
				DiamondMeta.setDisplayName(ChatColor.BLUE +  "Click to decompress diamond");
				Diamond.setItemMeta(DiamondMeta);
				
				ItemStack Emerald = new ItemStack(Material.EMERALD_BLOCK);
				ItemMeta EmeraldMeta = Emerald.getItemMeta();
				EmeraldMeta.setDisplayName(ChatColor.BLUE +  "Click to decompress emerald");
				Emerald.setItemMeta(EmeraldMeta);
	        	
				ItemStack Close = new ItemStack(Material.BARRIER);
				ItemMeta CloseMeta = Close.getItemMeta();
				CloseMeta.setDisplayName(ChatColor.RED + "Close");
				Close.setItemMeta(CloseMeta);

				File customYml2 = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml2);
				
				ItemStack fast = new ItemStack(Material.RED_DYE);
				ItemMeta fastMeta = Close.getItemMeta();
				fastMeta.setDisplayName(ChatColor.GOLD + "§lFast decompressor");
				ArrayList<String> fastLore = new ArrayList<String>();
				fastLore.add(ChatColor.RED + "Fast decompressor is disabled");
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
				
				Inventory compressor = Bukkit.createInventory(null, 27, ChatColor.BLUE + "§lDecompressor");
				if (e.getView().getTitle().contains("1")) {
	        		compressor = Bukkit.createInventory(null, 36, ChatColor.BLUE + "§lDecompressor 1");
				} else if (e.getView().getTitle().contains("2")) {
	        		compressor = Bukkit.createInventory(null, 36, ChatColor.BLUE + "§lDecompressor 2");
	        	} else {
	        		compressor = Bukkit.createInventory(null, 36, ChatColor.BLUE + "§lDecompressor 3");
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
				StoneMeta.setDisplayName(ChatColor.BLUE +  "Click to decompress stone");
				Stone.setItemMeta(StoneMeta);
				
				ItemStack Coal = new ItemStack(Material.COAL_BLOCK);
				ItemMeta CoalMeta = Coal.getItemMeta();
				CoalMeta.setDisplayName(ChatColor.BLUE +  "Click to decompress coal");
				Coal.setItemMeta(CoalMeta);
				
				ItemStack Iron = new ItemStack(Material.IRON_BLOCK);
				ItemMeta IronMeta = Iron.getItemMeta();
				IronMeta.setDisplayName(ChatColor.BLUE +  "Click to decompress iron");
				Iron.setItemMeta(IronMeta);
				
				ItemStack Gold = new ItemStack(Material.GOLD_BLOCK);
				ItemMeta GoldMeta = Gold.getItemMeta();
				GoldMeta.setDisplayName(ChatColor.BLUE +  "Click to decompress gold");
				Gold.setItemMeta(GoldMeta);
				
				ItemStack Diamond = new ItemStack(Material.DIAMOND_BLOCK);
				ItemMeta DiamondMeta = Diamond.getItemMeta();
				DiamondMeta.setDisplayName(ChatColor.BLUE +  "Click to decompress diamond");
				Diamond.setItemMeta(DiamondMeta);
				
				ItemStack Emerald = new ItemStack(Material.EMERALD_BLOCK);
				ItemMeta EmeraldMeta = Emerald.getItemMeta();
				EmeraldMeta.setDisplayName(ChatColor.BLUE +  "Click to decompress emerald");
				Emerald.setItemMeta(EmeraldMeta);
	        	
				ItemStack Close = new ItemStack(Material.BARRIER);
				ItemMeta CloseMeta = Close.getItemMeta();
				CloseMeta.setDisplayName(ChatColor.RED + "Close");
				Close.setItemMeta(CloseMeta);

				File customYml2 = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml2);

				ItemStack fast = new ItemStack(Material.LIME_DYE);
				ItemMeta fastMeta = Close.getItemMeta();
				fastMeta.setDisplayName(ChatColor.GOLD + "§lFast decompressor");
				ArrayList<String> fastLore = new ArrayList<String>();
				fastLore.add(ChatColor.GREEN + "Fast decompressor is enabled");
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
	        		compressor = Bukkit.createInventory(null, 36, ChatColor.BLUE + "§lDecompressor 1");
				} else if (e.getView().getTitle().contains("2")) {
	        		compressor = Bukkit.createInventory(null, 36, ChatColor.BLUE + "§lDecompressor 2");
	        	} else {
	        		compressor = Bukkit.createInventory(null, 36, ChatColor.BLUE + "§lDecompressor 3");
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
			
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE +  "Click to decompress stone")) {
				if (hasItem(p, Material.STONE)) {
					p.closeInventory();
					BlockLoc.getBlock().setType(Material.STONE);
					new BukkitRunnable() { 
						 @Override
						 public void run() {
							Red1.getBlock().setType(Material.AIR);
							Red2.getBlock().setType(Material.AIR);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 1 * 20);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							 BlockLoc.getBlock().setType(Material.AIR);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 20);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							 ItemStack item = new ItemStack(Material.STONE);
							 item.setAmount(64);
							 p.getInventory().addItem(item);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 40);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							Red1.getBlock().setType(Material.REDSTONE_BLOCK);
							Red2.getBlock().setType(Material.REDSTONE_BLOCK);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 3 * 20);
				} else {
					p.sendMessage(ChatColor.RED + "You don't have compressed stone!");
				}
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE +  "Click to decompress coal")) {
				if (hasItem(p, Material.COAL_BLOCK)) {
					p.closeInventory();
					BlockLoc.getBlock().setType(Material.COAL_BLOCK);
					new BukkitRunnable() { 
						 @Override
						 public void run() {
							Red1.getBlock().setType(Material.AIR);
							Red2.getBlock().setType(Material.AIR);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 1 * 20);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							 BlockLoc.getBlock().setType(Material.AIR);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 20);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							 ItemStack item = new ItemStack(Material.COAL_BLOCK);
							 item.setAmount(64);
							 p.getInventory().addItem(item);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 40);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							Red1.getBlock().setType(Material.REDSTONE_BLOCK);
							Red2.getBlock().setType(Material.REDSTONE_BLOCK);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 3 * 20);
				} else {
					p.sendMessage(ChatColor.RED + "You don't have compressed coal!");
				}
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE +  "Click to decompress iron")) {
				if (hasItem(p, Material.IRON_BLOCK)) {
					p.closeInventory();
					BlockLoc.getBlock().setType(Material.IRON_BLOCK);
					new BukkitRunnable() { 
						 @Override
						 public void run() {
							Red1.getBlock().setType(Material.AIR);
							Red2.getBlock().setType(Material.AIR);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 1 * 20);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							 BlockLoc.getBlock().setType(Material.AIR);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 20);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							 ItemStack item = new ItemStack(Material.IRON_BLOCK);
							 item.setAmount(64);
							 p.getInventory().addItem(item);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 40);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							Red1.getBlock().setType(Material.REDSTONE_BLOCK);
							Red2.getBlock().setType(Material.REDSTONE_BLOCK);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 3 * 20);
				} else {
					p.sendMessage(ChatColor.RED + "You don't have compressed iron!");
				}
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE +  "Click to decompress gold")) {
				if (hasItem(p, Material.GOLD_BLOCK)) {
					p.closeInventory();
					BlockLoc.getBlock().setType(Material.GOLD_BLOCK);
					new BukkitRunnable() { 
						 @Override
						 public void run() {
							Red1.getBlock().setType(Material.AIR);
							Red2.getBlock().setType(Material.AIR);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 1 * 20);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							 BlockLoc.getBlock().setType(Material.AIR);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 20);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							 ItemStack item = new ItemStack(Material.GOLD_BLOCK);
							 item.setAmount(64);
							 p.getInventory().addItem(item);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 40);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							Red1.getBlock().setType(Material.REDSTONE_BLOCK);
							Red2.getBlock().setType(Material.REDSTONE_BLOCK);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 3 * 20);
				} else {
					p.sendMessage(ChatColor.RED + "You don't have compressed gold!");
				}
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE +  "Click to decompress diamond")) {
				if (hasItem(p, Material.DIAMOND_BLOCK)) {
					p.closeInventory();
					BlockLoc.getBlock().setType(Material.DIAMOND_BLOCK);
					new BukkitRunnable() { 
						 @Override
						 public void run() {
							Red1.getBlock().setType(Material.AIR);
							Red2.getBlock().setType(Material.AIR);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 1 * 20);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							 BlockLoc.getBlock().setType(Material.AIR);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 20);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							 ItemStack item = new ItemStack(Material.DIAMOND_BLOCK);
							 item.setAmount(64);
							 p.getInventory().addItem(item);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 40);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							Red1.getBlock().setType(Material.REDSTONE_BLOCK);
							Red2.getBlock().setType(Material.REDSTONE_BLOCK);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 3 * 20);
				} else {
					p.sendMessage(ChatColor.RED + "You don't have compressed diamond!");
				}
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE +  "Click to decompress emerald")) {
				if (hasItem(p, Material.EMERALD_BLOCK)) {
					p.closeInventory();
					BlockLoc.getBlock().setType(Material.EMERALD_BLOCK);
					new BukkitRunnable() { 
						 @Override
						 public void run() {
							Red1.getBlock().setType(Material.EMERALD_BLOCK);
							Red2.getBlock().setType(Material.AIR);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 1 * 20);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							 BlockLoc.getBlock().setType(Material.AIR);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 20);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							 ItemStack item = new ItemStack(Material.EMERALD_BLOCK);
							 item.setAmount(64);
							 p.getInventory().addItem(item);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 40);
					 new BukkitRunnable() { 
						 @Override
						 public void run() {
							Red1.getBlock().setType(Material.REDSTONE_BLOCK);
							Red2.getBlock().setType(Material.REDSTONE_BLOCK);
						 }
					 }.runTaskLater(MainClass.getPlugin(MainClass.class), 3 * 20);
				} else {
					p.sendMessage(ChatColor.RED + "You don't have compressed emerald!");
				}
			}
			
		}
	}

	public static boolean hasItem(Player p, Material type) {
		ItemStack compressed = null;
		if (type == Material.STONE) {
			compressed = new ItemStack(Material.STONE);
			ItemMeta compressedMeta = compressed.getItemMeta();
			compressedMeta.setDisplayName(ChatColor.GRAY + "§lCompressed stone");
			compressedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			compressedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			compressed.setItemMeta(compressedMeta);
		} else if (type == Material.COAL_BLOCK) {
			compressed = new ItemStack(Material.COAL_BLOCK);
			ItemMeta compressedMeta = compressed.getItemMeta();
			compressedMeta.setDisplayName(ChatColor.DARK_GRAY + "§lCompressed coal");
			compressedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			compressedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			compressed.setItemMeta(compressedMeta);
		} else if (type == Material.IRON_BLOCK) {
			compressed = new ItemStack(Material.IRON_BLOCK);
			ItemMeta compressedMeta = compressed.getItemMeta();
			compressedMeta.setDisplayName(ChatColor.WHITE + "§lCompressed iron");
			compressedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			compressedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			compressed.setItemMeta(compressedMeta);
		} else if (type == Material.GOLD_BLOCK) {
			compressed = new ItemStack(Material.GOLD_BLOCK);
			ItemMeta compressedMeta = compressed.getItemMeta();
			compressedMeta.setDisplayName(ChatColor.GOLD + "§lCompressed gold");
			compressedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			compressedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			compressed.setItemMeta(compressedMeta);
		} else if (type == Material.DIAMOND_BLOCK) {
			compressed = new ItemStack(Material.DIAMOND_BLOCK);
			ItemMeta compressedMeta = compressed.getItemMeta();
			compressedMeta.setDisplayName(ChatColor.AQUA + "§lCompressed diamond");
			compressedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			compressedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			compressed.setItemMeta(compressedMeta);
		} else if (type == Material.EMERALD_BLOCK) {
			compressed = new ItemStack(Material.EMERALD_BLOCK);
			ItemMeta compressedMeta = compressed.getItemMeta();
			compressedMeta.setDisplayName(ChatColor.GREEN + "§lCompressed emerald");
			compressedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
			compressedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			compressed.setItemMeta(compressedMeta);
			compressed.setItemMeta(compressedMeta);
		}
		
		return (p.getInventory().containsAtLeast(compressed, 1));
    }
	
}
