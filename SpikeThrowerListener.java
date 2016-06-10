package me.Ilovecars333.LegendaryWeapons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class SpikeThrowerListener implements Listener
{
	MineZWeapons plugin;
	public SpikeThrowerListener(MineZWeapons plugin)
	{
		this.plugin = plugin;
	}
	@EventHandler
    public void onEntityShootBow(EntityShootBowEvent event)
    {
        if (event.getEntity() instanceof Player)
        {
        	Player hitter = (Player) event.getEntity();
        	if( hitter.getItemInHand().getType().equals(Material.BOW) )
			{
				if( hitter.getItemInHand().getItemMeta().hasDisplayName() )
				{
					if( hitter.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Spike Thrower") )
					{
						if (event.getForce() == 1.0)
			            {
			                Entity arrow = event.getProjectile();
			                arrow.getWorld().spawnArrow(arrow.getLocation(), arrow.getVelocity(), 3, 3).setShooter(event.getEntity());
			             
			            }
						else
						{
							event.setCancelled(true);
							hitter.getInventory().addItem(new ItemStack(Material.ARROW, 1));
							hitter.sendMessage(ChatColor.YELLOW + "You may only use this when drawn fully.");
						}
					}
				}
			}
        }
    }
	@EventHandler
	public void onEntityDamangeByEntity(EntityDamageByEntityEvent event){
		
		Entity entity = event.getEntity();
		//Check if the entity getting hit is a player
		if (event.getCause() == DamageCause.PROJECTILE)
		{
			if(entity instanceof Player)
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
								if( hitter.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Spike Thrower") )
								{
									if(hitter.getLocation().distance(hurted.getLocation()) > 10)
									{
										//Do stuff.
										event.setCancelled(true);
										final double horizontalInaccuracy = .1;
										Vector vector = arrow.getVelocity();
										Vector perpindicular = vector.clone().setX(-vector.getZ()).setZ(vector.getX()).setY(0).multiply(horizontalInaccuracy);
										Vector left = vector.clone().add(perpindicular);
										Vector center = vector.clone().multiply(1.4);
										Vector right = vector.clone().multiply(1.1).subtract(perpindicular);
										hurted.launchProjectile(Arrow.class);
					                    Arrow arrow1 = hurted.launchProjectile(Arrow.class);
					                    Arrow arrow2 = hurted.launchProjectile(Arrow.class);
					                    Arrow arrow3 = hurted.launchProjectile(Arrow.class);
					                    Arrow arrow4 = hurted.launchProjectile(Arrow.class);
					                    Arrow arrow5 = hurted.launchProjectile(Arrow.class);
					                    Arrow arrow6 = hurted.launchProjectile(Arrow.class);
					                    Arrow arrow7 = hurted.launchProjectile(Arrow.class);
					                    Arrow arrow8 = hurted.launchProjectile(Arrow.class);
					                    arrow1.setVelocity(right);
					                    arrow2.setVelocity(center);
					                    arrow3.setVelocity(left);
					                    arrow4.setVelocity(right);
					                    arrow5.setVelocity(center);
					                    arrow6.setVelocity(left);
					                    arrow7.setVelocity(center);
					                    arrow8.setVelocity(left);
									}
									else
									{
										hitter.sendMessage(ChatColor.RED + "You cannot shoot from this close!");
										event.setCancelled(true);
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
