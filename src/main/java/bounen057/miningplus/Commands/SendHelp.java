package bounen057.miningplus.Commands;

import bounen057.miningplus.MiningPlus;
import org.bukkit.entity.Player;

public class SendHelp {
    private MiningPlus plugin;

    public SendHelp(MiningPlus plugin) {
        this.plugin = plugin;
    }

    public void send(Player p){
        p.sendMessage("§6§l[" + "§8§l§m===" + "§7§l[MiningPlus]" + "§8§l§m===" + "§6§l]");
        p.sendMessage("§7>§9 /mine help §7-helpを出します");
        p.sendMessage("§7>§9 /mine pay <相手の名前> <数字> §7-採掘ptを他人にあげます");
    }
}
