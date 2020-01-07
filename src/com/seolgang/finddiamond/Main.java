package com.seolgang.finddiamond;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		System.out.println("Load Success FindDiamond Plugin");
	}
	
	@Override
	public void onDisable() {
		System.out.println("Unload Success FindDiamond Plugin");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equals("fd")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				player.sendMessage("Finding Diamond... Wait Please...");
				int diaCount = GetDiamondCount(player);
				player.sendMessage("Find Diamond : " + diaCount);
			}
		}
		return false;
	}
	
	public int GetDiamondCount(Player player) {
		int diaCount = 0;
		Location playerLoc = player.getLocation();
		World currentWorld = player.getWorld();
		for (int x = (int)(playerLoc.getX()) - 2; x < (int)(playerLoc.getX()) + 2; x++) {
			for(int z = (int)(playerLoc.getBlockZ()) - 2; z < (int)(playerLoc.getZ()) + 2; z++) {
				for(int y = (int)(playerLoc.getBlockY()) - 2; y > 0; y--) {
					Location worldLoc = new Location(currentWorld, x, y, z);
					Block b = worldLoc.getBlock();
					if (b.getType() == Material.DIAMOND_ORE) diaCount++;
				}
			}
		}
		return diaCount;
	}
}
