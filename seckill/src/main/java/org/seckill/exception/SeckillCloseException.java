package org.seckill.exception;

/**
 * project:seckill
 * 
 * @author Daley 上午9:44:08 2016年12月22日 2016 秒杀关闭异常
 */
public class SeckillCloseException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6290425115435104747L;

	/**
	 * @param message
	 * @param cause
	 */
	public SeckillCloseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public SeckillCloseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
