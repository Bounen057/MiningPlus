package bounen057.miningplus.Commands;

import bounen057.miningplus.GUI.OpenGUI;
import bounen057.miningplus.MiningPlus;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetCommands implements CommandExecutor{
    private MiningPlus plugin;

    public GetCommands(MiningPlus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player)sender;

        // GUIを表示
        if(args.length == 0){
            new OpenGUI(plugin).open(p);
            return true;
        }

        // help
        if(args[0].equals("help")) {
            new SendHelp(plugin).send(p);
            return true;
        }


        return false;
    }
}
