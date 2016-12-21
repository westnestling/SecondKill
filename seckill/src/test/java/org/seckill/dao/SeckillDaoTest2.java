package org.seckill.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * project:seckill
 * @author Daley 下午10:20:28 2016年12月20日 2016
 * 配置Spring和JUnit整合 ，JUnit启动时加载SpringIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉JUnitSpring配置文件
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest2 {
	//注入Dao实现类依赖
	@Resource
	private SeckillDao seckillDao;
	
	@Test
	public void testReduceNumber() {
		
	}

	
	@Test
	public void testQueryById() {
		long id=1000;
		Seckill seckill=seckillDao.queryById(id);
		System.out.println(seckill.getName());
		System.out.println(seckill);
	}

	
	@Test
	public void testQueryAll() {
		
	}

}
