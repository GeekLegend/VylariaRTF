package fr.geeklegend.rushtheflag.plugin.listeners.other;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.geeklegend.rushtheflag.plugin.RushTheFlag;
import fr.geeklegend.rushtheflag.plugin.game.GameManager;

public class InventoryClickListener implements Listener
{
	
	private GameManager gameManager;
	
	public InventoryClickListener()
	{
		this.gameManager = RushTheFlag.getInstance().getGameManager();
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		
		if (gameManager.contains(player))
		{
			event.setCancelled(true);
		}
	}
	
}
