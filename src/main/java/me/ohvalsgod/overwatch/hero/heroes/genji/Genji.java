package me.ohvalsgod.overwatch.hero.heroes.genji;

import me.ohvalsgod.overwatch.hero.Hero;
import me.ohvalsgod.overwatch.hero.abilities.Ability;
import me.ohvalsgod.overwatch.hero.abilities.Ultimate;
import me.ohvalsgod.overwatch.hero.heroes.genji.abilities.Dragonblade;
import me.ohvalsgod.overwatch.util.CC;

import java.util.Map;
import java.util.Set;

public class Genji implements Hero {

    private Ultimate dragonblade;

    public Genji() {
        dragonblade = new Dragonblade();
    }

    @Override
    public String getName() {
        return "Genji";
    }

    @Override
    public String getFancyName() {
        return CC.GREEN + getName();
    }

    @Override
    public String getDescription() {
        return "A stealthy ninja.";
    }

    @Override
    public double getDifficulty() {
        return 0;
    }

    @Override
    public Ultimate getUltimate() {
        return dragonblade;
    }

    @Override
    public Map<Integer, Ability> getAbilities() {
        return null;
    }

    @Override
    public Set<Ability> getPassives() {
        return null;
    }

    @Override
    public double getHealth() {
        return 0;
    }
}
