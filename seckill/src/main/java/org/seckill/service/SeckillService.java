package org.seckill.service;

import java.util.List;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillException;

/**
 * project:seckill
 * 
 * @author Daley 下午7:36:46 2016年12月21日 2016 业务接口：站在使用者的角度设计接口
 *         三个方面：方法定义力度，参数，返回类型(类型/异常)
 * 
 */

public interface SeckillService {

	/**
	 * 查询所有秒杀记录
	 * 
	 * @param
	 * @return List<Seckill>
	 */
	List<Seckill> getSeckillList();

	/**
	 * 查询单个秒杀记录
	 * 
	 * @param
	 * @return Seckill
	 */
	Seckill getById(long seckillId);

	/**
	 * @Description: TODO 秒杀开启时 输出秒杀接口的地址 否则输出系统时间和秒杀时间
	 * @param
	 * @return Exposer
	 */
	Exposer exportSeckillUrl(long seckillId);

	/**
	 * @Description: TODO 执行秒杀操作
	 * @param
	 * @return void
	 */
	SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillException;
	
	/**
	 * @Description: TODO 执行秒杀操作 by存储过程
	 * @param
	 * @return void
	 */
	SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5);
}
