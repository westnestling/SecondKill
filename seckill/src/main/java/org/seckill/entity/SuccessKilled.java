package org.seckill.entity;

import java.util.Date;

/**
 * project:seckill
 * 
 * @author Daley 下午11:10:28 2016年12月19日 2016
 *
 */
public class SuccessKilled {
	private long seckillId;
	private long userPhone;
	private short state;
	private Date createTime;
	private Seckill seckill;

	/**
	 * @return the seckillId
	 */
	public long getSeckillId() {
		return seckillId;
	}

	/**
	 * @param seckillId
	 *            the seckillId to set
	 */
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	/**
	 * @return the userPhone
	 */
	public long getUserPhone() {
		return userPhone;
	}

	/**
	 * @param userPhone
	 *            the userPhone to set
	 */
	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	/**
	 * @return the state
	 */
	public short getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(short state) {
		this.state = state;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the seckill
	 */
	public Seckill getSeckill() {
		return seckill;
	}

	/**
	 * @param seckill
	 *            the seckill to set
	 */
	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SuccessKilled [seckillId=" + seckillId + ", userPhone=" + userPhone + ", state=" + state
				+ ", createTime=" + createTime + ", seckill=" + seckill + "]";
	}

}
