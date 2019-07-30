package bounen057.miningplus.utils;

import bounen057.miningplus.Data.PlayerData;
import bounen057.miningplus.MiningPlus;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PayPoint {
    private MiningPlus plugin;
    public PayPoint(MiningPlus plugin) {
        this.plugin = plugin;
    }

    public void pay(String amount, String name, Player p){
        PlayerData pd = new PlayerData(plugin);

        // エラーチェック
        if(Bukkit.getPlayer(name) == null){
            p.sendMessage(plugin.logo+"§4相手が存在しません");
            return;
        }

        Double send = 0.0;
        try {
            send = Double.valueOf(amount);
        }catch (Exception e){
            p.sendMessage(plugin.logo+"§4数字を入力してください");
            return;
        }

        if(send <= 0){
            p.sendMessage(plugin.logo+"§40以下の数字は入力できません");
            return;
        }

        if(send > pd.getpoint(p)){
            p.sendMessage(plugin.logo+"§4君はそんな採掘ポイント持っていないぞ!");
            return;
        }

        // 処理
        Player user = Bukkit.getPlayer(name);

        // 送る処理
        p.sendMessage(plugin.logo+"§e"+user.getName()+"§aに§6"+amount+"採掘pt§a送りました!");
        pd.setpoint(p,pd.getpoint(p) - send);

        // 送られる処理
        user.sendMessage(plugin.logo+"§e"+p.getName()+"§aから§6"+amount+"採掘pt§a送られました!");
        pd.setpoint(user,send + pd.getpoint(user));
    }
}
