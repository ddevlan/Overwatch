package me.ohvalsgod.overwatch.jedis.handler;

import com.google.gson.JsonObject;
import me.ohvalsgod.overwatch.Overwatch;
import me.ohvalsgod.overwatch.jedis.JedisSubscriptionHandler;

public class OverwatchSubscriptionHandler implements JedisSubscriptionHandler {

    /*

        //  Write

    Basic.getInstance().getBasicJedis().write(
            BasicPayload.STAFF_CONNECTION,
                    new JsonChain()
                            .addProperty("player_name", player.getName())
            .addProperty("server_id", Basic.getInstance().getBasicConfig().getServerId())
            .addProperty("connection_context", "&ajoined")
                            .get()
            );


        //  Read

    final String serverId = data.get("server_id").getAsString();
    final String playerName = data.get("player_name").getAsString();
    final String context = data.get("connection_context").getAsString();

    Basic.getOnlineStaff().forEach(player -> player.sendMessage(
        STAFF_CONNECTION
            .replace("{player_name}", playerName)
            .replace("{server_id}", serverId)
            .replace("{connection_context}", CC.translate(context))
            ));

    */

    @Override
    public void handleMessage(JsonObject object) {
        OverwatchPayload payload;

        try {
            payload = OverwatchPayload.valueOf(object.get("payload").getAsString());
        } catch (IllegalArgumentException e) {
            Overwatch.getInstance().getLogger().warning("Received a payload-type that could not be parsed");
            return;
        }

        JsonObject data = object.get("data").getAsJsonObject();

        switch (payload) {
            case TEST_PAYLOAD: {
                System.out.println("Success!");
            }
            break;
        }
    }

}
