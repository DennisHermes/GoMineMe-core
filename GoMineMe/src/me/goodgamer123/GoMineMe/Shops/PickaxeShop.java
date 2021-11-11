package me.goodgamer123.GoMineMe.Shops;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.goodgamer123.GoMineMe.MainClass;

public class PickaxeShop implements Listener {

	@EventHandler
	public void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
	    if(e.getRightClicked() instanceof Villager) {
	    	if (e.getRightClicked().getCustomName().contains("Pickaxe Upgrade")) {
	    		if (e.getPlayer().getEquipment().getItemInMainHand() != null) {
	    			if (e.getPlayer().getEquipment().getItemInMainHand().getType().toString().contains("PICKAXE")) {
	    				ItemStack Filling = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
	    		        ItemMeta FillingMeta = Filling.getItemMeta();
	    		        FillingMeta.setDisplayName(" ");
	    		        Filling.setItemMeta(FillingMeta);
	    		        
	    		        ItemStack Filling1 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
	    		        ItemMeta Filling1Meta = Filling1.getItemMeta();
	    		        Filling1Meta.setDisplayName(" ");
	    		        Filling1.setItemMeta(FillingMeta);
	    	    		
	    		        ItemStack prePick = null;
	    		        ItemStack nextPick = null;
	    		        
	    		        ItemStack upgrade = new ItemStack(Material.FIREWORK_ROCKET);
    		        	ItemMeta upgradeMeta = upgrade.getItemMeta();
    		        	upgradeMeta.setDisplayName(ChatColor.GREEN + "Click to upgrade");
    		        	ArrayList<String> upgradeLore = new ArrayList<String>();
    		        	upgradeLore.add(" ");
    		        	upgradeLore.add(ChatColor.BLUE + "§lCost:");
    		        	upgradeLore.add(" ");
	    		        
	    		        if (e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().contains("Starter pickaxe")) {
	    		        	ItemStack bedrock = new ItemStack(Material.BEDROCK);
	    		        	ItemMeta bedrockMeta = bedrock.getItemMeta();
	    		        	bedrockMeta.setDisplayName(ChatColor.BLUE + "You are on your first tier.");
	    		        	bedrock.setItemMeta(bedrockMeta);
	    		        	prePick = bedrock;
	    		        	nextPick = pickaxe(1);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("1")) {
	    		        	prePick = pickaxe(0);
	    		        	nextPick = pickaxe(2);
	    		        	upgradeLore.addAll(upgradeNeed(2));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("2")) {
	    		        	prePick = pickaxe(1);
	    		        	nextPick = pickaxe(3);
	    		        	upgradeLore.addAll(upgradeNeed(3));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("3")) {
	    		        	prePick = pickaxe(2);
	    		        	nextPick = pickaxe(4);
	    		        	upgradeLore.addAll(upgradeNeed(4));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("4")) {
	    		        	prePick = pickaxe(3);
	    		        	nextPick = pickaxe(5);
	    		        	upgradeLore.addAll(upgradeNeed(5));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("5")) {
	    		        	prePick = pickaxe(4);
	    		        	nextPick = pickaxe(6);
	    		        	upgradeLore.addAll(upgradeNeed(6));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("6")) {
	    		        	prePick = pickaxe(5);
	    		        	nextPick = pickaxe(7);
	    		        	upgradeLore.addAll(upgradeNeed(7));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("7")) {
	    		        	prePick = pickaxe(6);
	    		        	nextPick = pickaxe(8);
	    		        	upgradeLore.addAll(upgradeNeed(8));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("8")) {
	    		        	prePick = pickaxe(7);
	    		        	nextPick = pickaxe(9);
	    		        	upgradeLore.addAll(upgradeNeed(9));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("9")) {
	    		        	prePick = pickaxe(8);
	    		        	nextPick = pickaxe(10);
	    		        	upgradeLore.addAll(upgradeNeed(10));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("10")) {
	    		        	prePick = pickaxe(9);
	    		        	nextPick = pickaxe(11);
	    		        	upgradeLore.addAll(upgradeNeed(11));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("11")) {
	    		        	prePick = pickaxe(10);
	    		        	nextPick = pickaxe(12);
	    		        	upgradeLore.addAll(upgradeNeed(12));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("12")) {
	    		        	prePick = pickaxe(11);
	    		        	nextPick = pickaxe(13);
	    		        	upgradeLore.addAll(upgradeNeed(13));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("13")) {
	    		        	prePick = pickaxe(12);
	    		        	nextPick = pickaxe(14);
	    		        	upgradeLore.addAll(upgradeNeed(14));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("14")) {
	    		        	prePick = pickaxe(13);
	    		        	nextPick = pickaxe(15);
	    		        	upgradeLore.addAll(upgradeNeed(15));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("15")) {
	    		        	prePick = pickaxe(14);
	    		        	nextPick = pickaxe(16);
	    		        	upgradeLore.addAll(upgradeNeed(16));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("16")) {
	    		        	prePick = pickaxe(15);
	    		        	nextPick = pickaxe(17);
	    		        	upgradeLore.addAll(upgradeNeed(17));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("17")) {
	    		        	prePick = pickaxe(16);
	    		        	nextPick = pickaxe(18);
	    		        	upgradeLore.addAll(upgradeNeed(18));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("18")) {
	    		        	prePick = pickaxe(17);
	    		        	nextPick = pickaxe(19);
	    		        	upgradeLore.addAll(upgradeNeed(19));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("19")) {
	    		        	prePick = pickaxe(18);
	    		        	nextPick = pickaxe(20);
	    		        	upgradeLore.addAll(upgradeNeed(20));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("20")) {
	    		        	prePick = pickaxe(19);
	    		        	nextPick = pickaxe(21);
	    		        	upgradeLore.addAll(upgradeNeed(21));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("21")) {
	    		        	prePick = pickaxe(20);
	    		        	nextPick = pickaxe(22);
	    		        	upgradeLore.addAll(upgradeNeed(22));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("22")) {
	    		        	prePick = pickaxe(21);
	    		        	nextPick = pickaxe(23);
	    		        	upgradeLore.addAll(upgradeNeed(23));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("23")) {
	    		        	prePick = pickaxe(22);
	    		        	nextPick = pickaxe(24);
	    		        	upgradeLore.addAll(upgradeNeed(24));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("24")) {
	    		        	prePick = pickaxe(23);
	    		        	nextPick = pickaxe(25);
	    		        	upgradeLore.addAll(upgradeNeed(25));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("25")) {
	    		        	prePick = pickaxe(24);
	    		        	nextPick = pickaxe(26);
	    		        	upgradeLore.addAll(upgradeNeed(26));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("26")) {
	    		        	prePick = pickaxe(25);
	    		        	nextPick = pickaxe(27);
	    		        	upgradeLore.addAll(upgradeNeed(27));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("27")) {
	    		        	prePick = pickaxe(26);
	    		        	nextPick = pickaxe(28);
	    		        	upgradeLore.addAll(upgradeNeed(28));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("28")) {
	    		        	prePick = pickaxe(27);
	    		        	nextPick = pickaxe(29);
	    		        	upgradeLore.addAll(upgradeNeed(29));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("29")) {
	    		        	prePick = pickaxe(28);
	    		        	nextPick = pickaxe(30);
	    		        	upgradeLore.addAll(upgradeNeed(30));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("30")) {
	    		        	prePick = pickaxe(29);
	    		        	nextPick = pickaxe(31);
	    		        	upgradeLore.addAll(upgradeNeed(31));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("31")) {
	    		        	prePick = pickaxe(30);
	    		        	nextPick = pickaxe(32);
	    		        	upgradeLore.addAll(upgradeNeed(32));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("32")) {
	    		        	prePick = pickaxe(31);
	    		        	nextPick = pickaxe(33);
	    		        	upgradeLore.addAll(upgradeNeed(33));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("33")) {
	    		        	prePick = pickaxe(32);
	    		        	nextPick = pickaxe(34);
	    		        	upgradeLore.addAll(upgradeNeed(34));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("34")) {
	    		        	prePick = pickaxe(33);
	    		        	nextPick = pickaxe(35);
	    		        	upgradeLore.addAll(upgradeNeed(35));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("35")) {
	    		        	prePick = pickaxe(34);
	    		        	nextPick = pickaxe(36);
	    		        	upgradeLore.addAll(upgradeNeed(36));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("36")) {
	    		        	prePick = pickaxe(35);
	    		        	nextPick = pickaxe(37);
	    		        	upgradeLore.addAll(upgradeNeed(37));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("37")) {
	    		        	prePick = pickaxe(36);
	    		        	nextPick = pickaxe(38);
	    		        	upgradeLore.addAll(upgradeNeed(38));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("38")) {
	    		        	prePick = pickaxe(37);
	    		        	nextPick = pickaxe(39);
	    		        	upgradeLore.addAll(upgradeNeed(39));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("39")) {
	    		        	prePick = pickaxe(38);
	    		        	nextPick = pickaxe(40);
	    		        	upgradeLore.addAll(upgradeNeed(40));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("40")) {
	    		        	prePick = pickaxe(39);
	    		        	nextPick = pickaxe(41);
	    		        	upgradeLore.addAll(upgradeNeed(41));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("41")) {
	    		        	prePick = pickaxe(40);
	    		        	nextPick = pickaxe(42);
	    		        	upgradeLore.addAll(upgradeNeed(42));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("42")) {
	    		        	prePick = pickaxe(41);
	    		        	nextPick = pickaxe(43);
	    		        	upgradeLore.addAll(upgradeNeed(43));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("43")) {
	    		        	prePick = pickaxe(42);
	    		        	nextPick = pickaxe(44);
	    		        	upgradeLore.addAll(upgradeNeed(44));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("44")) {
	    		        	prePick = pickaxe(43);
	    		        	nextPick = pickaxe(45);
	    		        	upgradeLore.addAll(upgradeNeed(45));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("45")) {
	    		        	prePick = pickaxe(44);
	    		        	nextPick = pickaxe(46);
	    		        	upgradeLore.addAll(upgradeNeed(46));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("46")) {
	    		        	prePick = pickaxe(45);
	    		        	nextPick = pickaxe(47);
	    		        	upgradeLore.addAll(upgradeNeed(47));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("47")) {
	    		        	prePick = pickaxe(46);
	    		        	nextPick = pickaxe(48);
	    		        	upgradeLore.addAll(upgradeNeed(48));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("48")) {
	    		        	prePick = pickaxe(47);
	    		        	nextPick = pickaxe(49);
	    		        	upgradeLore.addAll(upgradeNeed(49));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("49")) {
	    		        	prePick = pickaxe(48);
	    		        	nextPick = pickaxe(50);
	    		        	upgradeLore.addAll(upgradeNeed(50));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("50")) {
	    		        	prePick = pickaxe(49);
	    		        	nextPick = pickaxe(51);
	    		        	upgradeLore.addAll(upgradeNeed(51));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("51")) {
	    		        	prePick = pickaxe(50);
	    		        	nextPick = pickaxe(52);
	    		        	upgradeLore.addAll(upgradeNeed(52));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("52")) {
	    		        	prePick = pickaxe(51);
	    		        	nextPick = pickaxe(53);
	    		        	upgradeLore.addAll(upgradeNeed(53));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("53")) {
	    		        	prePick = pickaxe(52);
	    		        	nextPick = pickaxe(54);
	    		        	upgradeLore.addAll(upgradeNeed(54));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("54")) {
	    		        	prePick = pickaxe(53);
	    		        	nextPick = pickaxe(55);
	    		        	upgradeLore.addAll(upgradeNeed(55));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("55")) {
	    		        	prePick = pickaxe(54);
	    		        	nextPick = pickaxe(56);
	    		        	upgradeLore.addAll(upgradeNeed(56));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("56")) {
	    		        	prePick = pickaxe(55);
	    		        	nextPick = pickaxe(57);
	    		        	upgradeLore.addAll(upgradeNeed(57));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("57")) {
	    		        	prePick = pickaxe(56);
	    		        	nextPick = pickaxe(58);
	    		        	upgradeLore.addAll(upgradeNeed(58));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("58")) {
	    		        	prePick = pickaxe(57);
	    		        	nextPick = pickaxe(59);
	    		        	upgradeLore.addAll(upgradeNeed(59));
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("59")) {
	    		        	prePick = pickaxe(58);
	    		        	ItemStack bedrock = new ItemStack(Material.FIREWORK_ROCKET);
	    		        	ItemMeta bedrockMeta = bedrock.getItemMeta();
	    		        	bedrockMeta.setDisplayName(ChatColor.GREEN + "You made it to the end!");
	    		        	bedrock.setItemMeta(bedrockMeta);
	    		        	prePick = bedrock;
	    		        	upgrade = new ItemStack(Material.RED_STAINED_GLASS_PANE);
	    		        }
	    		        
    					upgradeMeta.setLore(upgradeLore);
    		        	upgrade.setItemMeta(upgradeMeta);
	    		        
	    	    		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.BLUE + "§lPickaxe upgrade");
	    				for (int i = 0; i < inv.getSize(); i++) {
	    					if (i % 2 == 0) inv.setItem(i, Filling);
	    					else inv.setItem(i, Filling1);
	    				}
	    				inv.setItem(13, e.getPlayer().getEquipment().getItemInMainHand());
	    				inv.setItem(11, prePick);
	    				inv.setItem(15, nextPick);
	    				inv.setItem(31, new ItemStack(Material.AIR));
	    				inv.setItem(40, upgrade);
	    				
	    				e.getPlayer().openInventory(inv);
		    		} else {
		    			e.getPlayer().sendMessage(MainClass.prefix + ChatColor.RED + "You need to hold your pickaxe!");
		    		}
	    		} else {
	    			e.getPlayer().sendMessage(MainClass.prefix + ChatColor.RED + "You need to hold your pickaxe!");
	    		}
	    	}
	    }
	}

	ItemStack pickaxe(int tier) {
		ItemStack pickaxe = new ItemStack(Material.WOODEN_PICKAXE);
		ItemMeta pickaxeMeta = pickaxe.getItemMeta();
		if (tier == 2) {
		} else if (tier == 3) {
			
		} else if (tier == 4) {
			
		} else if (tier == 5) {
			
		} else if (tier == 6) {
			
		} else if (tier == 7) {
			
		} else if (tier == 8) {
			
		} else if (tier == 9) {
			
		} else if (tier == 10) {
			
		} else if (tier == 11) {
			
		} else if (tier == 12) {
			
		} else if (tier == 13) {
			
		} else if (tier == 14) {
			
		} else if (tier == 15) {
			
		} else if (tier == 16) {
			
		} else if (tier == 17) {
			
		} else if (tier == 18) {
			
		} else if (tier == 19) {
			
		} else if (tier == 20) {
			
		} else if (tier == 21) {
			
		} else if (tier == 22) {
			
		} else if (tier == 23) {
			
		} else if (tier == 24) {
			
		} else if (tier == 25) {
			
		} else if (tier == 26) {
			
		} else if (tier == 27) {
			
		} else if (tier == 28) {
			
		} else if (tier == 29) {
			
		} else if (tier == 30) {
			
		} else if (tier == 31) {
			
		} else if (tier == 32) {
			
		} else if (tier == 33) {
			
		} else if (tier == 34) {
			
		} else if (tier == 35) {
			
		} else if (tier == 36) {
			
		} else if (tier == 37) {
			
		} else if (tier == 38) {
			
		} else if (tier == 39) {
			
		} else if (tier == 40) {
			
		} else if (tier == 41) {
			
		} else if (tier == 42) {
			
		} else if (tier == 43) {
			
		} else if (tier == 44) {
			
		} else if (tier == 45) {
			
		} else if (tier == 46) {
			
		} else if (tier == 47) {
			
		} else if (tier == 48) {
			
		} else if (tier == 49) {
			
		} else if (tier == 50) {
			
		} else if (tier == 51) {
			
		} else if (tier == 52) {
			
		} else if (tier == 53) {
			
		} else if (tier == 54) {
			
		} else if (tier == 55) {
			
		} else if (tier == 56) {
			
		} else if (tier == 57) {
			
		} else if (tier == 58) {
			
		} else if (tier == 59) {
			
		}
		pickaxe.setItemMeta(pickaxeMeta);
		return pickaxe;
	}
	
	ArrayList<String> upgradeNeed(int tier) {
		ArrayList<String> list = new ArrayList<String>();
		if (tier == 2) {
			list.add(ChatColor.GRAY + "• 16x Stone");
		} else if (tier == 3) {
			list.add(ChatColor.GRAY + "• 32x Stone");
		} else if (tier == 4) {
			list.add(ChatColor.GRAY + "• 64x Stone");
		} else if (tier == 5) {
			list.add(ChatColor.GRAY + "• 3x Compressed stone");
		} else if (tier == 6) {
			list.add(ChatColor.GRAY + "• 5x Compressed stone");
		} else if (tier == 7) {
			list.add(ChatColor.GRAY + "• 8x Compressed stone");
		} else if (tier == 8) {
			list.add(ChatColor.GRAY + "• 12x Compressed stone");
		} else if (tier == 9) {
			list.add(ChatColor.GRAY + "• 16x Compressed stone");
		} else if (tier == 10) {
			list.add(ChatColor.GRAY + "• 18x Compressed stone");
		} else if (tier == 11) {
			list.add(ChatColor.GRAY + "• 24x Compressed stone");
		} else if (tier == 12) {
			list.add(ChatColor.GRAY + "• 32x Compressed stone");
		} else if (tier == 13) {
			list.add(ChatColor.BLACK + "• 16x Coal block");
		} else if (tier == 14) {
			list.add(ChatColor.BLACK + "• 32x Coal block");
		} else if (tier == 15) {
			list.add(ChatColor.BLACK + "• 64x Coal block");
		} else if (tier == 16) {
			list.add(ChatColor.BLACK + "• 3x Compressed coal");
		} else if (tier == 17) {
			list.add(ChatColor.BLACK + "• 5x Compressed coal");
		} else if (tier == 18) {
			list.add(ChatColor.BLACK + "• 8x Compressed coal");
		} else if (tier == 19) {
			list.add(ChatColor.GRAY + "• 5x Stone infused coal");
		} else if (tier == 20) {
			list.add(ChatColor.GRAY + "• 8x Stone infused coal");
		} else if (tier == 21) {
			list.add(ChatColor.GRAY + "• 12x Stone infused coal");
		} else if (tier == 22) {
			list.add(ChatColor.GRAY + "• 16x Stone infused coal");
		} else if (tier == 23) {
			list.add(ChatColor.WHITE + "• 16x Iron block");
		} else if (tier == 24) {
			list.add(ChatColor.WHITE + "• 32x Iron block");
		} else if (tier == 25) {
			list.add(ChatColor.WHITE + "• 64x Iron block");
		} else if (tier == 26) {
			list.add(ChatColor.WHITE + "• 3x Compressed iron");
		} else if (tier == 27) {
			list.add(ChatColor.WHITE + "• 5x Compressed iron");
		} else if (tier == 28) {
			list.add(ChatColor.WHITE + "• 8x Compressed iron");
		} else if (tier == 29) {
			list.add(ChatColor.BLACK + "• 5x Coal infused iron");
		} else if (tier == 30) {
			list.add(ChatColor.BLACK + "• 8x Coal infused iron");
		} else if (tier == 31) {
			list.add(ChatColor.BLACK + "• 12x Coal infused iron");
		} else if (tier == 32) {
			list.add(ChatColor.BLACK + "• 16x Coal infused iron");
		} else if (tier == 33) {
			list.add(ChatColor.GOLD + "• 16x Gold block");
		} else if (tier == 34) {
			list.add(ChatColor.GOLD + "• 32x Gold block");
		} else if (tier == 35) {
			list.add(ChatColor.GOLD + "• 64x Gold block");
		} else if (tier == 36) {
			list.add(ChatColor.GOLD + "• 3x Compressed gold");
		} else if (tier == 37) {
			list.add(ChatColor.GOLD + "• 5x Compressed gold");
		} else if (tier == 38) {
			list.add(ChatColor.GOLD + "• 8x Compressed gold");
		} else if (tier == 39) {
			list.add(ChatColor.WHITE + "• 5x Iron infused gold");
		} else if (tier == 40) {
			list.add(ChatColor.WHITE + "• 8x Iron infused gold");
		} else if (tier == 41) {
			list.add(ChatColor.WHITE + "• 12x Iron infused gold");
		} else if (tier == 42) {
			list.add(ChatColor.WHITE + "• 16x Iron infused gold");
		} else if (tier == 43) {
			list.add(ChatColor.AQUA + "• 16x Diamond block");
		} else if (tier == 44) {
			list.add(ChatColor.AQUA + "• 32x Diamond block");
		} else if (tier == 45) {
			list.add(ChatColor.AQUA + "• 64x Diamond block");
		} else if (tier == 46) {
			list.add(ChatColor.AQUA + "• 3x Compressed diamond");
		} else if (tier == 47) {
			list.add(ChatColor.AQUA + "• 5x Compressed diamond");
		} else if (tier == 48) {
			list.add(ChatColor.AQUA + "• 8x Compressed diamond");
		} else if (tier == 49) {
			list.add(ChatColor.GOLD + "• 5x Gold infused diamond");
		} else if (tier == 50) {
			list.add(ChatColor.GOLD + "• 8x Gold infused diamond");
		} else if (tier == 51) {
			list.add(ChatColor.GOLD + "• 12x Gold infused diamond");
		} else if (tier == 52) {
			list.add(ChatColor.GOLD + "• 16x Gold infused diamond");
		} else if (tier == 53) {
			list.add(ChatColor.GREEN + "• 32x Emerald block");
		} else if (tier == 54) {
			list.add(ChatColor.GREEN + "• 64x Emerald block");
		} else if (tier == 55) {
			list.add(ChatColor.GREEN + "• 32x Compressed emerald");
		} else if (tier == 56) {
			list.add(ChatColor.GREEN + "• 32x Compressed emerald");
		} else if (tier == 57) {
			list.add(ChatColor.AQUA + "• 16x Diamond infused Emerald");
		} else if (tier == 58) {
			list.add(ChatColor.AQUA + "• 32x Diamond infused Emerald");
		} else if (tier == 59) {
			list.add(ChatColor.AQUA + "• 64x Diamond infused Emerald");
		}
		return list;
	}
	
}
