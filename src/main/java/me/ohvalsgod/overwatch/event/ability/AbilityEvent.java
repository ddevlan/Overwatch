package me.ohvalsgod.overwatch.event.ability;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.ohvalsgod.overwatch.data.OverwatchPlayer;
import me.ohvalsgod.overwatch.hero.abilities.Ability;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@AllArgsConstructor
public class AbilityEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();

    @Getter private OverwatchPlayer player;
    @Getter private Ability ability;

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
