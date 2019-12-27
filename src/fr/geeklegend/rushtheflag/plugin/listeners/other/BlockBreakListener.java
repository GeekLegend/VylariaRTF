package fr.geeklegend.rushtheflag.plugin.listeners.other;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import fr.geeklegend.rushtheflag.plugin.RushTheFlag;
import fr.geeklegend.rushtheflag.plugin.game.GameManager;

public class BlockBreakListener implements Listener
{
	
	private GameManager gameManager;
	
	public BlockBreakListener()
	{
		this.gameManager = RushTheFlag.getInstance().getGameManager();
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event)
	{
		Player player = event.getPlayer();
	
		if (gameManager.contains(player))
		{
			event.setCancelled(true);
		}
	}
	
}
