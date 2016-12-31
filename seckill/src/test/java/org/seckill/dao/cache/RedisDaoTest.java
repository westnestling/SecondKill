package org.seckill.dao.cache;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * project:seckill
 * @author Daley 下午11:22:47 2016年12月31日 2016
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉JUnitSpring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RedisDaoTest{

	/**
	 * Test method for {@link org.seckill.dao.cache.RedisDao#getSeckill(long)}.
	 */
	@Test
	public void testGetSeckill() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.seckill.dao.cache.RedisDao#putSeckill(org.seckill.entity.Seckill)}.
	 */
	@Test
	public void testPutSeckill() {
		fail("Not yet implemented");
	}
	
}
