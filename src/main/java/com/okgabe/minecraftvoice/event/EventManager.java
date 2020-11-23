/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.okgabe.minecraftvoice.event;

import com.okgabe.minecraftvoice.MinecraftVoice;
import org.bukkit.event.Listener;

public class EventManager implements Listener {
    private MinecraftVoice plugin;

    public EventManager(MinecraftVoice plugin){
        this.plugin = plugin;
    }

    public MinecraftVoice getPlugin() {
        return plugin;
    }
}
