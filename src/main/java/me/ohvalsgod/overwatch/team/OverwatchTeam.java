package me.ohvalsgod.overwatch.team;

import lombok.Getter;
import me.ohvalsgod.overwatch.data.OverwatchPlayer;
import me.ohvalsgod.overwatch.util.team.TeamPlayer;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OverwatchTeam<T extends OverwatchPlayer> {

    private List<T> teamPlayers;

    public OverwatchTeam() {
        this.teamPlayers = new ArrayList<>();
    }

    public boolean containsPlayer(Player player) {
        for (OverwatchPlayer overwatchPlayer : this.teamPlayers) {
            if (overwatchPlayer.getUuid().equals(player.getUniqueId())) {
                return true;
            }
        }

        return false;
    }

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();

        this.teamPlayers.forEach(matchPlayer -> {
            Player player = matchPlayer.toPlayer();

            if (player != null) {
                players.add(player);
            }
        });

        return players;
    }

    /**
     * Returns a list of objects that extend {@link TeamPlayer} whose
     * {@link TeamPlayer#isAlive()} returns true.
     *
     * @return A list of team players that are alive.
     */
    public List<T> getAliveTeamPlayers() {
        List<T> alive = new ArrayList<>();

        this.teamPlayers.forEach(teamPlayer -> {
            if (teamPlayer.isAlive()) {
                alive.add(teamPlayer);
            }
        });

        return alive;
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
        int alive = 0;

        for (OverwatchPlayer overwatchPlayer : this.teamPlayers) {
            if (overwatchPlayer.isAlive()) {
                alive++;
            }
        }

        return alive;
    }

    /**
     * Returns a list of objects that extend {@link OverwatchPlayer} whose
     * {@link OverwatchPlayer#isAlive()} returns false.
     *
     * @return A list of overwatch players that are dead.
     */
    public List<T> getDeadTeamPlayers() {
        List<T> dead = new ArrayList<>();

        this.teamPlayers.forEach(teamPlayer -> {
            if (!teamPlayer.isAlive()) {
                dead.add(teamPlayer);
            }
        });

        return dead;
    }

    /**
     * Subtracts the result of {@code getAliveCount} from the size
     * of the {@code overwatchPlayers} list.
     *
     * @return The count of team players that are dead.
     */
    public int getDeadCount() {
        return this.teamPlayers.size() - this.getAliveCount();
    }

    public void broadcast(String message) {
        this.getPlayers().forEach(player -> player.sendMessage(message));
    }

    public void broadcast(List<String> messages) {
        messages.forEach(this::broadcast);
    }

    public void broadcastComponents(List<BaseComponent[]> components) {
        this.getPlayers().forEach(player -> components.forEach(array -> player.spigot().sendMessage(array)));
    }

}
