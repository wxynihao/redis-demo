package me.rainking.redisdemo.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Rain
 * @description
 * @date 2018/5/13
 */
public class JedisDemo {

    /**
     * 基本使用
     */
    @Test
    public void basicUse() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("name", "rain");
        String val = jedis.get("name");
        System.out.println(val);
        jedis.close();
    }


    /**
     * 使用连接池
     */
    @Test
    public void poolUse() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(30);
        config.setMaxIdle(10);

        JedisPool jedisPool = new JedisPool(config, "127.0.0.1", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("date", "5/18");
        String val = jedis.get("name");
        System.out.println(val);
        jedis.close();
        jedisPool.close();
    }
}
