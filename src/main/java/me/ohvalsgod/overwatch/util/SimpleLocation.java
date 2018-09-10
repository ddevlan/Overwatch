package me.ohvalsgod.overwatch.util;


import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.Collection;
import java.util.stream.Collectors;

//Inspired by how HCFactions handles locations.
public class SimpleLocation {

    private String worldName;

    private double x;
    private double y;
    private double z;

    private float yaw;
    private float pitch;

    private Location location;

    public SimpleLocation(String worldName, double x, double y, double z, float yaw, float pitch) {
        this.worldName = worldName;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public SimpleLocation(Location loc) {
        this(loc.getWorld().getName(), loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
    }

    public static Collection<Location> toLocation(Collection<SimpleLocation> simpleLocations) {
        return simpleLocations.stream().map(SimpleLocation::getLocation).collect(Collectors.toSet());
    }

    public Location getLocation() {
        instantiateLocation();
        return location;
    }

    private void instantiateLocation() {

        if (Bukkit.getWorld(worldName) == null) return;
        if (location != null) {
            if (haveCoordsChanged()) {
                this.location = new Location(Bukkit.getWorld(worldName), x, y, z, yaw, pitch);
                return;
            }
        }
        this.location = new Location(Bukkit.getWorld(worldName), x, y, z, yaw, pitch);

    }

    private boolean haveCoordsChanged() {
        return location.getX() != x || location.getY() != y || location.getZ() != z || location.getYaw() != yaw ||
                location.getPitch() != pitch;
    }


    public String getWorldName() {
        return worldName;
    }

    public SimpleLocation setWorldName(String worldName) {
        this.worldName = worldName;
        return this;
    }

    public double getX() {
        return x;
    }

    public SimpleLocation setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return y;
    }

    public SimpleLocation setY(double y) {
        this.y = y;
        return this;
    }

    public double getZ() {
        return z;
    }

    public SimpleLocation setZ(double z) {
        this.z = z;
        return this;
    }

    public float getYaw() {
        return yaw;
    }

    public SimpleLocation setYaw(float yaw) {
        this.yaw = yaw;
        return this;
    }

    public float getPitch() {
        return pitch;
    }

    public SimpleLocation setPitch(float pitch) {
        this.pitch = pitch;
        return this;
    }
}
