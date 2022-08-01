package cn.edu.whut.binary.health.provider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-31 23:01 Sunday
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JedisTest {
    @Autowired
    private JedisPool jedisPool;

    @Test
    public void jedisPoolTest() {
        Jedis jedis = jedisPool.getResource();
        jedis.set("username", "Spring-_-Bear");
        System.out.println(jedis.get("username"));
        jedis.close();
    }
}
