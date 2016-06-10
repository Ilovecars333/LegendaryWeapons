package me.Ilovecars333.LegendaryWeapons;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MasamuneListener implements Listener
{
	MineZWeapons plugin;
	public static ArrayList <Player> masamuneCooldown = new ArrayList <Player>();
	public MasamuneListener(MineZWeapons plugin)
	{
		this.plugin = plugin;
	}
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			final Player hitter = event.getPlayer();
			if( hitter.getItemInHand().getType().equals(Material.IRON_SWORD) )
			{
				if( hitter.getItemInHand().getItemMeta().hasDisplayName() )
				{
					if( hitter.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Masamune") )
					{
						if(!(masamuneCooldown.contains(hitter)))
						{
							Random rand = new Random();
							int n = rand.nextInt(2) + 1;
							if(n == 1)
							{
								hitter.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40, 2));
								hitter.sendMessage(ChatColor.YELLOW + "You cannot do this for 1 minute now.");
								masamuneCooldown.add(hitter);
								hitter.getItemInHand().setDurability((short) (hitter.getItemInHand().getDurability() + (short)10));
								Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
								{
									public void run()
									{
										masamuneCooldown.remove(hitter);
										hitter.sendMessage(ChatColor.GREEN + "You can now use the Masamune");
									}
								}, 1200);
							}
							else
								if(n == 2)
								{
									hitter.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40, 2));
									hitter.sendMessage(ChatColor.YELLOW + "You cannot do this for 1 minute now.");
									masamuneCooldown.add(hitter);
									hitter.getItemInHand().setDurability((short) (hitter.getItemInHand().getDurability() + (short)10));;
									Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
									{
										public void run()
										{
											masamuneCooldown.remove(hitter);
											hitter.sendMessage(ChatColor.GREEN + "You can now use the Masamune");
										}
									}, 1200);
								}
						}
						else
							if(masamuneCooldown.contains(hitter))
							{
								hitter.sendMessage(ChatColor.RED + "You cannot use this yet! You will be notified when you can");
							}
					}
				}
			}
		}
	}
}
