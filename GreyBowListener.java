package me.Ilovecars333.LegendaryWeapons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.potion.PotionEffect;

public class GreyBowListener implements Listener
{
	MineZWeapons plugin;
	public GreyBowListener(MineZWeapons plugin)
	{
		this.plugin = plugin;
	}
	@EventHandler
	public void onEntityDamangeByEntity(EntityDamageByEntityEvent event){
		
		Entity entity = event.getEntity();
		//Check if the entity getting hit is a player
		if (event.getCause() == DamageCause.PROJECTILE)
		{
			Player hurted = (Player)entity;
			//Check if the event is a Entity damage event (basically)
			if (entity instanceof Player && event.getDamager() instanceof Arrow)
			{
				Arrow arrow = (Arrow) event.getDamager();
				if(arrow.getShooter() instanceof Player)
				{
						Player hitter = (Player)arrow.getShooter();
							if( hitter.getItemInHand().getType().equals(Material.BOW) )
							{
							if( hitter.getItemInHand().getItemMeta().hasDisplayName() )
							{
							if( hitter.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Grey Bow") )
							{
								
								//Do stuff.
								event.setCancelled(true);
								for (PotionEffect effect : hurted.getActivePotionEffects())
							        hurted.removePotionEffect(effect.getType());
								hurted.damage(1.0);
							}
						}
					}
					
				}
			}
			
			
		}
		
	}
}
