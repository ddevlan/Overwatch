package me.ohvalsgod.overwatch.jedis;

import com.google.gson.JsonObject;
import lombok.Getter;

import me.ohvalsgod.overwatch.Overwatch;
import me.ohvalsgod.overwatch.jedis.handler.OverwatchPayload;
import me.ohvalsgod.overwatch.jedis.handler.OverwatchSubscriptionHandler;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Getter
public class OverwatchJedis {

    private JedisSettings settings;
    private JedisPool pool;
    private JedisPublisher publisher;
    private JedisSubscriber subscriber;

    public OverwatchJedis(JedisSettings settings) {
        this.settings = settings;
        this.pool = new JedisPool(this.settings.getAddress(), this.settings.getPort());

        try (Jedis jedis = this.pool.getResource()) {
            if (this.settings.hasPassword()) {
                jedis.auth(this.settings.getPassword());
            }

            this.publisher = new JedisPublisher(this.settings);
            this.subscriber = new JedisSubscriber("overwatch", this.settings, new OverwatchSubscriptionHandler());
        }
    }

    public boolean isActive() {
        return this.pool != null && !this.pool.isClosed();
    }

    public void write(OverwatchPayload payload, JsonObject data) {
        JsonObject object = new JsonObject();

        object.addProperty("payload", payload.name());
        object.add("data", data == null ? new JsonObject() : data);

        this.publisher.write("overwatch", object);
    }

    public <T> T runCommand(RedisCommand<T> redisCommand) {
        Jedis jedis = this.pool.getResource();
        T result = null;

        try {
            result = redisCommand.execute(jedis);
        } catch (Exception e) {
            e.printStackTrace();

            if (jedis != null) {
                this.pool.returnBrokenResource(jedis);
                jedis = null;
            }
        } finally {
            if (jedis != null) {
                this.pool.returnResource(jedis);
            }
        }

        return result;
    }

    public static OverwatchJedis getInstance() {
        return Overwatch.getInstance().getOverwatchJedis();
    }

}
