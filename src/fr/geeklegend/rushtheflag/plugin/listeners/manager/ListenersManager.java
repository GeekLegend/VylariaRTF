package fr.geeklegend.rushtheflag.plugin.listeners.manager;

import org.bukkit.plugin.PluginManager;

import fr.geeklegend.rushtheflag.api.interfaces.IManager;
import fr.geeklegend.rushtheflag.plugin.RushTheFlag;
import fr.geeklegend.rushtheflag.plugin.listeners.other.BlockBreakListener;
import fr.geeklegend.rushtheflag.plugin.listeners.other.BlockPlaceListener;
import fr.geeklegend.rushtheflag.plugin.listeners.other.InventoryClickListener;
import fr.geeklegend.rushtheflag.plugin.listeners.other.WeatherChangeListener;
import fr.geeklegend.rushtheflag.plugin.listeners.player.PlayerDropItemListener;
import fr.geeklegend.rushtheflag.plugin.listeners.player.PlayerInteractListener;
import fr.geeklegend.rushtheflag.plugin.listeners.player.PlayerJoinListener;
import fr.geeklegend.rushtheflag.plugin.listeners.player.PlayerQuitListener;

public class ListenersManager implements IManager
{
	
	private RushTheFlag instance;
	
	public ListenersManager(RushTheFlag instance)
	{
		this.instance = instance;
	}

	@Override
	public void register()
	{
		PluginManager pluginManager = instance.getServer().getPluginManager();
		pluginManager.registerEvents(new PlayerJoinListener(), instance);
		pluginManager.registerEvents(new PlayerQuitListener(), instance);
		pluginManager.registerEvents(new PlayerDropItemListener(), instance);
		pluginManager.registerEvents(new PlayerInteractListener(), instance);
		
		pluginManager.registerEvents(new WeatherChangeListener(), instance);
		pluginManager.registerEvents(new BlockBreakListener(), instance);
		pluginManager.registerEvents(new BlockPlaceListener(), instance);
		pluginManager.registerEvents(new InventoryClickListener(), instance);
	}

}
