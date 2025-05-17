package org.collebol;

import org.bukkit.plugin.java.JavaPlugin;
import org.collebol.commands.development.DevelopmentCmd;
import org.collebol.commands.development.TabCompleteDevelopment;
import org.collebol.general.config.ConfigHandler;

/**
 *
 * Main Kingdom World class.
 *
 * @author ColleBol - <a href="mailto:contact@collebol.org">contact@collebol.org</a>
 * @since 1.0-dev
 */
public class Main extends JavaPlugin {

    private Main plugin;

    private ConfigHandler configHandler;

    @Override
    public void onEnable() {
        super.onEnable();
        System.out.println("Kingdom World Plugin starting!");
        this.plugin = this;

        // RegisterHandlers
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        this.configHandler = new ConfigHandler(this);

        // Command register
        getCommand("development").setExecutor(new DevelopmentCmd(this));

        getCommand("development").setTabCompleter(new TabCompleteDevelopment());
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public Main instance() {
        return this.plugin;
    }

    public ConfigHandler getConfigHandler() {
        return configHandler;
    }
}
