package me.ohvalsgod.overwatch.hero;

import me.ohvalsgod.overwatch.Overwatch;
import me.ohvalsgod.overwatch.util.RandomUtil;

import java.util.HashSet;
import java.util.Set;

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
        return (Hero) heroes.toArray()[RandomUtil.RANDOM.nextInt(heroes.size())];
    }

}
