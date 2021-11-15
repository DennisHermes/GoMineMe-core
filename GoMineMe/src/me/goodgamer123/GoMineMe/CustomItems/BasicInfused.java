package me.goodgamer123.GoMineMe.CustomItems;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BasicInfused {

	public static ItemStack StoneInfusedCoal() {
		ItemStack infused = new ItemStack(Material.COAL_BLOCK);
		ItemMeta infusedMeta = infused.getItemMeta();
		infusedMeta.setDisplayName(ChatColor.GRAY + "§lStone infused coal");
		infusedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		infusedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		infused.setItemMeta(infusedMeta);
		return infused;
	}
	
	public static ItemStack CoalInfusedIron() {
		ItemStack infused = new ItemStack(Material.IRON_BLOCK);
		ItemMeta infusedMeta = infused.getItemMeta();
		infusedMeta.setDisplayName(ChatColor.DARK_GRAY + "§lCoal infused iron");
		infusedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		infusedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		infused.setItemMeta(infusedMeta);
		return infused;
	}
	
	public static ItemStack IronInfusedGold() {
		ItemStack infused = new ItemStack(Material.GOLD_BLOCK);
		ItemMeta infusedMeta = infused.getItemMeta();
		infusedMeta.setDisplayName(ChatColor.WHITE + "§lIron infused gold");
		infusedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		infusedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		infused.setItemMeta(infusedMeta);
		return infused;
	}
	
	public static ItemStack GoldInfusedDiamond() {
		ItemStack infused = new ItemStack(Material.DIAMOND_BLOCK);
		ItemMeta infusedMeta = infused.getItemMeta();
		infusedMeta.setDisplayName(ChatColor.GOLD + "§lGold infused diamond");
		infusedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		infusedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		infused.setItemMeta(infusedMeta);
		return infused;
	}
	
	public static ItemStack DiamondInfusedEmerald() {
		ItemStack infused = new ItemStack(Material.EMERALD_BLOCK);
		ItemMeta infusedMeta = infused.getItemMeta();
		infusedMeta.setDisplayName(ChatColor.AQUA + "§lDiamond infused emerald");
		infusedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		infusedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		infused.setItemMeta(infusedMeta);
		return infused;
	}
	
}
