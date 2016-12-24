package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
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
	int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

	/*
	 * 根据Id查询SuccessKilled并携带秒杀对象产品
	 */
	SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}
