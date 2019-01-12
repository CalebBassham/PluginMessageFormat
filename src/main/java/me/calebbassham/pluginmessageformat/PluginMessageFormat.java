package me.calebbassham.pluginmessageformat;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import static me.calebbassham.pluginmessageformat.Util.cc;
import static me.calebbassham.pluginmessageformat.Util.elvis;

public class PluginMessageFormat {

    private static String prefix;
    private static String errorPrefix;
    private static ColorPallet mainColorPallet;
    private static ColorPallet errorColorPallet;
    private static FileConfiguration config;

    public static String getPrefix() {
        return prefix + mainColorPallet.getPrimaryTextColor();
    }

    public static String getErrorPrefix() {
        return elvis(errorPrefix, "") + errorColorPallet.getPrimaryTextColor();
    }

    public static ColorPallet getMainColorPallet() {
        return mainColorPallet;
    }

    public static ColorPallet getErrorColorPallet() {
        return errorColorPallet;
    }

    public static void setPrefix(String pre) {
        prefix = ChatColor.translateAlternateColorCodes('&', pre);
    }

    public static void setMainColorPallet(ColorPallet colorPallet) {
        mainColorPallet = colorPallet;
    }

    public static void setErrorColorPallet(ColorPallet colorPallet) {
        errorColorPallet = colorPallet;
    }

    public static void loadFromConfig(FileConfiguration cfg) {
        config = cfg;
        prefix = cc(cfg.getString("prefix"));
        errorPrefix = cc(cfg.getString("error prefix"));
        mainColorPallet = ColorPallet.fromConfig(cfg.getConfigurationSection("color pallets.main"));
        errorColorPallet = ColorPallet.fromConfig(cfg.getConfigurationSection("color pallets.error"));
    }

    public static void reloadFromLastConfig() {
        if (config == null) return;
        loadFromConfig(config);
    }

}
