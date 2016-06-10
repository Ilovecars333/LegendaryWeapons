package me.Ilovecars333.LegendaryWeapons;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

public class ShotBowListener implements Listener
{
	MineZWeapons plugin;
	public ShotBowListener(MineZWeapons plugin)
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
					if( hitter.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Shot Bow") )
					{
						if (event.getForce() == 1.0)
			            {
							Entity arrow = event.getProjectile();
						             
					                for (int i = 1; i < 8; i++)
					                {
					                    arrow.getWorld().spawnArrow(arrow.getLocation(), arrow.getVelocity(), 3, 3).setShooter(event.getEntity());
					                }
			            }
					}
				}
			}
        }
    }
}
