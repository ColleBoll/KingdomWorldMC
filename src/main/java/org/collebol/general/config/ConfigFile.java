package org.collebol.general.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public abstract class ConfigFile {

    private File file;
    private FileConfiguration customFile;

    private String pluginName;
    private String fileName;

     public ConfigFile(String pluginName, String fileName) {
        this.pluginName = pluginName;
        this.fileName = fileName;
     }

    public void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin(pluginName).getDataFolder(), fileName);

        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){

            }
        }
        customFile = YamlConfiguration.loadConfiguration(file);

    }

    public FileConfiguration get(){
        return customFile;
    }

    public void save() {
        try{
            customFile.save(file);
        }catch (IOException e){
            System.out.println("File saven is niet gelukt!? wtf");
        }
    }

    public void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }

}
