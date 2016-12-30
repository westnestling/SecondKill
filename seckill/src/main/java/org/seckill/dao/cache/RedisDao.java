package org.seckill.dao.cache;

import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.protostuff.runtime.RuntimeSchema;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * project:seckill
 * @author Daley 下午5:39:43 2016年12月30日 2016
 * 
 */
public class RedisDao {
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	private final JedisPool jedisPool;
	private RuntimeSchema<Seckill> schema=RuntimeSchema.createFrom(Seckill.class);
	private RedisDao(String ip,int port){
		jedisPool = new JedisPool(ip,port);
	}
	
	public Seckill getSeckill(long seckillId){
		//Redis操作逻辑
		try {
			Jedis jedis=jedisPool.getResource();
			try {
				String key="seckill:"+seckillId;
				//并没有实现内部序列化操作
				//get->bytes[]->反序列化->Object(Seckill)
				//采用自定义反序列化 protostuff:pojo
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				jedis.close();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return null;
		
	}
	
	public String putSeckill(Seckill seckill){
		return null;
		
	}
}
