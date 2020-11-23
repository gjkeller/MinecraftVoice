package com.okgabe.minecraftvoice;

import com.okgabe.minecraftvoice.command.CommandBase;
import com.okgabe.minecraftvoice.command.VoiceConnectCommand;
import com.okgabe.minecraftvoice.connection.VoiceHandler;
import com.okgabe.minecraftvoice.event.EventManager;
import com.okgabe.minecraftvoice.util.Plugin;
import com.okgabe.minecraftvoice.util.TextUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public final class MinecraftVoice extends Plugin {

    private EventManager eventManager;
    private VoiceHandler voiceHandler;

    public MinecraftVoice() {
        super("MinecraftVoice");
    }

    @Override
    public void onEnable() {
        registerEvents();
        voiceHandler = new VoiceHandler(this);
        // Plugin startup logic
        getLogger().info("MinecraftVoice started");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("MinecraftVoice disabled");
    }

    @Override
    protected void registerCommands() {
        commands.add(new VoiceConnectCommand(this));
    }

    @Override
    protected void registerEvents() {
        eventManager = new EventManager(this);
        getServer().getPluginManager().registerEvents(eventManager, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        for(CommandBase c : commands){
            if(c.getCommand().equalsIgnoreCase(label)|| (c.getAliases()!=null&&c.getAliases().contains(label))){
                boolean result = c.execute(sender, args);
                if(!result){
                    sender.sendMessage(TextUtil.convertColor("&cInvalid command usage!\n&7/" + label + " " + c.getUsage()));
                }
            }
        }

        return true;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public VoiceHandler getVoiceHandler() {
        return voiceHandler;
    }
}
