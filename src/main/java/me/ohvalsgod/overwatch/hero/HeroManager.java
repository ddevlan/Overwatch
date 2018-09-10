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
        //TODO: Statically load all heroes here:

        //TODO: The priority for heroes now are: Sombra, Mei, Mercy, as these heroes have abilities that greatly affect gameplay (rez, freeze, and hack as it disables all of your abilities)
    }

    public Hero getRandomHero() {
        return (Hero) heroes.toArray()[ThreadLocalRandom.current().nextInt(heroes.size())];
    }

}
