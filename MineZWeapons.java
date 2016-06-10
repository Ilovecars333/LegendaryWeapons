package me.Ilovecars333.LegendaryWeapons;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MineZWeapons extends JavaPlugin{
	
	public static MineZWeapons plugin;
	public Logger log;
	PluginDescriptionFile pdfFile;
	PluginManager pluginManager;
	public String[] helpText;
	public String[] weapons;
	
	public void onEnable(){
		log = Logger.getLogger("Minecraft");
		pdfFile = this.getDescription();
		pluginManager = this.getServer().getPluginManager();
		helpText = new String[]{
			ChatColor.YELLOW + pdfFile.getName() + " version " + pdfFile.getVersion(),
			ChatColor.YELLOW + pdfFile.getDescription()
		};
		weapons = new String[]{
				ChatColor.YELLOW + "" + "Weapons available:",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Kikuichimonji",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Robber's_Blade",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Simoon's_Deal",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Heal_Bow",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Grass_Blade",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Mjolnir",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Simoon's_Song",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Rocksteady",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Agni's_Rage",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Corsair's_Edge",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Gamble",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Ipse's_Folly",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Masamune",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Muramasa",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Night's_Shadow",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Overkill",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Sacrificial_Sword",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Therum's_Strength",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Vampyr",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Grey_Bow",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Pluvia's_Rain",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Shot_Bow",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Slow_Bow",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Spike_Thrower",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Ninja_Sandals",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Oni_Mask",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Rabbit_Feet",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Rubber_Shield",
				ChatColor.YELLOW + "" + ChatColor.BOLD + "Thorned_Crown"
		};
		
		log.info(pdfFile.getName() + " " + pdfFile.getVersion() + " has been enabled.");
		
		pluginManager.registerEvents( new KikuichimonjiListener(this), this );
		pluginManager.registerEvents( new RobbersBladeListener(this), this );
		pluginManager.registerEvents( new SimoonsDealListener(this), this);
		pluginManager.registerEvents( new GrassBladeListener(this), this);
		pluginManager.registerEvents( new GrassBladeListener(this), this);
		pluginManager.registerEvents( new MjolnirListener(this), this );
		pluginManager.registerEvents( new HealBowListener(this), this);
		pluginManager.registerEvents( new SimoonsSongListener(this), this );
		pluginManager.registerEvents( new RocksteadyListener(this), this);
		pluginManager.registerEvents( new AgnisRageListener(this), this);
		pluginManager.registerEvents( new CorsairsEdgeListener(this), this);
		pluginManager.registerEvents( new GambleListener(this), this);
		pluginManager.registerEvents( new IpsesFollyListener(this), this);
		pluginManager.registerEvents( new MasamuneListener(this), this);
		pluginManager.registerEvents( new MuramasaListener(this), this);
		pluginManager.registerEvents( new NightsShadowListener(this), this);
		pluginManager.registerEvents( new OverkillListener(this), this);
		pluginManager.registerEvents( new SacrificialSwordListener(this), this);
		pluginManager.registerEvents( new TherumsStrengthListener(this), this);
		pluginManager.registerEvents( new VampyrListener(this), this);
		pluginManager.registerEvents( new GreyBowListener(this), this);
		pluginManager.registerEvents( new PluviasRainListener(this), this);
		pluginManager.registerEvents( new ShotBowListener(this), this);
		pluginManager.registerEvents( new SlowBowListener(this), this);
		pluginManager.registerEvents( new SpikeThrowerListener(this), this);
		pluginManager.registerEvents( new NinjaSandalsListener(this), this);
		pluginManager.registerEvents( new OniMaskListener(this), this);
		pluginManager.registerEvents( new RabbitFeetListener(this), this);
		pluginManager.registerEvents( new RubberShieldListener(this), this);
	}
	
	public void onDisable(){
		log.info(pdfFile.getName() + " " + " has been disabled.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if( commandLabel.equalsIgnoreCase("legendary") )
		{
			Player player = (Player) sender;
			if(player.hasPermission("minezweapons.use"))
			{
				if(args.length > 0)
				{
				 if( args[0].equalsIgnoreCase("give") )
				{
					 if(args.length > 1)
					 {
						
							if( args[1].equalsIgnoreCase("kikuichimonji") ){
								
								ItemStack is = new ItemStack(Material.WOOD_SWORD, 1); //Make a stack of 1 Wood Sword
								ItemMeta im = is.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Kikuichimonji"); //Set its name to Kikuichimonji.
								is.setItemMeta(im);
								player.getInventory().addItem(is);
								
							}else if( args[1].equalsIgnoreCase("robber's_blade") ){
								
								ItemStack is = new ItemStack(Material.WOOD_SWORD, 1); //Make a stack of 1 Wood Sword
								ItemMeta im = is.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Robber's Blade"); //Set its name to Robber's Blade.
								is.setItemMeta(im);
								player.getInventory().addItem(is);
								
							}else if( args[1].equalsIgnoreCase("simoon's_deal") ){
								
								ItemStack is = new ItemStack(Material.WOOD_SWORD, 1); //Make a stack of 1 Wood Sword
								ItemMeta im = is.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Simoon's Deal"); //Set its name to Robber's Blade.
								is.setItemMeta(im);
								player.getInventory().addItem(is);
								
							}else if( args[1].equalsIgnoreCase("grass_blade") ){
								
								ItemStack is = new ItemStack(Material.WOOD_SWORD, 1); //Make a stack of 1 Wood Sword
								ItemMeta im = is.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Grass Blade"); //Set its name to Grass Blade.
								is.setItemMeta(im);
								player.getInventory().addItem(is);
								
							}else if( args[1].equalsIgnoreCase("mjolnir") ){
								
								ItemStack is = new ItemStack(Material.IRON_AXE, 1); //Make a stack of 1 Iron Axe
								ItemMeta im = is.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Mjolnir"); //Set its name to Heal Bow.
								is.setItemMeta(im);
								player.getInventory().addItem(is);
								
							}else if( args[1].equalsIgnoreCase("simoon's_song") )
							{
								ItemStack ss = new ItemStack(Material.IRON_SWORD, 1);
								ItemMeta im = ss.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Simoon's Song");
								ss.setItemMeta(im);
								player.getInventory().addItem(ss);
							}
							else if( args[1].equalsIgnoreCase("rocksteady"))
							{
								ItemStack rs = new ItemStack(Material.BOW, 1);
								ItemMeta im = rs.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Rocksteady");
								rs.setItemMeta(im);
								player.getInventory().addItem(rs);
							}
							else if( args[1].equalsIgnoreCase("heal_bow"))
							{
								ItemStack hb = new ItemStack(Material.BOW, 1);
								ItemMeta im = hb.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Heal Bow");
								hb.setItemMeta(im);
								player.getInventory().addItem(hb);
							}
							else if( args[1].equalsIgnoreCase("agni's_rage"))
							{
								ItemStack ar = new ItemStack(Material.IRON_SWORD);
								ItemMeta im = ar.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Agni's Rage");
								ar.setItemMeta(im);
								player.getInventory().addItem(ar);
							}
							else if( args[1].equalsIgnoreCase("corsair's_edge"))
							{
								ItemStack ce = new ItemStack(Material.IRON_SWORD);
								ItemMeta im = ce.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Corsair's Edge");
								ce.setItemMeta(im);
								player.getInventory().addItem(ce);
							}
							else if( args[1].equalsIgnoreCase("gamble"))
							{
								ItemStack ga = new ItemStack(Material.STONE_SWORD);
								ItemMeta im = ga.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Gamble");
								ga.setItemMeta(im);
								player.getInventory().addItem(ga);
							}
							else if( args[1].equalsIgnoreCase("ipse's_folly"))
							{
								ItemStack il = new ItemStack(Material.GOLD_SWORD);
								ItemMeta im = il.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Ipse's Folly");
								il.setItemMeta(im);
								player.getInventory().addItem(il);
							}
							else if( args[1].equalsIgnoreCase("masamune"))
							{
								ItemStack mm = new ItemStack(Material.IRON_SWORD);
								ItemMeta im = mm.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Masamune");
								mm.setItemMeta(im);
								player.getInventory().addItem(mm);
							}
							else if( args[1].equalsIgnoreCase("muramasa"))
							{
								ItemStack mm = new ItemStack(Material.IRON_SWORD);
								ItemMeta im = mm.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Muramasa");
								mm.setItemMeta(im);
								player.getInventory().addItem(mm);
							}
							else if( args[1].equalsIgnoreCase("night's_shadow"))
							{
								ItemStack ns = new ItemStack(Material.IRON_SWORD);
								ItemMeta im = ns.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Night's Shadow");
								ns.setItemMeta(im);
								player.getInventory().addItem(ns);
							}
							else if( args[1].equalsIgnoreCase("overkill"))
							{
								ItemStack mm = new ItemStack(Material.DIAMOND_SWORD);
								ItemMeta im = mm.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Overkill");
								mm.setItemMeta(im);
								player.getInventory().addItem(mm);
							}
							else if( args[1].equalsIgnoreCase("sacrificial_sword"))
							{
								ItemStack ss = new ItemStack(Material.WOOD_SWORD);
								ItemMeta im = ss.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Sacrificial Sword");
								ss.setItemMeta(im);
								player.getInventory().addItem(ss);
							}
							else if( args[1].equalsIgnoreCase("therum's_strength"))
							{
								ItemStack ts = new ItemStack(Material.IRON_SWORD);
								ItemMeta im = ts.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Therum's Strength");
								ts.setItemMeta(im);
								player.getInventory().addItem(ts);
							}
							else if( args[1].equalsIgnoreCase("vampyr"))
							{
								ItemStack vr = new ItemStack(Material.IRON_SWORD);
								ItemMeta im = vr.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Vampyr");
								vr.setItemMeta(im);
								player.getInventory().addItem(vr);
							}
							else if( args[1].equalsIgnoreCase("grey_bow"))
							{
								ItemStack gb = new ItemStack(Material.BOW);
								ItemMeta im = gb.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Grey Bow");
								gb.setItemMeta(im);
								player.getInventory().addItem(gb);
							}
							else if( args[1].equalsIgnoreCase("pluvia's_rain"))
							{
								ItemStack pr = new ItemStack(Material.BOW);
								ItemMeta im = pr.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Pluvia's Rain");
								pr.setItemMeta(im);
								player.getInventory().addItem(pr);
							}
							else if( args[1].equalsIgnoreCase("shot_bow"))
							{
								ItemStack sb = new ItemStack(Material.BOW);
								ItemMeta im = sb.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Shot Bow");
								sb.setItemMeta(im);
								player.getInventory().addItem(sb);
							}
							else if( args[1].equalsIgnoreCase("slow_bow"))
							{
								ItemStack sb = new ItemStack(Material.BOW);
								ItemMeta im = sb.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Slow Bow");
								sb.setItemMeta(im);
								player.getInventory().addItem(sb);
							}
							else if( args[1].equalsIgnoreCase("spike_thrower"))
							{
								ItemStack st = new ItemStack(Material.BOW);
								ItemMeta im = st.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Spike Thrower");
								st.setItemMeta(im);
								player.getInventory().addItem(st);
							}
							else if( args[1].equalsIgnoreCase("ninja_sandals"))
							{
								ItemStack ns = new ItemStack(Material.CHAINMAIL_BOOTS);
								ItemMeta im = ns.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Ninja Sandals");
								ns.setItemMeta(im);
								player.getInventory().addItem(ns);
							}
							else if( args[1].equalsIgnoreCase("oni_mask"))
							{
								ItemStack om = new ItemStack(Material.CHAINMAIL_HELMET);
								ItemMeta im = om.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Oni Mask");
								om.setItemMeta(im);
								player.getInventory().addItem(om);
							}
							else if( args[1].equalsIgnoreCase("rabbit_feet"))
							{
								ItemStack rf = new ItemStack(Material.IRON_BOOTS);
								ItemMeta im = rf.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Rabbit Feet");
								rf.setItemMeta(im);
								player.getInventory().addItem(rf);
							}
							else if( args[1].equalsIgnoreCase("rubber_shield"))
							{
								ItemStack rs = new ItemStack(Material.IRON_CHESTPLATE);
								ItemMeta im = rs.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Rubber Shield");
								rs.setItemMeta(im);
								player.getInventory().addItem(rs);
							}
							else if( args[1].equalsIgnoreCase("thorned_crown"))
							{
								ItemStack tc = new ItemStack(Material.LEATHER_HELMET);
								ItemMeta im = tc.getItemMeta();
								im.setDisplayName(ChatColor.ITALIC + "Thorned Crown");
								tc.setItemMeta(im);
								tc.addEnchantment(Enchantment.THORNS, 3);
								player.getInventory().addItem(tc);
							}
							else if(Bukkit.getPlayer(args[1]) != null)
							{
								Player give = Bukkit.getPlayer(args[1]);
								if( args[2].equalsIgnoreCase("kikuichimonji") ){
									
									ItemStack is = new ItemStack(Material.WOOD_SWORD, 1); //Make a stack of 1 Wood Sword
									ItemMeta im = is.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Kikuichimonji"); //Set its name to Kikuichimonji.
									is.setItemMeta(im);
									give.getInventory().addItem(is);
									
								}else if( args[2].equalsIgnoreCase("robber's_blade") ){
									
									ItemStack is = new ItemStack(Material.WOOD_SWORD, 1); //Make a stack of 1 Wood Sword
									ItemMeta im = is.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Robber's Blade"); //Set its name to Robber's Blade.
									is.setItemMeta(im);
									give.getInventory().addItem(is);
									
								}else if( args[2].equalsIgnoreCase("simoon's_deal") ){
									
									ItemStack is = new ItemStack(Material.WOOD_SWORD, 1); //Make a stack of 1 Wood Sword
									ItemMeta im = is.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Simoon's Deal"); //Set its name to Robber's Blade.
									is.setItemMeta(im);
									give.getInventory().addItem(is);
									
								}else if( args[2].equalsIgnoreCase("grass_blade") ){
									
									ItemStack is = new ItemStack(Material.WOOD_SWORD, 1); //Make a stack of 1 Wood Sword
									ItemMeta im = is.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Grass Blade"); //Set its name to Grass Blade.
									is.setItemMeta(im);
									give.getInventory().addItem(is);
									
								}else if( args[2].equalsIgnoreCase("mjolnir") ){
									
									ItemStack is = new ItemStack(Material.IRON_AXE, 1); //Make a stack of 1 Iron Axe
									ItemMeta im = is.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Mjolnir"); //Set its name to Heal Bow.
									is.setItemMeta(im);
									give.getInventory().addItem(is);
									
								}else if( args[2].equalsIgnoreCase("simoon's_song") )
								{
									ItemStack ss = new ItemStack(Material.IRON_SWORD, 1);
									ItemMeta im = ss.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Simoon's Song");
									ss.setItemMeta(im);
									give.getInventory().addItem(ss);
								}
								else if( args[2].equalsIgnoreCase("rocksteady"))
								{
									ItemStack rs = new ItemStack(Material.BOW, 1);
									ItemMeta im = rs.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Rocksteady");
									rs.setItemMeta(im);
									give.getInventory().addItem(rs);
								}
								else if( args[2].equalsIgnoreCase("heal_bow"))
								{
									ItemStack hb = new ItemStack(Material.BOW, 1);
									ItemMeta im = hb.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Heal Bow");
									hb.setItemMeta(im);
									give.getInventory().addItem(hb);
								}
								else if( args[2].equalsIgnoreCase("agni's_rage"))
								{
									ItemStack ar = new ItemStack(Material.IRON_SWORD);
									ItemMeta im = ar.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Agni's Rage");
									ar.setItemMeta(im);
									give.getInventory().addItem(ar);
								}
								else if( args[2].equalsIgnoreCase("corsair's_edge"))
								{
									ItemStack ce = new ItemStack(Material.IRON_SWORD);
									ItemMeta im = ce.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Corsair's Edge");
									ce.setItemMeta(im);
									give.getInventory().addItem(ce);
								}
								else if( args[2].equalsIgnoreCase("gamble"))
								{
									ItemStack ga = new ItemStack(Material.STONE_SWORD);
									ItemMeta im = ga.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Gamble");
									ga.setItemMeta(im);
									give.getInventory().addItem(ga);
								}
								else if( args[2].equalsIgnoreCase("ipse's_folly"))
								{
									ItemStack il = new ItemStack(Material.GOLD_SWORD);
									ItemMeta im = il.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Ipse's Folly");
									il.setItemMeta(im);
									give.getInventory().addItem(il);
								}
								else if( args[2].equalsIgnoreCase("masamune"))
								{
									ItemStack mm = new ItemStack(Material.IRON_SWORD);
									ItemMeta im = mm.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Masamune");
									mm.setItemMeta(im);
									give.getInventory().addItem(mm);
								}
								else if( args[2].equalsIgnoreCase("muramasa"))
								{
									ItemStack mm = new ItemStack(Material.IRON_SWORD);
									ItemMeta im = mm.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Muramasa");
									mm.setItemMeta(im);
									give.getInventory().addItem(mm);
								}
								else if( args[2].equalsIgnoreCase("night's_shadow"))
								{
									ItemStack ns = new ItemStack(Material.IRON_SWORD);
									ItemMeta im = ns.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Night's Shadow");
									ns.setItemMeta(im);
									give.getInventory().addItem(ns);
								}
								else if( args[2].equalsIgnoreCase("overkill"))
								{
									ItemStack mm = new ItemStack(Material.DIAMOND_SWORD);
									ItemMeta im = mm.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Overkill");
									mm.setItemMeta(im);
									give.getInventory().addItem(mm);
								}
								else if( args[2].equalsIgnoreCase("sacrificial_sword"))
								{
									ItemStack ss = new ItemStack(Material.WOOD_SWORD);
									ItemMeta im = ss.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Sacrificial Sword");
									ss.setItemMeta(im);
									give.getInventory().addItem(ss);
								}
								else if( args[2].equalsIgnoreCase("therum's_strength"))
								{
									ItemStack ts = new ItemStack(Material.IRON_SWORD);
									ItemMeta im = ts.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Therum's Strength");
									ts.setItemMeta(im);
									give.getInventory().addItem(ts);
								}
								else if( args[2].equalsIgnoreCase("vampyr"))
								{
									ItemStack vr = new ItemStack(Material.IRON_SWORD);
									ItemMeta im = vr.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Vampyr");
									vr.setItemMeta(im);
									give.getInventory().addItem(vr);
								}
								else if( args[2].equalsIgnoreCase("grey_bow"))
								{
									ItemStack gb = new ItemStack(Material.BOW);
									ItemMeta im = gb.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Grey Bow");
									gb.setItemMeta(im);
									give.getInventory().addItem(gb);
								}
								else if( args[2].equalsIgnoreCase("pluvia's_rain"))
								{
									ItemStack pr = new ItemStack(Material.BOW);
									ItemMeta im = pr.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Pluvia's Rain");
									pr.setItemMeta(im);
									give.getInventory().addItem(pr);
								}
								else if( args[2].equalsIgnoreCase("shot_bow"))
								{
									ItemStack sb = new ItemStack(Material.BOW);
									ItemMeta im = sb.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Shot Bow");
									sb.setItemMeta(im);
									give.getInventory().addItem(sb);
								}
								else if( args[2].equalsIgnoreCase("slow_bow"))
								{
									ItemStack sb = new ItemStack(Material.BOW);
									ItemMeta im = sb.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Slow Bow");
									sb.setItemMeta(im);
									give.getInventory().addItem(sb);
								}
								else if( args[2].equalsIgnoreCase("spike_thrower"))
								{
									ItemStack st = new ItemStack(Material.BOW);
									ItemMeta im = st.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Spike Thrower");
									st.setItemMeta(im);
									give.getInventory().addItem(st);
								}
								else if( args[2].equalsIgnoreCase("ninja_sandals"))
								{
									ItemStack ns = new ItemStack(Material.CHAINMAIL_BOOTS);
									ItemMeta im = ns.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Ninja Sandals");
									ns.setItemMeta(im);
									give.getInventory().addItem(ns);
								}
								else if( args[2].equalsIgnoreCase("oni_mask"))
								{
									ItemStack om = new ItemStack(Material.CHAINMAIL_HELMET);
									ItemMeta im = om.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Oni Mask");
									om.setItemMeta(im);
									give.getInventory().addItem(om);
								}
								else if( args[2].equalsIgnoreCase("rabbit_feet"))
								{
									ItemStack rf = new ItemStack(Material.IRON_BOOTS);
									ItemMeta im = rf.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Rabbit Feet");
									rf.setItemMeta(im);
									give.getInventory().addItem(rf);
								}
								else if( args[2].equalsIgnoreCase("rubber_shield"))
								{
									ItemStack rs = new ItemStack(Material.IRON_CHESTPLATE);
									ItemMeta im = rs.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Rubber Shield");
									rs.setItemMeta(im);
									give.getInventory().addItem(rs);
								}
								else if( args[2].equalsIgnoreCase("thorned_crown"))
								{
									ItemStack tc = new ItemStack(Material.LEATHER_HELMET);
									ItemMeta im = tc.getItemMeta();
									im.setDisplayName(ChatColor.ITALIC + "Thorned Crown");
									tc.setItemMeta(im);
									tc.addEnchantment(Enchantment.THORNS, 3);
									give.getInventory().addItem(tc);
								}
							}
							
							else
							{
								player.sendMessage(ChatColor.RED + "Invalid weapon.  Type " + ChatColor.ITALIC + "legendary list" + ChatColor.RESET + ChatColor.RED + " to get a list of all weapons.");
							}
							
				}
					 else
					 {
						 player.sendMessage(ChatColor.RED + "Invalid arguments! Type /legendary <give | list> [weapon]");
					 }
					
				}
					 else if( args[0].equalsIgnoreCase("list") )
					{ 
								player.sendMessage(weapons);
					}
				}
				else
				{
					player.sendMessage(ChatColor.RED + "Invalid arguments! Type /legendary <give | list> [weapon]");
				}
			}
			else
			{
				player.sendMessage(ChatColor.RED + "You do not have permission");
			}
			
		}
		
		return true;
	}
	
}