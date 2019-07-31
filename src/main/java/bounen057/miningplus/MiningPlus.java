package bounen057.miningplus;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import bounen057.miningplus.Commands.GetCommands;
import bounen057.miningplus.Data.CustomConfig;
import bounen057.miningplus.Listener.BreakBlock;
import bounen057.miningplus.Listener.ClickInventory;

public final class MiningPlus extends JavaPlugin {

    public String logo = "§6§l[§7§lMining+§6§l]";
    public CustomConfig config,player;

    @Override
    public void onEnable() {
        config = new CustomConfig(this);
        config.saveDefaultConfig();

        player = new CustomConfig(this,"player.yml");
        player.saveDefaultConfig();

        Bukkit.getPluginCommand("mine").setExecutor(new GetCommands(this));

        Bukkit.getPluginManager().registerEvents(new ClickInventory(this),this);
        Bukkit.getPluginManager().registerEvents(new BreakBlock(this),this);
    }

    @Override
    public void onDisable() {
    }
}
