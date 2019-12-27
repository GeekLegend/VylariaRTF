package fr.geeklegend.rushtheflag.plugin.world;

import org.bukkit.World;

import fr.geeklegend.rushtheflag.api.interfaces.IManager;
import fr.geeklegend.rushtheflag.plugin.RushTheFlag;

public class WorldManager implements IManager
{
	
	private RushTheFlag instance;
	
	public WorldManager(RushTheFlag instance)
	{
		this.instance = instance;
	}

	@Override
	public void register()
	{
		World world = instance.getServer().getWorld("world");
		world.setTime(1000L);
		world.setGameRuleValue("doDaylightCycle", String.valueOf(instance.getConfig().getBoolean("game.world.doDaylightCycle")));
	}

}
