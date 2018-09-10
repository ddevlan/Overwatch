package me.ohvalsgod.overwatch.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import me.ohvalsgod.overwatch.Overwatch;
import me.ohvalsgod.overwatch.util.config.ConfigCursor;
import org.bson.Document;

import java.util.Collections;

@Getter
public class OverwatchMongo {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> players;

    private static OverwatchMongo overwatchMongo;

    public OverwatchMongo() {
        overwatchMongo = this;
        ConfigCursor cursor = new ConfigCursor(Overwatch.getInstance().getMainFileConfig(), "database.mongo");

        //What the fuck? No, no no no.
        //This is better.

        String[] neededPaths = new String[]{
                "host",
                "port",
                "database",
                "authentication.enabled",
                "authentication.username",
                "authentication.password",
                "authentication.database"
        };

        for (String s : neededPaths)
            if (!cursor.exists(s)) {
                throw new RuntimeException("Missing configuration option");
            }

        if (cursor.getBoolean("authentication.enabled")) {
            final MongoCredential credential = MongoCredential.createCredential(
                    cursor.getString("authentication.username"),
                    cursor.getString("authentication.database"),
                    cursor.getString("authentication.password").toCharArray()
            );

            this.client = new MongoClient(new ServerAddress(cursor.getString("host"), cursor.getInt("port")), Collections.singletonList(credential));
        } else {
            this.client = new MongoClient(new ServerAddress(cursor.getString("host"), cursor.getInt("port")));
        }

        this.database = this.client.getDatabase("overwatch");
        this.players = this.database.getCollection("players");
    }

    public static OverwatchMongo getInstance() {
        return overwatchMongo;
    }

}
