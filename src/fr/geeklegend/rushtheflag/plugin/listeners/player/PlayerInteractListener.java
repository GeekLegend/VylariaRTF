package fr.geeklegend.rushtheflag.plugin.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import fr.geeklegend.rushtheflag.plugin.RushTheFlag;
import fr.geeklegend.rushtheflag.plugin.game.GameManager;

public class PlayerInteractListener implements Listener
{
	
	private GameManager gameManager;
	
	public PlayerInteractListener()
	{
		this.gameManager = RushTheFlag.getInstance().getGameManager();
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		ItemStack item = event.getItem();
		
		if (gameManager.contains(player))
		{
			if (item != null)
			{
				
			}
		}
	}

}
