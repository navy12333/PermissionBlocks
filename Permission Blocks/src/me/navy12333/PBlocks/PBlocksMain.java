package me.navy12333.PBlocks;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;



public class PBlocksMain extends JavaPlugin{

	public final Logger logger = Logger.getLogger("Minecraft");
	
	private static Plugin plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " has been enabled");
		
		getConfig().addDefault("player1health", 60);

		registerEvents(this, new PBlocksEvents());
		
		getCommand("pblocks").setExecutor(new PBlocksCommands());

		
	}
	
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " has been disabled");
		plugin = null;

	}
	
	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
		Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
		}
	public static Plugin getPlugin() {
		return plugin;
		}
	
	
	
}
