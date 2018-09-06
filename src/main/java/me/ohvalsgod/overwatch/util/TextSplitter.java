package me.ohvalsgod.overwatch.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextSplitter {

    public static List<String> split(String text, String prefix) {
        if (text.length() <= 32) {
            return Collections.singletonList(prefix + text);
        }

        final List<String> lines = new ArrayList<>();
        final String[] split = text.split(" ");
        StringBuilder builder = new StringBuilder(prefix);

        for (int i = 0; i < split.length; i++) {
            if (builder.length() + split[i].length() >= 32) {
                lines.add(builder.toString());
                builder = new StringBuilder(prefix);
            }

            builder.append(split[i]);
            builder.append(" ");
        }

        if (builder.length() != 0) {
            lines.add(builder.toString());
        }

        return lines;
    }

}