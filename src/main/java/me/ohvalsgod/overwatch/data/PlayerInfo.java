package me.ohvalsgod.overwatch.data;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

@Getter
public class PlayerInfo {

    private UUID uuid;
    @Setter
    private String name;

    public PlayerInfo(Player player) {
        this.uuid = player.getUniqueId();
        this.name = player.getName();
    }

    public PlayerInfo(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public PlayerInfo(String name) {
        this.name = name;
    }

    public Player toPlayer() {
        return Bukkit.getPlayer(this.getUuid());
    }

    public String getDisplayName() {
        final Player player = this.toPlayer();

        return player == null ? this.getName() : player.getDisplayName();
    }

}
