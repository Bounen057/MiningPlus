package bounen057.miningplus.Listener;

import bounen057.miningplus.Data.PlayerData;
import bounen057.miningplus.MiningPlus;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakBlock implements Listener {
    private MiningPlus plugin;

    public BreakBlock(MiningPlus plugin) {
        this.plugin = plugin;
    }

    // 採掘した時にポイントを追加
    @EventHandler(priority = EventPriority.LOW)
    public void OnBreak(BlockBreakEvent e){
        PlayerData pd = new PlayerData(plugin);
        Player p = e.getPlayer();

        pd.settotal(p,pd.gettotal(p) + 1.0);
        pd.setpoint(p,pd.getpoint(p) + 1.0);

        plugin.player.getConfig().set("uuid."+p.getUniqueId().toString(),p.getName());
        plugin.player.saveConfig();
    }
}
