/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.okgabe.minecraftvoice.util;

import com.okgabe.minecraftvoice.command.CommandBase;
import com.okgabe.minecraftvoice.data.DataManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public abstract class Plugin extends JavaPlugin {

    protected String pluginName;
    protected ArrayList<CommandBase> commands;
    protected DataManager dataManager;

    public Plugin(String name){
        this.pluginName = name;
        commands = new ArrayList<>();
        dataManager = new DataManager(this);
        registerCommands();
    }

    public abstract void onEnable();
    public abstract void onDisable();
    protected abstract void registerCommands();
    protected abstract void registerEvents();

    public CommandBase getCommand(Class command){
        for(CommandBase cb : commands){
            if(cb.getClass().equals(command)) return cb;
        }

        return null;
    }

    public ArrayList<CommandBase> getCommands() {
        return commands;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public String getPluginName() {
        return pluginName;
    }
}
