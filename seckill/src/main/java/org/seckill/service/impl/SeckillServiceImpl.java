package org.seckill.service.impl;

import java.util.Date;
import java.util.List;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

/**
 * project:seckill
 * 
 * @author Daley 上午9:58:40 2016年12月22日 2016
 * 
 */
public class SeckillServiceImpl implements SeckillService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private SeckillDao seckillDao;
	private SuccessKilledDao successKilledDao;
	//用于混淆md5
	private final String slat="afghieuhfidda4nhnb haldvianlo";
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seckill.service.SeckillService#getSeckillList()
	 */
	public List<Seckill> getSeckillList() {
		return seckillDao.queryAll(0, 4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seckill.service.SeckillService#getById(long)
	 */
	public Seckill getById(long seckillId) {
		return seckillDao.queryById(seckillId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seckill.service.SeckillService#exportSeckillUrl(long)
	 */
	public Exposer exportSeckillUrl(long seckillId) {
		Seckill seckill = seckillDao.queryById(seckillId);
		if (seckill == null) {
			return new Exposer(false, seckillId);
		}
		Date startTime=seckill.getStartTime();
		Date endTime=seckill.getEndTime();
		Date nowTime=new Date();
		if(nowTime.getTime()<startTime.getTime()||nowTime.getTime()>endTime.getTime()){
			return new Exposer(false,seckillId,nowTime.getTime(),startTime.getTime(),endTime.getTime());
		}
		String md5=getMd5(seckillId);
		return new Exposer(true,md5,seckillId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.seckill.service.SeckillService#executeSeckill(long, long,
	 * java.lang.String)
	 */
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillException {
		return null;
	}
	//生成md5
	private String getMd5(long seckillId){
		String base=seckillId+'/'+slat;
		String md5=DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}
}
