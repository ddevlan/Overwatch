package me.ohvalsgod.overwatch.jedis;

import redis.clients.jedis.Jedis;

public interface RedisCommand<T> {

    T execute(Jedis redis);

}
