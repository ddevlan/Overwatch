package me.ohvalsgod.overwatch.hero;

import me.ohvalsgod.overwatch.hero.abilities.Ability;
import me.ohvalsgod.overwatch.hero.abilities.Passive;
import me.ohvalsgod.overwatch.hero.abilities.Ultimate;
import me.ohvalsgod.overwatch.hero.effects.Buff;
import me.ohvalsgod.overwatch.hero.effects.Debuff;

import java.util.Map;
import java.util.Set;

public interface Hero {

    /**
     * Name to be used out of game.
     *
     * @return the hero's name
     */
    String getName();

    /**
     * If the hero is enabled this will return true.
     *
     * @return if the hero is enabled
     */
    boolean isEnabled();

    /**
     * Colored name to be used ingame.
     *
     * @return the hero's fancy name
     */
    String getFancyName();

    /**
     * Description to be used out of game (if ever needed).
     *
     * @return the hero's description
     */
    String getDescription();

    /**
     * Colored description to be used ingame.
     *
     * @return the ability's fancy description
     */
    String getFancyDescription();

    /**
     * The star difficulty of the hero (1-3)
     *
     * @return the hero's difficulty
     */
    double getDifficulty();

    /**
     * We will run into problems with heroe(s) that have multiple
     * ultimates! But maybe we just won't add them because those
     * heroes don't belong in the game *cough symmetra mains*.
     *
     * @return the hero's ultimate ability
     */
    Ultimate getUltimate();

    /**
     * We use a map here, because abilities in Overwatch aren't very
     * scalable, since all heroes have ability one, two, and three, being,
     * bound to lshift, e, and q respectively. This has changed once in the
     * lifetime of Overwatch (see patch 1.25)
     *
     * @return the hero's abilities
     */
    Map<Integer, Ability> getAbilities();

    /**
     * These are things such as: Reinhardt's Earth Shatter; Ana's Anti-Grenade;
     * Zenyatta's Discord orb.
     *
     * @return set of debuffs that the player is affected by
     */
    Set<Debuff> getDebuffs();

    /**
     * These are things such as: Mercy's damage boost; Ana's nano boost;
     * Lucio speed boost.
     *
     * @return set of buffs that the player is affected by
     */
    Set<Buff> getBuffs();

    /**
     * The hero's passive abilities, since they can have multiple!
     *
     * @return the hero's passive abilities
     */
    Set<Passive> getPassives();

    /**
     * The hero's max health, this is completely different
     * from OverwatchPlayer#getMaxHealth(). Have to take into
     * into account that armor and shields are in the game.
     *
     * @return the hero's max health
     */
    double getMaxHealth();

}
