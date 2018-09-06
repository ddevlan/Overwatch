package me.ohvalsgod.overwatch.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.Location;

@AllArgsConstructor
@Data
public class Position {

    private int x, y, z;

    public static Position fromLocation(Location location) {
        return new Position((int) location.getX(), (int) location.getY(), (int) location.getZ());
    }

}
