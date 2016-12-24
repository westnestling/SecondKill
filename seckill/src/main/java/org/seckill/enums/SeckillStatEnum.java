package org.seckill.enums;

/**
 * project:seckill
 * 
 * @author Daley 下午8:51:15 2016年12月23日 2016 使用枚举表示常量数据字段
 */
public enum SeckillStatEnum {
	SUCCESS(1, "秒杀成功"), END(0, "秒杀结束"), REPEAT_KILL(-1, "重复秒杀"), INNER_ERROR(2, "系统异常"), DATA_REWRITE(-3, "数据篡改");
	private int state;
	private String stateInfo;

	/**
	 * @param state
	 * @param stateInfo
	 */
	private SeckillStatEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @return the stateIndo
	 */
	public String getStateInfo() {
		return stateInfo;
	}

	public static SeckillStatEnum stateOf(int index) {
		for (SeckillStatEnum state : values()) {
			if (state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}
