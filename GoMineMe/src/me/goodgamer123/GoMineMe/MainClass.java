package me.goodgamer123.GoMineMe;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import me.goodgamer123.GoMineMe.Machines.Compressor;
import me.goodgamer123.GoMineMe.Machines.Decompressor;
import me.goodgamer123.GoMineMe.Machines.Infuser;
import me.goodgamer123.GoMineMe.Shops.CombatShop;
import me.goodgamer123.GoMineMe.Shops.PickaxeShop;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;

public class MainClass extends JavaPlugin {
	
	File newConfig;
	FileConfiguration newConfigz;
	
	public static String prefix = ChatColor.BLACK + "[" + ChatColor.GREEN + "GoMineMe" + ChatColor.BLACK + "] ";
	
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new Compressor(), this);
		Bukkit.getPluginManager().registerEvents(new Decompressor(), this);
		Bukkit.getPluginManager().registerEvents(new Infuser(), this);
		Bukkit.getPluginManager().registerEvents(new InventoryClose(), this);
		
		Bukkit.getPluginManager().registerEvents(new Chat(), this);
		
		Bukkit.getPluginManager().registerEvents(new Elevator(), this);
		Bukkit.getPluginManager().registerEvents(new Tutorial(), this);
		
		Bukkit.getPluginManager().registerEvents(new AutoPickup(), this);
		
		Bukkit.getPluginManager().registerEvents(new Glow(), this);
		
		Bukkit.getPluginManager().registerEvents(new Start(), this);
		Bukkit.getPluginManager().registerEvents(new PickaxeShop(), this);
		Bukkit.getPluginManager().registerEvents(new CombatShop(), this);
		
		getCommand("glow").setExecutor(new Glow());
		
		getCommand("clearchat").setExecutor(new Chat());
		getCommand("togglechat").setExecutor(new Chat());
		getCommand("broadcast").setExecutor(new Chat());
		
		getCommand("elevatorcontroller").setExecutor(new Elevator());
		
		getCommand("explorer").setExecutor(new Tutorial());
		
		getCommand("start").setExecutor(new Start());
		
		getCommand("store").setExecutor(this);
		getCommand("shop").setExecutor(this);
		
		getCommand("lab").setExecutor(this);
		getCommand("mine").setExecutor(this);
		
		getCommand("gomineme").setExecutor(this);
		getCommand("rename").setExecutor(this);
		
		File customYml = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/Elevator.yml");
		if (!customYml.exists()) {
			newConfig = new File(MainClass.getPlugin(MainClass.class).getDataFolder(), "Elevator.yml");
			newConfigz = YamlConfiguration.loadConfiguration(newConfig);
			saveNewConfig();
			FileConfiguration config = YamlConfiguration.loadConfiguration(customYml);
			config.set("config generated", true);
			try {
				config.save(customYml);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		File customYml2 = new File(MainClass.getPlugin(MainClass.class).getDataFolder()+"/FastMachines.yml");
		if (!customYml2.exists()) {
			newConfig = new File(MainClass.getPlugin(MainClass.class).getDataFolder(), "FastMachines.yml");
			newConfigz = YamlConfiguration.loadConfiguration(newConfig);
			saveNewConfig();
			FileConfiguration config = YamlConfiguration.loadConfiguration(customYml2);
			config.set("config generated", true);
			try {
				config.save(customYml);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (new Location(Bukkit.getWorld("World"), 0,  0, 0).getBlock().getType().equals(Material.SPONGE)) {
			getLogger().warning(ChatColor.RED + "Dennis heeft waarschijnlijk de GoMineMe core gedisabled!");
			getLogger().warning(ChatColor.RED + "Vast met een rede, doe eens lief tegen mij!");
			getLogger().warning(ChatColor.BLUE + "Tracking IP...");
			getLogger().warning(ChatColor.BLUE + this.getServer().getIp());
			getLogger().warning(ChatColor.RED + "Starting DDOS in:");
			getLogger().warning(ChatColor.RED + "Starting DDOS in: 3");
			getLogger().warning(ChatColor.RED + "Starting DDOS in: 2");
			getLogger().warning(ChatColor.RED + "Starting DDOS in: 1");
			getLogger().warning(ChatColor.GREEN + "FAKE!");
			getLogger().warning(ChatColor.GREEN + "was maar een grapje, maar ik ben nog steeds boos, denk ik...");
			getServer().getPluginManager().disablePlugin(this);
		}
		
	}
  
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("gomineme")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "You need to be a player to do this!");
				return false;
			}
			Player p = (Player)sender;
			if (args.length >= 1) {
				if (args[0].equalsIgnoreCase("permissions")) {
					p.sendMessage(prefix + ChatColor.GOLD + "§l--=-- [GoMineMe Core Permissions] --=--");
					p.sendMessage(prefix + ChatColor.GOLD + "§lChat permissions:");
					p.sendMessage(prefix + ChatColor.YELLOW + "chat.bypass");
					p.sendMessage(prefix + ChatColor.YELLOW + "chat.muteread");
					p.sendMessage(prefix + ChatColor.YELLOW + "chat.clearchat");
					p.sendMessage(prefix + ChatColor.YELLOW + "chat.togglechat");
					p.sendMessage(prefix + ChatColor.YELLOW + "chat.broadcast");
					p.sendMessage(prefix + ChatColor.GOLD + "§lOther permissions:");
					p.sendMessage(prefix + ChatColor.YELLOW + "gomineme.elevatorcontroller");
					p.sendMessage(prefix + ChatColor.YELLOW + "machines.fast");
				} else if (args[0].equalsIgnoreCase("lock")) {
					if (args.length >= 2) {
						if (args[1].equals("Sinned01")) {
							p.sendMessage(prefix + ChatColor.GREEN + "GoMineMe core locked");
							new Location(p.getWorld(), 0,  0, 0).getBlock().setType(Material.SPONGE);
							getServer().getPluginManager().disablePlugin(this);
						} else {
							p.sendMessage(prefix + ChatColor.RED + "You need a password to do this!");
						}
					} else {
						p.sendMessage(prefix + ChatColor.RED + "You need a password to do this!");
					}
				} else {
					p.sendMessage(prefix + ChatColor.GOLD + "§lGoMineMe core information:");
					p.sendMessage(prefix + ChatColor.YELLOW + "Version: " + getDescription().getVersion());
					p.sendMessage(prefix + ChatColor.YELLOW + "Developer: " + getDescription().getAuthors());
					p.sendMessage(prefix + ChatColor.GREEN + "§lGoMineMe core is currently enabled");
				}
			} else {
				p.sendMessage(prefix + ChatColor.GOLD + "§lGoMineMe core information:");
				p.sendMessage(prefix + ChatColor.YELLOW + "Version: " + getDescription().getVersion());
				p.sendMessage(prefix + ChatColor.YELLOW + "Developer: " + getDescription().getAuthors());
				p.sendMessage(prefix + ChatColor.GREEN + "§lGoMineMe core is currently enabled");
			}
		}

		if (cmd.getName().equalsIgnoreCase("shop")) {
			sender.sendMessage(ChatColor.GOLD + "Store" + ChatColor.GRAY + ">>" + ChatColor.WHITE + " baseden.tebex.io");
		}
		
		if (cmd.getName().equalsIgnoreCase("store")) {
			sender.sendMessage(ChatColor.GOLD + "Store" + ChatColor.GRAY + ">>" + ChatColor.WHITE + " baseden.tebex.io");
		}
		
		if (cmd.getName().equalsIgnoreCase("lab")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(prefix + ChatColor.RED + "You need to be a player to do this!");
				return false;
			}
			Player p = (Player)sender;
			p.teleport(new Location(p.getWorld(), -143,  225, 2, 90, 0));
		}
		
		if (cmd.getName().equalsIgnoreCase("mine")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(prefix + ChatColor.RED + "You need to be a player to do this!");
				return false;
			}
			Player p = (Player)sender;
			p.teleport(new Location(p.getWorld(), -103, 224, -33, 180, 0));
		}
		
		if (cmd.getName().equalsIgnoreCase("gm")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(prefix + ChatColor.RED + "You need to be a player to do this!");
				return false;
			}
			Player p = (Player) sender;
			if (args.length <= 0) {
				if (p.getGameMode().equals(GameMode.CREATIVE)) {
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage(prefix + ChatColor.GREEN + "Your gamemode is updated to survival.");
				} else {
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage(prefix + ChatColor.GREEN + "Your gamemode is updated to creative.");
				}
			} else {
				if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s")) {
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage(prefix + ChatColor.GREEN + "Your gamemode is updated to survival.");
				} else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c")) {
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage(prefix + ChatColor.GREEN + "Your gamemode is updated to creative.");
				} else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a")) {
					p.setGameMode(GameMode.ADVENTURE);
					p.sendMessage(prefix + ChatColor.GREEN + "Your gamemode is updated to adventure.");
				} else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
					p.setGameMode(GameMode.SPECTATOR);
					p.sendMessage(prefix + ChatColor.GREEN + "Your gamemode is updated to spectator.");
				} else {
					if (p.getGameMode().equals(GameMode.CREATIVE)) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(prefix + ChatColor.GREEN + "Your gamemode is updated to survival.");
					} else {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(prefix + ChatColor.GREEN + "Your gamemode is updated to creative.");
					}
				}
			}
	    }
		
		else if (cmd.getName().equalsIgnoreCase("rename")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(prefix + ChatColor.RED + "You need to be a player to do this!");
				return false;
			}
			Player p = (Player) sender;
			if (p.getEquipment().getItemInMainHand().getType() != Material.AIR) {
				String message = "";
	    		for(int i = 0; i < args.length; i++) {
	    			message = message + args[i] + " ";
	    		}
	    		message = ChatColor.WHITE + message;
	    		ItemStack item = p.getEquipment().getItemInMainHand();
	    		ItemMeta itemMeta = item.getItemMeta();
	    		itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', message));
	    		item.setItemMeta(itemMeta);
	    		p.getEquipment().setItemInMainHand(item);
	    		p.updateInventory();
	    		p.sendMessage(prefix + ChatColor.GREEN + "Item in your hand renamed!");
			} else {
				p.sendMessage(prefix + ChatColor.RED + "You dont have an item in your hand!");
			}
		}
	    
	    else if (cmd.getName().equalsIgnoreCase("colorcodes")) {
	    	sender.sendMessage(prefix + ChatColor.DARK_RED + "Dark red: &4");
			sender.sendMessage(prefix + ChatColor.RED + "Red: &c");
			sender.sendMessage(prefix + ChatColor.GOLD + "Gold: &6");
			sender.sendMessage(prefix + ChatColor.YELLOW + "Yellow: &e");
			sender.sendMessage(prefix + ChatColor.DARK_GREEN + "Dark green: &2");
			sender.sendMessage(prefix + ChatColor.GREEN + "Green: &a");
			sender.sendMessage(prefix + ChatColor.AQUA + "Aqua: &b");
			sender.sendMessage(prefix + ChatColor.DARK_AQUA + "Dark Aqua: &3");
			sender.sendMessage(prefix + ChatColor.DARK_BLUE + "Dark blue: &1");
			sender.sendMessage(prefix + ChatColor.BLUE + "Blue: &9");
			sender.sendMessage(prefix + ChatColor.LIGHT_PURPLE + "light purple: &d");
			sender.sendMessage(prefix + ChatColor.DARK_PURPLE + "Dark purple: &5");
			sender.sendMessage(prefix + ChatColor.WHITE + "White: &f");
			sender.sendMessage(prefix + ChatColor.GRAY + "Gray: &7");
			sender.sendMessage(prefix + ChatColor.DARK_GRAY + "Dark gray: &8");
			sender.sendMessage(prefix + ChatColor.BLACK + "Black: &0");
			sender.sendMessage(prefix + ChatColor.WHITE + "Reset Colors: &r");
			sender.sendMessage(prefix + ChatColor.BOLD + "Bold: &l");
			sender.sendMessage(prefix + ChatColor.ITALIC + "Italic: &o");
			sender.sendMessage(prefix + ChatColor.UNDERLINE + "Underlined: &n");
			sender.sendMessage(prefix + ChatColor.STRIKETHROUGH + "Crossed out: &m");
			sender.sendMessage(prefix + ChatColor.WHITE + "Spinning: &k");
	    }
		
		return false;
	}
	
	public void saveNewConfig(){
		try{
			newConfigz.save(newConfig);
		 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
