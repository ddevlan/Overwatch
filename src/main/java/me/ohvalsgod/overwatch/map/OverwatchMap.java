package me.ohvalsgod.overwatch.map;

import lombok.Getter;
import lombok.Setter;
import me.ohvalsgod.overwatch.Overwatch;
import me.ohvalsgod.overwatch.util.LocationUtil;
import me.ohvalsgod.overwatch.util.Position;
import me.ohvalsgod.overwatch.util.SimpleLocation;
import me.ohvalsgod.overwatch.util.config.ConfigCursor;
import me.ohvalsgod.overwatch.util.config.FileConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.util.*;

@Getter
public class OverwatchMap {

    private final Overwatch overwatch = Overwatch.getInstance();

    private String name;
    private String description;
    private OverwatchMapType overwatchMapType;
    private World world;
    @Setter private Location cornerA, cornerB, spawnA, spawnB;
    private Set<SimpleLocation> miniHealthPacks;
    private Set<SimpleLocation> megaHealthPacks;
    @Setter private int skyBox, deathFloor;
    private boolean loaded;
    private FileConfig config;

    public OverwatchMap(String name) {
        this.name = name;
    }

    private FileConfig find() {
        for (File file : Objects.requireNonNull(overwatch.getOverwatchMapDirectory().listFiles())) {
            if (file.getName().contains(".yml") && file.getName().substring(file.getName().length(), 4).equalsIgnoreCase(name)) {
                config = new FileConfig(overwatch,  name + ".yml");
                return config;
            }
        }
        return null;
    }

    public void load() {

        find();

        if (config == null) {
            return;
        }

        final ConfigCursor cursor = new ConfigCursor(config, "");

        description = cursor.getString("description");
        overwatchMapType = OverwatchMapType.valueOf(cursor.getString("type"));

        cursor.setPath("locations");

        world = Bukkit.getServer().createWorld(new WorldCreator(cursor.getString("world")));
        skyBox = cursor.getInt("sky-box");
        deathFloor = cursor.getInt("death-floor");

        cursor.setPath("corners");

        cornerA = LocationUtil.deserialize(cursor.getString("a"));
        cornerB = LocationUtil.deserialize(cursor.getString("b"));

        cursor.setPath("spawns");

        spawnA = LocationUtil.deserialize(cursor.getString("a"));
        spawnB = LocationUtil.deserialize(cursor.getString("b"));

        cursor.setPath("locations");

        miniHealthPacks = new HashSet<>();

        for (String string : cursor.getStringList("minis"))
            miniHealthPacks.add(LocationUtil.deserializeSimpleLocation(string));

        megaHealthPacks = new HashSet<>();

        for (String string : cursor.getStringList("megas"))
            megaHealthPacks.add(LocationUtil.deserializeSimpleLocation(string));

        loaded = true;
    }


    public void save() {
        final FileConfiguration editableConfig = config.getConfig();

        editableConfig.set("name", name);
        editableConfig.set("description", description);
        editableConfig.set("type", overwatchMapType.name());

        editableConfig.set("locations.world", world.getName());
        editableConfig.set("locations.sky-box", skyBox);
        editableConfig.set("locations.death-floor", deathFloor);
        editableConfig.set("locations.corners.a", cornerA);
        editableConfig.set("locations.corners.a", cornerB);
        editableConfig.set("locations.spawns.a", spawnA);
        editableConfig.set("locations.spawns.a", spawnB);
        editableConfig.set("locations.minis", transform(miniHealthPacks));
        editableConfig.set("locations.megas", transform(megaHealthPacks));

        config.save();//brb
    }

    public void removeMiniHealthpack(SimpleLocation location) {
        if (miniHealthPacks.contains(location)) miniHealthPacks.remove(location);
    }

    public void addMiniHealthpack(SimpleLocation location) {
        Position position = Position.fromSimpleLocation(location);
        if(!miniHealthPacks.contains(location)) miniHealthPacks.add(location);
    }

    private List<String> transform(Set<SimpleLocation> locations) {
        List<String> toReturn = new ArrayList<>();
        locations.forEach(loc -> toReturn.add(LocationUtil.serializeSimpleLocation(loc)));
        return toReturn;
    }


}
