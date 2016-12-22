package org.seckill.exception;
/**
 * project:seckill
 * @author Daley 上午9:46:16 2016年12月22日 2016
 * 
 */
public class SeckillException extends RuntimeException{

	/**
	 * @param message
	 * @param cause
	 */
	public SeckillException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public SeckillException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
