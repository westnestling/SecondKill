package org.seckill.dao;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * project:seckill
 * 
 * @author Daley 下午5:16:01 2016年12月21日 2016 配置Spring和JUnit整合
 *         ，JUnit启动时加载SpringIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉JUnitSpring配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class SuccessKilledTest {
	@Resource
	private SuccessKilledDao successKilledDao;

	/**
	 * Test method for
	 * {@link org.seckill.dao.SuccessKilledDao#insertSuccessKilled(long, long)}.
	 */
	@Test
	public void testInsertSuccessKilled() {
		long id = 1001L;
		long phone = 13124584638L;
		int insertCount = successKilledDao.insertSuccessKilled(id, phone);
		System.out.println("affect lines:" + insertCount);
	}

	/**
	 * Test method for
	 * {@link org.seckill.dao.SuccessKilledDao#queryByIdWithSeckill(long)}.
	 */
	@Test
	public void testQueryByIdWithSeckill() {
		long id = 1001L;
		long phone = 13124584638L;
		SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
		System.out.println(successKilled);
		if (successKilled != null) {
			System.out.println(successKilled.getSeckill());
		}
	}

}
