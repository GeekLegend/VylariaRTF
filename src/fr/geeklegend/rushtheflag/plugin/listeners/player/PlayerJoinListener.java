package fr.geeklegend.rushtheflag.plugin.listeners.player;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import fr.geeklegend.rushtheflag.api.builder.ItemBuilder;
import fr.geeklegend.rushtheflag.plugin.RushTheFlag;
import fr.geeklegend.rushtheflag.plugin.game.GameManager;

public class PlayerJoinListener implements Listener
{

	private FileConfiguration config;
	private GameManager gameManager;

	public PlayerJoinListener()
	{
		this.config = RushTheFlag.getInstance().getConfig();
		this.gameManager = RushTheFlag.getInstance().getGameManager();
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();

		if (!gameManager.contains(player))
		{
			gameManager.add(player);
			gameManager.vanish(player);

			setup(player);
		}
		
		event.setJoinMessage(null);
	}

	private void setup(Player player)
	{
		player.setHealth(20.0);
		player.setFoodLevel(20);
		player.setAllowFlight(true);
		player.setFlying(true);
		player.setGameMode(GameMode.ADVENTURE);
		player.getInventory().setHelmet(new ItemStack(Material.AIR));
		player.getInventory().setChestplate(new ItemStack(Material.AIR));
		player.getInventory().setLeggings(new ItemStack(Material.AIR));
		player.getInventory().setBoots(new ItemStack(Material.AIR));
		
		giveItems(player);
	}

	private void giveItems(Player player)
	{
		player.getInventory().clear();
		player.getInventory().setItem(config.getInt("setups.join.items.join.slot"),
				new ItemBuilder(Material
						.valueOf(config.getString("setups.join.items.join.material").replace(" ", "_").toUpperCase()))
				.setName(config.getString("setups.join.items.join.name").replace("&", "§")).toItemStack());
		player.getInventory().setItem(config.getInt("setups.join.items.leave.slot"),
				new ItemBuilder(Material
						.valueOf(config.getString("setups.join.items.leave.material").replace(" ", "_").toUpperCase()))
								.setName(config.getString("setups.join.items.leave.name").replace("&", "§")).toItemStack());
	}

}
