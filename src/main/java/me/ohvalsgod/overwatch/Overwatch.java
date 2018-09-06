package me.ohvalsgod.overwatch;

import lombok.Getter;
import me.ohvalsgod.overwatch.data.PlayerCache;
import me.ohvalsgod.overwatch.hero.HeroManager;
import me.ohvalsgod.overwatch.jedis.JedisSettings;
import me.ohvalsgod.overwatch.jedis.OverwatchJedis;
import me.ohvalsgod.overwatch.map.OverwatchMapManager;
import me.ohvalsgod.overwatch.mongo.OverwatchMongo;
import me.ohvalsgod.overwatch.util.ItemUtil;
import me.ohvalsgod.overwatch.util.config.ConfigCursor;
import me.ohvalsgod.overwatch.util.config.FileConfig;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

@Getter
public class Overwatch extends JavaPlugin {

    @Getter private static Overwatch instance;

    //  Files
    private FileConfig mainFileConfig;
    private File overwatchMapDirectory;

    //  Database
    private OverwatchJedis overwatchJedis;
    private OverwatchMongo overwatchMongo;

    //  Util
    private PlayerCache playerCache;

    //  Managers
    private OverwatchMapManager overwatchMapManager;
    private HeroManager heroManager;

    @Override
    public void onEnable() {
        instance = this;

        //  Files
        initFiles();

        //  Database
        initJedis();
        initMongo();

        //  Util
        initUtils();

        //  Managers
        initManagers();

        //  Overwatch
        initOverwatch();
    }

    public void initOverwatch() {
        overwatchMapManager.loadMaps();
    }

    private void initManagers() {
        overwatchMapManager = new OverwatchMapManager(this);
        heroManager = new HeroManager(this);
    }

    private void initUtils() {
        ItemUtil.load();
        playerCache = new PlayerCache(this);
    }

    public void initMongo() {
        overwatchMongo = new OverwatchMongo();
    }

    private void initFiles() {
        mainFileConfig = new FileConfig(this, "config.yml");

        final ConfigCursor cursor = new ConfigCursor(mainFileConfig, "settings");

        overwatchMapDirectory = new File(getDataFolder() + cursor.getString("map-directory") + "/");

        if (overwatchMapDirectory.exists()) {
            if (overwatchMapDirectory.getParentFile().exists()) {
                overwatchMapDirectory.getParentFile().mkdirs();
            }
            overwatchMapDirectory.mkdir();
        }
    }
    private void initJedis() {
        final ConfigCursor cursor = new ConfigCursor(mainFileConfig, "database");

        final JedisSettings settings = new JedisSettings(
                cursor.getString("redis.host"),
                cursor.getInt("redis.port"),
                cursor.getString("redis.password")
        );
        overwatchJedis = new OverwatchJedis(settings);
    }

}
