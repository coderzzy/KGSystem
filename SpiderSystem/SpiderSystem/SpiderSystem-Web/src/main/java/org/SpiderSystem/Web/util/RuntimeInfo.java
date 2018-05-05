package org.SpiderSystem.Web.util;


/**
 * JVM后台运行信息获取(内存,CPU等)
 * @author zzy
 *
 */
public class RuntimeInfo {
	
	/**
	 * 获取可用内存,单位MB
	 * @return
	 */
	public static long getFreeMemory(){
		return Runtime.getRuntime().freeMemory()/1024/1024;
	}
	
	
	/**
	 * 获取总内存,单位MB
	 * @return
	 */
	public static long getTotalMemory(){
		return Runtime.getRuntime().totalMemory()/1024/1024;
	}
	
	
	/**
	 * 获取可用最大内存,单位MB
	 * @return
	 */
	public static long getMaxMemory(){
		return Runtime.getRuntime().maxMemory()/1024/1024;
	}
	
	
	/**
	 * 获取jvm可用的处理器核心的数量
	 * @return
	 */
	public static int getAvailableProcessors() {
	    return Runtime.getRuntime().availableProcessors();
	}
	
	
	/**
	 * 执行系统命令
	 */
	public static void commend() {
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("calc");
            // Process process = runtime.exec("calc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
