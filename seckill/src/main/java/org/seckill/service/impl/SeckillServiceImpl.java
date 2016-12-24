package org.seckill.service.impl;

import java.util.Date;
import java.util.List;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

/**
 * project:seckill
 * 
 * @author Daley 上午9:58:40 2016年12月22日 2016
 * 
 */
@Service
public class SeckillServiceImpl implements SeckillService {
	// 日志对象
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//注入Service依赖
	@Autowired
	private SeckillDao seckillDao;
	@Autowired
	private SuccessKilledDao successKilledDao;
	// 用于混淆md5
	private final String slat = "afghieuhfidda4nhnb haldvianlo";

	/**
	 * 查询单个所有记录
	 * @see org.seckill.service.SeckillService#getSeckillList()
	 */
	public List<Seckill> getSeckillList() {
		return seckillDao.queryAll(0, 4);
	}

	/**
	 * 查询单个秒杀记录
	 * @see org.seckill.service.SeckillService#getById(long)
	 */
	public Seckill getById(long seckillId) {
		return seckillDao.queryById(seckillId);
	}

	/**
	 * 秒杀开启时 输出秒杀接口的地址 否则输出系统时间和秒杀时间
	 * @see org.seckill.service.SeckillService#exportSeckillUrl(long)
	 */
	public Exposer exportSeckillUrl(long seckillId) {
		Seckill seckill = seckillDao.queryById(seckillId);
		if (seckill == null) {
			return new Exposer(false, seckillId);
		}
		Date startTime = seckill.getStartTime();
		Date endTime = seckill.getEndTime();
		Date nowTime = new Date();
		if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
			return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
		}
		String md5 = getMd5(seckillId);
		return new Exposer(true, md5, seckillId);
	}

	/**
	 * 执行秒杀操作
	 * @see org.seckill.service.SeckillService#executeSeckill(long, long,
	 * java.lang.String)
	 */
	@Transactional
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillException {
		// 验证md5是否可用
		if (md5 == null || !md5.equals(getMd5(seckillId))) {
			throw new SeckillException("Seckill data has been rewrite");
		}
		// 执行秒杀逻辑：减库存 + 记录购买行为
		Date nowTime = new Date();
		try {
			int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
			if (updateCount <= 0) {
				// 秒杀结束
				throw new SeckillCloseException("Seckill is Closed");
			} else {
				// 记录购买行为
				int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
				if (insertCount <= 0) {
					throw new RepeatKillException("Seckill repeated");
				} else {
					SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
					return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
				}
			}
		} catch (SeckillCloseException e1) {
			throw e1;
		} catch (RepeatKillException e2) {
			throw e2;
		} catch (Exception e) {

			logger.error(e.getMessage(), e);
			// 所有编译期异常转化为运行期异常
			throw new SeckillException("" + e.getMessage());
		}

	}

	// 生成md5
	private String getMd5(long seckillId) {
		String base = seckillId + '/' + slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}
}
