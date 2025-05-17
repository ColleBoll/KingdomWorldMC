package org.collebol.commands.development;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabCompleteDevelopment implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) return null;
        Player player = (Player) sender;
        if (!player.hasPermission("kingdomworld.role.developer")) return null;

        if(args.length == 1) {
            List<String> arguments = new ArrayList<>();
            arguments.add("resetDefaultConfig");
            return arguments;
        }
        return null;
    }
}
