package me.ohvalsgod.overwatch.util;

import org.bukkit.ChatColor;

import java.util.List;

public class StringUtil {

    public static String capitalizeFirstLetter(String original) {
        if (original == null || original.length() == 0) {
            return original;
        }

        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }

    public static int getCountOfChar(String src, char match) {
        int amount = 0;

        for (char c : src.toCharArray()) {
            if (c == match)
                amount++;
        }

        return amount;
    }

    public static String level(List<String> list) {
        StringBuilder toReturn = new StringBuilder();

        int i = 0;
        for (String string : list) {
            i++;
            toReturn.append(string);
            if (i < list.size()) {
                toReturn.append(CC.WHITE).append(", ");
            }
        }

        return toReturn.toString();
    }

    public static String level(List<String> list, ChatColor color) {
        StringBuilder toReturn = new StringBuilder();

        int i = 0;
        for (String string : list) {
            i++;
            toReturn.append(string);
            if (i < list.size()) {
                toReturn.append(color).append(", ");
            }
        }

        return toReturn.toString();
    }

}
