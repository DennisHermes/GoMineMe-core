package me.goodgamer123.GoMineMe;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class AutoPickup implements Listener {

	@EventHandler
	public void MineBlockEvent(BlockBreakEvent e) {
		Player p = (Player) e.getPlayer();
		
		if (e.getBlock().getType().equals(Material.STONE) || e.getBlock().getType().equals(Material.COBBLESTONE)) {
			
			e.setDropItems(false);
			
			if (e.getBlock().getDrops(p.getEquipment().getItemInMainHand()).isEmpty()) return;
			
			if (p.getEquipment().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS)) {
				
				ItemStack stone = new ItemStack(Material.STONE);
				
				if (p.getEquipment().getItemInMainHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 1) {
					Random rand = new Random();
					int n = rand.nextInt(2);
					if (n == 0) stone.setAmount(2);
				} else if (p.getEquipment().getItemInMainHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 2) {
					Random rand = new Random();
					int n = rand.nextInt(4);
					if (n == 0) stone.setAmount(2);
					else if (n == 1) stone.setAmount(3);
				} else if (p.getEquipment().getItemInMainHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 3) {
					Random rand = new Random();
					int n = rand.nextInt(5);
					if (n == 0) stone.setAmount(2);
					else if (n == 1) stone.setAmount(3);
					else if (n == 2) stone.setAmount(4);
				}
				p.getInventory().addItem(stone);
			} else {
				p.getInventory().addItem(new ItemStack(Material.STONE));
			}
			
		} else if (e.getBlock().getType().equals(Material.COAL_BLOCK) || e.getBlock().getType().equals(Material.IRON_BLOCK) || e.getBlock().getType().equals(Material.GOLD_BLOCK) || e.getBlock().getType().equals(Material.DIAMOND_BLOCK) || e.getBlock().getType().equals(Material.EMERALD_BLOCK)) {
			
			e.setDropItems(false);
			
			if (e.getBlock().getDrops(p.getEquipment().getItemInMainHand()).isEmpty()) {
				if (p.getEquipment().getItemInMainHand().getType().equals(Material.GOLDEN_PICKAXE)) {
					Material type = Material.DIAMOND_BLOCK;
					if (e.getBlock().getType().equals(Material.EMERALD_BLOCK)) type = Material.EMERALD_BLOCK;
					
					if (p.getEquipment().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS)) {
						
						ItemStack drop = new ItemStack(type);
						
						if (p.getEquipment().getItemInMainHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 1) {
							Random rand = new Random();
							int n = rand.nextInt(2);
							if (n == 0) drop.setAmount(2);
						} else if (p.getEquipment().getItemInMainHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 2) {
							Random rand = new Random();
							int n = rand.nextInt(4);
							if (n == 0) drop.setAmount(2);
							else if (n == 1) drop.setAmount(3);
						} else if (p.getEquipment().getItemInMainHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 3) {
							Random rand = new Random();
							int n = rand.nextInt(5);
							if (n == 0) drop.setAmount(2);
							else if (n == 1) drop.setAmount(3);
							else if (n == 2) drop.setAmount(4);
						}
						p.getInventory().addItem(drop);
					} else {
						p.getInventory().addItem(new ItemStack(type));
					}
				}
			} else {
				if (e.getBlock().getDrops(p.getEquipment().getItemInMainHand()).isEmpty()) return;
				
				if (p.getEquipment().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS)) {
					
					ItemStack drop = new ItemStack(e.getBlock().getType());
					
					if (p.getEquipment().getItemInMainHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 1) {
						Random rand = new Random();
						int n = rand.nextInt(2);
						if (n == 0) drop.setAmount(2);
					} else if (p.getEquipment().getItemInMainHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 2) {
						Random rand = new Random();
						int n = rand.nextInt(4);
						if (n == 0) drop.setAmount(2);
						else if (n == 1) drop.setAmount(3);
					} else if (p.getEquipment().getItemInMainHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 3) {
						Random rand = new Random();
						int n = rand.nextInt(5);
						if (n == 0) drop.setAmount(2);
						else if (n == 1) drop.setAmount(3);
						else if (n == 2) drop.setAmount(4);
					}
					p.getInventory().addItem(drop);
				} else {
					p.getInventory().addItem(new ItemStack(e.getBlock().getType()));
				}
			}
			
		} else if (e.getBlock().getType().equals(Material.IRON_ORE) || e.getBlock().getType().equals(Material.GOLD_ORE)) {
			e.setDropItems(false);
			
			if (e.getBlock().getDrops(p.getEquipment().getItemInMainHand()).isEmpty()) return;
			
			Material type = Material.IRON_INGOT;
			if (e.getBlock().getType().equals(Material.GOLD_ORE)) type = Material.GOLD_INGOT;
			
			if (p.getEquipment().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS)) {
				
				ItemStack drop = new ItemStack(type);
				
				if (p.getEquipment().getItemInMainHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 1) {
					Random rand = new Random();
					int n = rand.nextInt(2);
					if (n == 0) drop.setAmount(2);
				} else if (p.getEquipment().getItemInMainHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 2) {
					Random rand = new Random();
					int n = rand.nextInt(4);
					if (n == 0) drop.setAmount(2);
					else if (n == 1) drop.setAmount(3);
				} else if (p.getEquipment().getItemInMainHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 3) {
					Random rand = new Random();
					int n = rand.nextInt(5);
					if (n == 0) drop.setAmount(2);
					else if (n == 1) drop.setAmount(3);
					else if (n == 2) drop.setAmount(4);
				}
				p.getInventory().addItem(drop);
			} else {
				p.getInventory().addItem(new ItemStack(type));
			}
			
			if (p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 9)) {
				for (int i = 0; i < p.getInventory().getSize(); i++) {
					if (p.getInventory().getItem(i) != null) {
						if (p.getInventory().getItem(i).getType() == Material.IRON_INGOT) {
							ItemStack item = p.getInventory().getItem(i);
							
							ItemStack coalBlocks = new ItemStack(Material.IRON_BLOCK);
							ItemStack coal = new ItemStack(Material.IRON_INGOT);
							
							int blocks = (int) Math.floor(item.getAmount() / 9);
							int backAmount = ((item.getAmount() / 9) - blocks) * 9;
							
							coalBlocks.setAmount(blocks);
							coal.setAmount(backAmount);
							
							p.getInventory().addItem(coalBlocks);
							p.getInventory().setItem(i, coal);
							break;
						}
					}
				}
			}
			
			if (p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 9)) {
				for (int i = 0; i < p.getInventory().getSize(); i++) {
					if (p.getInventory().getItem(i) != null) {
						if (p.getInventory().getItem(i).getType() == Material.GOLD_INGOT) {
							ItemStack item = p.getInventory().getItem(i);
							
							ItemStack coalBlocks = new ItemStack(Material.GOLD_BLOCK);
							ItemStack coal = new ItemStack(Material.GOLD_INGOT);
							
							int blocks = (int) Math.floor(item.getAmount() / 9);
							int backAmount = ((item.getAmount() / 9) - blocks) * 9;
							
							coalBlocks.setAmount(blocks);
							coal.setAmount(backAmount);
							
							p.getInventory().addItem(coalBlocks);
							p.getInventory().setItem(i, coal);
							break;
						}
					}
				}
			}
			
		} else if (e.getBlock().getType().equals(Material.DIAMOND_ORE) || e.getBlock().getType().equals(Material.EMERALD_ORE) || e.getBlock().getType().equals(Material.COAL_ORE)) {
			
			e.setDropItems(false);
			
			if (e.getBlock().getDrops(p.getEquipment().getItemInMainHand()).isEmpty()) {
				if (p.getEquipment().getItemInMainHand().getType().equals(Material.GOLDEN_PICKAXE)) {
					Material type = Material.DIAMOND;
					if (e.getBlock().getType().equals(Material.EMERALD_ORE)) type = Material.EMERALD;
					
					if (p.getEquipment().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS)) {
						
						ItemStack drop = new ItemStack(type);
						
						if (p.getEquipment().getItemInMainHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 1) {
							Random rand = new Random();
							int n = rand.nextInt(2);
							if (n == 0) drop.setAmount(2);
						} else if (p.getEquipment().getItemInMainHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 2) {
							Random rand = new Random();
							int n = rand.nextInt(4);
							if (n == 0) drop.setAmount(2);
							else if (n == 1) drop.setAmount(3);
						} else if (p.getEquipment().getItemInMainHand().getEnchantments().get(Enchantment.LOOT_BONUS_BLOCKS) == 3) {
							Random rand = new Random();
							int n = rand.nextInt(5);
							if (n == 0) drop.setAmount(2);
							else if (n == 1) drop.setAmount(3);
							else if (n == 2) drop.setAmount(4);
						}
						p.getInventory().addItem(drop);
					} else {
						p.getInventory().addItem(new ItemStack(type));
					}
				}
			} else {
				for (ItemStack stack : e.getBlock().getDrops(p.getEquipment().getItemInMainHand())) {
				      p.getInventory().addItem(stack);
				}
			
				if (p.getInventory().containsAtLeast(new ItemStack(Material.COAL), 9)) {
					for (int i = 0; i < p.getInventory().getSize(); i++) {
						if (p.getInventory().getItem(i) != null) {
							if (p.getInventory().getItem(i).getType() == Material.COAL) {
								ItemStack item = p.getInventory().getItem(i);
								
								ItemStack coalBlocks = new ItemStack(Material.COAL_BLOCK);
								ItemStack coal = new ItemStack(Material.COAL);
								
								int blocks = (int) Math.floor(item.getAmount() / 9);
								int backAmount = ((item.getAmount() / 9) - blocks) * 9;
								
								coalBlocks.setAmount(blocks);
								coal.setAmount(backAmount);
								
								p.getInventory().addItem(coalBlocks);
								p.getInventory().setItem(i, coal);
								break;
							}
						}
					}
				}
			}
			

			
			if (p.getInventory().containsAtLeast(new ItemStack(Material.DIAMOND), 9)) {
				for (int i = 0; i < p.getInventory().getSize(); i++) {
					if (p.getInventory().getItem(i) != null) {
						if (p.getInventory().getItem(i).getType() == Material.DIAMOND) {
							ItemStack item = p.getInventory().getItem(i);
							
							ItemStack coalBlocks = new ItemStack(Material.DIAMOND_BLOCK);
							ItemStack coal = new ItemStack(Material.DIAMOND);
							
							int blocks = (int) Math.floor(item.getAmount() / 9);
							int backAmount = ((item.getAmount() / 9) - blocks) * 9;
							
							coalBlocks.setAmount(blocks);
							coal.setAmount(backAmount);
							
							p.getInventory().addItem(coalBlocks);
							p.getInventory().setItem(i, coal);
							break;
						}
					}
				}
			}
			
			if (p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 9)) {
				for (int i = 0; i < p.getInventory().getSize(); i++) {
					if (p.getInventory().getItem(i) != null) {
						if (p.getInventory().getItem(i).getType() == Material.EMERALD) {
							ItemStack item = p.getInventory().getItem(i);
							
							ItemStack coalBlocks = new ItemStack(Material.EMERALD_BLOCK);
							ItemStack coal = new ItemStack(Material.EMERALD);
							
							int blocks = (int) Math.floor(item.getAmount() / 9);
							int backAmount = ((item.getAmount() / 9) - blocks) * 9;
							
							coalBlocks.setAmount(blocks);
							coal.setAmount(backAmount);
							
							p.getInventory().addItem(coalBlocks);
							p.getInventory().setItem(i, coal);
							break;
						}
					}
				}
			}
			
		}
	}
	
}
