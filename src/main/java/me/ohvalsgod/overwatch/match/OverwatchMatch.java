package me.ohvalsgod.overwatch.match;

import lombok.Getter;
import me.ohvalsgod.overwatch.map.OverwatchMap;
import me.ohvalsgod.overwatch.team.OverwatchTeam;

import java.util.List;

@Getter
public class OverwatchMatch {

    private OverwatchMap previousMap, currentMap, upcomingMap;
    private List<OverwatchTeam> teams;

    //Just in case we want more teams.

    public OverwatchMatch() {

    }

}
