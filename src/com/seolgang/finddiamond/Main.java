package com.seolgang.finddiamond;

import org.bukkit.plugin.java.JavaPlugin;
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
				player.sendMessage(args[0]);
			}
		}
		
		return false;
	}
}
