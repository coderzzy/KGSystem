package org.SpiderSystem.Web.service;

import java.util.Map;

import org.springframework.ui.Model;

public interface ISpiderService {
	void start(String urlSeed,String regexRule,Map<String,String> itemMap,String missionName);
	
	/**
	 * 直接爬下数据存储到数据库中
	 */
	void mysql(String urlSeed,String regexRule,INewsService newsService);
	
	void stop();
	
	void check(Model model);
}
