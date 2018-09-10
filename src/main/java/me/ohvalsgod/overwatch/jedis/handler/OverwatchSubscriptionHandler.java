package me.ohvalsgod.overwatch.jedis.handler;

import com.google.gson.JsonObject;
import me.ohvalsgod.overwatch.Overwatch;
import me.ohvalsgod.overwatch.jedis.JedisSubscriptionHandler;

public class OverwatchSubscriptionHandler implements JedisSubscriptionHandler {

    @Override
    public void handleMessage(JsonObject object) {
        OverwatchPayload payload;

        try {
            payload = OverwatchPayload.valueOf(object.get("payload").getAsString());
        } catch (IllegalArgumentException e) {
            //TODO: Check for other plugins (written by me) that might be using jedis and make sure that the payloads don't interfere with each other for spammy console messages
            return;
        }

        JsonObject data = object.get("data").getAsJsonObject();

        switch (payload) {
            case OVERWATCH_PAYLOAD_GAME_END: {

            }
            break;
        }
    }

}
