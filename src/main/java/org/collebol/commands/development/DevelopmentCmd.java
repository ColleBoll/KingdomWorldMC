package org.collebol.commands.development;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.collebol.Main;
import org.collebol.commands.SubCommands;

import java.util.ArrayList;

public class DevelopmentCmd implements CommandExecutor {

    private Main instance;

    private ArrayList<SubCommands> sub = new ArrayList<>();

    public DevelopmentCmd(Main i) {
        this.instance = i;
        getSub().add(new SubResetDefaultConfig(this.instance));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if (!player.hasPermission("kingdomworld.role.developer")) return false;

        if (args.length > 0) {
            for (int i = 0; i < getSub().size(); i++){
                if(args[0].equalsIgnoreCase(getSub().get(i).getName())){
                    getSub().get(i).perform(player, args);
                }
            }
        } else if (args.length == 0) {
            player.sendMessage("Developer command");
        }
        return false;
    }

    public ArrayList<SubCommands> getSub(){
        return this.sub;
    }
}
