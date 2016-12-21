package org.seckill.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * project:seckill
 * @author Daley 上午12:24:42 2016年12月21日 2016
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉JUnitSpring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class test {
	@Autowired
	private SeckillDao seckillDao;
	@Test
	public void testQueryById() {
		long id=1000;
		Seckill seckill=seckillDao.queryById(id);
		System.out.println(seckill.getName());
		System.out.println(seckill);
	}
}
