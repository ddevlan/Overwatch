package me.ohvalsgod.overwatch.hero.heroes.genji;

import me.ohvalsgod.overwatch.hero.Hero;
import me.ohvalsgod.overwatch.hero.abilities.Ability;
import me.ohvalsgod.overwatch.hero.abilities.Passive;
import me.ohvalsgod.overwatch.hero.abilities.Ultimate;
import me.ohvalsgod.overwatch.hero.effects.Buff;
import me.ohvalsgod.overwatch.hero.effects.Debuff;
import me.ohvalsgod.overwatch.hero.heroes.genji.abilities.CyberAgility;
import me.ohvalsgod.overwatch.hero.heroes.genji.abilities.Dragonblade;
import me.ohvalsgod.overwatch.hero.heroes.genji.abilities.Reflect;
import me.ohvalsgod.overwatch.hero.heroes.genji.abilities.SwiftStrike;
import me.ohvalsgod.overwatch.util.CC;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Genji implements Hero {

    private Ultimate dragonblade;
    private Map<Integer, Ability> abilities;
    private Set<Passive> passives;

    public Genji() {
        //  Ultimate
        dragonblade = new Dragonblade();

        //  Abilities
        Map<Integer, Ability> abilities = new HashMap<>();

        abilities.put(abilities.size(), new SwiftStrike());
        abilities.put(abilities.size(), new Reflect());

        //  Passives
        passives = new HashSet<>();

        passives.add(new CyberAgility());
    }

    @Override
    public String getName() {
        return "Genji";
    }

    @Override
    public boolean isEnabled() {
        //TODO: Need to remember when the heroes are statically loaded to check if they are enabled through the config.
        return true;
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
    public String getFancyDescription() {
        return CC.GREEN + "A stealthy ninja.";
    }

    @Override
    public double getDifficulty() {
        return 3;
    }

    @Override
    public Ultimate getUltimate() {
        return dragonblade;
    }

    @Override
    public Map<Integer, Ability> getAbilities() {
        return abilities;
    }

    @Override
    public Set<Debuff> getDebuffs() {
        return null;
    }

    @Override
    public Set<Buff> getBuffs() {
        return null;
    }

    @Override
    public Set<Passive> getPassives() {
        return passives;
    }

    @Override
    public double getMaxHealth() {
        return 0;
    }
}
