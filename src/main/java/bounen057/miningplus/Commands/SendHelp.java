package bounen057.miningplus.Commands;

import bounen057.miningplus.MiningPlus;
import org.bukkit.entity.Player;

public class SendHelp {
    private MiningPlus plugin;

    public SendHelp(MiningPlus plugin) {
        this.plugin = plugin;
    }

    public void send(Player p){
        p.sendMessage("§6§l[" + "§8§l§k===" + "§7§l[MiningPlus]" + "§8§l§k===" + "§6§l]");
        p.sendMessage("§7>§9 /mine help §7-helpを出します");
    }
}
