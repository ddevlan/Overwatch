package me.ohvalsgod.overwatch.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class LocationUtil {

    public static Location[] getFaces(Location start) {
        Location[] faces = new Location[4];
        faces[0] = new Location(start.getWorld(), start.getX() + 1, start.getY(), start.getZ());
        faces[1] = new Location(start.getWorld(), start.getX() - 1, start.getY(), start.getZ());
        faces[2] = new Location(start.getWorld(), start.getX(), start.getY() + 1, start.getZ());
        faces[3] = new Location(start.getWorld(), start.getX(), start.getY() - 1, start.getZ());
        return faces;
    }

    public static String serialize(final Location location) {
        return location.getWorld().getName() + ":" + location.getX() + ":" + location.getY() + ":" + location.getZ() + ":" + location.getYaw() + ":" + location.getPitch();
    }

    public static String serializeSimpleLocation(final SimpleLocation location) {
        return location.getWorldName() + ":" + location.getX() + ":" + location.getY() + ":" + location.getZ() + ":" + location.getYaw() + ":" + location.getPitch();
    }


    public static Location deserialize(final String source) {
        final String[] split = source.split(":");
        return new Location(Bukkit.getServer().getWorld(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]), Float.parseFloat(split[4]), Float.parseFloat(split[5]));
    }

    public static SimpleLocation deserializeSimpleLocation(final String source) {
        final String[] split = source.split(":");
        return new SimpleLocation(split[0], Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]), Float.parseFloat(split[4]), Float.parseFloat(split[5]));
    }

}
