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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightsShadowListener implements Listener
{
	MineZWeapons plugin;
	public NightsShadowListener(MineZWeapons plugin)
	{
		this.plugin = plugin;
	}
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
					if( hitter.getItemInHand().getType().equals(Material.IRON_SWORD) ){
						if( hitter.getItemInHand().getItemMeta().hasDisplayName() ){
							if( hitter.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Night's Shadow") )
							{
								long time = hitter.getWorld().getTime();
								if(time >= 13500 && time <= 22500)
								{
									Random rand = new Random();
									int n = rand.nextInt(20) + 1;
									if(n==1)
									{
										hurted.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 160, 4));
									}
									else
										if(n==2)
										{
											hurted.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 160, 4));
										}
										else
											if(n==3)
											{
												hurted.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 160, 4));
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
