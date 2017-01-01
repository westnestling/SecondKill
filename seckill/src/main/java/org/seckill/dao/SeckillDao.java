package org.seckill.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

/**
 * project:seckill
 * 
 * @author Daley 下午11:53:07 2016年12月19日 2016
 *
 */
public interface SeckillDao {
	/*
	 * 减库存
	 * 
	 * @return 如果影响行数>1,表示更新的行数记录，0没有成功
	 */
	int reduceNumber(@Param("seckillId")long seckillId,@Param("killTime") Date killTime);

	/*
	 * 根据id查询秒杀对象
	 */
	Seckill queryById(long seckillId);

	/*
	 * 根据偏移量查询商品列表
	 * 
	 */
	//org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.binding.BindingException: Parameter 'offset' not found. Available parameters are [0, 1, param1, param2]
	//Caused by: org.apache.ibatis.binding.BindingException: Parameter 'offset' not found. Available parameters are [0, 1, param1, param2]
	//java没有保存形参的记录，queryAll(int offset, int limit)会变为——>queryAll(arg0，arg1)

	List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);
	
	/**
	 * 使用存储过程执行秒杀
	 */
	void killByProcedure(Map<String,Object> paramMap);
}
