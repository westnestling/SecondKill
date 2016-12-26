package org.seckill.dto;
/**
 * project:seckill
 * @author Daley 下午4:08:38 2016年12月25日 2016
 * 
 */
//所有ajax接口的返回类型,封装json结果
public class SeckillResult<T> {
	private boolean success;
	private T data;
	private String error;
	/**
	 * @param success
	 * @param data
	 */
	public SeckillResult(boolean success, T data) {
		super();
		this.success = success;
		this.data = data;
	}
	/**
	 * @param success
	 * @param error
	 */
	public SeckillResult(boolean success, String error) {
		super();
		this.success = success;
		this.error = error;
	}
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	
}
