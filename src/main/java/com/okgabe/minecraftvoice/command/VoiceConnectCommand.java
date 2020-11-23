/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.okgabe.minecraftvoice.command;

import com.okgabe.minecraftvoice.MinecraftVoice;
import com.okgabe.minecraftvoice.exception.SocketException;
import com.okgabe.minecraftvoice.util.TextUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VoiceConnectCommand extends CommandBase {
    public VoiceConnectCommand(MinecraftVoice plugin) {
        super(plugin, "voiceconnect", "Sends a link to connect to the voice channel. Also used to manage the voice plugin's connection.", "[reload | connect | disconnect]", "vc", "voice", "connectvoice");
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if(args.length > 0){
            if(args[0].equals("connect")){
                if(!hasPermission(sender, "minecraftvoice.admin.connect")) return true;
                try{
                    plugin.getVoiceHandler().connect("localhost", 9449);
                }
                catch(SocketException ex){
                    sender.sendMessage(TextUtil.convertColor("&cAn error occurred: " + ex.getMessage() + "\n&7Full stack trace has been printed to console."));
                    ex.printStackTrace();
                }
            }
            else if(args[0].equals("disconnect")){
                if(!hasPermission(sender, "minecraftvoice.admin.disconnect")) return true;
                try{
                    plugin.getVoiceHandler().disconnect();
                }
                catch(SocketException ex){
                    sender.sendMessage(TextUtil.convertColor("&cAn error occurred: " + ex.getMessage() + "\n&7Full stack trace has been printed to console."));
                    ex.printStackTrace();
                }
            }
            else if(args[0].equals("reload")){
                if(!hasPermission(sender, "minecraftvoice.admin.reload")) return true;
                plugin.getDataManager().reloadConfig();
                sender.sendMessage(TextUtil.convertColor("&aThe configuration has been reloaded!"));
            }
        }
        else{
            if(!(sender instanceof Player)){
                sender.sendMessage(TextUtil.convertColor("&cUsable console commands: voiceconnect reload | connect | disconnect"));
                return true;
            }

            plugin.getVoiceHandler().reportPlayerData("Hello world!");
        }
        return true;
    }
}
