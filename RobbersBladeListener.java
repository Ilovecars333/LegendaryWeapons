package me.Ilovecars333.LegendaryWeapons;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class RobbersBladeListener implements Listener{
	
	MineZWeapons plugin;
	
	public RobbersBladeListener(MineZWeapons plugin){
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
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
					
					//Check if the hitter is holding a Robber's Blade and it is a wood sword.
					if( hitter.getItemInHand().getType().equals(Material.WOOD_SWORD) ){
						if( hitter.getItemInHand().getItemMeta().hasDisplayName() ){
							if( hitter.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Robber's Blade") ){
								
								//Do stuff.
								Inventory hurtInventory = hurted.getInventory();
								ItemStack blade = hitter.getItemInHand();
								ItemStack stolenItem = null;
								int n = 0;
								int i = 0;
								
								//Iterate through random inventory slots until we find one that is filled.
								while(stolenItem==null){
									i++;
									Random rand = new Random();
									n = rand.nextInt(hurtInventory.getSize());
									ItemStack value = hurtInventory.getItem(n);
										
									if( value!=null ){ //If value is an Item.
										stolenItem = value;
									}else if(i>hurtInventory.getSize()){
										hitter.sendMessage(ChatColor.RED + hurted.getDisplayName() + ChatColor.RESET + ChatColor.RED + "\'s inventory is empty.");
										break;
									}
								}
								if(stolenItem != null){
									//Remove from hurted's inventory.
									hurtInventory.setItem(n, null);
									
									//Add to hitter's inventory.
									hitter.getInventory().addItem(stolenItem);
									
									//Break Robber's Blade.
									hitter.getInventory().setItemInHand(null);
									
									//Update players' inventories.
									hitter.updateInventory();
									hurted.updateInventory();
								}else{
									//Make sure Robber's Blade doesn't break.
									blade.setDurability((short) 0);
								}
								
							}
						}
					}
					
				}
				
			}
			
		}
		
		
	}

}
