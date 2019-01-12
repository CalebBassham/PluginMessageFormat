package me.calebbassham.pluginmessageformat;

import org.bukkit.plugin.java.JavaPlugin;

import static me.calebbassham.pluginmessageformat.Util.registerCommand;

public class BukkitPlugin extends JavaPlugin  {

    @Override
    public void onEnable() {
        PluginMessageFormat.loadFromConfig(this.getConfig());
        registerCommand("pluginmessageformat", new PluginMessageFormatCmd());
    }

}
