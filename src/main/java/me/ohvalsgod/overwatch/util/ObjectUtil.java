package me.ohvalsgod.overwatch.util;

public class ObjectUtil {

    public static Object transform(String value) {
        if (value.equalsIgnoreCase("true")) {
            return true;
        } else if (value.equalsIgnoreCase("false")) {
            return false;
        } else {
            return value;
        }
    }

    /**
     * @param e     An {@link Enum}.
     * @return      The first {@link Enum} or next {@link Enum} according to the given {@link Enum}'s ordinal.
     */
    public static Object getNext(Enum e) {
        Object[] objects = e.getClass().getEnumConstants();

        if (e.ordinal() == objects.length - 1) {
            return objects[0];
        } else {
            return objects[e.ordinal() + 1];
        }
    }

    public static String toReadable(Enum e) {
        return StringUtil.capitalizeFirstLetter(e.name().toLowerCase());
    }

}
