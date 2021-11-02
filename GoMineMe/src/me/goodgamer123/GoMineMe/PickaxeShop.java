package me.goodgamer123.GoMineMe;

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
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("2")) {
	    		        	prePick = pickaxe(1);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("3")) {
	    		        	prePick = pickaxe(2);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("4")) {
	    		        	prePick = pickaxe(3);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("5")) {
	    		        	prePick = pickaxe(4);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("6")) {
	    		        	prePick = pickaxe(5);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("7")) {
	    		        	prePick = pickaxe(6);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("8")) {
	    		        	prePick = pickaxe(7);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("9")) {
	    		        	prePick = pickaxe(8);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("10")) {
	    		        	prePick = pickaxe(9);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("11")) {
	    		        	prePick = pickaxe(10);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("12")) {
	    		        	prePick = pickaxe(11);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("13")) {
	    		        	prePick = pickaxe(12);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("14")) {
	    		        	prePick = pickaxe(13);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("15")) {
	    		        	prePick = pickaxe(14);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("16")) {
	    		        	prePick = pickaxe(15);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("17")) {
	    		        	prePick = pickaxe(16);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("18")) {
	    		        	prePick = pickaxe(17);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("19")) {
	    		        	prePick = pickaxe(18);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("20")) {
	    		        	prePick = pickaxe(19);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("21")) {
	    		        	prePick = pickaxe(20);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("22")) {
	    		        	prePick = pickaxe(21);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("23")) {
	    		        	prePick = pickaxe(22);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("24")) {
	    		        	prePick = pickaxe(23);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("25")) {
	    		        	prePick = pickaxe(24);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("26")) {
	    		        	prePick = pickaxe(25);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("27")) {
	    		        	prePick = pickaxe(26);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("28")) {
	    		        	prePick = pickaxe(27);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("29")) {
	    		        	prePick = pickaxe(28);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("30")) {
	    		        	prePick = pickaxe(29);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("31")) {
	    		        	prePick = pickaxe(30);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("32")) {
	    		        	prePick = pickaxe(31);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("33")) {
	    		        	prePick = pickaxe(32);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("34")) {
	    		        	prePick = pickaxe(33);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("35")) {
	    		        	prePick = pickaxe(34);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("36")) {
	    		        	prePick = pickaxe(35);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("37")) {
	    		        	prePick = pickaxe(36);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("38")) {
	    		        	prePick = pickaxe(37);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("39")) {
	    		        	prePick = pickaxe(38);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("40")) {
	    		        	prePick = pickaxe(39);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("41")) {
	    		        	prePick = pickaxe(40);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("42")) {
	    		        	prePick = pickaxe(41);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("43")) {
	    		        	prePick = pickaxe(42);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("44")) {
	    		        	prePick = pickaxe(43);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("45")) {
	    		        	prePick = pickaxe(44);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("46")) {
	    		        	prePick = pickaxe(45);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("47")) {
	    		        	prePick = pickaxe(46);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("48")) {
	    		        	prePick = pickaxe(47);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("49")) {
	    		        	prePick = pickaxe(48);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("50")) {
	    		        	prePick = pickaxe(49);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("51")) {
	    		        	prePick = pickaxe(50);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("52")) {
	    		        	prePick = pickaxe(51);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("53")) {
	    		        	prePick = pickaxe(52);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("54")) {
	    		        	prePick = pickaxe(53);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("55")) {
	    		        	prePick = pickaxe(54);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("56")) {
	    		        	prePick = pickaxe(55);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("57")) {
	    		        	prePick = pickaxe(56);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("58")) {
	    		        	prePick = pickaxe(57);
	    		        	nextPick = pickaxe(2);
	    		        } else if (ChatColor.stripColor(e.getPlayer().getEquipment().getItemInMainHand().getItemMeta().getDisplayName().replace("Pickaxe tier ", "")).equals("59")) {
	    		        	prePick = pickaxe(58);
	    		        	ItemStack bedrock = new ItemStack(Material.FIREWORK_ROCKET);
	    		        	ItemMeta bedrockMeta = bedrock.getItemMeta();
	    		        	bedrockMeta.setDisplayName(ChatColor.GREEN + "You made it to the end!.");
	    		        	bedrock.setItemMeta(bedrockMeta);
	    		        	prePick = bedrock;
	    		        }
	    		        
	    	    		Inventory inv = Bukkit.createInventory(null, 45, ChatColor.BLUE + "§lPickaxe upgrade");
	    				for (int i = 0; i < inv.getSize(); i++) {
	    					if (i % 2 == 0) inv.setItem(i, Filling);
	    					else inv.setItem(i, Filling1);
	    				}
	    				inv.setItem(13, e.getPlayer().getEquipment().getItemInMainHand());
	    				inv.setItem(11, prePick);
	    				inv.setItem(15, nextPick);
	    				
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

	private ItemStack pickaxe(int tier) {
		return null;
		// TODO Auto-generated method stub
	}
	
}
