package me.ohvalsgod.overwatch.data;

import lombok.Getter;
import lombok.Setter;
import me.ohvalsgod.overwatch.Overwatch;
import me.ohvalsgod.overwatch.util.MongoUtil;
import org.bson.Document;

import java.util.UUID;

@Getter
public class OverwatchPlayer extends PlayerInfo {

    @Setter private boolean alive;

    public OverwatchPlayer(UUID uuid) {
        super(uuid, null);
    }

    private Document find() {
        return Overwatch.getInstance().getOverwatchMongo().getPlayers().find(MongoUtil.find("uuid", this.getUuid().toString())).first();

    }

}
