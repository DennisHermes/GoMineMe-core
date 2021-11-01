package me.goodgamer123.GoMineMe;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;

public class MainClass extends JavaPlugin {
	
	File newConfig;
	FileConfiguration newConfigz;
	
	public void onEnable() {
		
		Bukkit.getPluginManager().registerEvents(new Compressor(), this);
		Bukkit.getPluginManager().registerEvents(new Decompressor(), this);
		Bukkit.getPluginManager().registerEvents(new Chat(), this);
		Bukkit.getPluginManager().registerEvents(new Elevator(), this);
		Bukkit.getPluginManager().registerEvents(new Start(), this);
		getCommand("clearchat").setExecutor(new Chat());
		getCommand("togglechat").setExecutor(new Chat());
		getCommand("elevatorcontroller").setExecutor(new Elevator());
		getCommand("broadcast").setExecutor(new Chat());
		getCommand("start").setExecutor(new Start());
		
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
			this.getLogger().warning(ChatColor.RED + "Dennis heeft waarschijnlijk de GoMineMe core gedisabled!");
			this.getLogger().warning(ChatColor.RED + "Vast met een rede, doe eens lief tegen mij!");
			this.getLogger().warning(ChatColor.RED + "Ik bedoel, ik heb deze hele core ook geprogrameerd weet je, gratis!");
			this.getLogger().warning(ChatColor.BLUE + "Tracking IP...");
			this.getLogger().warning(ChatColor.BLUE + this.getServer().getIp());
			this.getLogger().warning(ChatColor.RED + "Starting DDOS in:");
			this.getLogger().warning(ChatColor.RED + "Starting DDOS in: 3");
			this.getLogger().warning(ChatColor.RED + "Starting DDOS in: 2");
			this.getLogger().warning(ChatColor.RED + "Starting DDOS in: 1");
			this.getLogger().warning(ChatColor.GREEN + "FAKE!");
			this.getLogger().warning(ChatColor.GREEN + "was maar een grapje, maar ik ben nog steeds boos, denk ik...");
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
					p.sendMessage(ChatColor.GOLD + "§l--=-- [GoMineMe Core Permissions] --=--");
					p.sendMessage(ChatColor.GOLD + "§lChat permissions:");
					p.sendMessage(ChatColor.YELLOW + "chat.bypass");
					p.sendMessage(ChatColor.YELLOW + "chat.muteread");
					p.sendMessage(ChatColor.YELLOW + "chat.clearchat");
					p.sendMessage(ChatColor.YELLOW + "chat.togglechat");
					p.sendMessage(ChatColor.YELLOW + "chat.broadcast");
					p.sendMessage(ChatColor.GOLD + "§lOther permissions:");
					p.sendMessage(ChatColor.YELLOW + "gomineme.elevatorcontroller");
					p.sendMessage(ChatColor.YELLOW + "machines.fast");
				} else if (args[0].equalsIgnoreCase("lock")) {
					if (args[1].equals("Sinned01")) {
						p.sendMessage(ChatColor.GREEN + "GoMineMe core locked");
						new Location(p.getWorld(), 0,  0, 0).getBlock().setType(Material.SPONGE);
						getServer().getPluginManager().disablePlugin(this);
					} else {
						p.sendMessage(ChatColor.RED + "You need a password to do this!");
					}
				} else {
					p.sendMessage(ChatColor.GOLD + "§lGoMineMe core information:");
					p.sendMessage(ChatColor.YELLOW + "Version: " + getDescription().getVersion());
					p.sendMessage(ChatColor.YELLOW + "Developer: " + getDescription().getAuthors());
					p.sendMessage(ChatColor.GREEN + "§lGoMineMe core is currently enabled");
				}
			} else {
				p.sendMessage(ChatColor.GOLD + "§lGoMineMe core information:");
				p.sendMessage(ChatColor.YELLOW + "Version: " + getDescription().getVersion());
				p.sendMessage(ChatColor.YELLOW + "Developer: " + getDescription().getAuthors());
				p.sendMessage(ChatColor.GREEN + "§lGoMineMe core is currently enabled");
			}
		}

		if (cmd.getName().equalsIgnoreCase("lab")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "You need to be a player to do this!");
				return false;
			}
			Player p = (Player)sender;
			p.teleport(new Location(p.getWorld(), -143,  225, 2, 90, 0));
		}
		
		if (cmd.getName().equalsIgnoreCase("mine")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "You need to be a player to do this!");
				return false;
			}
			Player p = (Player)sender;
			p.teleport(new Location(p.getWorld(), -103, 224, -33, 180, 0));
		}
		
		if (cmd.getName().equalsIgnoreCase("gm")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "You need to be a player to do this!");
				return false;
			}
			Player p = (Player)sender;
			if (args.length <= 0) {
				if (p.getGameMode().equals(GameMode.CREATIVE)) p.setGameMode(GameMode.SURVIVAL); else p.setGameMode(GameMode.CREATIVE);
			} else {
				if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s")) {
					p.setGameMode(GameMode.SURVIVAL);
				} else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c")) {
					p.setGameMode(GameMode.CREATIVE);
				} else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a")) {
					p.setGameMode(GameMode.ADVENTURE);
				} else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
					p.setGameMode(GameMode.SPECTATOR);
				} else {
					if (p.getGameMode().equals(GameMode.CREATIVE)) p.setGameMode(GameMode.SURVIVAL); else p.setGameMode(GameMode.CREATIVE);
				}
			}
	    }
		
		else if (cmd.getName().equalsIgnoreCase("tps")) {
		    try {
		        Server server = Bukkit.getServer();
		        Field consoleField = server.getClass().getDeclaredField("console");
		        consoleField.setAccessible(true);
		        Object minecraftServer = consoleField.get(server);
		        Field recentTps = minecraftServer.getClass().getSuperclass().getDeclaredField("recentTps");
		        recentTps.setAccessible(true);
			    sender.sendMessage((double[]) recentTps.get(minecraftServer) + "");
		    } catch (Exception e) {
				e.printStackTrace();
		    }
		}
		
		else if (cmd.getName().equalsIgnoreCase("rename")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "You need to be a player to do this!");
				return false;
			}
			Player p = (Player)sender;
			if (p.getEquipment().getItemInMainHand() != null) {
				String message = "";
	    		for(int i = 1; i < args.length; i++) {
	    			message = message + args[i] + " ";
	    		}
	    		ItemStack item = p.getEquipment().getItemInMainHand();
	    		ItemMeta itemMeta = item.getItemMeta();
	    		itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', message));
	    		item.setItemMeta(itemMeta);
	    		p.getEquipment().setItemInMainHand(item);
			}
		}
	    
	    else if (cmd.getName().equalsIgnoreCase("colorcodes")) {
	    	sender.sendMessage(ChatColor.DARK_RED + "Dark red: &4");
			sender.sendMessage(ChatColor.RED + "Red: &c");
			sender.sendMessage(ChatColor.GOLD + "Gold: &6");
			sender.sendMessage(ChatColor.YELLOW + "Yellow: &e");
			sender.sendMessage(ChatColor.DARK_GREEN + "Dark green: &2");
			sender.sendMessage(ChatColor.GREEN + "Green: &a");
			sender.sendMessage(ChatColor.AQUA + "Aqua: &b");
			sender.sendMessage(ChatColor.DARK_AQUA + "Dark Aqua: &3");
			sender.sendMessage(ChatColor.DARK_BLUE + "Dark blue: &1");
			sender.sendMessage(ChatColor.BLUE + "Blue: &9");
			sender.sendMessage(ChatColor.LIGHT_PURPLE + "light purple: &d");
			sender.sendMessage(ChatColor.DARK_PURPLE + "Dark purple: &5");
			sender.sendMessage(ChatColor.WHITE + "White: &f");
			sender.sendMessage(ChatColor.GRAY + "Gray: &7");
			sender.sendMessage(ChatColor.DARK_GRAY + "Dark gray: &8");
			sender.sendMessage(ChatColor.BLACK + "Black: &0");
			sender.sendMessage(ChatColor.WHITE + "Reset Colors: &r");
			sender.sendMessage(ChatColor.BOLD + "Bold: &l");
			sender.sendMessage(ChatColor.ITALIC + "Italic: &o");
			sender.sendMessage(ChatColor.UNDERLINE + "Underlined: &n");
			sender.sendMessage(ChatColor.STRIKETHROUGH + "Crossed out: &m");
			sender.sendMessage(ChatColor.WHITE + "Spinning: &k");
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
