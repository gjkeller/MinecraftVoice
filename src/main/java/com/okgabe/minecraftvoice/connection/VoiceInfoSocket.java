/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.okgabe.minecraftvoice.connection;

import com.okgabe.minecraftvoice.MinecraftVoice;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class VoiceInfoSocket extends WebSocketClient {

    private MinecraftVoice plugin;

    public VoiceInfoSocket(MinecraftVoice plugin, URI serverUri) {
        super(serverUri);
        this.plugin = plugin;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        plugin.getLogger().info("Socket connected: " + handshakedata.getHttpStatusMessage());
    }

    @Override
    public void onMessage(String message) {
        plugin.getLogger().info("Received socket message: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        plugin.getLogger().info("Socket closed: " + code + ", " + reason);
    }

    @Override
    public void onError(Exception ex) {
        plugin.getLogger().warning("Socket had an exception");
        ex.printStackTrace();
    }
}
