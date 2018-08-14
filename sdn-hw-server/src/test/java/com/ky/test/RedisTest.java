package com.ky.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.Transaction;

/*
 *作者：barret
 *日期：2018年2月1日
 *
*/

public class RedisTest {

	public void test(){
		Jedis jedis = new Jedis("192.168.100.74", 6379);
		jedis.auth("12345678");
	}
	
	/**
	 * 简单同步方式
	 */
	@Test
	public void test1Normal(){
		Jedis jedis = new Jedis("192.168.100.74", 6379);
		jedis.auth("12345678");
		long start = System.currentTimeMillis();
		for(int i = 0;i<100000;i++){
			String result = jedis.set("n"+i, "n"+i);
		}
		long end = System.currentTimeMillis();
		System.out.println("Simple SET: " + ((end - start)/1000.0) + " seconds");
		jedis.disconnect();
	}
	
	/**
	 * 事务方式
	 * jedis.watch()可以监控key,如果调用后key值发生变化，则整个事务会执行失败，
	 * 事务中某个操作失败，并不会回滚其他操作
	 */
	@Test
	public void test2Trans(){
		Jedis jedis = new Jedis("192.168.100.74", 6379);
		jedis.auth("12345678");
		jedis.select(2);
		long start = System.currentTimeMillis();
		Transaction tx = jedis.multi();
		for(int i = 0;i<100000;i++){
			tx.set("t"+i, "t"+i);
		}
		List<Object> results = tx.exec();
		System.out.println("results:"+results);
		long end = System.currentTimeMillis();
		System.out.println("Transaction SET: " + ((end - start)/1000.0) + " seconds");
		jedis.disconnect();
	}
	
	/**
	 * 管道
	 * 异步方式，一次发送多个指令，不同步等待其返回结果，
	 */
	@Test
	public void test3Pipelined(){
		Jedis jedis = new Jedis("192.168.100.74", 6379);
		jedis.auth("12345678");
		jedis.select(1);
		Pipeline pipeline = jedis.pipelined();
		for(int i = 0;i<10000;i++){
			pipeline.set("p"+i, "p"+i);
		}
		List<Object> result = pipeline.syncAndReturnAll();
		System.out.println("result:"+result);
		jedis.disconnect();
	}
	
	/**
	 * 管道中调用事务
	 * 测试发现效率和单独使用事务差不多，甚至还略微差点
	 */
	@Test
	public void test4combPipelineTrans(){
		Jedis jedis = new Jedis("192.168.100.74", 6379);
		jedis.auth("12345678");
		jedis.select(4);
		Pipeline pipeline = jedis.pipelined();
		pipeline.multi();
		for(int i = 0;i<100;i++){
			pipeline.set(""+i, ""+i);
		}
		pipeline.exec();
		List<Object> result = pipeline.syncAndReturnAll();
		System.out.println("result:"+result);
		jedis.disconnect();
	}
	
	/**
	 * 分布式直连同步调用
	 * 
	 */
	@Test
	public void test5shardNormal(){
		//设置连接池的相关配置
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(2);
        poolConfig.setMaxIdle(1);
        poolConfig.setMaxWaitMillis(2000);
        poolConfig.setTestOnBorrow(false);
        poolConfig.setTestOnReturn(false);
        
        //设置Redis信息
        JedisShardInfo shardInfo1 = new JedisShardInfo("192.168.100.74", 6379, 500);
        shardInfo1.setPassword("12345678");
        JedisShardInfo shardInfo2 = new JedisShardInfo("192.168.100.65", 6379, 500);
        shardInfo2.setPassword("kaiyuan");
        
        //初始化ShardedJedisPool
        List<JedisShardInfo> infoList = Arrays.asList(shardInfo1, shardInfo2);
        ShardedJedisPool jedisPool = new ShardedJedisPool(poolConfig, infoList);
		
        //进行查询等其他操作
        ShardedJedis jedis = null;
        try {
        	jedis = jedisPool.getResource();
        	jedis.set("test", "test");
        	jedis.set("test1", "test1");
        	String test = jedis.get("test");
        	System.out.println(test);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//使用后一定关闭，还给连接池
			if(jedis != null){
				jedis.close();
			}
		}
	}
	
	
}
