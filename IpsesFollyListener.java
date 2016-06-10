package me.Ilovecars333.LegendaryWeapons;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class IpsesFollyListener implements Listener
{
	MineZWeapons plugin;
	public IpsesFollyListener(MineZWeapons plugin)
	{
		this.plugin = plugin;
	}
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			Player hitter = event.getPlayer();
			if( hitter.getItemInHand().getType().equals(Material.GOLD_SWORD) )
			{
				if( hitter.getItemInHand().getItemMeta().hasDisplayName() )
				{
					if( hitter.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Ipse's Folly") )
					{
						hitter.damage(10.0);
						double radius = 5D;
						List<Entity> nearbyPlayers = hitter.getLocation().getWorld().getEntities();
						for(Entity entity : nearbyPlayers)
						{
							if(entity.getLocation().distance(hitter.getLocation()) <= radius)
							{
								if(entity instanceof Player)
								{
									Player hurted = (Player) entity;
									hurted.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 300, 2));
								}
							}
						}
						
					}
				}
			}
		}
	}
}
