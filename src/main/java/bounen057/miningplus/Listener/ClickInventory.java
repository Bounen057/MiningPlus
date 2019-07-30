package bounen057.miningplus.Listener;

import bounen057.miningplus.GUI.OpenGUI;
import bounen057.miningplus.MiningPlus;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickInventory implements Listener{
    private MiningPlus plugin;

    public ClickInventory(MiningPlus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnClick(InventoryClickEvent e){
        if(!e.getInventory().getName().equals(new OpenGUI(plugin).name)){
            return;
        }
        e.setCancelled(true);
    }
}
