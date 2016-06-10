package me.Ilovecars333.LegendaryWeapons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class OniMaskListener implements Listener
{
	MineZWeapons plugin;
	public OniMaskListener(MineZWeapons plugin)
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
					if( hitter.getItemInHand().getType().equals(Material.DIAMOND_SWORD) )
					{
						if(hurted.getInventory().getHelmet() != null)
						{
							if(hurted.getInventory().getHelmet().getType().equals(Material.CHAINMAIL_HELMET))
							{
								if(hurted.getInventory().getHelmet().getItemMeta().hasDisplayName())
								{
									if(hurted.getInventory().getHelmet().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Oni Mask"))
									{
										event.setDamage(7.0);
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
