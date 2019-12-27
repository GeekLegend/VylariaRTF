package fr.geeklegend.rushtheflag.plugin.game;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class GameManager
{

	private List<Player> players;
	
	public GameManager()
	{
		this.players = new ArrayList<Player>();
	}
	
	public void add(Player player)
	{
		players.add(player);
	}
	
	public void remove(Player player)
	{
		players.remove(player);
	}
	
	public boolean contains(Player player)
	{
		return players.contains(player);
	}
	
	public void vanish(Player player)
	{
		for (Player pls : players)
		{
			pls.hidePlayer(player);
			player.showPlayer(pls);
		}
	}
	
	public List<Player> getPlayers()
	{
		return players;
	}
	
}
