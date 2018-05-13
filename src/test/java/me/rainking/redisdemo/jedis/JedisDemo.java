package me.rainking.redisdemo.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
        System.out.println("服务正在运行: " + jedis.ping());
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

    /**
     * 使用数据结构List
     */
    @Test
    public void RedisList() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0, 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 使用命令Keys
     */
    @Test
    public void RedisKey() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
    }


}
