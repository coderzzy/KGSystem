package org.SpiderSystem.Web.service;

import java.util.Map;

import org.SpiderSystem.Web.service.spider.MySpider;
import org.SpiderSystem.Web.service.spider.pageprocesser.SQLPageProcessor;
import org.SpiderSystem.Web.service.spider.pageprocesser.SpiderPageProcessor;
import org.SpiderSystem.Web.service.spider.saver.SQLSaver;
import org.SpiderSystem.Web.service.spider.saver.SpiderSaver;
import org.springframework.ui.Model;

/**
 * 爬虫Service
 * @author zzy
 *
 */
public class SpiderService{
	
	public static void start(String urlSeed,String regexRule,Map<String,String> itemMap,String missionName){
		MySpider t = null;
		if(MySpider.isNull()){
			// 获取单例对象，启动线程标志位
			t = MySpider.getSingleton();
			t.setProcessor(new SpiderPageProcessor(itemMap));
			t.setSaver(new SpiderSaver(missionName));
			// t.addUrlSeed("http://news.xjtu.edu.cn");
			// t.addRegexRule("http://news.xjtu.edu.cn/.*htm");
			t.addUrlSeed(urlSeed);
			t.addRegexRule(regexRule);
			t.startme();
		}		
		if(t != null){
			t.start();
		}	
	}
	
	/**
	 * 直接爬下数据存储到数据库中
	 */
	public static void mysql(String urlSeed,String regexRule,INewsService newsService){
		MySpider t = null;
		if(MySpider.isNull()){
			// 获取单例对象，启动线程标志位
			t = MySpider.getSingleton();
			t.setProcessor(new SQLPageProcessor());
			t.setSaver(new SQLSaver(newsService));
			// t.addUrlSeed("http://news.xjtu.edu.cn");
			// t.addRegexRule("http://news.xjtu.edu.cn/.*htm");
			t.addUrlSeed(urlSeed);
			t.addRegexRule(regexRule);
			t.startme();
		}		
		if(t != null){
			t.start();
		}	
	}
	
	public static void stop(){
		MySpider t = null;
		if(!MySpider.isNull()){
			// 获取单例对象，关闭线程标志位
			t = MySpider.getSingleton();
			t.stopme();
		}		
		MySpider.setNull();
	}
	
	public static void check(Model model){
		if(MySpider.isNull()==true){
			model.addAttribute("state", "系统级爬虫停滞状态中...");
		}else{
			model.addAttribute("state", "系统级爬虫运行状态中...");
		}
	}
}