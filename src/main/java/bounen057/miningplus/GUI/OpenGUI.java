package bounen057.miningplus.GUI;

import bounen057.miningplus.Data.PlayerData;
import bounen057.miningplus.MiningPlus;
import bounen057.miningplus.utils.GetRanking;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class OpenGUI {
    private MiningPlus plugin;

    public OpenGUI(MiningPlus plugin) {
        this.plugin = plugin;
    }

    public String name = "採掘メニュー";
    int size = 9 * 3;

    public void open(Player p){
        Inventory inv = Bukkit.createInventory(null,size,name);

        // invに色々追加
        inv = add(inv,p);

        p.openInventory(inv);
    }

    private Inventory add(Inventory inv,Player p){
        ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)15);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(" ");
        item.setItemMeta(itemMeta);

        // ガラスを設置
        for(int i = 0;i < size;i++){
            inv.setItem(i,item);
        }

        inv.setItem(13,getHead(p));
        inv.setItem(11,getTop());
        inv.setItem(15,getReward());
        inv.setItem(18,getCommand());

        return inv;
    }

    private ItemStack getHead(Player p){
        ItemStack item = new ItemStack(Material.EYE_OF_ENDER);
        ItemMeta itemMeta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        itemMeta.setDisplayName("§e§l" + p.getName() + " §a§lのステータス §6§kX");
        lore.add("§7合計採掘数 : §e" + new PlayerData(plugin).gettotal(p) + " §8§l/ §6順位 §l"+new GetRanking(plugin).getrankingFromUUID(p)+"§6位");
        lore.add("§7ポイント : §e" + new PlayerData(plugin).getpoint(p));

        itemMeta.setLore(lore);
        itemMeta.addEnchant(Enchantment.PROTECTION_FIRE,1,false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(itemMeta);
        return item;
    }

    private ItemStack getTop(){
        GetRanking gr = new GetRanking(plugin);

        ItemStack item = new ItemStack(Material.GOLD_ORE);
        ItemMeta itemMeta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        itemMeta.setDisplayName("§6§l≪§7§l 採掘ランキング §6§l≫");
        for(int i = 1;i < 11;i++) {
            lore.add("§e§l" + i + "位 §9§l" + gr.getUUIDFromnumber(i) + " §7§l: §6" + gr.gettotalFromnumber(i));
        }

        itemMeta.setLore(lore);
        itemMeta.addEnchant(Enchantment.PROTECTION_FIRE,1,false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(itemMeta);
        return item;
    }

    private ItemStack getReward(){
        ItemStack item = new ItemStack(Material.CHEST);
        ItemMeta itemMeta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        itemMeta.setDisplayName("§9§l≪ §b§l報酬を受け取る §9§l≫");
        lore.add("§7§l準備中...");

        itemMeta.setLore(lore);
        //itemMeta.addEnchant(Enchantment.PROTECTION_FIRE,1,false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(itemMeta);
        return item;
    }

    private ItemStack getCommand(){
        ItemStack item = new ItemStack(Material.COMMAND_REPEATING);
        ItemMeta itemMeta = item.getItemMeta();
        List<String> lore = new ArrayList<>();

        itemMeta.setDisplayName("§2§l≪ §a§lコマンド §2§l≫");
        lore.add("§7§l/mine help");

        itemMeta.setLore(lore);
        //itemMeta.addEnchant(Enchantment.PROTECTION_FIRE,1,false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(itemMeta);
        return item;
    }
}
