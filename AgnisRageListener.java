package me.Ilovecars333.LegendaryWeapons;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class AgnisRageListener implements Listener
{
	MineZWeapons plugin;
	public AgnisRageListener(MineZWeapons plugin)
	{
		this.plugin = plugin;
	}
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) 
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
				
				//Get a variable for the cause of the damage
				EntityDamageByEntityEvent damageCause = (EntityDamageByEntityEvent)event;
				//Check if the damager is a player
				if (damageCause.getDamager() instanceof Player)
				{
					
					//Get the variable for the player who punched someone
					Player hitter = (Player)damageCause.getDamager();
					
					//Check if the hitter is holding a Kikuichimonji and it is a wood sword.
					if( hitter.getItemInHand().getType().equals(Material.IRON_SWORD) )
					{
						if( hitter.getItemInHand().getItemMeta().hasDisplayName() )
						{
							if( hitter.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Agni's Rage") )
							{
								Random rand = new Random();
								int n = rand.nextInt(4) + 1;
								Random rand2 = new Random();
								int n2 = rand2.nextInt(20) + 1;
								
								if(n==1)
								{
									//Poison the hurted.
									hurted.playSound(hurted.getLocation(), Sound.FUSE, 2F, 1F);
									hitter.playSound(hitter.getLocation(), Sound.FUSE, 2F, 1F);
									hurted.setFireTicks(80);
								}
								if(n2==1)
								{
									//Poison the hurter.
									hurted.playSound(hurted.getLocation(), Sound.FUSE, 2F, 1F);
									hitter.playSound(hitter.getLocation(), Sound.FUSE, 2F, 1F);
									hitter.setFireTicks(80);;
								}
								else
									if(n2==2)
									{
										//Poison the hurter.
										hurted.playSound(hurted.getLocation(), Sound.FUSE, 2F, 1F);
										hitter.playSound(hitter.getLocation(), Sound.FUSE, 2F, 1F);
										hitter.setFireTicks(80);;
									}
									else
										if(n2==3)
										{
											//Poison the hurter.
											hurted.playSound(hurted.getLocation(), Sound.FUSE, 2F, 1F);
											hitter.playSound(hitter.getLocation(), Sound.FUSE, 2F, 1F);
											hitter.setFireTicks(80);;
										}
									
							
							}
						}
					}
					
				}
				
			}
			
		}
		
		
	}
}
