package org.collebol.commands;

import org.bukkit.entity.Player;
import org.collebol.Main;

public abstract class SubCommands {

    private Main instance;

    public SubCommands(Main i) {
        this.instance = i;
    }

    public Main instance() {
        return instance;
    }

    public abstract String getName();

    public abstract String getDescription();

    public abstract String getSyntax();

    public abstract void perform(Player player, String args[]);

}
