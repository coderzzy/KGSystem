package org.SpiderSystem.Web.util.transaction;

import org.SpiderSystem.Web.util.RuntimeInfo;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 爬虫事务,AOP类
 * @author zzy
 *
 */
public class SpiderTransaction {
    private static Logger logger = LoggerFactory.getLogger(SpiderTransaction.class);
	
    
	// 后置
	public void doAfter(JoinPoint jp) { 
        // System.out.println("log Ending method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());  
		// logger.info("---***log Ending method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName()+"***---");
		logger.info("可用内存为:  "+RuntimeInfo.getFreeMemory()+"MB");
		logger.info("全部内存为:  "+RuntimeInfo.getTotalMemory()+"MB");
		logger.info("可用最大内存为:  "+RuntimeInfo.getMaxMemory()+"MB");
		logger.info("可用处理器核心数量为:  "+RuntimeInfo.getAvailableProcessors());
    }  
    
	
	/*
	// 环绕
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {  
        long time = System.currentTimeMillis();  
        Object retVal = pjp.proceed();  
        time = System.currentTimeMillis() - time;  
        System.out.println("process time: " + time + " ms");  
        return retVal;  
    } 
    */ 
  
	
    // 前置
    public void doBefore(JoinPoint jp) {  
    	// System.out.println("-----------------------------------------------------------------");
        // System.out.println("log Begining method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
		// logger.info("---***log Begining method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName()+"***---");
    	logger.info("可用内存为:  "+RuntimeInfo.getFreeMemory()+"MB");
		logger.info("全部内存为:  "+RuntimeInfo.getTotalMemory()+"MB");
		logger.info("可用最大内存为:  "+RuntimeInfo.getMaxMemory()+"MB");
		logger.info("可用处理器核心数量为:  "+RuntimeInfo.getAvailableProcessors());
    }  
    
    
    /*
    // 环绕
    public void doThrowing(JoinPoint jp, Throwable ex) {  
        System.out.println("method " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + " throw exception");  
        System.out.println(ex.getMessage());  
    } 
    */ 
}
