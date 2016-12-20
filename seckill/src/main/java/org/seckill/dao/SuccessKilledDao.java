package org.seckill.dao;

import org.seckill.entity.SuccessKilled;

/**
 * project:seckill
 * 
 * @author Daley 上午9:13:55 2016年12月20日 2016
 *
 */
public interface SuccessKilledDao {
	/*
	 * 插入购买明细,可过滤重复秒杀
	 * 
	 * @return 插入的行数
	 */
	int insertSuccessKilled(long seckillId, long userPhone);

	/*
	 * 根据Id查询SuccessKilled并携带秒杀对象产品
	 */
	SuccessKilled queryByIdWithSeckill(long seckillId);
}
