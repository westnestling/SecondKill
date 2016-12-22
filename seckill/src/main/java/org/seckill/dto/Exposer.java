package org.seckill.dto;
/**
 * project:seckill
 * @author Daley 下午9:42:55 2016年12月21日 2016
 * 暴露秒杀地址DTO（数据传输层）
 */
public class Exposer {
	//是否开启秒杀
	private boolean exposed;
	//一种加密措施
	private String md5;
	//id
	private long seckillId;
	//系统当前时间
	private long now;
	//开启时间
	private long start;
	//结束时间
	private long end;
	/**
	 * @param exposed
	 * @param md5
	 * @param seckillId
	 */
	public Exposer(boolean exposed, String md5, long seckillId) {
		super();
		this.exposed = exposed;
		this.md5 = md5;
		this.seckillId = seckillId;
	}
	/**
	 * @param exposed
	 * @param now
	 * @param start
	 * @param end
	 */
	public Exposer(boolean exposed, long now, long start, long end) {
		super();
		this.exposed = exposed;
		this.now = now;
		this.start = start;
		this.end = end;
	}
	/**
	 * @param exposed
	 * @param seckillId
	 */
	public Exposer(boolean exposed, long seckillId) {
		super();
		this.exposed = exposed;
		this.seckillId = seckillId;
	}
	/**
	 * @return the exposed
	 */
	public boolean isExposed() {
		return exposed;
	}
	/**
	 * @param exposed the exposed to set
	 */
	public void setExposed(boolean exposed) {
		this.exposed = exposed;
	}
	/**
	 * @return the md5
	 */
	public String getMd5() {
		return md5;
	}
	/**
	 * @param md5 the md5 to set
	 */
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	/**
	 * @return the seckillId
	 */
	public long getSeckillId() {
		return seckillId;
	}
	/**
	 * @param seckillId the seckillId to set
	 */
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}
	/**
	 * @return the now
	 */
	public long getNow() {
		return now;
	}
	/**
	 * @param now the now to set
	 */
	public void setNow(long now) {
		this.now = now;
	}
	/**
	 * @return the start
	 */
	public long getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(long start) {
		this.start = start;
	}
	/**
	 * @return the end
	 */
	public long getEnd() {
		return end;
	}
	/**
	 * @param end the end to set
	 */
	public void setEnd(long end) {
		this.end = end;
	}

	
}
