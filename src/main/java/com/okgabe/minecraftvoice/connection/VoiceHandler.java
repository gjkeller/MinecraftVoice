/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.okgabe.minecraftvoice.connection;

import com.okgabe.minecraftvoice.MinecraftVoice;
import com.okgabe.minecraftvoice.exception.SocketException;

import java.net.URI;

public class VoiceHandler {

    private MinecraftVoice plugin;
    private VoiceInfoSocket webSocketClient;
    private boolean connected = false;

    public VoiceHandler(MinecraftVoice plugin){
        this.plugin = plugin;
    }

    public void reportPlayerData(String s){
        webSocketClient.send(s);
    }

    public void connect(String addr, int port) throws SocketException {
        if(connected){
            throw new SocketException("Already connected!");
        }

        try{
            webSocketClient = new VoiceInfoSocket(plugin, URI.create("ws://" + addr + ":" + port));
            webSocketClient.connect();
            connected = true;
        }
        catch(IllegalArgumentException ex){
            throw new SocketException("Invalid address or port", ex);
        }
        catch(Throwable t){
            throw new SocketException("Failed to connect", t);
        }
    }

    public void disconnect() throws SocketException {
        if(!connected){
            throw new SocketException("Not connected!");
        }

        try{
            webSocketClient.close();
            connected = false;
        }
        catch(Throwable t){
            throw new SocketException("Failed to disconnect", t);
        }
    }

    public boolean isConnected() {
        return connected;
    }
}
