package me.ohvalsgod.overwatch.hero;

import me.ohvalsgod.overwatch.Overwatch;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class HeroManager {

    private Overwatch overwatch;
    private Set<Hero> heroes;

    public HeroManager(Overwatch overwatch) {
        this.overwatch = overwatch;
        heroes = new HashSet<>();
    }

    public void loadHeroes() {
        //TODO: statically load all heroes here
    }

    public Hero getRandomHero() {
        return (Hero) heroes.toArray()[ThreadLocalRandom.current().nextInt(heroes.size())];
    }

}
