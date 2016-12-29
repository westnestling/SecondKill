package org.seckill.service;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * project:seckill
 * 
 * @author Daley 下午2:35:50 2016年12月24日 2016
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class SeckillServiceTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SeckillService seckillService;

	/**
	 * Test method for
	 * {@link org.seckill.service.SeckillService#getSeckillList()}.
	 */
	@Test
	public void testGetSeckillList() {
		List<Seckill> list = seckillService.getSeckillList();
		logger.info("list = {}", list);
	}

	/**
	 * Test method for {@link org.seckill.service.SeckillService#getById(long)}.
	 */
	@Test
	public void testGetById() {
		long id = 1000;
		Seckill seckill = seckillService.getById(id);
		logger.info("seckill = {}", seckill);
	}

	/**
	 * Test method for
	 * {@link org.seckill.service.SeckillService#exportSeckillUrl(long)}.
	 */
	@Test
	public void testExportSeckillUrl() {
		long id = 1000;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		logger.info("exposer={}", exposer);
		// exposer=Exposer [exposed=true, md5=27435e6a36e7580a6775a05f4462459f,
		// seckillId=1000, now=0, start=0, end=0]
	}

	/**
	 * Test method for
	 * {@link org.seckill.service.SeckillService#executeSeckill(long, long, java.lang.String)}
	 * .
	 */
	@Test
	public void testExecuteSeckill() {
		long id = 1000;
		long phone = 53445467857L;
		String md5 = "27435e6a36e7580a6775a05f4462459f";
		SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
		logger.info("seckillExecution= {}", seckillExecution);
	}

	// 集成测试代码完整逻辑，注意可重复执行秒杀
	@Test
	public void testSeckillLogic() throws Exception {
		long id = 1001;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		if (exposer.isExposed()) {
			logger.info("exposer={}", exposer);
			long phone = 23445467857L;
			String md5 = exposer.getMd5();
			try {
				SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
				logger.info("seckillExecution= {}", seckillExecution);
			} catch (RepeatKillException e) {
				logger.error(e.getMessage());
			} catch (SeckillCloseException e) {
				logger.error(e.getMessage());
			}
		}
		logger.warn("exposer={}", exposer);
	}

}
