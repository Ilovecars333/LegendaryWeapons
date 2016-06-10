package me.Ilovecars333.LegendaryWeapons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NinjaSandalsListener implements Listener
{
	MineZWeapons plugin;
	public NinjaSandalsListener(MineZWeapons plugin)
	{
		this.plugin = plugin;
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
					if(hurted.getInventory().getBoots() != null)
					{
						if(hurted.getInventory().getBoots().getType().equals(Material.CHAINMAIL_BOOTS))
						{
							if(hurted.getInventory().getBoots().getItemMeta().hasDisplayName())
							{
								if(hurted.getInventory().getBoots().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Ninja Sandals"))
								{
									hurted.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 2));
								}
							}
						}
					}
					
				}
				
			}
			
		}
		
	}
}
