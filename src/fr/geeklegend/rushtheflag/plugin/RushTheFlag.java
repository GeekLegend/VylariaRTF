package fr.geeklegend.rushtheflag.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import fr.geeklegend.rushtheflag.plugin.game.GameManager;
import fr.geeklegend.rushtheflag.plugin.listeners.manager.ListenersManager;
import fr.geeklegend.rushtheflag.plugin.world.WorldManager;

public class RushTheFlag extends JavaPlugin
{
	
	public static RushTheFlag instance;
	
	private GameManager gameManager;
	
	@Override
	public void onEnable()
	{
		instance = this;
		
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		
		gameManager = new GameManager();

		new WorldManager(this).register();
		new ListenersManager(this).register();
	}
	
	@Override
	public void onDisable()
	{
		instance = null;
	}
	
	public static RushTheFlag getInstance()
	{
		return instance;
	}

	public GameManager getGameManager()
	{
		return gameManager;
	}
	
}
