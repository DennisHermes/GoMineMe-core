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
import me.goodgamer123.GoMineMe.CustomItems.Compressed;

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
				fastMeta.setDisplayName(ChatColor.GOLD + "§lFast infuser");
				ArrayList<String> fastLore = new ArrayList<String>();
				
				if (!p.hasPermission("machines.fast")) {
					fast = new ItemStack(Material.ORANGE_DYE);
					fastLore.add(ChatColor.BLUE + "Buy " + ChatColor.GOLD + "§lV" + ChatColor.YELLOW + "§lI" + ChatColor.GOLD + "§lP" + ChatColor.BLUE + " to get access to ");
					fastLore.add(ChatColor.BLUE + "this and other unique functions!");
				} else if ((config.get(p.getName().toLowerCase()) == null)) {
					fast = new ItemStack(Material.LIME_DYE);
					fastLore.add(ChatColor.GREEN + "Fast infuser is enabled");
					fastLore.add(" ");
					fastLore.add(ChatColor.BLUE + "Click to toggle");
					config.set(p.getName().toLowerCase(), true);
					try { config.save(customYml); } catch (IOException ex) { ex.printStackTrace(); }
				} else if (config.getBoolean(p.getName().toLowerCase())) {
					fast = new ItemStack(Material.LIME_DYE);
					fastLore.add(ChatColor.GREEN + "Fast infuser is enabled");
					fastLore.add(" ");
					fastLore.add(ChatColor.BLUE + "Click to toggle");
				} else {
					fast = new ItemStack(Material.RED_DYE);
					fastLore.add(ChatColor.RED + "Fast infuser is disabled");
					fastLore.add(" ");
					fastLore.add(ChatColor.BLUE + "Click to toggle");
				}
				
				fastMeta.setLore(fastLore);
				fast.setItemMeta(fastMeta);
				
	        	Inventory compressor = Bukkit.createInventory(null, 54, ChatColor.DARK_PURPLE + "§lInfuser");
	        	
	        	if (e.getClickedBlock().getLocation().equals(new Location(p.getWorld(), -156, 227, 18))) compressor = Bukkit.createInventory(null, 54, ChatColor.DARK_PURPLE + "§lInfuser 1");
	        	else if (e.getClickedBlock().getLocation().equals(new Location(p.getWorld(), -164, 227, 18))) compressor = Bukkit.createInventory(null, 54, ChatColor.DARK_PURPLE + "§lInfuser 2");
	        	else compressor = Bukkit.createInventory(null, 54, ChatColor.BLUE + "§lInfuser 3");
	        	
	        	for (int i = 0; i < compressor.getSize(); i++) compressor.setItem(i, Filling);
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
		Player p = (Player) e.getWhoClicked();
		
		if (e.getView().getTitle().startsWith(ChatColor.DARK_PURPLE + "§lInfuser")) {
			if (e.getView().getBottomInventory() == e.getClickedInventory()) return;
			if (e.getSlot() == 12 || e.getSlot() == 30) return;
			
			e.setCancelled(true);
			p.updateInventory();
			
			if (e.getInventory().getItem(12) != null && e.getInventory().getItem(30) != null) {
				ItemStack itemInfusing = e.getInventory().getItem(12);
				ItemStack infusedItem = e.getInventory().getItem(30);
				
				itemInfusing.setAmount(1);
				infusedItem.setAmount(1);
				
				String resultName = "";
				ItemStack result = new ItemStack(Material.STONE);
						
				if (itemInfusing.equals(Compressed.compressedStone())) resultName = ChatColor.GRAY + "§lStone infussed ";
				else if (itemInfusing.equals(Compressed.compressedCoal())) resultName = ChatColor.BLACK + "§lCoal infussed ";
				else if (itemInfusing.equals(Compressed.compressedIron())) resultName = ChatColor.WHITE + "§lIron infussed ";
				else if (itemInfusing.equals(Compressed.compressedGold())) resultName = ChatColor.GOLD + "§lGold infussed ";
				else if (itemInfusing.equals(Compressed.compressedDiamond())) resultName = ChatColor.AQUA + "§lDiamond infussed ";
				else if (itemInfusing.equals(Compressed.compressedEmerald())) resultName = ChatColor.GREEN + "§lEmerald infussed ";
				
				if (infusedItem.equals(Compressed.compressedStone())) {
					resultName = resultName + "stone";
				}
				else if (infusedItem.equals(Compressed.compressedCoal())) {
					resultName = resultName + "coal";
					result.setType(Material.COAL_BLOCK);
				}
				else if (infusedItem.equals(Compressed.compressedIron())) {
					resultName = resultName + "iron";
					result.setType(Material.IRON_BLOCK);
				}
				else if (infusedItem.equals(Compressed.compressedGold())) {
					resultName = resultName + "gold";
					result.setType(Material.GOLD_BLOCK);
				}
				else if (infusedItem.equals(Compressed.compressedDiamond())) {
					resultName = resultName + "diamond";
					result.setType(Material.DIAMOND_BLOCK);
				}
				else if (infusedItem.equals(Compressed.compressedEmerald())) {
					resultName = resultName + "emerald";
					result.setType(Material.EMERALD_BLOCK);
				}
				
				ItemMeta resultMeta = result.getItemMeta();
				resultMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				resultMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				resultMeta.setDisplayName(resultName);
				result.setItemMeta(resultMeta);
				
				e.getInventory().setItem(14, result);
			}
				
			if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
				p.closeInventory();
			} else if (e.getCurrentItem().getType().equals(Material.LIME_DYE)) {
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
				
				Inventory compressor = Bukkit.createInventory(null, 54, e.getView().getTitle());
	        	
	        	for (int i = 0; i < compressor.getSize(); i++) compressor.setItem(i, Filling);
				compressor.setItem(12, new ItemStack(Material.AIR));
				compressor.setItem(21, hopper);
				compressor.setItem(30, new ItemStack(Material.AIR));
				compressor.setItem(14, result);
				compressor.setItem(32, done);
				compressor.setItem(48, fast);
				compressor.setItem(50, Close);
				p.openInventory(compressor);
			} else if (e.getCurrentItem().getType().equals(Material.LIME_DYE)) {
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
				
				ItemStack fast = new ItemStack(Material.LIME_DYE);
				ItemMeta fastMeta = fast.getItemMeta();
				fastMeta.setDisplayName(ChatColor.GOLD + "§lFast decompressor");
				ArrayList<String> fastLore = new ArrayList<String>();
				fastLore.add(ChatColor.GREEN + "Fast decompressor is enabled");
				fastLore.add(" ");
				fastLore.add(ChatColor.BLUE + "Click to toggle");
				fastMeta.setLore(fastLore);
				fast.setItemMeta(fastMeta);
				
				config.set(p.getName().toLowerCase(), false);
				try { config.save(customYml); } catch (IOException ex) { ex.printStackTrace(); }
				
				Inventory compressor = Bukkit.createInventory(null, 54, e.getView().getTitle());
	        	
	        	for (int i = 0; i < compressor.getSize(); i++) compressor.setItem(i, Filling);
				compressor.setItem(12, new ItemStack(Material.AIR));
				compressor.setItem(21, hopper);
				compressor.setItem(30, new ItemStack(Material.AIR));
				compressor.setItem(14, result);
				compressor.setItem(32, done);
				compressor.setItem(48, fast);
				compressor.setItem(50, Close);
				p.openInventory(compressor);
			} else if (e.getCurrentItem().getType().equals(Material.EMERALD)) {
				
				e.getClickedInventory().setItem(12, new ItemStack(Material.AIR));
				e.getClickedInventory().setItem(30, new ItemStack(Material.AIR));
				p.closeInventory();
				
				p.getInventory().addItem(e.getInventory().getItem(14));
				
			}
		}
	}
	
}
