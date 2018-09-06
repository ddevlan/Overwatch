package me.ohvalsgod.overwatch.hero;

import me.ohvalsgod.overwatch.hero.abilities.Ability;
import me.ohvalsgod.overwatch.hero.abilities.Ultimate;

import java.util.Map;
import java.util.Set;

public interface Hero {

    /**
     * @return the hero's name
     */
    String getName();

    /**
     * @return the hero's fancy name
     */
    String getFancyName();

    /**
     * @return the hero's description
     */
    String getDescription();

    /**
     * @return the ability's fancy description
     */
    String getFancyDescription();

    /**
     * @return the hero's difficulty
     */
    double getDifficulty();

    /**
     * @return the hero's ultimate ability
     */
    Ultimate getUltimate();

    /**
     * @return the hero's abilities
     */
    Map<Integer, Ability> getAbilities();


    /**
     * @return the hero's passive abilities
     */
    Set<Ability> getPassives();

    /**
     * @return the hero's health
     */
    double getHealth();

}
