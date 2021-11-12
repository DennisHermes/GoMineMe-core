package me.goodgamer123.GoMineMe.CustomItems;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Compressed {

	public static ItemStack compressedStone() {
		ItemStack compressed = new ItemStack(Material.STONE);
		ItemMeta compressedMeta = compressed.getItemMeta();
		compressedMeta.setDisplayName(ChatColor.GRAY + "§lCompressed stone");
		compressedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		compressedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		compressed.setItemMeta(compressedMeta);
		return compressed;
	}
	
	public static ItemStack compressedCoal() {
		ItemStack compressed = new ItemStack(Material.COAL_BLOCK);
		ItemMeta compressedMeta = compressed.getItemMeta();
		compressedMeta.setDisplayName(ChatColor.DARK_GRAY + "§lCompressed coal");
		compressedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		compressedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		compressed.setItemMeta(compressedMeta);
		return compressed;
	}
	
	public static ItemStack compressedIron() {
		ItemStack compressed = new ItemStack(Material.IRON_BLOCK);
		ItemMeta compressedMeta = compressed.getItemMeta();
		compressedMeta.setDisplayName(ChatColor.WHITE + "§lCompressed iron");
		compressedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		compressedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		compressed.setItemMeta(compressedMeta);
		return compressed;
	}
	
	public static ItemStack compressedGold() {
		ItemStack compressed = new ItemStack(Material.GOLD_BLOCK);
		ItemMeta compressedMeta = compressed.getItemMeta();
		compressedMeta.setDisplayName(ChatColor.GOLD + "§lCompressed gold");
		compressedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		compressedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		compressed.setItemMeta(compressedMeta);
		return compressed;
	}

	public static ItemStack compressedDiamond() {
		ItemStack compressed = new ItemStack(Material.DIAMOND_BLOCK);
		ItemMeta compressedMeta = compressed.getItemMeta();
		compressedMeta.setDisplayName(ChatColor.AQUA + "§lCompressed diamond");
		compressedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		compressedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		compressed.setItemMeta(compressedMeta);
		return compressed;
	}
	
	public static ItemStack compressedEmerald() {
		ItemStack compressed = new ItemStack(Material.EMERALD_BLOCK);
		ItemMeta compressedMeta = compressed.getItemMeta();
		compressedMeta.setDisplayName(ChatColor.GREEN + "§lCompressed emerald");
		compressedMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		compressedMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		compressed.setItemMeta(compressedMeta);
		compressed.setItemMeta(compressedMeta);
		return compressed;
	}
	
}
