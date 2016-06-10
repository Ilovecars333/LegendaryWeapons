package me.Ilovecars333.LegendaryWeapons;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SacrificialSwordListener implements Listener
{
	MineZWeapons plugin;
	public List<Player> getPlayersWithin(Player player, int distance) {
		  List<Player> res = new ArrayList<Player>();
		  int d2 = distance * distance;
		  for (Player p : Bukkit.getServer().getOnlinePlayers()) {
		    if (p.getWorld() == player.getWorld() && p.getLocation().distanceSquared(player.getLocation()) <= d2) 
		    {
		    	res.add(p);
		    }
		  }
		  return res;
		}
	public SacrificialSwordListener(MineZWeapons plugin)
	{
		this.plugin = plugin;
	}
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			Player hitter = event.getPlayer();
			if( hitter.getItemInHand().getType().equals(Material.WOOD_SWORD) )
			{
				if( hitter.getItemInHand().getItemMeta().hasDisplayName() )
				{
					if( hitter.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Sacrificial Sword") )
					{
						hitter.setHealth(1.0);
						List<Player> hurted = this.getPlayersWithin(hitter, 5);
						hurted.remove(hitter);
						hitter.getInventory().remove(hitter.getInventory().getItemInHand());
						hitter.getInventory().clear();
						hitter.playSound(hitter.getLocation(), Sound.BLAZE_BREATH, 2F, 1F);
						for(Player hurt : hurted)
						{
							if(hurt instanceof Player)
							{
								Player hurted1 = (Player) hurt;
								hitter.getInventory().remove(hitter.getInventory().getItemInHand());
								hitter.getInventory().clear();
								hitter.playSound(hitter.getLocation(), Sound.BLAZE_BREATH, 2F, 1F);
								hurted1.playSound(hitter.getLocation(), Sound.BLAZE_BREATH, 2F, 1F);
								hurted1.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 300, 1));
							}
						}
					}
				}
			}
		}
	}
}
