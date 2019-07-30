package bounen057.miningplus.Data;

import bounen057.miningplus.MiningPlus;
import org.bukkit.entity.Player;

public class PlayerData {
    private MiningPlus plugin;

    public PlayerData(MiningPlus plugin) {
        this.plugin = plugin;
    }

    // ポイントをセット
    public void setpoint(Player p,double amount){
        plugin.player.getConfig().set("point."+p.getUniqueId().toString(),amount);
        plugin.player.saveConfig();
    }

    // ポイントをゲット
    public double getpoint(Player p){
        return plugin.player.getConfig().getDouble("point."+p.getUniqueId().toString());
    }

    // 合計採掘数をセット
    public void settotal(Player p,double amount){
        plugin.player.getConfig().set("total."+p.getUniqueId().toString(),amount);
        plugin.player.saveConfig();
    }

    // 合計採掘数をゲット
    public double gettotal(Player p){
        return plugin.player.getConfig().getDouble("total."+p.getUniqueId().toString());
    }
}
