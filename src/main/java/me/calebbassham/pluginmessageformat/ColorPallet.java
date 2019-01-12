package me.calebbassham.pluginmessageformat;

import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static me.calebbassham.pluginmessageformat.Util.cc;
import static me.calebbassham.pluginmessageformat.Util.elvis;

public class ColorPallet {

    private String primaryTextColor;
    private String highlightTextColor;
    private String valueTextColor;
    private String extraTextColor;

    public ColorPallet(String primaryTextColor, String highlightTextColor, String valueTextColor, String extraTextColor) {
        this.primaryTextColor = primaryTextColor;
        this.highlightTextColor = highlightTextColor;
        this.valueTextColor = valueTextColor;
        this.extraTextColor = extraTextColor;
    }

    public String getPrimaryTextColor() {
        return elvis(primaryTextColor, ChatColor.WHITE.toString());
    }

    public String getHighlightTextColor() {
        return elvis(highlightTextColor, ChatColor.YELLOW.toString());
    }

    public String getValueTextColor() {
        return elvis(valueTextColor, highlightTextColor);
    }

    public String getExtraTextColor() {
        return elvis(extraTextColor, ChatColor.GRAY.toString());
    }

    public void setPrimaryTextColor(ChatColor... colors) {
        this.primaryTextColor = join(colors);
    }

    public void setHighlightTextColor(ChatColor... colors) {
        this.highlightTextColor = join(colors);
    }

    public void setValueTextColor(ChatColor... colors) {
        this.valueTextColor = join(colors);
    }

    public void setExtraTextColor(ChatColor... colors) {
        this.extraTextColor = join(colors);
    }

    private String join(ChatColor[] colors) {
        return Stream.of(colors).map(ChatColor::toString).collect(Collectors.joining());
    }

    public static ColorPallet fromConfig(ConfigurationSection config) {
        var primary = cc(config.getString("primaryTextColor"));
        var highlight = cc(config.getString("highlightTextColor"));
        var value = cc(config.getString("valueTextColor"));
        var extra = cc(config.getString("extraTextColor"));

        return new ColorPallet(primary, highlight, value, extra);
    }

}
