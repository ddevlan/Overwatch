package me.ohvalsgod.overwatch;

import lombok.Getter;
import me.ohvalsgod.overwatch.util.config.ConfigCursor;

@Getter
public class OverwatchConfig {

    private String serverId;

    public void load() {
        ConfigCursor cursor = new ConfigCursor(Overwatch.getInstance().getMainFileConfig(),  "server");

        serverId = cursor.getString("id");
    }
}
