package bounen057.miningplus.utils;

import bounen057.miningplus.Data.PlayerData;
import bounen057.miningplus.MiningPlus;
import org.bukkit.entity.Player;

import java.util.*;

public class GetRanking {
    private MiningPlus plugin;
    public GetRanking(MiningPlus plugin) {
        this.plugin = plugin;
    }


    // 順位からuuidを取得
    public String getUUIDFromnumber(int i){
        HashMap<Double,String> data = new HashMap<>();
        List<Double> total = new ArrayList<>();

        for (Map.Entry<String, Object> entry : plugin.player.getConfig().getConfigurationSection("total").getValues(false).entrySet()) {
            Double amount = Double.valueOf(entry.getValue().toString());
            String key = entry.getKey();

            total.add(amount);
            data.put(amount,key);
        }

        Collections.sort(total,Comparator.reverseOrder());

        String uuid = data.get(total.get(i-1));
        String name = plugin.player.getConfig().getString("uuid."+uuid);

        return name;
    }

    // 順位からuuidを取得
    public Double gettotalFromnumber(int i){
        HashMap<Double,String> data = new HashMap<>();
        List<Double> total = new ArrayList<>();

        for (Map.Entry<String, Object> entry : plugin.player.getConfig().getConfigurationSection("total").getValues(false).entrySet()) {
            Double amount = Double.valueOf(entry.getValue().toString());
            String key = entry.getKey();

            total.add(amount);
            data.put(amount,key);
        }

        Collections.sort(total,Comparator.reverseOrder());

        return total.get(i-1);
    }

    // UUIDから順位を取得
    public int getrankingFromUUID(Player p){
        HashMap<Double,String> data = new HashMap<>();
        List<Double> total = new ArrayList<>();

        for (Map.Entry<String, Object> entry : plugin.player.getConfig().getConfigurationSection("total").getValues(false).entrySet()) {
            Double amount = Double.valueOf(entry.getValue().toString());
            String key = entry.getKey();

            total.add(amount);
            data.put(amount,key);
        }

        Collections.sort(total,Comparator.reverseOrder());


        Double plater_amount = new PlayerData(plugin).gettotal(p);
        for(int i = 0;i < total.size();i++){
            if(plater_amount.equals(total.get(i))){
                return i + 1;
            }
        }


        return -1;
    }
}
