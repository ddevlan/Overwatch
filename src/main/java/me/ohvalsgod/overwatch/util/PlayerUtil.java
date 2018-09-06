package me.ohvalsgod.overwatch.util;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerUtil {

    public static void spawn(Player player) {
        player.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
    }

    public static void reset(Player player) {
        player.setFireTicks(0);
        player.getInventory().setHeldItemSlot(0);
        player.setHealth(20.0);
        player.setFoodLevel(20);
        player.setSaturation(20);
        player.setMaximumNoDamageTicks(20);
        player.setExp(0);
        player.setLevel(0);
        player.setAllowFlight(false);
        player.setFlying(false);
        player.setGameMode(GameMode.SURVIVAL);
        player.getInventory().setArmorContents(new ItemStack[4]);
        player.getInventory().setContents(new ItemStack[36]);
        player.getActivePotionEffects().forEach(effect -> player.removePotionEffect(effect.getType()));
        player.updateInventory();
    }

    public static List<Player> toBukkitPlayers(List<UUID> list) {
        List<Player> toReturn = new ArrayList<>();

        list.forEach(uuid -> {
            Player player = Bukkit.getPlayer(uuid);

            if (player != null) {
                toReturn.add(player);
            }
        });

        return toReturn;
    }

}
