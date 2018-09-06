package me.ohvalsgod.overwatch.hero.abilities;

import me.ohvalsgod.overwatch.util.cooldown.Cooldown;
import org.bukkit.entity.Player;

public interface Ability {

    /**
     * @return the ability's name
     */
    String getName();

    /**
     * @return the ability's fancy name
     */
    String getFancyName();

    /**
     * @return the ability's description
     */
    String getDescription();

    /**
     * @return the ability's fancy description
     */
    String getFancyDescription();

    /**
     *  This is for all abilities, passives, regular abilities,
     *  and ultimates, but passive abilities also contain a runnable.
     *
     * @param player the player that the ability should be casted on
     */
    void cast(Player player);

    /**
     * @return the cooldown of the ability
     */
    Cooldown getCooldown();

}
