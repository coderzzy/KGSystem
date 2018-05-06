package org.SpiderSystem.Web.util.transaction;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 所有Service事务,AOP类
 * @author zzy
 *
 */
public class AllServiceTransaction {
private static Logger logger = LoggerFactory.getLogger(AllServiceTransaction.class);
	
	// 后置
	public void doAfter(JoinPoint jp) { 
        // System.out.println("log Ending method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());  
		logger.info("---***log Ending method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName()+"***---");
    }  
  
	// 环绕
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {  
        long time = System.currentTimeMillis();  
        Object retVal = pjp.proceed();  
        time = System.currentTimeMillis() - time;  
        logger.info("process time: " + time + " ms");  
        return retVal;  
    }  
  
    // 前置
    public void doBefore(JoinPoint jp) {  
    	// System.out.println("-----------------------------------------------------------------");
        // System.out.println("log Begining method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
		logger.info("---***log Begining method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName()+"***---");
    }  
  
    public void doThrowing(JoinPoint jp, Throwable ex) {  
    	logger.error("method " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + " throw exception");  
    	logger.error(ex.getMessage());  
    }  
}