package redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class TestRedis {
	@Test
	public void redis() {
		Jedis jedis = new Jedis("192.168.138.21", 6379);
		String name = jedis.get("name");
		System.out.println(name);
	}
}
