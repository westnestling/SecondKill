package org.seckill.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * project:seckill
 * @author Daley 下午10:20:28 2016年12月20日 2016
 * 配置Spring和JUnit整合 ，JUnit启动时加载SpringIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉JUnitSpring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
	//注入Dao实现类依赖
	@Resource
	private SeckillDao seckillDao;
	
	@Test
	public void testReduceNumber() {
		Date killTime=new Date();
		int update=seckillDao.reduceNumber(1000L, killTime);
		System.out.println("修改行数："+update);
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
		List<Seckill> seckills=seckillDao.queryAll(0, 100);
		for(Seckill seckill:seckills){
			System.out.println(seckill);
		}
	}

}
