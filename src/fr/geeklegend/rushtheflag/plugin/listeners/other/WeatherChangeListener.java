package fr.geeklegend.rushtheflag.plugin.listeners.other;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

import fr.geeklegend.rushtheflag.plugin.RushTheFlag;

public class WeatherChangeListener implements Listener
{
	
	private FileConfiguration config;
	
	public WeatherChangeListener()
	{
		this.config = RushTheFlag.getInstance().getConfig();
	}
	
	@EventHandler
	public void onWeatherChange(WeatherChangeEvent event)
	{
		if (config.getBoolean("game.world.weather"))
		{
			event.setCancelled(true);
		}
	}

}
