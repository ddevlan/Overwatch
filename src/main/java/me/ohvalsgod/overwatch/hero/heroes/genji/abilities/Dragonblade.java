package me.ohvalsgod.overwatch.hero.heroes.genji.abilities;

import lombok.Getter;
import lombok.Setter;
import me.ohvalsgod.overwatch.hero.abilities.Ultimate;
import me.ohvalsgod.overwatch.util.CC;
import me.ohvalsgod.overwatch.util.cooldown.Cooldown;
import org.bukkit.entity.Player;

@Getter
public class Dragonblade implements Ultimate {

    @Setter private int currentPoints;

    public Dragonblade() {
        this.currentPoints = 0;
    }

    @Override
    public int getCost() {
        return 1500;
    }

    @Override
    public int getCurrentPoints() {
        return currentPoints;
    }

    @Override
    public void addPoints(int i) {
        this.currentPoints = currentPoints+i;
    }

    @Override
    public String getName() {
        return "Dragonblade";
    }

    @Override
    public String getFancyName() {
        return CC.GREEN + CC.BOLD + getName();
    }

    @Override
    public String getDescription() {
        return "Unsheathe a deadly melee weapon.";
    }

    @Override
    public String getFancyDescription() {
        return CC.GRAY + getDescription();
    }

    @Override
    public void cast(Player player) {

    }

    @Override
    public Cooldown getCooldown() {
        return null;
    }
}
