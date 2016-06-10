package me.Ilovecars333.LegendaryWeapons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class RubberShieldListener implements Listener
{
	MineZWeapons plugin;
	public RubberShieldListener(MineZWeapons plugin)
	{
		this.plugin = plugin;
	}
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event) {
		if ((event.getPlayer() instanceof Player)) {
						Player hurted = (Player)event.getPlayer();
						ItemStack chestPlate = hurted.getInventory().getChestplate();
						if (chestPlate != null) 
						{
						if (chestPlate.hasItemMeta()) 
						{
						if (chestPlate.getItemMeta().hasDisplayName()) 
						{
						if (chestPlate.getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Rubber Shield")) 
						{
						chestPlate.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 3);
						}
					}
				}
			}
		}
	}
	@EventHandler
	public void onPlayerHitOtherPlayer(EntityDamageByEntityEvent event)
	{
		
		Entity entity = event.getEntity();
		//Check if the entity getting hit is a player
		if (entity instanceof Player)
		{
			
			//Create the variable for the player (getting hit)
			Player hurted = (Player)entity;
			//Check if the event is a Entity damage event (basically)
			if (event instanceof EntityDamageByEntityEvent)
			{
				if(event.getDamager() instanceof Player)
				{
					//Get a variable for the cause of the damage
					Player hitter = (Player)event.getDamager();
					if( hitter.getItemInHand().getType().equals(Material.WOOD_SWORD) )
					{
						if(hurted.getInventory().getChestplate() != null)
						{
							if(hurted.getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE))
							{
								if(hurted.getInventory().getChestplate().getItemMeta().hasDisplayName())
								{
									if(hurted.getInventory().getChestplate().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Rubber Shield"))
									{
										if(hurted.getInventory().getChestplate().containsEnchantment(Enchantment.PROTECTION_PROJECTILE))
										{
											event.setDamage(9.0);
										}
									}
								}
							}
						}
					}
					else
						if(hitter.getItemInHand().getType().equals(Material.GOLD_SWORD))
						{
							if(hurted.getInventory().getChestplate() != null)
							{
								if(hurted.getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE))
								{
									if(hurted.getInventory().getChestplate().getItemMeta().hasDisplayName())
									{
										if(hurted.getInventory().getChestplate().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Rubber Shield"))
										{
											if(hurted.getInventory().getChestplate().containsEnchantment(Enchantment.PROTECTION_PROJECTILE))
											{
												event.setDamage(9.0);
											}
										}
									}
								}
							}
						}
						else
							if(hitter.getItemInHand().getType().equals(Material.STONE_SWORD))
							{
								if(hurted.getInventory().getChestplate() != null)
								{
									if(hurted.getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE))
									{
										if(hurted.getInventory().getChestplate().getItemMeta().hasDisplayName())
										{
											if(hurted.getInventory().getChestplate().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Rubber Shield"))
											{
												if(hurted.getInventory().getChestplate().containsEnchantment(Enchantment.PROTECTION_PROJECTILE))
												{
													event.setDamage(9.5);
												}
											}
										}
									}
								}
							}
							else
								if(hitter.getItemInHand().getType().equals(Material.IRON_SWORD))
								{
									if(hurted.getInventory().getChestplate() != null)
									{
										if(hurted.getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE))
										{
											if(hurted.getInventory().getChestplate().getItemMeta().hasDisplayName())
											{
												if(hurted.getInventory().getChestplate().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Rubber Shield"))
												{
													if(hurted.getInventory().getChestplate().containsEnchantment(Enchantment.PROTECTION_PROJECTILE))
													{
														event.setDamage(10.5);
													}
												}
											}
										}
									}
								}
								else
									if(hitter.getItemInHand().getType().equals(Material.DIAMOND_SWORD))
									{
										if(hurted.getInventory().getChestplate() != null)
										{
											if(hurted.getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE))
											{
												if(hurted.getInventory().getChestplate().getItemMeta().hasDisplayName())
												{
													if(hurted.getInventory().getChestplate().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Rubber Shield"))
													{
														if(hurted.getInventory().getChestplate().containsEnchantment(Enchantment.PROTECTION_PROJECTILE))
														{
															event.setDamage(12.5);
														}
													}
												}
											}
										}
									}
					
				}
				
			}
			
		}
		
	}
}
