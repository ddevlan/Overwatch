package me.ohvalsgod.overwatch.data;

import me.ohvalsgod.overwatch.Overwatch;
import me.ohvalsgod.overwatch.util.AtomicString;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerCache {

    private static Map<String, UUID> nameToUuid;
    private static Map<UUID, String> uuidToName;

    private Overwatch overwatch;

    public PlayerCache(Overwatch overwatch) {
        this.overwatch = overwatch;
        nameToUuid = new HashMap<>();
        uuidToName = new HashMap<>();
    }
    public String getName(UUID uuid) {
        if (uuidToName.containsKey(uuid)) {
            return uuidToName.get(uuid);
        }

        AtomicString atomic = new AtomicString();

        overwatch.getOverwatchJedis().runCommand(redis -> {
            atomic.setString(redis.hget("uuid-to-name", String.valueOf(uuid)));
            return null;
        });

        if (atomic.getString() == null) {
            return null;
        } else {
            return atomic.getString();
        }
    }

    public UUID getUuid(String name) {
        if (nameToUuid.containsKey(name.toLowerCase())) {
            return nameToUuid.get(name.toLowerCase());
        }

        AtomicString atomic = new AtomicString();

        overwatch.getOverwatchJedis().runCommand(redis -> {
            atomic.setString(redis.hget("name-to-uuid", name.toLowerCase()));
            return null;
        });

        if (atomic.getString() == null) {
            return null;
        } else {
            return UUID.fromString(atomic.getString());
        }
    }

    public void fetch() {
        overwatch.getOverwatchJedis().runCommand((redis) -> {
            Map<String, String> cached = redis.hgetAll("name-to-uuid");

            if (cached == null || cached.isEmpty()) {
                return null;
            }

            Map<String, UUID> ntu = new HashMap<>();
            Map<UUID, String> utn = new HashMap<>();

            for (Map.Entry<String, String> entry : cached.entrySet()) {
                ntu.put(entry.getKey(), UUID.fromString(entry.getValue()));
                utn.put(UUID.fromString(entry.getValue()), entry.getKey());
            }

            nameToUuid = ntu;
            uuidToName = utn;

            return null;
        });
    }

    public void update(String name, UUID uuid) {
        nameToUuid.put(name.toLowerCase(), uuid);
        uuidToName.put(uuid, name);

        overwatch.getOverwatchJedis().runCommand((redis) -> {
            redis.hset("name-to-uuid", name.toLowerCase(), uuid.toString());
            redis.hset("uuid-to-name", uuid.toString(), name);
            return null;
        });
    }

}
