package me.ohvalsgod.overwatch.hero.heroes.genji.abilities;

import me.ohvalsgod.overwatch.hero.abilities.Passive;
import me.ohvalsgod.overwatch.util.CC;
import me.ohvalsgod.overwatch.util.cooldown.Cooldown;
import org.bukkit.entity.Player;

public class CyberAgility implements Passive {

    @Override
    public Runnable run() {
        return null;
    }

    @Override
    public String getName() {
        return "Cyber Agility";
    }

    @Override
    public String getFancyName() {
        return CC.GREEN + "Cyber Agility";
    }

    @Override
    public String getDescription() {
        return "Allows Genji to climb walls and double jump.";
    }

    @Override
    public String getFancyDescription() {
        return CC.GREEN + "Allows Genji to climb walls and double jump.";
    }

    @Override
    public void cast(Player player) {

    }

    @Override
    public Cooldown getCooldown() {
        return null;
    }

}
