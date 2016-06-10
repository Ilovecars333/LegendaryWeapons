package me.Ilovecars333.LegendaryWeapons;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SimoonsSongListener implements Listener
{
MineZWeapons plugin;

	public SimoonsSongListener(MineZWeapons plugin)
	{
		this.plugin = plugin;
	}
	@SuppressWarnings("deprecation")
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
				Player damager = (Player)event.getDamager();
				if (damager.getItemInHand().getType().equals(Material.IRON_SWORD))
				{
					
						if( damager.getItemInHand().getItemMeta().hasDisplayName() )
						{
							ItemStack ssword = (new ItemStack(Material.IRON_SWORD));
							ItemMeta sswordm = ssword.getItemMeta();
							sswordm.setDisplayName("Simoon's Song");
							ssword.setItemMeta(sswordm);
							if( damager.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Simoon's Song") )
							{
								if(hurted.getInventory().contains(ssword))
								{
									hurted.setVelocity(hurted.getLocation().getDirection().multiply(-15));
									Location loc = hurted.getLocation();
									loc.setY(loc.getY() + 15);
									hurted.teleport(loc);
									event.setDamage(0);
								}
								else
									if(hurted.getLocation().getBlock().equals(Material.AIR));
								{
									hurted.setVelocity(hurted.getLocation().getDirection().multiply(-15));
									Location loc = hurted.getLocation();
									loc.setY(loc.getY() + 15);
									hurted.teleport(loc);
									event.setDamage(0);
								}
							}
						}
					}
					
				}
				
			}
			
		}
		
	}
}
