package org.seckill.dao.cache;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.SeckillDao;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * project:seckill
 * 
 * @author Daley 下午11:22:47 2016年12月31日 2016
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉JUnitSpring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class RedisDaoTest {
	private long id = 1001;
	@Autowired
	private SeckillDao seckillDao;

	/**
	 * Test method for {@link org.seckill.dao.cache.RedisDao#getSeckill(long)}.
	 */
	@Autowired
	private RedisDao redisDao;

	@Test
	public void testSeckill() throws Exception {
		Seckill seckill = redisDao.getSeckill(id);
		if (seckill == null) {
			seckill = seckillDao.queryById(id);
			if (seckill != null) {
				String result = redisDao.putSeckill(seckill);
				System.out.println(result);
				seckill = redisDao.getSeckill(id);
				System.out.println(seckill);
			}
		}
	}

}
