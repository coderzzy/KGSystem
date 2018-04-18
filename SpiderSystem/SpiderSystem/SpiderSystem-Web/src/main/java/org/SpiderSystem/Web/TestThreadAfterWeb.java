package org.SpiderSystem.Web;

/**
 * 测试后台启动线程，单例模式
 * @author zzy
 *
 */
public class TestThreadAfterWeb extends Thread{
	private static TestThreadAfterWeb singleton;
	private boolean runflag = true;
	
	private TestThreadAfterWeb(){}
	
	public void run(){
		for(int i=0;i<10000000 && runflag;i++){
			System.out.println("hello world + "+i);
		}
	}
	
	public void startme(){
		this.runflag = true;
	}
	
	public void stopme(){
		this.runflag = false;
	}
	
	public static boolean isNull(){
		if(singleton == null){
			return true;
		}else{
			return false;
		}
	}
	
	public static TestThreadAfterWeb getSingleton(){
		if(singleton == null){
			synchronized(TestThreadAfterWeb.class){
				if(singleton == null){
					singleton = new TestThreadAfterWeb();
				}
			}
		}
		
		return singleton;
	}
	
	/**
	 * 将对象置null，触发GC
	 */
	public static void setNull(){
		singleton = null;
	}
}
