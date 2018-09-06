package me.ohvalsgod.overwatch.jedis;

import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import me.ohvalsgod.overwatch.Overwatch;
import org.apache.commons.lang3.Validate;

@RequiredArgsConstructor
public class JedisPublisher {

	private final JedisSettings jedisSettings;

	public void write(String channel, JsonObject payload) {
		Validate.notNull(Overwatch.getInstance().getOverwatchJedis().getPool());

		Overwatch.getInstance().getOverwatchJedis().runCommand(redis -> {
			if (jedisSettings.hasPassword()) {
				redis.auth(jedisSettings.getPassword());
			}

			redis.publish(channel, payload.toString());

			return null;
		});
	}

}
