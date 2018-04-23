package org.SpiderSystem.Web.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬虫配置工具类
 * @author zzy
 *
 */
public class SpiderProperties {
	private static String util_urlSeed;
	private static String util_regexRule;
	private static Map<String,String> util_itemMap;
	private static String util_missionName;
	
	public static void update(String urlSeed,String RegexRule,String items,String mission){
		util_urlSeed = urlSeed;
		util_regexRule = RegexRule;
		util_missionName = mission;
		
		util_itemMap = new HashMap<String,String>();
		String[] item = items.split(",");
		for(String each : item){
			String[] eachItem = each.split(":");
			util_itemMap.put(eachItem[0].substring(1, eachItem[0].length()-1),
					eachItem[1].substring(1, eachItem[1].length()-1));
		}
	}
	
	public static String getUrlSeed(){
		return util_urlSeed;
	}
	
	public static String getRegexRule(){
		return util_regexRule;
	}
	
	public static Map<String,String> getItemMap(){
		return util_itemMap;
	}
	
	public static String getMissionName(){
		return util_missionName;
	}
}
