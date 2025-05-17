package org.collebol.general.config;

import org.collebol.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigHandler {

    private Main instance;

    private Map<Class<? extends ConfigFile>, ConfigFile> configFiles;

    private void registerConfigs() {
        this.configFiles.put(LandenConfig.class, new LandenConfig("KingdomWorldMC", "landen.yml"));
        this.configFiles.put(RolesConfig.class, new RolesConfig("KingdomWorldMC", "roles.yml"));
    }

    public ConfigHandler(Main i) {
        this.instance = i;

        this.configFiles = new HashMap<>();
        registerConfigs();
        setupFiles();
    }

    public ConfigFile getConfig(Class<? extends ConfigFile> config) {
        return this.configFiles.get(config);
    }

    public void setupFiles() {
        for (ConfigFile file : this.configFiles.values()) {
            file.setup();
        }
    }
}
