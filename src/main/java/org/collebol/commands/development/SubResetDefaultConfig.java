package org.collebol.commands.development;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.collebol.Main;
import org.collebol.commands.SubCommands;

import java.io.File;

public class SubResetDefaultConfig extends SubCommands {

    public SubResetDefaultConfig(Main i) {
        super(i);
    }

    @Override
    public String getName() {
        return "resetDefaultConfig";
    }

    @Override
    public String getDescription() {
        return "reset de default config. Alle gegevens worden gereset.";
    }

    @Override
    public String getSyntax() {
        return "/development resetDefaultConfig";
    }

    @Override
    public void perform(Player player, String[] args) {
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("KingdomWorldMC").getDataFolder(), "config.yml");
        if(!file.exists()) return;
        file.deleteOnExit();
        instance().getConfig().options().copyDefaults(true);
        instance().saveDefaultConfig();
    }
}
