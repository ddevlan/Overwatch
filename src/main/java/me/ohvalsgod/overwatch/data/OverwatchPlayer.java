package me.ohvalsgod.overwatch.data;

import com.mongodb.client.MongoCollection;
import lombok.Getter;
import lombok.Setter;
import me.ohvalsgod.overwatch.Overwatch;
import me.ohvalsgod.overwatch.mongo.OverwatchMongo;
import me.ohvalsgod.overwatch.util.MongoUtil;
import org.bson.Document;

import java.util.UUID;

@Getter
public class OverwatchPlayer extends PlayerInfo {

    @Setter private boolean alive;

    private final Overwatch overwatch = Overwatch.getInstance();
    private final OverwatchMongo mongo = overwatch.getOverwatchMongo();
    private final MongoCollection<Document> players = mongo.getPlayers();

    public OverwatchPlayer(UUID uuid) {
        super(uuid, null);
    }

    private Document find() {
        //Let's make this code a little more readable.
        Document document = players.find(MongoUtil.find("uuid", getUuid().toString())).first();
        return document;
    }

}
