package me.calebbassham.pluginmessageformat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;

class Util {

    static String cc(String s) {
        if (s == null) return null;
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    static <T> T elvis(T tryValue, T ifNull) {
        return tryValue != null ? tryValue : ifNull;
    }

    static void registerCommand(String name, CommandExecutor cmd) {
        var pc = Bukkit.getPluginCommand(name);
        pc.setExecutor(cmd);
        if (cmd instanceof TabCompleter) {
            pc.setTabCompleter((TabCompleter) cmd);
        }
    }
}
