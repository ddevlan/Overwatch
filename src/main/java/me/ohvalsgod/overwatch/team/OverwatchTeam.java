package me.ohvalsgod.overwatch.team;

import lombok.Getter;
import me.ohvalsgod.overwatch.data.OverwatchPlayer;
import me.ohvalsgod.overwatch.util.team.TeamPlayer;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
public class OverwatchTeam<T extends OverwatchPlayer> {

    private List<T> teamPlayers;

    public OverwatchTeam() {
        this.teamPlayers = new ArrayList<>();
    }

    public boolean containsPlayer(Player player) {
        return teamPlayers.stream().anyMatch(owPlayer -> owPlayer.getUuid().equals(player.getUniqueId()));
    }

    public List<Player> getPlayers() {
        return this.teamPlayers.stream().map(T::toPlayer).filter(Objects::nonNull).collect(Collectors.toList());
    }

    /**
     * Returns a list of objects that extend {@link TeamPlayer} whose
     * {@link TeamPlayer#isAlive()} returns true.
     *
     * @return A list of team players that are alive.
     */
    public List<T> getAliveTeamPlayers() {
        return this.teamPlayers.stream().filter(OverwatchPlayer::isAlive).collect(Collectors.toList());
    }

    /**
     * Returns an integer that is incremented for each {@link TeamPlayer}
     * element in the {@code teamPlayers} list whose {@link TeamPlayer#isAlive()}
     * returns true.
     *
     * Use this method rather than calling {@link List#size()} on
     * the result of {@code getAliveTeamPlayers}.
     *
     * @return The count of team players that are alive.
     */
    public int getAliveCount() {

        //lel what was all that code about
        return getAliveTeamPlayers().size();
    }

    /**
     * Returns a list of objects that extend {@link OverwatchPlayer} whose
     * {@link OverwatchPlayer#isAlive()} returns false.
     *
     * @return A list of overwatch players that are dead.
     */
    public List<T> getDeadTeamPlayers() {
        return this.teamPlayers.stream().filter(t -> !t.isAlive()).collect(Collectors.toList());
    }

    /**
     * Subtracts the result of {@code getAliveCount} from the size
     * of the {@code overwatchPlayers} list.
     *
     * @return The count of team players that are dead.
     */
    public int getDeadCount() {
        //that's a lot better.
        return getDeadTeamPlayers().size();
    }

    public void broadcast(String message) {
        this.getPlayers().forEach(player -> player.sendMessage(message));
    }

    public void broadcast(List<String> messages) {
        messages.forEach(this::broadcast);
    }

    public void broadcastComponents(List<BaseComponent[]> components) {
        //Nested lambdas are ugly and aren't considered nice. Don't use them.
        for (Player player : this.getPlayers()) {
            components.forEach(array -> player.spigot().sendMessage(array));
        }
    }

}
