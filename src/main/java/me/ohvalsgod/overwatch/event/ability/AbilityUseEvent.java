package me.ohvalsgod.overwatch.event.ability;

import me.ohvalsgod.overwatch.data.OverwatchPlayer;
import me.ohvalsgod.overwatch.hero.abilities.Ability;
import org.bukkit.event.Cancellable;

public class AbilityUseEvent extends AbilityEvent implements Cancellable {

    private boolean cancelled;

    public AbilityUseEvent(OverwatchPlayer player, Ability ability) {
        super(player, ability);
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }
}
