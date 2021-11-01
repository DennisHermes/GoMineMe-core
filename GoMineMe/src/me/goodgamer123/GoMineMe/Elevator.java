package me.goodgamer123.GoMineMe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Elevator implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		
		if (cmd.getName().equalsIgnoreCase("elevatorcontroller")) {
			Villager villager = (Villager) p.getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
			villager.setCustomName(ChatColor.BLUE + "§lElevator Controller");
			villager.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.0D);
			villager.setRemoveWhenFarAway(false);
			
		}
        
		return false;
	}
	
	@EventHandler
	public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent e) {
		if (e.getRightClicked().getType().equals(EntityType.VILLAGER)) {
			if (e.getRightClicked().getCustomName().equals(ChatColor.BLUE + "§lElevator Controller")) {

				Player p = (Player) e.getPlayer();
				File customYml = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/Elevator.yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(customYml);
				
				if (e.getRightClicked().getLocation().getY() == 196) {
					if (!config.getStringList(p.getName().toLowerCase()).contains("coal")) {
						if (config.getStringList(p.getName().toLowerCase()) == null) {
							List<String> stringList = new ArrayList<String>();
							stringList.add("coal");
							config.set(p.getName().toLowerCase(), stringList);
						} else {
							List<String> stringList = config.getStringList(p.getName().toLowerCase());
							stringList.add("coal");
							config.set(p.getName().toLowerCase(), stringList);
						}
						try {
							config.save(customYml);
						} catch (IOException ex) {
						ex.printStackTrace();
						}
					}
				}
				if (e.getRightClicked().getLocation().getY() == 174) {
					if (!config.getStringList(p.getName().toLowerCase()).contains("iron")) {
						if (config.getStringList(p.getName().toLowerCase()) == null) {
							List<String> stringList = new ArrayList<String>();
							stringList.add("iron");
							config.set(p.getName().toLowerCase(), stringList);
						} else {
							List<String> stringList = config.getStringList(p.getName().toLowerCase());
							stringList.add("iron");
							config.set(p.getName().toLowerCase(), stringList);
						}
						try {
							config.save(customYml);
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
				}
				if (e.getRightClicked().getLocation().getY() == 147) {
					if (!config.getStringList(p.getName().toLowerCase()).contains("gold")) {
						if (config.getStringList(p.getName().toLowerCase()) == null) {
							List<String> stringList = new ArrayList<String>();
							stringList.add("gold");
							config.set(p.getName().toLowerCase(), stringList);
						} else {
							List<String> stringList = config.getStringList(p.getName().toLowerCase());
							stringList.add("gold");
							config.set(p.getName().toLowerCase(), stringList);
						}
						try {
							config.save(customYml);
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
				}
				if (e.getRightClicked().getLocation().getY() == 126) {
					if (!config.getStringList(p.getName().toLowerCase()).contains("diamond")) {
						if (config.getStringList(p.getName().toLowerCase()) == null) {
							List<String> stringList = new ArrayList<String>();
							stringList.add("diamond");
							config.set(p.getName().toLowerCase(), stringList);
						} else {
							List<String> stringList = config.getStringList(p.getName().toLowerCase());
							stringList.add("diamond");
							config.set(p.getName().toLowerCase(), stringList);
						}
						try {
							config.save(customYml);
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
				}
					if (e.getRightClicked().getLocation().getY() == 97) {
						if (!config.getStringList(p.getName().toLowerCase()).contains("emerald")) {
							if (config.getStringList(p.getName().toLowerCase()) == null) {
								List<String> stringList = new ArrayList<String>();
								stringList.add("emerald");
								config.set(p.getName().toLowerCase(), stringList);
							} else {
								List<String> stringList = config.getStringList(p.getName().toLowerCase());
								stringList.add("emerald");
								config.set(p.getName().toLowerCase(), stringList);
							}
							try {
								config.save(customYml);
							} catch (IOException ex) {
								ex.printStackTrace();
							}
						}
				}

				
				e.setCancelled(true);
				ItemStack Stone = new ItemStack(Material.STONE);
				ItemMeta StoneMeta = Stone.getItemMeta();
				StoneMeta.setDisplayName(ChatColor.GRAY +  "§lStone");
				ArrayList<String> StoneLore = new ArrayList<String>();
				StoneLore.add(ChatColor.BLUE + "Click to teleport");
				StoneMeta.setLore(StoneLore);
				Stone.setItemMeta(StoneMeta);
				
				ItemStack Coal;
				ItemStack Iron;
				ItemStack Gold;
				ItemStack Diamond;
				ItemStack Emerald;
				
				if (config.getStringList(p.getName().toLowerCase()).contains("coal")) {
					Coal = new ItemStack(Material.COAL);
					ItemMeta CoalMeta = Coal.getItemMeta();
					CoalMeta.setDisplayName(ChatColor.DARK_GRAY + "§lCoal");
					ArrayList<String> CoalLore = new ArrayList<String>();
					CoalLore.add(ChatColor.BLUE + "Click to teleport");
					CoalMeta.setLore(CoalLore);
					Coal.setItemMeta(CoalMeta);
				} else {
					Coal = new ItemStack(Material.RED_STAINED_GLASS_PANE);
					ItemMeta CoalMeta = Coal.getItemMeta();
					CoalMeta.setDisplayName(ChatColor.DARK_GRAY + "§lCoal");
					ArrayList<String> CoalLore = new ArrayList<String>();
					CoalLore.add(ChatColor.RED + "You have not unlocked this mine yet!");
					CoalMeta.setLore(CoalLore);
					Coal.setItemMeta(CoalMeta);
				}
				
				if (config.getStringList(p.getName().toLowerCase()).contains("iron")) {
					Iron = new ItemStack(Material.IRON_INGOT);
					ItemMeta IronMeta = Iron.getItemMeta();
					IronMeta.setDisplayName(ChatColor.WHITE +  "§lIron");
					ArrayList<String> IronLore = new ArrayList<String>();
					IronLore.add(ChatColor.BLUE + "Click to teleport");
					IronMeta.setLore(IronLore);
					Iron.setItemMeta(IronMeta);
				} else {
					Iron = new ItemStack(Material.RED_STAINED_GLASS_PANE);
					ItemMeta IronMeta = Iron.getItemMeta();
					IronMeta.setDisplayName(ChatColor.WHITE +  "§lIron");
					ArrayList<String> IronLore = new ArrayList<String>();
					IronLore.add(ChatColor.RED + "You have not unlocked this mine yet!");
					IronMeta.setLore(IronLore);
					Iron.setItemMeta(IronMeta);
				}
				
				if (config.getStringList(p.getName().toLowerCase()).contains("gold")) {
					Gold = new ItemStack(Material.GOLD_INGOT);
					ItemMeta GoldMeta = Gold.getItemMeta();
					GoldMeta.setDisplayName(ChatColor.GOLD +  "§lGold");
					ArrayList<String> GoldLore = new ArrayList<String>();
					GoldLore.add(ChatColor.BLUE + "Click to teleport");
					GoldMeta.setLore(GoldLore);
					Gold.setItemMeta(GoldMeta);
				} else {
					Gold = new ItemStack(Material.RED_STAINED_GLASS_PANE);
					ItemMeta GoldMeta = Gold.getItemMeta();
					GoldMeta.setDisplayName(ChatColor.GOLD +  "§lGold");
					ArrayList<String> GoldLore = new ArrayList<String>();
					GoldLore.add(ChatColor.RED + "You have not unlocked this mine yet!");
					GoldMeta.setLore(GoldLore);
					Gold.setItemMeta(GoldMeta);
				}
				
				if (config.getStringList(p.getName().toLowerCase()).contains("diamond")) {
					Diamond = new ItemStack(Material.DIAMOND);
					ItemMeta DiamondMeta = Diamond.getItemMeta();
					DiamondMeta.setDisplayName(ChatColor.AQUA +  "§lDiamond");
					ArrayList<String> DiamondLore = new ArrayList<String>();
					DiamondLore.add(ChatColor.BLUE + "Click to teleport");
					DiamondMeta.setLore(DiamondLore);
					Diamond.setItemMeta(DiamondMeta);
				} else {
					Diamond = new ItemStack(Material.RED_STAINED_GLASS_PANE);
					ItemMeta DiamondMeta = Diamond.getItemMeta();
					DiamondMeta.setDisplayName(ChatColor.AQUA +  "§lDiamond");
					ArrayList<String> DiamondLore = new ArrayList<String>();
					DiamondLore.add(ChatColor.RED + "You have not unlocked this mine yet!");
					DiamondMeta.setLore(DiamondLore);
					Diamond.setItemMeta(DiamondMeta);
				}
				
				if (config.getStringList(p.getName().toLowerCase()).contains("emerald")) {
					Emerald = new ItemStack(Material.EMERALD);
					ItemMeta EmeraldMeta = Emerald.getItemMeta();
					EmeraldMeta.setDisplayName(ChatColor.GREEN +  "§lEmerald");
					ArrayList<String> EmeraldLore = new ArrayList<String>();
					EmeraldLore.add(ChatColor.BLUE + "Click to teleport");
					EmeraldMeta.setLore(EmeraldLore);
					Emerald.setItemMeta(EmeraldMeta);
				} else {
					Emerald = new ItemStack(Material.RED_STAINED_GLASS_PANE);
					ItemMeta EmeraldMeta = Emerald.getItemMeta();
					EmeraldMeta.setDisplayName(ChatColor.GREEN +  "§lEmerald");
					ArrayList<String> EmeraldLore = new ArrayList<String>();
					EmeraldLore.add(ChatColor.RED + "You have not unlocked this mine yet!");
					EmeraldMeta.setLore(EmeraldLore);
					Emerald.setItemMeta(EmeraldMeta);
				}
	        	
	        	Inventory compressor = Bukkit.createInventory(null, 27, ChatColor.BLUE + "§lElevator");
				compressor.setItem(10, Stone);
				compressor.setItem(11, Coal);
				compressor.setItem(12, Iron);
				compressor.setItem(14, Gold);
				compressor.setItem(15, Diamond);
				compressor.setItem(16, Emerald);
				e.getPlayer().openInventory(compressor);
			}
		}
	}
	
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getCurrentItem() == null) return;
		Player p = (Player) e.getWhoClicked();
		
		if (e.getView().getTitle().startsWith(ChatColor.BLUE + "§lElevator")) {
			e.setCancelled(true);
			p.updateInventory();
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GRAY + "§lStone")) {
				if (e.getCurrentItem().getItemMeta().getLore().get(0).contains("teleport")) {
					p.teleport(new Location(p.getWorld(), -110.5, 224, -33.5, 138, 0));
				}
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GRAY + "§lCoal")) {
				if (e.getCurrentItem().getItemMeta().getLore().get(0).contains("teleport")) {
					p.teleport(new Location(p.getWorld(), -111.5, 196, -52.5, 130, 0));
				}
			} else if (e.getCurrentItem().getType().equals(Material.IRON_INGOT)) {
				if (e.getCurrentItem().getItemMeta().getLore().get(0).contains("teleport")) {
					p.teleport(new Location(p.getWorld(), -90.5, 174, -59.5, -142, 0));
				}
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "§lGold")) {
				if (e.getCurrentItem().getItemMeta().getLore().get(0).contains("teleport")) {
					p.teleport(new Location(p.getWorld(), -86.5, 147, -55.5, -128, 0));
				}
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + "§lDiamond")) {
				if (e.getCurrentItem().getItemMeta().getLore().get(0).contains("teleport")) {
					p.teleport(new Location(p.getWorld(), -79.5, 126, -53.5, -133, 0));
				}
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "§lEmerald")) {
				if (e.getCurrentItem().getItemMeta().getLore().get(0).contains("teleport")) {
					p.teleport(new Location(p.getWorld(), -77.5,  97, -49.5, -140, 0));
				}
			}
		}
	}
	
}
