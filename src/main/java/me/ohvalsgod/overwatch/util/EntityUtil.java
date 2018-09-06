package me.ohvalsgod.overwatch.util;

import com.comphenix.protocol.PacketType;

import me.ohvalsgod.basic.packet.Packet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class EntityUtil {

    public static void hideEntity(Player player, Entity entity) {
        Packet packet = new Packet(PacketType.Play.Server.ENTITY_DESTROY);
        packet.getIntegerArrays().write(0, new int[]{entity.getEntityId()});
        packet.send(player);
    }

    public static void hideEntities(Player player, List<? extends Entity> entities) {
        int[] ids = new int[entities.size()];
        AtomicInteger atomic = new AtomicInteger(0);

        entities.forEach(entity -> ids[atomic.getAndIncrement()] = entity.getEntityId());

        Packet packet = new Packet(PacketType.Play.Server.ENTITY_DESTROY);
        packet.getIntegerArrays().write(0, ids);
    }

    public static void hideEntitiesForAllExcluding(List<UUID> uuids, List<? extends Entity> entities) {
        Bukkit.getOnlinePlayers().forEach(player -> {
            if (!uuids.contains(player.getUniqueId())) {
                hideEntities(player, entities);
            }
        });
    }

}
