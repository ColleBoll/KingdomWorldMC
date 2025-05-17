package org.collebol.general.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.collebol.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigHandler {

    private Main instance;

    private Map<String, ConfigFile> configFiles;

    private void registerConfigs() {
        this.configFiles.put("landen", new LandenConfig("KingdomWorldMC", "landen", ".yml"));
        this.configFiles.put("roles", new RolesConfig("KingdomWorldMC", "roles", ".yml"));
    }

    public ConfigHandler(Main i) {
        this.instance = i;

        this.configFiles = new HashMap<>();
        registerConfigs();
        setupFiles();
    }

    public ConfigFile getConfig(String configName) {
        return this.configFiles.get(configName);
    }

    public FileConfiguration getDefaultConfig() {
        return this.instance.getConfig();
    }

    public void setupFiles() {
        System.out.println("Setting up config files.");
        for (ConfigFile file : this.configFiles.values()) {
            file.setup();
            file.get().options().copyDefaults(true);
            file.save();
        }
    }
}
