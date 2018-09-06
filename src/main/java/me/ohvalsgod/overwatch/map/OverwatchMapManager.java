package me.ohvalsgod.overwatch.map;

import lombok.Getter;
import me.ohvalsgod.overwatch.Overwatch;
import me.ohvalsgod.overwatch.util.config.ConfigCursor;

import java.util.HashSet;
import java.util.Set;

public class OverwatchMapManager {

    private Overwatch overwatch;
    @Getter private Set<OverwatchMap> loadedMaps;

    public OverwatchMapManager(Overwatch overwatch) {
        loadedMaps = new HashSet<>();
        this.overwatch = overwatch;
    }

    public void loadMaps() {
        final ConfigCursor cursor = new ConfigCursor(overwatch.getMainFileConfig(), "settings");
        for (String string : cursor.getStringList("load-maps")) {
            OverwatchMap overwatchMap = new OverwatchMap(string);
            overwatchMap.load();

            if (!overwatchMap.isLoaded()) {
                overwatch.getLogger().severe("[WARNING] The overwatchMap '" + overwatchMap.getName() + "' could not be loaded...");
                continue;
            }
            loadedMaps.add(overwatchMap);
        }
    }

}
