package me.Ilovecars333.LegendaryWeapons;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class PluviasRainListener implements Listener
{
	MineZWeapons plugin;
	public PluviasRainListener(MineZWeapons plugin)
	{
		this.plugin = plugin;
	}
	@EventHandler
	public void onEntityDamangeByEntity(EntityDamageByEntityEvent event){
		
		Entity entity = event.getEntity();
		//Check if the entity getting hit is a player
		if (event.getCause() == DamageCause.PROJECTILE)
		{
			
			//Check if the event is a Entity damage event (basically)
			if (entity instanceof Player && event.getDamager() instanceof Arrow)
			{
				Player hurted = (Player)entity;
				Arrow arrow = (Arrow) event.getDamager();
				if(arrow.getShooter() instanceof Player)
				{
						Player hitter = (Player)arrow.getShooter();
							if( hitter.getItemInHand().getType().equals(Material.BOW) )
							{
							if( hitter.getItemInHand().getItemMeta().hasDisplayName() )
							{
							if( hitter.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Pluvia's Rain") )
							{
								Random rand = new Random();
								int n = rand.nextInt(2) + 1;
								if(n==1)
								{
									hitter.sendMessage("works 1");
									hitter.damage(6.0);
									event.setDamage(0.0);
								}
								else
									if(n==2)
									{
										hitter.sendMessage("works 2");
										event.setDamage(0.0);
										hurted.damage(6.0);
									}
							}
						}
					}
					
				}
			}
			
			
		}
		
	}
}
