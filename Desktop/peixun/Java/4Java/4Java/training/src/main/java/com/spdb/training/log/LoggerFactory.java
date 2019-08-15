package com.spdb.training.log;

/**
 * 日志工厂方法，所有需要日志记录的都使用此工厂获取
 * @author wanglw2
 *
 */

public class LoggerFactory {
	/**
	 * 获取日志记录的工厂方法
	 * @param clazz
	 * @return
	 */
	public static ILog getLogger(Class<?> clazz){
		ILog log = new SimpleLogger(clazz);
		return log;
	}
}
