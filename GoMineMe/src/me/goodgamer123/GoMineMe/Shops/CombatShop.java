package me.goodgamer123.GoMineMe.Shops;

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

public class CombatShop implements Listener {

	@EventHandler
	public void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
		if (e.getRightClicked() instanceof Villager) {
			if (e.getRightClicked().getCustomName().contains("Combat shop")) {
	    		e.setCancelled(true);
				
				ItemStack Filling = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
				ItemMeta FillingMeta = Filling.getItemMeta();
				FillingMeta.setDisplayName(" ");
				Filling.setItemMeta(FillingMeta);
		        
				ItemStack Filling1 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
				ItemMeta Filling1Meta = Filling1.getItemMeta();
				Filling1Meta.setDisplayName(" ");
				Filling1.setItemMeta(FillingMeta);
		        
				ItemStack Sword = new ItemStack(Material.DIAMOND_SWORD);
				ItemMeta SwordMeta = Sword.getItemMeta();
				SwordMeta.setDisplayName(ChatColor.BLUE + "§lSword");
				Sword.setItemMeta(SwordMeta);
				
				ItemStack Armor = new ItemStack(Material.DIAMOND_CHESTPLATE);
				ItemMeta ArmorMeta = Armor.getItemMeta();
				ArmorMeta.setDisplayName(ChatColor.BLUE + "§lArmor");
				Armor.setItemMeta(ArmorMeta);
				
				ItemStack Bow = new ItemStack(Material.BOW);
				ItemMeta BowMeta = Bow.getItemMeta();
				BowMeta.setDisplayName(ChatColor.BLUE + "§lBow");
				Bow.setItemMeta(BowMeta);
				
				ItemStack Arrow = new ItemStack(Material.ARROW);
				ItemMeta ArrowMeta = Arrow.getItemMeta();
				ArrowMeta.setDisplayName(ChatColor.BLUE + "§lArrow type");
				Arrow.setItemMeta(ArrowMeta);
	    		
				Inventory inv = Bukkit.createInventory(null, 27, ChatColor.BLUE + "§lCombat shop");
				for (int i = 0; i < inv.getSize(); i++) {
					if (i % 2 == 0) inv.setItem(i, Filling);
					else inv.setItem(i, Filling1);
				}
				inv.setItem(10, Sword);
				inv.setItem(12, Armor);
				inv.setItem(14, Bow);
				inv.setItem(16, Arrow);
				
				
				e.getPlayer().openInventory(inv);
	    	}
	    }
	}
	
}
