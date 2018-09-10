package me.ohvalsgod.overwatch.hero.abilities;

public interface Passive extends Ability {

    /**
     * @return the passive's runnable
     */
    Runnable run();

}
