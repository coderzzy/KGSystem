package org.SpiderSystem.Web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuntimeInfo {
	private static Logger logger = LoggerFactory.getLogger(RuntimeInfo.class);

	/**
	 * 获取当前jvm的内存信息,返回的值是 字节为单位
	 */
	public static void getFreeMemory() {
	    //获取可用内存
	    long value = Runtime.getRuntime().freeMemory();
	    // System.out.println("可用内存为:"+value/1024/1024+"mb");
	    logger.info("可用内存为:  "+value/1024/1024+"mb");
	    //获取jvm的总数量，该值会不断的变化
	    long  totalMemory = Runtime.getRuntime().totalMemory();
	    // System.out.println("全部内存为:"+totalMemory/1024/1024+"mb");
	    logger.info("全部内存为:  "+totalMemory/1024/1024+"mb");
	    //获取jvm 可以最大使用的内存数量，如果没有被限制 返回 Long.MAX_VALUE;
	    long maxMemory = Runtime.getRuntime().maxMemory();
	    // System.out.println("可用最大内存为:"+maxMemory/1024/1024+"mb");
	    logger.info("可用最大内存为:  "+maxMemory/1024/1024+"mb");
	}
	
	/**
	 * 获取jvm可用的处理器核心的数量
	 */
	public static void getAvailableProcessors() {
	    int value = Runtime.getRuntime().availableProcessors();
	    // System.out.println(value);
	    logger.info("可用处理器核心数量为:  "+value);
	}
	
	/**
	 * 执行系统命令
	 */
	public static void commend() {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("calc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
