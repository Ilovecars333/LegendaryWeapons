package me.Ilovecars333.LegendaryWeapons;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RabbitFeetListener implements Listener
{
	MineZWeapons plugin;
	private void StopTimer() 
	{
		  Bukkit.getServer().getScheduler().cancelTask(stop);
	}
	int stop;
	public RabbitFeetListener(MineZWeapons plugin)
	{
		this.plugin = plugin;
	}
	@EventHandler
	public void onClick(InventoryClickEvent event)
	{
		if(event.getSlotType() == InventoryType.SlotType.ARMOR)
		{
			
				final Player player = (Player) event.getWhoClicked();
				final ItemStack rabbit = new ItemStack(Material.IRON_BOOTS);
				ItemMeta im = rabbit.getItemMeta();
				im.setDisplayName(ChatColor.ITALIC + "Rabbit Feet");
				rabbit.setItemMeta(im);
						if(event.getCursor().equals(rabbit))
						{
										player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 160, 4));
										player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 160, 10));
										stop = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable()
										{
											public void run()
											{
												if(player.getInventory().getBoots() != null)
												{
													if(player.getInventory().getBoots().equals(rabbit))
													{
														player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 160, 4));
														player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 160, 10));
													}
													else
													{
														StopTimer();
													}
												}
												else
												{
													StopTimer();
												}
												
											}
										}, 160L, 160L);
						}
						
							
								
						
						
					
				
			
		}
	}
}