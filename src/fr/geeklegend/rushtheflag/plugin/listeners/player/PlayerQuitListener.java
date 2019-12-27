package fr.geeklegend.rushtheflag.plugin.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.geeklegend.rushtheflag.plugin.RushTheFlag;
import fr.geeklegend.rushtheflag.plugin.game.GameManager;

public class PlayerQuitListener implements Listener
{
	
	private GameManager gameManager;
	
	public PlayerQuitListener()
	{
		this.gameManager = RushTheFlag.getInstance().getGameManager();
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event)
	{
		Player player = event.getPlayer();
	
		if (gameManager.contains(player))
		{
			gameManager.remove(player);
		}

		event.setQuitMessage(null);
	}
	
}
