package me.Ilovecars333.LegendaryWeapons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class CorsairsEdgeListener implements Listener
{
	MineZWeapons plugin;
	public CorsairsEdgeListener(MineZWeapons plugin)
	{
		this.plugin = plugin;
	}
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
	    
		Entity entity = event.getEntity();
		//Check if the entity getting hit is a player
		if (entity instanceof Player){
			
			//Create the variable for the player (getting hit)
			Player hurted = (Player)entity;
			//Check if the event is a Entity damage event (basically)
			if (event instanceof EntityDamageByEntityEvent){
				
				//Get a variable for the cause of the damage
				EntityDamageByEntityEvent damageCause = (EntityDamageByEntityEvent)event;
				//Check if the damager is a player
				if (damageCause.getDamager() instanceof Player){
					
					//Get the variable for the player who punched someone
					Player hitter = (Player)damageCause.getDamager();
					
					//Check if the hitter is holding a Kikuichimonji and it is a wood sword.
					if( hitter.getItemInHand().getType().equals(Material.IRON_SWORD) ){
						if( hitter.getItemInHand().getItemMeta().hasDisplayName() ){
							if( hitter.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Corsair's Edge") )
							{
								if(hurted.getItemInHand().equals(new ItemStack(Material.DIAMOND_SWORD)))
								{
									event.setDamage(10.0);
								}
								else
									if(!(hurted.getItemInHand().equals(new ItemStack(Material.DIAMOND_SWORD))))
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
