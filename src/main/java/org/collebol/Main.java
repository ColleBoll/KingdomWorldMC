package org.collebol;

import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * Main Kingdom World class.
 *
 * @author ColleBol - <a href="mailto:contact@collebol.org">contact@collebol.org</a>
 * @since 1.0-dev
 */
public class Main extends JavaPlugin {

    private Main plugin;

    @Override
    public void onEnable() {
        super.onEnable();

        System.out.println("Kingdom World Plugin starting!");

        this.plugin = this;
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public Main instance() {
        return this.plugin;
    }
}
