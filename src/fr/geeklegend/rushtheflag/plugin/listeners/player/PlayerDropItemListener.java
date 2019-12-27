package fr.geeklegend.rushtheflag.plugin.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import fr.geeklegend.rushtheflag.plugin.RushTheFlag;
import fr.geeklegend.rushtheflag.plugin.game.GameManager;

public class PlayerDropItemListener implements Listener
{
	
	private GameManager gameManager;
	
	public PlayerDropItemListener()
	{
		this.gameManager = RushTheFlag.getInstance().getGameManager();
	}
	
	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent event)
	{
		Player player = event.getPlayer();
		
		if (gameManager.contains(player))
		{
			event.setCancelled(true);
		}
	}

}
