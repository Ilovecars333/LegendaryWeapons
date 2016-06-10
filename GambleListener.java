package me.Ilovecars333.LegendaryWeapons;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class GambleListener implements Listener
{
	MineZWeapons plugin;
	public GambleListener(MineZWeapons plugin)
	{
		this.plugin = plugin;
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
	    
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
					if( hitter.getItemInHand().getType().equals(Material.STONE_SWORD) ){
						if( hitter.getItemInHand().getItemMeta().hasDisplayName() ){
							if( hitter.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Gamble") )
							{
								Random rand = new Random();
								int n = rand.nextInt(4) + 1;
								int n2 = rand.nextInt(3) +1;
								if(n==1)
								{
									if(n2==1)
									{
										event.setDamage(6.0);
									}
									else
										if(n2==2)
										{
											event.setDamage(8.0);
										}
										else
											if(n2==3)
											{
												event.setDamage(10.0);
											}
								}
								else
									if(n==2)
									{
										hitter.damage(6.0);
										event.setDamage(0);
									}
									else
										if(n==3)
										{
											hitter.damage(8.0);
											event.setDamage(0);
										}
										else
											if(n==4)
											{
												hitter.damage(10.0);
												event.setDamage(0);
											}
							
							}
						}
					}
					
				}
				
			}
			
		}
		else
			if(entity instanceof Monster)
			{
				Monster hurted = (Monster) entity;
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
						if( hitter.getItemInHand().getType().equals(Material.STONE_SWORD) ){
							if( hitter.getItemInHand().getItemMeta().hasDisplayName() ){
								if( hitter.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Gamble") )
								{
									Random rand = new Random();
									int n = rand.nextInt(4) + 1;
									int n2 = rand.nextInt(3) +1;
									if(n==1)
									{
										if(n2==1)
										{
											event.setDamage(6.0);
										}
										else
											if(n2==2)
											{
												event.setDamage(8.0);
											}
											else
												if(n2==3)
												{
													event.setDamage(10.0);
												}
									}
									else
										if(n==2)
										{
											hitter.damage(6.0);
										}
										else
											if(n==3)
											{
												hitter.damage(8.0);

											}
											else
												if(n==4)
												{
													hitter.damage(10.0);
												}
								
								}
							}
						}
						
					}
					
				}
			}
		
		
	}
}
