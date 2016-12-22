package org.seckill.exception;
/**
 * project:seckill
 * @author Daley 上午9:39:43 2016年12月22日 2016
 * 重复秒杀异常（运行期异常）
 */
public class RepeatKillException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8397838588376825183L;

	/**
	 * @param message
	 * @param cause
	 */
	public RepeatKillException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public RepeatKillException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
