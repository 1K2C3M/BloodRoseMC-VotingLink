package me.Corey.Voting;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getCommand("Vote").setExecutor(new Voting());
	}
	
	@Override
	public void onDisable() {
		
	}
}
