package me.ohvalsgod.overwatch.match;

import lombok.Getter;
import me.ohvalsgod.overwatch.map.OverwatchMap;
import me.ohvalsgod.overwatch.team.OverwatchTeam;

@Getter
public class OverwatchMatch {

    private OverwatchMap previousMap, currentMap, upcomingMap;
    private OverwatchTeam teamA, teamB;


    public OverwatchMatch() {
        this.teamA = new OverwatchTeam();
        this.teamB = new OverwatchTeam();
    }

}
