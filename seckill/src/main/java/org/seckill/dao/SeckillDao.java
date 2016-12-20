package org.seckill.dao;

import java.util.Date;
import java.util.List;

import org.seckill.entity.Seckill;

/**
 * project:seckill
 * @author Daley 下午11:53:07 2016年12月19日 2016
 *
 */
public interface SeckillDao {
	/*
	 * 减库存
	 *  @return 如果影响行数>1,表示更新的行数记录，0没有成功
	 */
	int reduceNumber(long seckillId,Date killTime);
	/*
	 * 根据id查询秒杀对象
	 */
	Seckill queryById(long seckillId);
	/*
	 * 根据偏移量查询商品列表
	 */
	List<Seckill> queryAll(int offset,int limit);
}
